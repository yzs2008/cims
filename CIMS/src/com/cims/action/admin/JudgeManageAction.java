package com.cims.action.admin;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.cims.base.frame.BaseAction;
import com.cims.base.type.StateEnum;
import com.cims.model.persist.Judge;
import com.cims.process.JudgeProcess;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;

@SuppressWarnings("unused")
@Namespace("/admin/judge")
public class JudgeManageAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private JudgeProcess judgeProcess;

	private Judge judge;

	private List<Judge> judgeList;

	private String id;

	private File avatar;
	private String avatarContentType;
	private String avatarFileName;
	private Integer imageClipStartX = 0;
	private Integer imageClipStartY = 0;
	private Integer imageClipWidth = 200;
	private Integer imageClipHeight = 200;

	private Integer changeAvatarFlag;
	private Judge judge4update;

	private final String defaultAvatar = "/images/sys/default_avatar.png";

	@Action(value = "add", results = {
			@Result(name = "input", location = "/WEB-INF/admin/judge/add.jsp"),
			@Result(name = "success", type = "redirect", location = "list") })
	public String addJudge() {
		if (accept(judge)) {
			boolean saveAvatarDone = false;
			try {
				if (avatar == null) {
					String realPath = ServletActionContext.getServletContext()
							.getRealPath("/");
					String path = realPath + defaultAvatar;
					saveAvatar(new File(path));
				} else {
					saveAvatar(avatar);
				}
				saveAvatarDone = true;
			} catch (Exception e) {
				// 图片读取失败，请提供正确的图片文件
				saveAvatarDone = false;
				return ERROR;
			}
			if (saveAvatarDone) {
				judge.setRegisterDate(new Date());
				judge.setState(StateEnum.enable.name());
				if (judgeProcess.saveJudge(judge)) {
					return SUCCESS;
				}
				return ERROR;
			} else {
				// 图片读取失败，请提供正确的图片文件
				// return "ajaxError";
				return ERROR;
			}
		}
		return INPUT;
	}

	@Action(value = "list", results = { @Result(name = "input", location = "/WEB-INF/admin/judge/list.jsp") })
	public String judgeList() {
		judgeList = judgeProcess.retrieveList(new Judge());
		return INPUT;
	}

	@Action(value = "edit", results = { @Result(name = "success", location = "/WEB-INF/admin/judge/edit.jsp") })
	public String showDetail() {
		if (StringUtils.isNotBlank(id)) {
			judge = judgeProcess.retrieve(Integer.valueOf(id));
			return SUCCESS;
		}
		return ERROR;
	}

	@Action(value = "detail", results = { @Result(name = "success", location = "/WEB-INF/admin/judge/detail.jsp") })
	public String judgeDetail() {
		if (StringUtils.isNotBlank(id)) {
			judge = judgeProcess.retrieve(Integer.valueOf(id));
			return SUCCESS;
		}
		return ERROR;
	}

	@Action(value = "update", results = {
			@Result(name = "input", location = "/WEB-INF/admin/judge/edit.jsp"),
			@Result(name = "success", type = "redirect", location = "list") })
	public String update() {
		if (accept(judge4update)) {
			judge = judgeProcess.retrieve(judge4update.getJudgeId());
			if (changeAvatarFlag == 1) {// 用户没有修改图片
				judge.setAvatar(judge4update.getAvatar());
			} else {
				boolean saveAvatarDone = false;
				try {
					String path = ServletActionContext.getServletContext()
							.getRealPath("/") + judge.getAvatar();
					if (avatar == null) {// 用户没有上传新图片，但是调整了原本的图片大小
						saveAvatar(new File(path));
					} else {// 用户上传了新的图片
						saveAvatar(avatar);
					}
					deleteAvatar(path);
					saveAvatarDone=true;
				} catch (Exception e) {
					// 图片读取失败，请提供正确的图片文件
					saveAvatarDone = false;
				}
				if (!saveAvatarDone) {
					// 图片读取失败，请提供正确的图片文件
					// return "ajaxError";
					return ERROR;
				}
			}
			judge.setPassword(judge4update.getPassword());
			judge.setEmail(judge4update.getEmail());
			judge.setPhone(judge4update.getPhone());
			judge.setIntroduction(judge4update.getIntroduction());
			judgeProcess.update(judge);
			return SUCCESS;
		}
		return INPUT;
	}

	@Action(value = "deleted", results = { @Result(name = "success", type = "redirect", location = "list") })
	public String delete() {
		if (StringUtils.isNotBlank(id)) {
			if (judgeProcess.detete(id)) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		}
		return ERROR;
	}

	private boolean accept(Judge judge4accept) {
		boolean accept = true;
		if (judge4accept == null) {
			return !accept;
		}
		if (!(StringUtils.isNotEmpty(judge4accept.getJudgeName()) && StringUtils
				.isNotEmpty(judge4accept.getPassword()))) {
			return !accept;
		}
		return accept;
	}

	private void deleteAvatar(String path) {
		try {
			File file = new File(path);
			if (file.exists()) {
				file.delete();
			}
		} catch (Exception e) {
		}
	}

	private void saveAvatar(File imageFile) throws IOException {
		// 获取原图
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(imageFile);
		} catch (Exception e) {
			JPEGImageDecoder decoder = JPEGCodec
					.createJPEGDecoder(new FileInputStream(imageFile));
			bufferedImage = decoder.decodeAsBufferedImage();
		}
		Image orignImage = bufferedImage.getScaledInstance(
				bufferedImage.getWidth(), bufferedImage.getHeight(),
				Image.SCALE_SMOOTH);
		// 根据用户的缩放，生成缩放图
		BufferedImage thumbnail = new BufferedImage(imageClipWidth,
				imageClipHeight, Image.SCALE_SMOOTH);
		Graphics2D thumbnailGraphic = thumbnail.createGraphics();
		thumbnailGraphic.drawImage(orignImage, 0, 0, imageClipWidth,
				imageClipHeight, Color.WHITE, null);
		thumbnailGraphic.dispose();
		// 针对缩放图裁剪
		Image thumbnailImage = thumbnail
				.getScaledInstance(thumbnail.getWidth(), thumbnail.getHeight(),
						Image.SCALE_SMOOTH);
		BufferedImage selectedImage = new BufferedImage(200, 200,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D selectedGraphic = selectedImage.createGraphics();
		selectedGraphic.drawImage(thumbnailImage, imageClipStartX,
				imageClipStartY, imageClipWidth, imageClipHeight, Color.WHITE,
				null);
		selectedGraphic.dispose();
		// 保存最终用户选择
		String realPath = ServletActionContext.getServletContext().getRealPath(
				"/");
		String location = "/images/judge/";
		String name = String.valueOf(System.nanoTime()) + ".png";

		ImageIO.write(selectedImage, "png",
				new File(realPath + location + name));

		String imageURL = location + name;
		judge.setAvatar(imageURL);
	}

	// private String getContextPath() {
	// String URL = ((HttpServletRequest) ServletActionContext.getRequest())
	// .getRequestURL().toString();
	// String contextPath = ServletActionContext.getRequest().getContextPath();
	//
	// String imageURL = URL.substring(0, URL.indexOf(contextPath)
	// + contextPath.length());
	// return imageURL;
	// }

	public Judge getJudge() {
		return judge;
	}

	public void setJudge(Judge judge) {
		this.judge = judge;
	}

	public void setAvatarContentType(String avatarContentType) {
		this.avatarContentType = avatarContentType;
	}

	public void setAvatarFileName(String avatarFileName) {
		this.avatarFileName = avatarFileName;
	}

	public void setAvatar(File avatar) {
		this.avatar = avatar;
	}

	public Integer getImageClipStartX() {
		return imageClipStartX;
	}

	public Integer getImageClipStartY() {
		return imageClipStartY;
	}

	public void setImageClipStartX(Integer imageClipStartX) {
		this.imageClipStartX = imageClipStartX;
	}

	public void setImageClipStartY(Integer imageClipStartY) {
		this.imageClipStartY = imageClipStartY;
	}

	public Integer getImageClipWidth() {
		return imageClipWidth;
	}

	public Integer getImageClipHeight() {
		return imageClipHeight;
	}

	public void setImageClipWidth(Integer imageClipWidth) {
		this.imageClipWidth = imageClipWidth;
	}

	public void setImageClipHeight(Integer imageClipHeight) {
		this.imageClipHeight = imageClipHeight;
	}

	public List<Judge> getJudgeList() {
		return judgeList;
	}

	public void setJudgeList(List<Judge> judgeList) {
		this.judgeList = judgeList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getChangeAvatarFlag() {
		return changeAvatarFlag;
	}

	public Judge getJudge4update() {
		return judge4update;
	}

	public void setJudge4update(Judge judge4update) {
		this.judge4update = judge4update;
	}

	public void setChangeAvatarFlag(Integer changeAvatarFlag) {
		this.changeAvatarFlag = changeAvatarFlag;
	}
}
