package com.cims.model.datastruct;

public enum RaceState {
	needConfig("未配置"),
	wait("未进行"),
	sign("报名"),
	signOver("报名结束"),
	underWay("正在进行"),
	over("结束");

	
	private final String name;
	
	private RaceState(String name){
		this.name=name;
	}
	@Override
	public String toString() {
		return this.name;
	}
}
