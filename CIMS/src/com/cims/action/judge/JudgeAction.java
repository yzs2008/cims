package com.cims.action.judge;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.cims.base.frame.BaseAction;
import com.cims.process.RaceProcess;

@Namespace("/judge")
public class JudgeAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	@Autowired
	private  RaceProcess raceProcess;

	/**
	 * 评审评分
	 * @return
	 */
	@Action(value="work",results={@Result(name="input",location="/WEB-INF/content/judge/work.jsp")})
	public String waitPage(){
		return INPUT;
	}
}
