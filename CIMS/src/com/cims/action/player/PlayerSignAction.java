package com.cims.action.player;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.cims.base.frame.BaseAction;

@Namespace("/")
public class PlayerSignAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	
	@Action(value="sign",results={@Result(name="input",location="/WEB-INF/content/player/sign.jsp")})
	public String sign(){
		return INPUT;
	}
	

}
