package com.cims.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cims_promotion")
public class Promotion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer promotionId;
	private Integer raceId;
	private Integer nextId;
	private Integer start;
	private Integer end;
	public Integer getPromotionId() {
		return promotionId;
	}
	public Integer getRaceId() {
		return raceId;
	}
	public Integer getNextId() {
		return nextId;
	}
	public Integer getStart() {
		return start;
	}
	public Integer getEnd() {
		return end;
	}
	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
	public void setNextId(Integer nextId) {
		this.nextId = nextId;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	
}
