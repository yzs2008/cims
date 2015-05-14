package com.cims.base.type;

public enum ActionEnum {
	demo("demo");
	
	private final String name;

	private ActionEnum(String name){
		this.name=name;
	}

	@Override
	public String toString(){
		return name;
	}
}
