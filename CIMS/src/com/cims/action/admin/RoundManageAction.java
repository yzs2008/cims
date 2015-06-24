package com.cims.action.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cims.base.frame.BaseAction;
import com.cims.base.frame.HttpUtils;
import com.cims.base.type.StateEnum;
import com.cims.model.Round;
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
	private Map<String, String> judgePatternMap;
	private Map<String, String> drawPatternMap;

	@Action(value = "list", results = { @Result(name = "input", location = "/WEB-INF/admin/round/list.jsp") })
	public String list() {
		roundList = roundProcess.retrieveList(new Round());
		return INPUT;
	}

	@Action(value = "detail", results = { @Result(name = "input", location = "/WEB-INF/admin/round/detail.jsp") })
	public String detail() {
		if (id == null) {

		}
		return INPUT;
	}

	@Action(value = "add", results = { @Result(name = "input", location = "/WEB-INF/admin/round/add.jsp"), @Result(name = "success", type = "redirect", location = "list") })
	public String add() {
		Round filter=new Round();
		filter.setHasNode(true);
		roundList=roundProcess.retrieveList(filter);
		if (accept()) {
			round.setState(StateEnum.enable.toString());
			round.setCreateTime(new Date());
			roundProcess.saveRound(round);
			return SUCCESS;
		}
		return INPUT;
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
	
	@Action(value = "update", results = { @Result(name = "input", location = "/WEB-INF/admin/round/edit.jsp"), @Result(name = "success", type = "redirect", location = "list") })
	public String update() {
		return INPUT;
	}

	@Action(value = "edit", results = { @Result(name = "input", location = "/WEB-INF/admin/round/edit.jsp"), @Result(name = "success", type = "redirect", location = "list") })
	public String edit() {
		return INPUT;
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
	public void roundNameCheck(){
		try{
			if(StringUtils.isNotBlank(roundName)){
				JSONObject resultData=new JSONObject();
				if(roundProcess.retrieve(roundName)){
					resultData.put("resultData", true);
				}else{
					resultData.put("resultData", false);
				} 
				String jsonResult = resultData.toJSONString();
				HttpUtils.responseJson(jsonResult, response);
			}
		}catch(Exception e){
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

	public Map<String, String> getJudgePatternMap() {
		return judgePatternMap;
	}

	public Map<String, String> getDrawPatternMap() {
		return drawPatternMap;
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

	public void setJudgePatternMap(Map<String, String> judgePatternMap) {
		this.judgePatternMap = judgePatternMap;
	}

	public void setDrawPatternMap(Map<String, String> drawPatternMap) {
		this.drawPatternMap = drawPatternMap;
	}

	public String getRoundName() {
		return roundName;
	}

	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}

}
