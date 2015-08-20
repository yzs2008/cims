package com.cims.action.player;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cims.base.frame.BaseAction;
import com.cims.base.frame.HttpUtils;
import com.cims.base.type.ActionContant;
import com.cims.model.datastruct.Message;
import com.cims.model.datastruct.RaceState;
import com.cims.model.persist.Race;
import com.cims.model.persist.SignUp;
import com.cims.model.persist.User;
import com.cims.process.RaceProcess;
import com.cims.process.SignProcess;

@Namespace("/player")
@InterceptorRef("playerInterceptorStack")
public class PlayerSignAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SignProcess signProcess;
	@Autowired
	private RaceProcess raceProcess;

	private User user;
	private List<Race> raceList;
	
	private Integer raceId;
	private String productName;
	private String description;
	

	@Action(value = "sign", results = { @Result(name = "input", location = "/WEB-INF/content/player/sign.jsp") })
	public String sign() {
		try {
			user = (User) sessionMap.get(ActionContant.session_user);
			//列出所有正在接受报名状态的赛事
			Race race=new Race();
			race.setState(RaceState.sign);
			raceList=raceProcess.retrieveList(race);
		} catch (Exception e) {
			log.error(e);
		}
		return INPUT;
	}
	/**
	 * 获取用户报名数据（作品信息）
	 * 
	 * @throws IOException
	 */
	@Action(value = "getProductInfo",interceptorRefs={@InterceptorRef("defaultStack"),@InterceptorRef(value="json")})
	public void getProductInfo() throws IOException {
		JSONObject resultData = new JSONObject();
		Message msg = new Message();
		try {
			if (raceId!=null) {
				User usr=(User)sessionMap.get(ActionContant.session_user);
				SignUp sign=signProcess.getProductInfo(usr.getUserId(),raceId);
				if (sign!=null) {
					msg.setMsg("作品信息获取成功");
					msg.setState(true);
					resultData.put("sign", sign);
				} else {
					msg.setMsg("作品信息为空");
					msg.setState(false);
				}

			} else {
				msg.setMsg("参数错误");
				msg.setState(false);
			}
		} catch (Exception e) {
			msg.setMsg("获取作品信息失败");
			msg.setState(false);
			log.error(e);
		}
		resultData.put("msg", msg);
		String resultJson = resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}
	/**
	 * 保存用户报名数据（作品信息）
	 * 
	 * @throws IOException
	 */
	@Action(value = "saveProductInfo",interceptorRefs={@InterceptorRef("defaultStack"),@InterceptorRef(value="json")})
	public void saveProductInfo() throws IOException {
		JSONObject resultData = new JSONObject();
		Message msg = new Message();
		try {
			if (acceptProduct()) {
				SignUp sign=new SignUp();
				sign.setProductDescription(description);
				sign.setProductName(productName);
				sign.setRaceId(raceId);
				User usr=(User)sessionMap.get(ActionContant.session_user);
				sign.setUserId(usr.getUserId());
				if (signProcess.saveProductInfo(sign)) {
					msg.setMsg("作品信息保存成功");
					msg.setState(true);
				} else {
					msg.setMsg("作品信息保存失败");
					msg.setState(false);
				}

			} else {
				msg.setMsg("请填写完整信息");
				msg.setState(false);
			}
		} catch (Exception e) {
			msg.setMsg("作品信息保存失败");
			msg.setState(false);
		}
		resultData.put("msg", msg);
		String resultJson = resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}
	
	/**
	 * 保存用户报名数据（用户个人信息）
	 * 
	 * @throws IOException
	 */
	@Action(value = "saveUserInfo",interceptorRefs={@InterceptorRef(value="json")})
	public void saveUserInfo() throws IOException {
		JSONObject resultData = new JSONObject();
		Message msg = new Message();
		try {
			if (accept()) {
				if (signProcess.saveUserInfo(user)) {
					msg.setMsg("报名用户信息保存成功");
					msg.setState(true);
				} else {
					msg.setMsg("报名用户信息保存失败");
					msg.setState(false);
				}

			} else {
				msg.setMsg("请填写完整信息");
				msg.setState(false);
			}
		} catch (Exception e) {
			msg.setMsg("报名用户信息保存失败");
			msg.setState(false);
		}
		resultData.put("msg", msg);
		String resultJson = resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}
	
	private boolean acceptProduct() {
		boolean accept = true;
		if (raceId == null) {
			accept = false;
			return accept;
		}
		if (!StringUtils.isNotEmpty(productName)) {
			accept = false;
		}
		return accept;
	}
	
	private boolean accept() {
		boolean accept = true;
		if (user == null) {
			accept = false;
			return accept;
		}
		if (user.getUserId() == null) {
			accept = false;
		}
		if (!StringUtils.isNotEmpty(user.getRealName())) {
			accept = false;
		}
		if (!StringUtils.isNotEmpty(user.getUnit())) {
			accept = false;
		}
		return accept;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Race> getRaceList() {
		return raceList;
	}

	public void setRaceList(List<Race> raceList) {
		this.raceList = raceList;
	}

	public Integer getRaceId() {
		return raceId;
	}

	public String getProductName() {
		return productName;
	}

	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
