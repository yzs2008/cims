package com.cims.action.main;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.cims.base.frame.BaseAction;

@Namespace("/main")
public class ScreenShow extends BaseAction {
	private static final long serialVersionUID = 7602284715386060788L;

	@Action(value = "orderscore", results = { @Result(name = "input", location = "/WEB-INF/content/main/orderScore.jsp"),
			@Result(name = "back", type = "redirect", location = "wait") })
	public String orderScore(){
		return INPUT;
	}
}
