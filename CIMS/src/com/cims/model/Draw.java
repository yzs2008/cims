package com.cims.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cims_draw")
public class Draw {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer drawId;
	private Integer playerId;
	private Integer raceId;
	private Integer drawGroupId;
	private Integer orderSerial;
	public Integer getDrawId() {
		return drawId;
	}
	public Integer getPlayerId() {
		return playerId;
	}
	public Integer getRaceId() {
		return raceId;
	}
	public Integer getDrawGroupId() {
		return drawGroupId;
	}
	public Integer getOrderSerial() {
		return orderSerial;
	}
	public void setDrawId(Integer drawId) {
		this.drawId = drawId;
	}
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
	public void setDrawGroupId(Integer drawGroupId) {
		this.drawGroupId = drawGroupId;
	}
	public void setOrderSerial(Integer orderSerial) {
		this.orderSerial = orderSerial;
	}
	
}
