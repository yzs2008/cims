package com.cims.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cims_award")
public class Award {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer awardId;
	private Integer raceId;
	private String awardName;
	private Integer count;
	private Integer start;
	public Integer getAwardId() {
		return awardId;
	}
	public Integer getRaceId() {
		return raceId;
	}
	public String getAwardName() {
		return awardName;
	}
	public Integer getCount() {
		return count;
	}
	public Integer getStart() {
		return start;
	}
	public void setAwardId(Integer awardId) {
		this.awardId = awardId;
	}
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	
}
