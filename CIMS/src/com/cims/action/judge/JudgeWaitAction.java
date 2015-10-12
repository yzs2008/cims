package com.cims.action.judge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cims.base.frame.BaseAction;
import com.cims.base.frame.HttpUtils;
import com.cims.base.type.ActionContant;
import com.cims.model.datastruct.JudgeScoreModel;
import com.cims.model.datastruct.PlayerScoreModel;
import com.cims.model.persist.Judge;
import com.cims.model.persist.Race;
import com.cims.model.persist.User;
import com.cims.process.RaceProcess;
import com.cims.process.ScoreProcess;

@Namespace("/judge")
@InterceptorRef("judgeInterceptorStack")
public class JudgeWaitAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	private RaceProcess raceProcess;
	@Autowired
	private ScoreProcess scoreProcess;

	private Integer raceId;
	private String displayName;
	
	
	@Action(value="wait4race",results={@Result(name="input",type="redirect",location="wait"),
			@Result(name = "choose", type = "redirect", location = "racelist") })
	public String wait4race(){
		try{
			if (raceId == null) {
				return "choose";
			}
			Race race=raceProcess.retrieve(raceId);
			if(sessionMap.get(ActionContant.session_race)==null){
				sessionMap.put(ActionContant.session_race, race);
			}else{
				sessionMap.replace(ActionContant.session_race, race);
			}
			if(sessionMap.get(ActionContant.session_user)==null){
				sessionMap.put(ActionContant.session_user, scoreProcess.getCurPlayer(race));
			}
			return INPUT;
		}catch(Exception e){
			log.error(e);
			return ERROR;
		}
	}

	@Action(value = "wait", results = { @Result(name = "input", location = "/WEB-INF/content/judge/wait.jsp"),
			@Result(name = "choose", type = "redirect", location = "racelist") })
	public String waitPage() {
		try {
			Race race;
			if (sessionMap.get(ActionContant.session_race) == null) {
				return "choose";
			} else {
				race=(Race)sessionMap.get(ActionContant.session_race);
			}

			Judge judge = (Judge) sessionMap.get(ActionContant.session_judge);
			displayName = raceProcess.getDisplayName(judge, race);

			return INPUT;
		} catch (Exception e) {
			log.error(e);
			return ERROR;
		}
	}

	/**
	 * 所有选手总成绩
	 * 
	 * @throws IOException
	 */
	@Action(value = "getFinalScore", interceptorRefs = { @InterceptorRef(value = "json") })
	public void getFinalScore() throws IOException {
		JSONObject resultData = new JSONObject();
		try {
			Race race=(Race)sessionMap.get(ActionContant.session_race);
			List<PlayerScoreModel> finalScoreList = scoreProcess.getFinalScoreModel(race.getRaceId());
			resultData.put("resultData", finalScoreList);
		} catch (Exception e) {
			log.error(e.getMessage());
			resultData.put("resultData", new ArrayList<PlayerScoreModel>());
		}
		String resultJson = resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}

	/**
	 * 评委打分轨迹
	 * 
	 * @throws IOException
	 */
	@Action(value = "getJudgeScoreTrace", interceptorRefs = { @InterceptorRef(value = "json") })
	public void getJudgeScoreTrace() throws IOException {
		JSONObject resultData = new JSONObject();
		try {
			Judge judge=(Judge)sessionMap.get(ActionContant.session_judge);
			Race race=(Race)sessionMap.get(ActionContant.session_race);
			List<PlayerScoreModel> judgeTraceList = scoreProcess.getJudgeTraceScoreModel(race.getRaceId(), judge.getJudgeId());
			resultData.put("resultData", judgeTraceList);
		} catch (Exception e) {
			log.error(e.getMessage());
			resultData.put("resultData", new ArrayList<PlayerScoreModel>());
		}
		String resultJson = resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}

	/**
	 * 当前选手的得分情况
	 * 
	 * @throws IOException
	 */
	@Action(value = "getProgress", interceptorRefs = { @InterceptorRef(value = "json") })
	public void getProgress() throws IOException {
		JSONObject resultData = new JSONObject();
		try {
			User user=(User)sessionMap.get(ActionContant.session_user);
			Race race=(Race)sessionMap.get(ActionContant.session_race);
			List<JudgeScoreModel> judgeScoreList = scoreProcess.getJudgeScoreModel(race.getRaceId(), user.getUserId());
			resultData.put("resultData", judgeScoreList);
		} catch (Exception e) {
			log.error(e.getMessage());
			resultData.put("resultData", new ArrayList<JudgeScoreModel>());
		}
		String resultJson = resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}

	public Integer getRaceId() {
		return raceId;
	}

	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
