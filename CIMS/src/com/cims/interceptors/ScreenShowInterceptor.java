package com.cims.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cims.base.type.ActionContant;
import com.cims.model.persist.Race;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ScreenShowInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		Race race = (Race) session.get(ActionContant.session_screen_race);
		if (race == null) {
			// 没有登录，跳转登录
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpServletRequest request = ServletActionContext.getRequest();
			String ctx = request.getContextPath();
			if (request.getRequestURI().indexOf("/choose") == -1) {
				String url=request.getRequestURI();
				url=url.substring(request.getContextPath().length());
				session.put("previousUrl", url);

				String loginUrl = ctx + "/main/choose";
				response.sendRedirect(loginUrl);
				return null;

			}
		}

		return invocation.invoke();
	}

}
