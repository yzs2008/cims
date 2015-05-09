package com.cims.register.action;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@Results({ @Result(name = "error", location = "/error/error.jsp") })
public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Action(value = "register", results = { @Result(name = "success", location = "/index.html") })
	public String execute(){
		return SUCCESS;
	}
}
