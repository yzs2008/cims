package com.cims.model.persist;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cims_finalScore")
public class FinalScore {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer finalScoreId;
	private Integer raceId;
	@Basic(fetch=FetchType.LAZY)
	@OneToOne
	@JoinColumn(name="playerId",insertable=true,unique=true)
	private User player;
	private Double finalScore;
	public Integer getFinalScoreId() {
		return finalScoreId;
	}
	public Integer getRaceId() {
		return raceId;
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

	public void setFinalScore(Double finalScore) {
		this.finalScore = finalScore;
	}
	public User getPlayer() {
		return player;
	}
	public void setPlayer(User player) {
		this.player = player;
	}
	
}
