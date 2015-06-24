package com.cims.base.frame;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class HttpUtils {
	public static void responseJson(String resultJson, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		if (resultJson == null)
			resultJson = "";
		response.getWriter().write(resultJson);
	}
}
