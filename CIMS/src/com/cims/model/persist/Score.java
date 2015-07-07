package com.cims.model.persist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cims_score")
public class Score {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer scoreId;
	private Integer raceId;
	private Integer playerId;
	private Integer judgeId;
	private Double score;
	public Integer getScoreId() {
		return scoreId;
	}
	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}
	public Integer getRaceId() {
		return raceId;
	}
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
	public Integer getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	public Integer getJudgeId() {
		return judgeId;
	}
	public void setJudgeId(Integer judgeId) {
		this.judgeId = judgeId;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
}
