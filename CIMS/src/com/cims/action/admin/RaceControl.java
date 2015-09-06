package com.cims.action.admin;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.cims.base.frame.BaseAction;
import com.cims.model.datastruct.RaceState;
import com.cims.model.persist.Race;
import com.cims.process.RaceProcess;

@Namespace("/admin/race")
public class RaceControl extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	private RaceProcess raceProcess;

	private List<Race> raceList; 
	private RaceState[] raceStateList=RaceState.values();

	@Action(value = "index", results = { @Result(name = "input", location = "/WEB-INF/admin/race/controlpanel.jsp") })
	public String index(){
		try{
			raceList = raceProcess.retrieveList();
			return INPUT;
		}catch(Exception e){
			log.error(e);
			return ERROR;
		}
	}

	public List<Race> getRaceList() {
		return raceList;
	}

	public void setRaceList(List<Race> raceList) {
		this.raceList = raceList;
	}

	public RaceState[] getRaceStateList() {
		return raceStateList;
	}

	public void setRaceStateList(RaceState[] raceStateList) {
		this.raceStateList = raceStateList;
	}

}
