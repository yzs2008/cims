package com.cims.model.datastruct;

public enum DrawPattern {
	auto("自动随机排序"),
	defaultOrder("默认排序"),
	handy("手工排序");
	
	private final String name;
	
	private DrawPattern(String name){
		this.name=name;
	}
	@Override
	public String toString() {
		return this.name;
	}
}
