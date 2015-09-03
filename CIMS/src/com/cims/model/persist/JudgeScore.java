package com.cims.model.persist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cims_score")
public class JudgeScore {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer scoreId;
	private Integer raceId;
	private Integer playerId;
	@OneToOne
	@JoinColumn(name="judgeId")
	private Judge judge;
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

	public Judge getJudge() {
		return judge;
	}
	public void setJudge(Judge judge) {
		this.judge = judge;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
}
