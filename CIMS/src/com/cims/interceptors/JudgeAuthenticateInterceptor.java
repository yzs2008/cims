package com.cims.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cims.base.type.ActionContant;
import com.cims.model.persist.Judge;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class JudgeAuthenticateInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context=ActionContext.getContext();
		Map<String,Object> session=context.getSession();
		Judge judge=(Judge)session.get(ActionContant.session_judge);
		if(judge==null){
			//没有登录，跳转登录
			HttpServletResponse response=ServletActionContext.getResponse();
			HttpServletRequest request=ServletActionContext.getRequest();
			String ctx=request.getContextPath();
			String loginUrl=ctx+"/judge/login";
			//获取当前路径，如果登录成功，跳转回来
			String url=request.getRequestURI();
			session.put("previousUrl", url);
			response.sendRedirect(loginUrl); 
			return null;
		}
		
		return invocation.invoke();
	}
	
	

}
