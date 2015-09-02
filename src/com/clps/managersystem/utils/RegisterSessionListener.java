package com.clps.managersystem.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class RegisterSessionListener implements HttpSessionListener{

	public static Map<String,Object> map=new HashMap<String,Object>();
	private MySessionContext myc=MySessionContext.getInstance();
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {

		System.out.println("进来存储session"+myc);
		myc.addSession(event.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {

		HttpSession session=event.getSession();
		myc.delSession(session);
	}

	
	
	
}














