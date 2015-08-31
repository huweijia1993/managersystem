package com.clps.managersystem.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.clps.managersystem.exception.DaoException;
import com.clps.managersystem.exception.ManagerSystemException;
import com.clps.managersystem.exception.ServiceException;
import com.clps.managersystem.exception.TransactionException;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ExceptionInterceptor implements Interceptor{

	/**
	  * @Fields serialVersionUID : TODO
	  */
	
	private static final long serialVersionUID = -1322308508707809577L;

	public void destroy(){
		
	}
	
	public void init(){
		
	}
	
	/**
	 * 拦截所有异常并处理
	 */
	public String intercept(ActionInvocation actionInvocation) throws Exception{
		
		try{
			return actionInvocation.invoke();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("异常发生了，必须进来,快到碗里来"+e.getMessage());
			
			if(e instanceof ManagerSystemException){
				System.out.println("是自定义异常");
				System.out.println(((ManagerSystemException) e).getCode());
				HttpServletRequest request=(HttpServletRequest)
						actionInvocation.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("msg", e.getMessage());
				request.setAttribute("cause", e.getCause());
				request.setAttribute("code", ((ManagerSystemException) e).getCode());
				
				//自定义异常，可以分类处理
				if(e instanceof DaoException|| e instanceof TransactionException){
					//dao层异常，用户处理不了，直接跳到系统错误页面，并打印出出错信息
					
					return "systemError";
				}else if(e instanceof ServiceException){
					//业务层异常，返回提交页面，让用户自己处理
					
					return "input";
				}else{
					request.setAttribute("msg", "未知异常，请通知管理员");
					request.setAttribute("code", -1);
					return "systemError";
				}
				
				
			}else{
				//未知异常，直接扔到error.jsp
				HttpServletRequest request=(HttpServletRequest)
						actionInvocation.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
				request.setAttribute("msg", "未知异常，请通知管理员");
				request.setAttribute("code", -1);
				return "systemError";
			}
		}

	
		
		
		
	}
	
	
}
