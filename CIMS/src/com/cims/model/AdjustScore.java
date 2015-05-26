package com.cims.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cims_adjustScore")
public class AdjustScore {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer adjustScoreId;
	private Integer raceId;
	private Integer playerId;
	private Double adjustment;
	public Integer getAdjustScoreId() {
		return adjustScoreId;
	}
	public Integer getRaceId() {
		return raceId;
	}
	public Integer getPlayerId() {
		return playerId;
	}
	public Double getAdjustment() {
		return adjustment;
	}
	public void setAdjustScoreId(Integer adjustScoreId) {
		this.adjustScoreId = adjustScoreId;
	}
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	public void setAdjustment(Double adjustment) {
		this.adjustment = adjustment;
	}
	
}
