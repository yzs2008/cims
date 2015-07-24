package com.cims.model.datastruct;

public enum RaceState {
	close("关闭"),
	over("结束"),
	wait("未进行"),
	needConfig("未配置"),
	sign("报名");
	
	private final String name;
	
	private RaceState(String name){
		this.name=name;
	}
	@Override
	public String toString() {
		return this.name;
	}
}
