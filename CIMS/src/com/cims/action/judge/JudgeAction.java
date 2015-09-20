package com.cims.action.judge;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.cims.base.frame.BaseAction;
import com.cims.base.type.ActionContant;
import com.cims.model.datastruct.ApplicationState;
import com.cims.model.persist.Judge;
import com.cims.model.persist.JudgeScore;
import com.cims.model.persist.JudgeScoreDetail;
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

	private List<JudgeScoreDetail> detailList;
	private Double score;
	
	public JudgeAction() {
	}
	
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
	/**
	 * 保存评审评分
	 * @return
	 */
	@Action(value="saveScore",results={@Result(name="success",type="redirect",location="/judge/wait")}
							,interceptorRefs={@InterceptorRef("json")}
							)
	public String saveScore(){
		try{
			if(score==null || detailList==null || detailList.size()==0){
				return ERROR;
			}
			JudgeScore judgeScore=new JudgeScore();
			Judge judge=(Judge)ActionContext.getContext().getSession().get(ActionContant.session_judge);
			judgeScore.setJudge(judge);
			judgeScore.setScore(score);
			judgeScore.setRaceId(race.getRaceId());
			judgeScore.setPlayerId(user.getUserId());

			if(scoreProcess.saveScore(judgeScore,detailList)){
				//设置该评委的标志为已打分
			}else{
				
			}
			
		}catch(Exception e){
			log.error(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
}
