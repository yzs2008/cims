package com.cims.model.persist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cims_liveScore")
public class LiveScore {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer liveScoreId;
	private Integer raceId;
	private Integer playerId;
	private Double liveScore;
	public Integer getLiveScoreId() {
		return liveScoreId;
	}
	public void setLiveScoreId(Integer liveScoreId) {
		this.liveScoreId = liveScoreId;
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
	public Double getLiveScore() {
		return liveScore;
	}
	public void setLiveScore(Double liveScore) {
		this.liveScore = liveScore;
	}

	
}
