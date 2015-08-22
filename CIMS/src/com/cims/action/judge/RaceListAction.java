package com.cims.action.judge;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.cims.base.frame.BaseAction;
import com.cims.process.RaceProcess;

public class RaceListAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	@Autowired
	private  RaceProcess raceProcess;
	@Action(value="racelist",results={@Result(name="input",location="/WEB-INF/content/judge/raceList.jsp")})
	public String list(){
		return INPUT;
	}
}
