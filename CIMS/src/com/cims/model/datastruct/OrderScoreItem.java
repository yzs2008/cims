package com.cims.model.datastruct;

import com.cims.model.persist.SignUp;
import com.cims.model.persist.User;

public class OrderScoreItem {
	
	private User player;
	private SignUp production;
	private Double score;
	public User getPlayer() {
		return player;
	}
	public void setPlayer(User player) {
		this.player = player;
	}
	public SignUp getProduction() {
		return production;
	}
	public void setProduction(SignUp production) {
		this.production = production;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}

	
}
