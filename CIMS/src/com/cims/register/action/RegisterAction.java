package com.cims.register.action;


import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.cims.base.frame.BaseAction;
import com.cims.register.model.User;
import com.cims.register.process.UserProcess;


@Namespace("/")
@Results({ @Result(name = "error", location = "/error/error.jsp") })
public class RegisterAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private User user;
	@Autowired
	private UserProcess process;

	public String execute(){
		return INPUT;
	}
	@Action(value = "register", results = { @Result(name = "success", location = "/WEB-INF/content/register/register.jsp") 
											,@Result(name="input",location="/WEB-INF/content/register/register.jsp")
										  })
	public String register(){
		if(customerValidate()){
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
