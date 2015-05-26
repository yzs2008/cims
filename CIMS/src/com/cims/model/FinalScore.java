package com.cims.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cims_finalScore")
public class FinalScore {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer finalScoreId;
	private Integer raceId;
	private Integer playerId;
	private Double finalScore;
	public Integer getFinalScoreId() {
		return finalScoreId;
	}
	public Integer getRaceId() {
		return raceId;
	}
	public Integer getPlayerId() {
		return playerId;
	}
	public Double getFinalScore() {
		return finalScore;
	}
	public void setFinalScoreId(Integer finalScoreId) {
		this.finalScoreId = finalScoreId;
	}
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	public void setFinalScore(Double finalScore) {
		this.finalScore = finalScore;
	}
	
}
