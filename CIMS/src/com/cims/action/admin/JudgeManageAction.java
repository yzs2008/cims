package com.cims.action.admin;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.cims.base.frame.BaseAction;
import com.cims.model.Judge;
import com.cims.process.JudgeProcess;

@Namespace("/admin/judge")
public class JudgeManageAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private JudgeProcess judgeProcess;
	
	private Judge judge;

	@Action(value="add",results={@Result(name="input",location="/WEB-INF/admin/judge/add.jsp"),
								 @Result(name="success",location="list")
								})
	public String addJudge(){
		if(accept()){
			if(judgeProcess.saveJudge(judge)){
				return SUCCESS;
			}
			return ERROR;
		}
		return INPUT;
	}
	private boolean accept(){
		boolean accept=true;
		if(judge==null){
			return !accept;
		}
		if(!(StringUtils.isNotEmpty(judge.getJudgeName()) && StringUtils.isNotEmpty(judge.getPassword()))){
			return !accept;
		}
		return accept;
	}

	@Action(value="list",results={@Result(name="input",location="/WEB-INF/admin/judge/list.jsp")})
	public String judgeList(){
		return INPUT;
	}

	public Judge getJudge() {
		return judge;
	}

	public void setJudge(Judge judge) {
		this.judge = judge;
	}

}
