package com.cims.action.judge;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.cims.base.frame.BaseAction;
import com.cims.base.type.ActionContant;
import com.cims.model.persist.Judge;
import com.cims.model.persist.Race;
import com.cims.process.RaceProcess;

@Namespace("/judge")
@InterceptorRef("judgeInterceptorStack")
public class RaceListAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	@Autowired
	private  RaceProcess raceProcess;
	
	private List<Race> raceList;

	@Action(value="racelist",results={@Result(name="input",location="/WEB-INF/content/judge/raceList.jsp")})
	public String list(){
		try{
			Judge judge=(Judge)sessionMap.get(ActionContant.session_judge);
			raceList=raceProcess.getRaceListByJudge(judge);
		}catch(Exception e){
			log.error(e);
			return ERROR;
		}
		return INPUT;
	}

	public List<Race> getRaceList() {
		return raceList;
	}

	public void setRaceList(List<Race> raceList) {
		this.raceList = raceList;
	}
	
}
