package com.clps.managersystem.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Title: LogoutAction.java 
 * @Package com.clps.systemmanagement.user.action 
 * @Description TODO
 * @author Osborn(LiYiJie)
 * @date 2015年8月30日 下午10:13:24 
 * @version v1.0
 */

public class LogoutAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L; //uid value
	
	private Map<String,Object> sessionMap; //sessionMap
	 
	 /**
	  * @Description quit logon
	  */
	 public String logout(){   
        if(sessionMap == null){  
            return "indexPage";  
		}  
		else{  
			sessionMap.remove("user");  
			return "indexPage";  
		}
	}

	 /**
	  * Description  set session
	  * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	  */
	@Override
	 public void setSession(Map<String,Object> sessionMap){
		 this.sessionMap = sessionMap;
	 }
	
}