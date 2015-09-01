/**   
 * @Title: LoginAction.java 
 * @author Osborn(LiYiJie)
 */
package com.clps.managersystem.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.clps.managersystem.model.User;
import com.clps.managersystem.service.IUserService;
import com.clps.managersystem.utils.FileUtil;
import com.clps.managersystem.utils.ValidUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**  
 * @Title: LoginAction.java 
 * @Package com.clps.managersystem.action 
 * @Description TODO
 * @author Osborn(LiYiJie)
 * @date 2015年8月26日 下午10:01:56 
 * @version v1.0
 */
public class LoginAction extends ActionSupport implements ModelDriven<User>,SessionAware {

	/** @Fields serialVersionUID: */
	private static final long serialVersionUID = 1L;

	private User user=new User(); //User instance
	
	private IUserService ius=(IUserService)FileUtil.createNewInstance("IUserService");
	
	private Map<String,Object> session;	//session instance

	private List<User> list=new ArrayList<User>();
	
	/**
	 * @return list
	 */
	public List<User> getList() {
		return list;
	}
	/** 
	 * @param list need to define list 
	 */
	public void setList(List<User> list) {
		this.list = list;
	}
	
	public String toLoginPage(){
		
		return "loginPage";
	}
	
	/**
	 * @Description check user login 
	 * @return
	 */
	public String checkLogin(){
			System.out.println(user.getUserName()+"dafwe");
			if(ius.checkUser(user)){
				session.put("username",user.getUserName());
				if(user.getUserLevel().equals("1")){
					return "admin-success";

				}else if(user.getUserLevel().equals("0")){
					return "user-success";
				}else{
					return "input";
				}
			}else{
				return "input";
			}

	}

	public String show(){
		
		return SUCCESS;
	}
	
	/**
	 * Description: define sessionMap
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map) 
	 */
	@Override 
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	/**
	 * Description: getModerl method
	 * @return : 	user
	 * @see com.opensymphony.xwork2.ModelDriven#getModel() 
	 */ 
	@Override
	public User getModel() {
		return user;
	}

	/**
	 * 校验
	 */
	@Override
	public void validate(){
//		//验证用户登录
//		usd.checkLogin(user);
//		
		//1.非空
		String username=user.getUserName();
		String password = user.getUserPassword();
		if(!ValidUtil.isValid(username)){
			addFieldError("userName","username是必填项");
		}
		if(!ValidUtil.isValid(password)){
			addFieldError("userPassword","password是必填项");
		}
		//不能包含空格
		if(ValidUtil.isValidTrim(username)){
			addFieldError("userName", "username不能有空格");
		}
		if(ValidUtil.isValidTrim(password)){
			addFieldError("userPassword","password不能有空格");
		}
		

	}
}
