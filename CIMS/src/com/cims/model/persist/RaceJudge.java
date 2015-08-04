package com.cims.model.persist;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cims.base.type.StateEnum;

@Entity
@Table(name="cims_raceJudge")
public class RaceJudge {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer raceJudgeId;
	private Integer raceId;
	private Integer judgeId;
	@Enumerated(EnumType.STRING)
	private StateEnum status;
	private Integer weight;
	private String displayName;
	
	public RaceJudge(){
		
	}
	
	public Integer getRaceJudgeId() {
		return raceJudgeId;
	}
	public Integer getRaceId() {
		return raceId;
	}
	public Integer getJudgeId() {
		return judgeId;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setRaceJudgeId(Integer raceJudgeId) {
		this.raceJudgeId = raceJudgeId;
	}
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
	public void setJudgeId(Integer judgeId) {
		this.judgeId = judgeId;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public StateEnum getStatus() {
		return status;
	}

	public void setStatus(StateEnum status) {
		this.status = status;
	}
	
}
