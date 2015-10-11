package com.cims.model.datastruct;

import java.util.ArrayList;
import java.util.List;

import com.cims.model.persist.Race;

public class ApplicationChairman {

	/**
	 * 存放当前系统中所有的正在进行的比赛
	 */
	public List<Race> raceList = new ArrayList<Race>();

	static Object lock = new Object();

	private ApplicationChairman() {
	}

	static ApplicationChairman chairman;

	public static ApplicationChairman getInstance() {
		if (chairman == null) {
			synchronized (lock) {
				if (chairman == null) {
					chairman = new ApplicationChairman();
				}
			}
		}
		return chairman;
	}

}
