package com.clps.managersystem.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Log4jListener implements ServletContextListener{
	
	public static final String log4jdirkey="log4jdir";

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.getProperties().remove(log4jdirkey);
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {

		String log4jdir=servletContextEvent.getServletContext().getRealPath("/");
		
		System.setProperty(log4jdirkey,log4jdir);
	}
	
	
	
	
}
