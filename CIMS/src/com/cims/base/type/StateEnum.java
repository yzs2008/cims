package com.cims.base.type;

public enum StateEnum {
	enable("启用"),
	disable("禁用");
	
	private final String name;

	private StateEnum(String name){
		this.name=name;
	}

	@Override
	public String toString(){
		return name;
	}
}
