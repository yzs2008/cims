package com.cims.action.admin;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cims.base.frame.BaseAction;
import com.cims.base.frame.HttpUtils;
import com.cims.base.type.StateEnum;
import com.cims.model.datastruct.RoundList;
import com.cims.model.persist.Round;
import com.cims.process.RoundProcess;

@Namespace("/admin/round")
public class RoundManageAction extends BaseAction {

	private static final long serialVersionUID = 3742461286899118994L;

	@Autowired
	private RoundProcess roundProcess;

	private Round round;
	private Integer id;
	private Round round4update;

	private String roundName;

	private List<Round> roundList;

	@Action(value = "list", results = { @Result(name = "input", location = "/WEB-INF/admin/round/list.jsp") })
	public String list() {
		return INPUT;
	}


	@Action(value = "add", results = { @Result(name = "input", location = "/WEB-INF/admin/round/add.jsp"), @Result(name = "success", type = "redirect", location = "list") })
	public String add() {
		try {
			
			if (accept()) {
				round.setState(StateEnum.enable.toString());
				round.setCreateTime(new Date());
				roundProcess.saveRound(round);
				return SUCCESS;
			}
				Round filter = new Round();
				filter.setHasNode(true);
				roundList = roundProcess.retrieveList(filter);
			return INPUT;
		} catch (Exception e) {
			log.error(e.getMessage());
			return ERROR;
		}
	}

	private boolean accept() {
		if (round == null) {
			return false;
		}
		if (!StringUtils.isNotBlank(round.getRoundName())) {
			return false;
		}
		if (round.getParent() == null) {
			return false;
		}
		return true;
	}

	@Action("delete")
	public void delete() {
		try {
			JSONObject resultData = new JSONObject();
			if (id != null) {
				// 查看是否可以删除
				if (roundProcess.prepareDelete(id)) {
					if (roundProcess.detete(String.valueOf(id))) {
						resultData.put("resultData", true);
						resultData.put("message", "删除成功");
					} else {
						resultData.put("resultData", false);
						resultData.put("message", "程序内部错误！请联系系统提供商！");

					}
				} else {
					resultData.put("resultData", false);
					resultData.put("message", "该轮次下面包含子轮次或赛事，无法删除该轮次！");
				}
			} else {
				resultData.put("resultData", false);
				resultData.put("message", "参数错误");
			}
			String jsonResult = resultData.toJSONString();
			HttpUtils.responseJson(jsonResult, response);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Action(value = "update", results = { @Result(name = "success", type = "redirect", location = "list") })
	public String update() {
		if (round4update == null) {
			return ERROR;
		}
		try {
			round = roundProcess.retrieve(round4update.getRoundId());
			round.setDescription(round4update.getDescription());
			round.setHasNode(round4update.isHasNode());
			round.setParent(round4update.getParent());
			round.setParentName(round4update.getParentName());
			round.setRoundName(round4update.getRoundName());
			roundProcess.update(round);
			return SUCCESS;
		} catch (Exception e) {
			log.error(e.getMessage());
			return ERROR;
		}
	}

	@Action(value = "edit", results = { @Result(name = "input", location = "/WEB-INF/admin/round/edit.jsp"), @Result(name = "success", type = "redirect", location = "list") })
	public String edit() {
		if (id != null) {
			try {
				Round filter = new Round();
				filter.setRoundId(id);
				filter.setHasNode(true);
				roundList = roundProcess.retrieveParentList(filter);
				round4update = roundProcess.retrieve(id);
				return INPUT;
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		return ERROR;
	}

	@Action("roundInfo")
	public void roundInfo() {
		try {
			if (id != null) {
				Round round4json = roundProcess.retrieve(id);
				JSONObject resultData = new JSONObject();
				resultData.put("resultData", round4json);
				String jsonResult = resultData.toJSONString();
				HttpUtils.responseJson(jsonResult, response);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Action("roundNameCheck")
	public void roundNameCheck() {
		try {
			if (StringUtils.isNotBlank(roundName)) {
				JSONObject resultData = new JSONObject();
				if (roundProcess.retrieve(roundName)) {
					resultData.put("resultData", true);
				} else {
					resultData.put("resultData", false);
				}
				String jsonResult = resultData.toJSONString();
				HttpUtils.responseJson(jsonResult, response);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Action("roundNameCheck4update")
	public void roundNameCheck4update() {
		try {
			if (StringUtils.isNotBlank(roundName)) {
				JSONObject resultData = new JSONObject();
				// 判断是否具有同名轮次
				if (roundProcess.retrieveExclude(roundName, id)) {
					boolean hasNode = Boolean.valueOf(request.getParameter("hasNode"));
					// 判断是否包含叶子节点
					if (!hasNode) {
						if (roundProcess.acceptChangeHasNode(id)) {
							resultData.put("resultData", true);
						} else {
							resultData.put("resultData", false);
							resultData.put("message", "该轮次下面包含子轮次，无法成为叶子轮次");
						}
					} else {
						resultData.put("resultData", true);
					}
				} else {
					resultData.put("resultData", false);
					resultData.put("message", "轮次名称不能重复");
				}
				String jsonResult = resultData.toJSONString();
				HttpUtils.responseJson(jsonResult, response);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Action("roundListJson")
	public void roundListJson() {
		try {
			RoundList root = roundProcess.retrieveRoundList();
			JSONObject resultData = new JSONObject();
			resultData.put("resultData", root);
			String jsonResult = resultData.toJSONString();
			HttpUtils.responseJson(jsonResult, response);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public Round getRound() {
		return round;
	}

	public Integer getId() {
		return id;
	}

	public Round getRound4update() {
		return round4update;
	}

	public List<Round> getRoundList() {
		return roundList;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRound4update(Round round4update) {
		this.round4update = round4update;
	}

	public void setRoundList(List<Round> roundList) {
		this.roundList = roundList;
	}

	public String getRoundName() {
		return roundName;
	}

	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}

}
