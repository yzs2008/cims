package com.cims.model;

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
	private Integer parent;
	private String hasNode;
	private Integer max;
	private Integer min;
	private Integer serial;
	public Integer getStandardId() {
		return standardId;
	}
	public void setStandardId(Integer standardId) {
		this.standardId = standardId;
	}
	public String getStandardName() {
		return standardName;
	}
	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	public String getHasNode() {
		return hasNode;
	}
	public void setHasNode(String hasNode) {
		this.hasNode = hasNode;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	
}
