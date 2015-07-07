package com.cims.model.persist;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cims_round")
public class Round {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer roundId;
	private String roundName;
	private Integer parent;
	private String parentName;
	private boolean hasNode;
	private String state;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	private String description;
	
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public String getDescription() {
		return description;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public boolean isHasNode() {
		return hasNode;
	}
	public void setHasNode(boolean hasNode) {
		this.hasNode = hasNode;
	}
	
}
