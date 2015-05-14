package com.cims.register.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;

import com.cims.base.frame.BaseAction;
import com.cims.base.type.ActionContant;
import com.cims.base.type.ActionEnum;
import com.cims.register.model.User;
import com.cims.register.process.UserProcess;


@Namespace("/")
public class LoginAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Autowired
	private UserProcess process;
	
	private String userName;
	private String password;
	
	@Action(value="login", results={@Result(name="input",location="/WEB-INF/content/register_login/login.jsp"),
									@Result(name="success",location="/index.jsp")})
	public String login(){
		if(customValidate()){
			User user = process.login(userName, password);
			if(user==null || user.getUserId()==null){
				return INPUT;
			}
			sessionMap.put(ActionContant.session_user, user);
			return SUCCESS;
		}
		return INPUT;
	}
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
	

}
