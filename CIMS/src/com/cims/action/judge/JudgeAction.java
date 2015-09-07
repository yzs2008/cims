package com.cims.action.judge;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.cims.base.frame.BaseAction;
import com.cims.base.type.ActionContant;
import com.cims.model.datastruct.ApplicationState;
import com.cims.model.persist.Race;
import com.cims.model.persist.SignUp;
import com.cims.model.persist.Standard;
import com.cims.model.persist.User;
import com.cims.process.RaceProcess;
import com.cims.process.ScoreProcess;
import com.opensymphony.xwork2.ActionContext;

@Namespace("/judge")
public class JudgeAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	@Autowired
	private  RaceProcess raceProcess;
	@Autowired
	private ScoreProcess scoreProcess;
	
	private User user;
	private SignUp signUp;
	private Race race;
	private List<Standard> raceStandardList;

	/**
	 * 评审评分
	 * @return
	 */
	@Action(value="work",results={@Result(name="input",location="/WEB-INF/content/judge/work.jsp")})
	public String waitPage(){
		Map<String,Object> application=ActionContext.getContext().getApplication();
		ApplicationState appState=(ApplicationState) application.get(ActionContant.application_state);
		user=appState.getCurPlayer();
		race=appState.getCurRace();
		signUp=scoreProcess.getSignUpByUser(user,race);
		raceStandardList=raceProcess.retrieveStandard(race.getRaceId());
		return INPUT;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SignUp getSignUp() {
		return signUp;
	}

	public void setSignUp(SignUp signUp) {
		this.signUp = signUp;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public List<Standard> getRaceStandardList() {
		return raceStandardList;
	}

	public void setRaceStandardList(List<Standard> raceStandardList) {
		this.raceStandardList = raceStandardList;
	}
}
