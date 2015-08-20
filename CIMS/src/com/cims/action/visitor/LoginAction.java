package com.cims.action.visitor;


import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.cims.base.frame.BaseAction;
import com.cims.base.type.ActionContant;
import com.cims.model.datastruct.Message;
import com.cims.model.persist.User;
import com.cims.process.UserProcess;


@Namespace("/")
public class LoginAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Autowired
	private UserProcess process;
	
	private String userName;
	private String password;
	private Message ajaxResult=new Message();
	
	@Action(value="login", results={@Result(name="input",location="/WEB-INF/content/visitor/login.jsp"),
									@Result(name="success",type="json",params={"root","ajaxResult","includeProperties","msg,state"}),
									@Result(name="deny",type="json",params={"root","ajaxResult","includeProperties","msg,state"})},
							interceptorRefs={@InterceptorRef("defaultStack"), @InterceptorRef(value="json")})
	public String login(){
		if(customValidate()){
			User user = process.login(userName, password);
			if(user==null || user.getUserId()==null){
				ajaxResult.setMsg("用户名或密码错误");
				ajaxResult.setState(false);
				return "deny";
			}
			sessionMap.put(ActionContant.session_user, user);
			ajaxResult.setMsg("登录成功");
			ajaxResult.setState(true);
			return SUCCESS;
		}
		return INPUT;
	}
//
//	@Action(value = "login", results = { @Result(name = "input", location = "/WEB-INF/content/visitor/login.jsp"), @Result(name = "success", location = "/index.jsp"),
//			@Result(name = "deny", type = "json", params = { "root", "ajaxResult", "includeProperties", "msg,state" }) }, interceptorRefs = { @InterceptorRef(value = "json"),
//			@InterceptorRef(value = "paramsPrepareParamsStack") })
//	public String login() {
//		if (customValidate()) {
//			User user = process.login(userName, password);
//			if (user == null || user.getUserId() == null) {
//				ajaxResult.setMsg("用户名或密码错误");
//				ajaxResult.setState(false);
//				return "deny";
//			}
//			sessionMap.put(ActionContant.session_user, user);
//			return SUCCESS;
//		}
//		return INPUT;
//	}
	@Action(value="logout",results={@Result(name="success",location="/index.jsp")})
	public String logout(){
		sessionMap.remove(ActionContant.session_user);
		return SUCCESS;
	}
	private boolean customValidate(){
		boolean accept=true;
		if(StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(password)){
			return accept;
		}
		return !accept;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Message getAjaxResult() {
		return ajaxResult;
	}
	public void setAjaxResult(Message ajaxResult) {
		this.ajaxResult = ajaxResult;
	}

}
