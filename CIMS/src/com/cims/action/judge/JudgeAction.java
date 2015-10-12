package com.cims.action.judge;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cims.base.frame.BaseAction;
import com.cims.base.frame.HttpUtils;
import com.cims.base.type.ActionContant;
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
@InterceptorRef("judgeInterceptorStack")
public class JudgeAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	private RaceProcess raceProcess;
	@Autowired
	private ScoreProcess scoreProcess;

	private User user;
	private SignUp signUp;
	private Race race;
	private List<Standard> raceStandardList;

	private List<JudgeScoreDetail> detailList;
	private Double score;
	//private Integer userId;

	private Judge judge;

	public JudgeAction() {
	}

	/**
	 * 评审评分
	 * 
	 * @return
	 */
	@Action(value = "work", results = { @Result(name = "input", location = "/WEB-INF/content/judge/work.jsp"),
			@Result(name = "back", type = "redirect", location = "wait") })
	public String waitPage() {
		try {
			judge = (Judge) sessionMap.get(ActionContant.session_judge);
			race = (Race) sessionMap.get(ActionContant.session_race);
			user = scoreProcess.getCurPlayer(race);
			// 查看该评委是否已经给该选手打过分，打过分了，直接返回等待页面。没打分方可进入。
			if (scoreProcess.isScored(judge, race, user)) {
				return "back";
			}
			sessionMap.remove(ActionContant.session_user);
			sessionMap.put(ActionContant.session_user, user);
			signUp = scoreProcess.getSignUpByUser(user, race);
			raceStandardList = raceProcess.retrieveStandard(race.getRaceId());
			return INPUT;
		} catch (Exception e) {
			log.error(e);
			return ERROR;
		}
	}

	/**
	 * 保存评审评分
	 * 
	 * @return
	 * @throws IOException
	 */
	@Action(value = "saveScore", interceptorRefs = { @InterceptorRef(value = "json") })
	public void saveScore() throws IOException {
		JSONObject resultData = new JSONObject();
		try {
			if (score == null || detailList == null || detailList.size() == 0 ) {
				resultData.put("resultData", "error");
				return;
			}
			
			JudgeScore judgeScore = new JudgeScore();
			Judge judge = (Judge) ActionContext.getContext().getSession().get(ActionContant.session_judge);
			race = (Race) sessionMap.get(ActionContant.session_race);
			user =(User)sessionMap.get(ActionContant.session_user);
			judgeScore.setJudge(judge);
			judgeScore.setScore(score);
			judgeScore.setRaceId(race.getRaceId());
			judgeScore.setPlayerId(user.getUserId());

			if (!scoreProcess.isJudgeScored(judgeScore)) {
				if (scoreProcess.saveScore(judgeScore, detailList)) {
					// 检测打分状态
					scoreProcess.checkScoreState(judgeScore);
					resultData.put("resultData", "done");
				} else {
					log.error("无法保存成绩：[" + judgeScore + "]");
					resultData.put("resultData", "error");
				}
			} else {
				//已经存在成绩，不允许重复打分
				resultData.put("resultData", "error2");
			}

		} catch (Exception e) {
			log.error(e);
			resultData.put("resultData", "error");
		}

		String resultJson = resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}

	public SignUp getSignUp() {
		return signUp;
	}

	public void setSignUp(SignUp signUp) {
		this.signUp = signUp;
	}

	public List<Standard> getRaceStandardList() {
		return raceStandardList;
	}

	public void setRaceStandardList(List<Standard> raceStandardList) {
		this.raceStandardList = raceStandardList;
	}

	public List<JudgeScoreDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<JudgeScoreDetail> detailList) {
		this.detailList = detailList;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Judge getJudge() {
		return judge;
	}

	public void setJudge(Judge judge) {
		this.judge = judge;
	}

}
