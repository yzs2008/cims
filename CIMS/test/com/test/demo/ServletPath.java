package com.test.demo;

public class ServletPath {
	public static void main(String[] args){
		String URL="http://localhost:8080/cims/admin/judge/add";
		String contextPath="cims";
		String path=URL.substring(0,URL.indexOf(contextPath)+contextPath.length()
				)+"/";
		System.out.println(path);
	}
}
