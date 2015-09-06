package com.cims.model.datastruct;

public enum ApplicationMode {
	auto("自动进行"),
	manual("手动进行");

	
	private final String tip;
	
	private ApplicationMode(String tip){
		this.tip=tip;
	}
	@Override
	public String toString() {
		return this.tip;
	}
}
