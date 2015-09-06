package com.cims.model.datastruct;

import java.util.Map;

import com.cims.model.persist.Race;
import com.cims.model.persist.User;

public class ApplicationState {
	//当前比赛选手
	private User curPlayer;

	//当前比赛
	private Race curRace;
	//当前系统的运行状态
	private ApplicationMode appModel;
	
	//赛事评委的评分状态,记录某个评委是否已经为当前选手评分
	private Map<Integer,Boolean> judgeStates;

	public User getCurPlayer() {
		return curPlayer;
	}

	public void setCurPlayer(User curPlayer) {
		this.curPlayer = curPlayer;
	}

	public ApplicationMode getAppModel() {
		return appModel;
	}

	public void setAppModel(ApplicationMode appModel) {
		this.appModel = appModel;
	}

	public Map<Integer, Boolean> getJudgeStates() {
		return judgeStates;
	}

	public void setJudgeStates(Map<Integer, Boolean> judgeStates) {
		this.judgeStates = judgeStates;
	}

	public Race getCurRace() {
		return curRace;
	}

	public void setCurRace(Race curRace) {
		this.curRace = curRace;
	}
	
	
}
