package com.cims.model.datastruct;

import com.cims.model.persist.Judge;
import com.cims.model.persist.RaceJudge;

public class JudgeScoreModel {
	
	private Judge judge;
	private RaceJudge raceJudge;
	private Double score;
	public Judge getJudge() {
		return judge;
	}
	public void setJudge(Judge judge) {
		this.judge=new Judge();
		this.judge.setJudgeId(judge.getJudgeId());
		this.judge.setJudgeName(judge.getJudgeName());
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public RaceJudge getRaceJudge() {
		return raceJudge;
	}
	public void setRaceJudge(RaceJudge raceJudge) {
		this.raceJudge = raceJudge;
	}
	
}
