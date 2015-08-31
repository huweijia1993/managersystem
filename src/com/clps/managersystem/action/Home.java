package com.clps.managersystem.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class Home extends ActionSupport{

	/**
	  * @Fields serialVersionUID : TODO
	  */
	
	private static final long serialVersionUID = -3915862908605933851L;



	

	private  Map<String,String> locales=new HashMap<String,String>();
	
	
	public Map<String, String> getLocales() {
		return locales;
	}




	public void setLocales(Map<String, String> locales) {
		this.locales = locales;
	}




	public Home(){
		locales.put("en_US", "English");
		locales.put("zh_CN", "中文");
	}
		


	
	@Override
	public String execute(){
		return SUCCESS;
	}
	
	
	
}
