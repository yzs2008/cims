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

import com.cims.model.datastruct.DrawPattern;
import com.cims.model.datastruct.JudgePattern;
import com.cims.model.datastruct.RaceState;

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
	/**
	 * 赛事状态
	 */
	@Enumerated(EnumType.STRING)
	private RaceState state;
	private String description;
	@Enumerated(EnumType.STRING)
	private JudgePattern judgePattern;
	private String judgeRuler;
	private Integer voteTime;
	@Enumerated(EnumType.STRING)
	private DrawPattern drawPattern;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	/**
	 * 备注字段，存放临时数据
	 */
	private String mark;
	
	public Race(){
		
	}
	
	
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
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRoundName() {
		return roundName;
	}
	public String getMark() {
		return mark;
	}


	public void setMark(String mark) {
		this.mark = mark;
	}


	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}
	public DrawPattern getDrawPattern() {
		return drawPattern;
	}
	public void setDrawPattern(DrawPattern drawPattern) {
		this.drawPattern = drawPattern;
	}


	public RaceState getState() {
		return state;
	}


	public void setState(RaceState state) {
		this.state = state;
	}
	
}
