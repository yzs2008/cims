package com.cims.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cims_voteDetail")
public class VoteDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer voteDetailId;
	private Integer voteId;
	private String IP;
	private Date time;

	public Integer getVoteDetailId() {
		return voteDetailId;
	}
	public void setVoteDetailId(Integer voteDetailId) {
		this.voteDetailId = voteDetailId;
	}
	public Integer getVoteId() {
		return voteId;
	}
	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
