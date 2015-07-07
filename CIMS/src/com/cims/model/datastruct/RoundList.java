package com.cims.model.datastruct;

import java.util.ArrayList;
import java.util.List;

import com.cims.model.persist.Round;

public class RoundList {
	private List<RoundList> children =new ArrayList<RoundList>();
	private Round round;

	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	public List<RoundList> getChildren() {
		return children;
	}

	public void setChildren(List<RoundList> children) {
		this.children = children;
	}
	
}
