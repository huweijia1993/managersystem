package com.clps.managersystem.logproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.log4j.Logger;



/**
 * 
  * @ClassName: LogHandler
  * @Description: 日志记录方式：底层日志不使用代理，尽量描述清楚，服务层使用动态代理模式，提供简单日志剥离
  * @author Comsys-huweijia
  * @date 2015年8月29日 上午10:54:33
  *
 */

public class LogHandler implements InvocationHandler{

	private Object targetObject;
	private static Logger log=Logger.getLogger(LogHandler.class);
	
	public  Object newProxyInstance(Object targetObject){
		this.targetObject=targetObject;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader()
				, targetObject.getClass().getInterfaces(), this);
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		log.info("start-->>"+method.getName());
		StringBuilder sb=new StringBuilder();
		if(args!=null){
			sb.append("参数信息：");
			
			for(int i=0;i<args.length;i++){
				sb.append(args[i]);
			}
		}
		
		Object ret=null;
		try{
			ret=method.invoke(targetObject, args);
			log.info("success-->>"+method.getName());
		}catch(Exception e){
			log.error("error-->>"+method.getName()+sb.toString());
			throw e;
		}
		
		return ret;
	}

	
	
}
