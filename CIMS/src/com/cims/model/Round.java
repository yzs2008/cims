package com.cims.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cims_round")
public class Round {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer roundId;
	private String roundName;
	private Integer parent;
	private String hasNode;
	private String state;
	public Integer getRoundId() {
		return roundId;
	}
	public void setRoundId(Integer roundId) {
		this.roundId = roundId;
	}
	public String getRoundName() {
		return roundName;
	}
	public void setRoundName(String roundName) {
		this.roundName = roundName;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
