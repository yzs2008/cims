package com.cims.model.datastruct;

public enum RaceState {
	needConfig("未配置"),
	sign("报名"),
	signOver("报名结束"),
	wait("未进行"),
	underWay("正在进行"),
	over("结束");
//	needConfig("needConfig","未配置"),
//	wait("wait","未进行"),
//	sign("sign","报名"),
//	signOver("signOver","报名结束"),
//	underWay("underWay","正在进行"),
//	over("结束");

	
	private final String tip;
//	private final String key;
	
	private RaceState(String tip){
		this.tip=tip;
		//this.key=key;
	}
	@Override
	public String toString() {
		return this.tip;
	}
}
