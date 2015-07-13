package com.cims.model.persist;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cims.model.datastruct.JudgePattern;

@Entity
@Table(name="cims_race")
public class Race {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer raceId;
	private String raceName;
	private Integer roundId;
	private String roundName;
	private String host;
	private String place;
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	private String qualification;
	private String state;
	private String description;
	@Enumerated(EnumType.STRING)
	private JudgePattern judgePattern;
	private String judgeRuler;
	private Integer voteTime;
	private String drawPattern;
	private String eraseGroup;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
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
	public JudgePattern getJudgePattern() {
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
	public void setJudgePattern(JudgePattern judgePattern) {
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRoundName() {
		return roundName;
	}
	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}
	
}
