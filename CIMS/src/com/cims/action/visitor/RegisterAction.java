package com.cims.action.visitor;


import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.cims.base.frame.BaseAction;
import com.cims.base.type.ActionContant;
import com.cims.model.persist.User;
import com.cims.process.UserProcess;


@Namespace("/")
public class RegisterAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private User user;
	@Autowired
	private UserProcess process;
	
	private final String default_avatar="/images/sys/player_default.png";

	@Action(value = "register", results = { @Result(name = "success", location = "/WEB-INF/content/visitor/login.jsp") 
											,@Result(name="input",location="/WEB-INF/content/visitor/login.jsp")
											,@Result(name="slip",type="redirect",location="slip")
										  })
	public String register(){
		if(sessionMap.get(ActionContant.session_user)!=null){
			if(sessionMap.get(ActionContant.session_slip)==null){
				String tip="请先注销当前登录再执行注册操作！";
				sessionMap.put(ActionContant.session_slip,tip);
			}
			return ActionContant.result_slip;
		}
		if(customerValidate()){
			user.setAvatar(default_avatar);
			user.setRegisterTime(new Date());
			if(process.saveRegister(user)){
				return SUCCESS;
			}
			return ERROR;
		}
		return INPUT;
	}
	private boolean customerValidate(){
		boolean accept=true;
		if(user==null){
			return !accept;
		}
		if(StringUtils.trimToEmpty(user.getEmail())==""){
			return !accept;
		}
		return accept;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
