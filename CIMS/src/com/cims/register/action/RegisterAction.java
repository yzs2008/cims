package com.cims.register.action;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.cims.base.frame.BaseAction;
import com.cims.register.model.User;

@Namespace("/")
@Results({ @Result(name = "error", location = "/error/error.jsp") })
public class RegisterAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private User user;

	@Action(value = "register", results = { @Result(name = "success", location = "/WEB-INF/content/register/register.jsp") })
	public String execute(){
		
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
