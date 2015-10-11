package com.cims.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitRaceListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent context) {
			context.getServletContext();
	}

	@Override
	public void contextDestroyed(ServletContextEvent context) {
		
	}
	
}
