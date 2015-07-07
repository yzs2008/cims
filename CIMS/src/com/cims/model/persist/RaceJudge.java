package com.cims.model.persist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cims_raceJudge")
public class RaceJudge {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer raceJudgeId;
	private Integer raceId;
	private Integer judgeId;
	private Integer status;
	private Integer weight;
	public Integer getRaceJudgeId() {
		return raceJudgeId;
	}
	public Integer getRaceId() {
		return raceId;
	}
	public Integer getJudgeId() {
		return judgeId;
	}
	public Integer getStatus() {
		return status;
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
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
}
