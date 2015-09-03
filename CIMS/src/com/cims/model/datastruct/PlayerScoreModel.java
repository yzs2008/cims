package com.cims.model.datastruct;

import com.cims.model.persist.User;

public class PlayerScoreModel {
	private User user;
	private Double score;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user=new User();
		this.user.setUserId(user.getUserId());
		this.user.setUserName(user.getUserName());
		this.user.setRealName(user.getRealName());
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	
	
}
