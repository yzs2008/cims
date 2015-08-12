package com.cims.model.persist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cims_standard")
public class Standard {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer standardId;
	private String standardName;
	private Integer raceId;
	private Integer max;
	private Integer min;

	public Integer getStandardId() {
		return standardId;
	}
	public String getStandardName() {
		return standardName;
	}
	public Integer getRaceId() {
		return raceId;
	}
	public Integer getMax() {
		return max;
	}
	public Integer getMin() {
		return min;
	}
	public void setStandardId(Integer standardId) {
		this.standardId = standardId;
	}
	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
	
}
