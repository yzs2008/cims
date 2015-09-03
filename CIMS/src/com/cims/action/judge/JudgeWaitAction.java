package com.cims.action.judge;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.cims.base.frame.BaseAction;
import com.cims.model.persist.FinalScore;
import com.cims.process.RaceProcess;
import com.cims.process.ScoreProcess;

@Namespace("/judge")
public class JudgeWaitAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	@Autowired
	private  RaceProcess raceProcess;
	@Autowired
	private ScoreProcess scoreProcess;
	
	private Integer raceId;
	
	private List<FinalScore> finalScoreList;

	@Action(value="wait",results={@Result(name="input",location="/WEB-INF/content/judge/wait.jsp")})
	public String waitPage(){
		finalScoreList=scoreProcess.getFinalScore(raceId);
		for(FinalScore fs:finalScoreList){
			String name=fs.getPlayer().getRealName();
		}
		return INPUT;
	}


	public List<FinalScore> getFinalScoreList() {
		return finalScoreList;
	}

	public void setFinalScoreList(List<FinalScore> finalScoreList) {
		this.finalScoreList = finalScoreList;
	}


	public Integer getRaceId() {
		return raceId;
	}


	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
}
