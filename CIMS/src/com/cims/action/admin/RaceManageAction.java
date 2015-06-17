package com.cims.action.admin;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.cims.base.frame.BaseAction;
import com.cims.model.Race;
import com.cims.model.Round;
import com.cims.process.RaceProcess;

@Namespace("/admin/race")
public class RaceManageAction extends BaseAction {

	private static final long serialVersionUID = 3742461286899118994L;
	
	@Autowired
	private RaceProcess raceProcess;

	private Race race;
	private List<Race> raceList;
	private Integer id;
	private Race race4update;
	
	private List<Round> roundList;
	private Map<String,String> judgePatternMap;
	private Map<String,String> drawPatternMap; 
	

	@Action(value = "list", results = { @Result(name = "input", location = "/WEB-INF/admin/race/list.jsp") })
	public String list() {
		raceList=raceProcess.retrieveList(new Race());
		return INPUT;
	}

	@Action(value = "detail", results = { @Result(name = "input", location = "/WEB-INF/admin/race/detail.jsp") })
	public String detail() {
		return INPUT;
	}

	@Action(value = "add", results = {
			@Result(name = "input", location = "/WEB-INF/admin/race/add.jsp"),
			@Result(name = "success", type = "redirect", location = "list") })
	public String add() {
		return INPUT;
	}

	@Action(value = "update", results = {
			@Result(name = "input", location = "/WEB-INF/admin/race/edit.jsp"),
			@Result(name = "success", type = "redirect", location = "list") })
	public String update() {
		return INPUT;
	}

	@Action(value = "edit", results = {
			@Result(name = "input", location = "/WEB-INF/admin/race/edit.jsp"),
			@Result(name = "success", type = "redirect", location = "list") })
	public String edit() {
		return INPUT;
	}
	
	
	public Race getRace() {
		return race;
	}

	public List<Race> getRaceList() {
		return raceList;
	}

	public Integer getId() {
		return id;
	}

	public Race getRace4update() {
		return race4update;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public void setRaceList(List<Race> raceList) {
		this.raceList = raceList;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRace4update(Race race4update) {
		this.race4update = race4update;
	}

	public List<Round> getRoundList() {
		return roundList;
	}

	public void setRoundList(List<Round> roundList) {
		this.roundList = roundList;
	}

	public Map<String, String> getJudgePatternMap() {
		return judgePatternMap;
	}

	public Map<String, String> getDrawPatternMap() {
		return drawPatternMap;
	}

	public void setJudgePatternMap(Map<String, String> judgePatternMap) {
		this.judgePatternMap = judgePatternMap;
	}

	public void setDrawPatternMap(Map<String, String> drawPatternMap) {
		this.drawPatternMap = drawPatternMap;
	}
	
}
