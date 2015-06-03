package com.test.demo;

import java.net.URL;


public class ClassPath {

	public static void main(String[] args) {
		ClassPath path=new ClassPath();
		path.getResourcePath();
	}
	
	public String getResourcePath(){
		ClassPath2 path2=new ClassPath2();
		URL url= path2.getClass().getResource("/");
		String path=path2.getClass().getResource("/").getPath();
		System.out.println(path);
		return path;
	}

}
