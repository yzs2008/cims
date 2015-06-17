package com.cims.action.admin;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.cims.base.frame.BaseAction;
import com.cims.model.Round;
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
	
	private List<Round> roundList;
	private Map<String,String> judgePatternMap;
	private Map<String,String> drawPatternMap; 
	

	@Action(value = "list", results = { @Result(name = "input", location = "/WEB-INF/admin/round/list.jsp") })
	public String list() {
		roundList=roundProcess.retrieveList(new Round());
		return INPUT;
	}

	@Action(value = "detail", results = { @Result(name = "input", location = "/WEB-INF/admin/round/detail.jsp") })
	public String detail() {
		return INPUT;
	}

	@Action(value = "add", results = {
			@Result(name = "input", location = "/WEB-INF/admin/round/add.jsp"),
			@Result(name = "success", type = "redirect", location = "list") })
	public String add() {
		return INPUT;
	}

	@Action(value = "update", results = {
			@Result(name = "input", location = "/WEB-INF/admin/round/edit.jsp"),
			@Result(name = "success", type = "redirect", location = "list") })
	public String update() {
		return INPUT;
	}

	@Action(value = "edit", results = {
			@Result(name = "input", location = "/WEB-INF/admin/round/edit.jsp"),
			@Result(name = "success", type = "redirect", location = "list") })
	public String edit() {
		return INPUT;
	}
	

}
