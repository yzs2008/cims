package com.cims.model.persist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="cims_draw")
public class Draw {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer drawId;
	private Integer userId;
	private Integer raceId;
	private Integer orderSerial;
	@Type(type="true_false")
	private Boolean scored;
	
	public Integer getDrawId() {
		return drawId;
	}

	public Integer getRaceId() {
		return raceId;
	}
	public Integer getOrderSerial() {
		return orderSerial;
	}
	public void setDrawId(Integer drawId) {
		this.drawId = drawId;
	}

	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
	public void setOrderSerial(Integer orderSerial) {
		this.orderSerial = orderSerial;
	}
	public Boolean getScored() {
		return scored;
	}
	public void setScored(Boolean scored) {
		this.scored = scored;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
