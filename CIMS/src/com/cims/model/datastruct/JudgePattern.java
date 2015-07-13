package com.cims.model.datastruct;

public enum JudgePattern {
	max_min_exclude_sum("去最大最小求和"),
	max_min_exclude_average("去最大最小求平均"),
	sum("求和"),
	expression("动态表达式"),
	average("求平均");
	
	private final String name;
	
	private JudgePattern(String name){
		this.name=name;
	}
	@Override
	public String toString() {
		return this.name;
	}
}
