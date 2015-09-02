package com.clps.managersystem.utils;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

public class MySessionContext {
		private static MySessionContext instance;
		private HashMap<String,Object> mymap;
		
		private MySessionContext(){
			mymap=new HashMap<String,Object>();
		}
		
		public static MySessionContext getInstance(){
			if(instance==null){
				instance=new MySessionContext();
			}
			return instance;
		}
		
		public synchronized void addSession(HttpSession session){
			if(session!=null){
				mymap.put(session.getId(), session);
			}
		}
		
		
		public synchronized void delSession(HttpSession session){
			if(session!=null){
				mymap.remove(session.getId());
			}
		}
		
		public synchronized HttpSession getSession(String session_id){
			if(session_id==null) return null;
			return (HttpSession)mymap.get(session_id);
		}
		
}
