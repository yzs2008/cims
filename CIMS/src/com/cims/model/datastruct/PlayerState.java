package com.cims.model.datastruct;

public enum PlayerState {
	normal("正常"),
	giveUp("弃权"),
	absent("未到"),
	cheat("作弊");

	
	private final String tip;
	
	private PlayerState(String tip){
		this.tip=tip;
	}
	@Override
	public String toString() {
		return this.tip;
	}
}
