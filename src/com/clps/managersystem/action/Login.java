package com.clps.managersystem.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.clps.managersystem.logproxy.LogHandler;
import com.clps.managersystem.model.User;
import com.clps.managersystem.service.IUserService;
import com.clps.managersystem.utils.FileUtil;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements SessionAware{

	private LogHandler logHandler=new LogHandler();
	private User user;
	private Map<String,User> session;
	private IUserService ius=(IUserService)logHandler.newProxyInstance(FileUtil.getClassInstance(
			FileUtil.getProperties(Login.class.getClassLoader().getResource("reflectFile.properties").getPath()).getProperty("IUserService")));
	




	public void setSession(Map session){
		this.session=session;
	}
	
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	  * @Fields serialVersionUID : TODO
	  */
	
	private static final long serialVersionUID = -5039966374262991391L;

	@Override
	public String execute(){
		if(ius.checkUser(user)){
			session.put("USER", user);
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}
	
	@Override
	public void validate() {
		if(user.getUserName().length()==0){
			addFieldError("user.userName", this.getText("userName.required"));
		}
		if(user.getUserPassword().length()==0){ 
			addFieldError("user.userPassword", this.getText("password.required"));
		}
		
	
	}
	
	

	
}
