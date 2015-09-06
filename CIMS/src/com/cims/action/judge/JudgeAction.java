package com.cims.action.judge;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.cims.base.frame.BaseAction;
import com.cims.base.type.ActionContant;
import com.cims.model.datastruct.ApplicationState;
import com.cims.model.persist.SignUp;
import com.cims.model.persist.User;
import com.cims.process.RaceProcess;
import com.opensymphony.xwork2.ActionContext;

@Namespace("/judge")
public class JudgeAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	@Autowired
	private  RaceProcess raceProcess;
	
	private User user;
	private SignUp signUp;

	/**
	 * 评审评分
	 * @return
	 */
	@Action(value="work",results={@Result(name="input",location="/WEB-INF/content/judge/work.jsp")})
	public String waitPage(){
		Map<String,Object> application=ActionContext.getContext().getApplication();
		ApplicationState appState=(ApplicationState) application.get(ActionContant.application_state);
		
		return INPUT;
	}
}
