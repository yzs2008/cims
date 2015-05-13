package com.cims.base.frame;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author kaidi
 * @Date 2015年5月13日
 */
public class BaseAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = -1068930277410067087L;
	
	protected final transient Logger log;
	
	protected Map<String,Object> sessionMap;
	
	protected ActionContext context;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	public BaseAction(){
		context=ActionContext.getContext();
		request=(HttpServletRequest)context.get(ServletActionContext.HTTP_REQUEST);
		response=(HttpServletResponse)context.get(ServletActionContext.HTTP_RESPONSE);
		log=Logger.getLogger(BaseAction.class); 
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;
	}
	
}
