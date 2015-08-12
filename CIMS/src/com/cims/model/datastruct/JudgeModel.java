package com.cims.model.datastruct;

import com.cims.model.persist.Judge;
import com.cims.model.persist.RaceJudge;

public class JudgeModel {
	private Judge judge;
	private RaceJudge raceJudge;
	
	
	public Judge getJudge() {
		return judge;
	}
	public RaceJudge getRaceJudge() {
		return raceJudge;
	}
	public void setJudge(Judge judge) {
		this.judge = judge;
	}
	public void setRaceJudge(RaceJudge raceJudge) {
		this.raceJudge = raceJudge;
	}
}
