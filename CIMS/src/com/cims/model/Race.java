package com.cims.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cims_race")
public class Race {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer raceId;
	private String raceName;
	private Integer roundId;
	private String host;
	private String place;
	private Date startTime;
	private String qualification;
	private String state;
	private String description;
	private String judgePattern;
	private String judgeRuler;
	private Integer voteTime;
	private String drawPattern;
	private String eraseGroup;
	public Integer getRaceId() {
		return raceId;
	}
	public String getRaceName() {
		return raceName;
	}
	public Integer getRoundId() {
		return roundId;
	}
	public String getHost() {
		return host;
	}
	public String getPlace() {
		return place;
	}
	public Date getStartTime() {
		return startTime;
	}
	public String getQualification() {
		return qualification;
	}
	public String getState() {
		return state;
	}
	public String getDescription() {
		return description;
	}
	public String getJudgePattern() {
		return judgePattern;
	}
	public String getJudgeRuler() {
		return judgeRuler;
	}
	public Integer getVoteTime() {
		return voteTime;
	}
	public String getDrawPattern() {
		return drawPattern;
	}
	public String getEraseGroup() {
		return eraseGroup;
	}
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	public void setRoundId(Integer roundId) {
		this.roundId = roundId;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setJudgePattern(String judgePattern) {
		this.judgePattern = judgePattern;
	}
	public void setJudgeRuler(String judgeRuler) {
		this.judgeRuler = judgeRuler;
	}
	public void setVoteTime(Integer voteTime) {
		this.voteTime = voteTime;
	}
	public void setDrawPattern(String drawPattern) {
		this.drawPattern = drawPattern;
	}
	public void setEraseGroup(String eraseGroup) {
		this.eraseGroup = eraseGroup;
	}
	
}
