package com.cims.action.common;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.cims.base.frame.BaseAction;
import com.cims.base.type.ActionContant;

@Namespace("/")
public class ErrorAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private String message="错的莫名奇妙的";

	@Action(value="slip",results={@Result(name="input",location="/errorPage/slip.jsp")})
	public String slip(){
		if(sessionMap.get(ActionContant.session_slip)!=null){
			message=sessionMap.get(ActionContant.session_slip).toString();
			sessionMap.remove(ActionContant.session_slip);
		}
		return INPUT;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
