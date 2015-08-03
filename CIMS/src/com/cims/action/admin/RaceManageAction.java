package com.cims.action.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cims.base.frame.BaseAction;
import com.cims.base.frame.HttpUtils;
import com.cims.model.datastruct.DrawPattern;
import com.cims.model.datastruct.JudgePattern;
import com.cims.model.persist.Judge;
import com.cims.model.persist.Race;
import com.cims.model.persist.RaceJudge;
import com.cims.model.persist.Round;
import com.cims.process.JudgeProcess;
import com.cims.process.RaceProcess;

@Namespace("/admin/race")
@InterceptorRef(value="json")
public class RaceManageAction extends BaseAction {

	private static final long serialVersionUID = 3742461286899118994L;

	@Autowired
	private RaceProcess raceProcess;
	@Autowired
	private JudgeProcess judgeProcess;

	private Race race;
	private List<Race> raceList;
	private Integer id;
	private Race race4update;
	private String startTime;

	private List<Round> roundList;
	private Map<String, String> judgePatternMap;
	private Map<String, String> drawPatternMap;
	
	
	

	public RaceManageAction() {
		judgePatternMap = new LinkedHashMap<String, String>();
		for (JudgePattern p : JudgePattern.values()) {
			judgePatternMap.put(p.name(), p.toString());
		}
		drawPatternMap = new LinkedHashMap<String, String>();
		for(DrawPattern d:DrawPattern.values()){
			drawPatternMap.put(d.name(), d.toString());
		}
	}

	@Action(value = "list", results = { @Result(name = "input", location = "/WEB-INF/admin/race/list.jsp") })
	public String list() {
		raceList = raceProcess.retrieveList(new Race());
		return INPUT;
	}

	@Action(value = "detail", results = { @Result(name = "input", location = "/WEB-INF/admin/race/detail.jsp") })
	public String detail() {
		return INPUT;
	}

	@Action(value = "add", results = { @Result(name = "input", location = "/WEB-INF/admin/race/add.jsp"), @Result(name = "success", type = "redirect", location = "list") })
	public String add() {
		try {
			if (accept()) {
				raceProcess.saveRace(race);
				return SUCCESS;
			} else {
				roundList = raceProcess.retrieveRoundList();
				return INPUT;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return ERROR;
		}
	}
	
	private List<Judge> judgeList;
	private List<RaceJudge> raceJudgeList;
	
	@Action(value="config",results={@Result(name="input",location="/WEB-INF/admin/race/config.jsp")})
	public String config(){
		try{
			judgeList=judgeProcess.retrieveList(new Judge());
		}catch(Exception e){
			log.error(e.getMessage());
			return ERROR;
		}
		return INPUT;
	}
	@Action(value="configJudge")
	public void configJudge() throws IOException{
		JSONObject resultData=new  JSONObject();
		try{
			for(RaceJudge rj:raceJudgeList){
				rj.setDisplayName("评委");
			}
			resultData.put("resultData", "done");
		}catch(Exception e){
			log.error(e.getMessage());
			resultData.put("resultData", "error");
		}
		String resultJson=resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}


	private boolean accept() {
		boolean accept = true;
		if (race == null) {
			accept = false;
			return accept;
		}
		if (StringUtils.isBlank(race.getRaceName())) {
			accept = false;
		}
		if (StringUtils.isBlank(race.getHost())) {
			accept = false;
		}
		if (StringUtils.isBlank(race.getRoundName())) {
			accept = false;
		}
		if (race.getRoundId() == null) {
			accept = false;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			race.setStartTime(sdf.parse(startTime));
		} catch (Exception e) {
			accept = false;
		}
		if (race.getStartTime() == null) {
			accept = false;
		}
		return accept;
	}

	@Action(value = "update", results = { @Result(name = "input", location = "/WEB-INF/admin/race/edit.jsp"), @Result(name = "success", type = "redirect", location = "list") })
	public String update() {
		return INPUT;
	}

	@Action(value = "edit", results = { @Result(name = "input", location = "/WEB-INF/admin/race/edit.jsp") })
	public String edit() {
		if (id == null) {
			return ERROR;
		}
		try {
			race = raceProcess.retrieve(id);
			return INPUT;
		} catch (Exception e) {
			log.error(e.getMessage());
			return ERROR;
		}
	}

	@Action("raceNameCheck")
	public void raceNameCheck() {
		try {
			if (StringUtils.isNotBlank(race.getRaceName())) {
				JSONObject resultData = new JSONObject();
				if (raceProcess.raceNameCheck(race.getRaceName())) {
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public List<Judge> getJudgeList() {
		return judgeList;
	}

	public void setJudgeList(List<Judge> judgeList) {
		this.judgeList = judgeList;
	}

	public List<RaceJudge> getRaceJudgeList() {
		return raceJudgeList;
	}

	public void setRaceJudgeList(List<RaceJudge> raceJudgeList) {
		this.raceJudgeList = raceJudgeList;
	}

}
