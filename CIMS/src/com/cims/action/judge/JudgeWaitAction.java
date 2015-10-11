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
import com.cims.model.datastruct.JudgeScoreModel;
import com.cims.model.datastruct.PlayerScoreModel;
import com.cims.process.RaceProcess;
import com.cims.process.ScoreProcess;

@Namespace("/judge")
@InterceptorRef("judgeInterceptorStack")
public class JudgeWaitAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	@Autowired
	private  RaceProcess raceProcess;
	@Autowired
	private ScoreProcess scoreProcess;
	
	private Integer raceId;
	

	@Action(value="wait",results={@Result(name="input",location="/WEB-INF/content/judge/wait.jsp")})
	public String waitPage(){
		return INPUT;
	}
	
	/**
	 * 所有选手总成绩
	 * @throws IOException
	 */
	@Action(value="getFinalScore",interceptorRefs={@InterceptorRef(value="json")})
	public void getFinalScore() throws IOException{
		JSONObject resultData = new JSONObject();
		try{
			List<PlayerScoreModel> finalScoreList = scoreProcess.getFinalScoreModel(raceId);
			resultData.put("resultData", finalScoreList);
		}catch(Exception e){
			log.error(e.getMessage());
			resultData.put("resultData", new ArrayList<PlayerScoreModel>());
		}
		String resultJson=resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}
	/**
	 * 评委打分轨迹
	 * @throws IOException
	 */
	@Action(value="getJudgeScoreTrace",interceptorRefs={@InterceptorRef(value="json")})
	public void getJudgeScoreTrace() throws IOException{
		JSONObject resultData = new JSONObject();
		try{
			//Judge judge=(Judge)sessionMap.get(ActionContant.session_judge);
			Integer judgeId=1;
			List<PlayerScoreModel> judgeTraceList = scoreProcess.getJudgeTraceScoreModel(raceId, judgeId);
			resultData.put("resultData", judgeTraceList);
		}catch(Exception e){
			log.error(e.getMessage());
			resultData.put("resultData", new ArrayList<PlayerScoreModel>());
		}
		String resultJson=resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}
	/**
	 * 当前选手的得分情况
	 * @throws IOException
	 */
	@Action(value="getProgress",interceptorRefs={@InterceptorRef(value="json")})
	public void getProgress() throws IOException{
		JSONObject resultData = new JSONObject();
		try{
			Integer playerId=1;
			List<JudgeScoreModel> judgeScoreList = scoreProcess.getJudgeScoreModel(raceId, playerId);
			resultData.put("resultData", judgeScoreList);
		}catch(Exception e){
			log.error(e.getMessage());
			resultData.put("resultData", new ArrayList<JudgeScoreModel>());
		}
		String resultJson=resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}

	public Integer getRaceId() {
		return raceId;
	}


	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
}
