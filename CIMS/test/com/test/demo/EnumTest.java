package com.test.demo;

import com.cims.base.type.StateEnum;

public class EnumTest {

	public static void main(String[] args) {
		System.out.println(StateEnum.enable.toString());
		StateEnum enable=StateEnum.valueOf(StateEnum.enable.name());
		System.out.println(enable);
	}

}
