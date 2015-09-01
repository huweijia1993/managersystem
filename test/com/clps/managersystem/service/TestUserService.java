package com.clps.managersystem.service;

import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.clps.managersystem.logproxy.LogHandler;
import com.clps.managersystem.model.User;
import com.clps.managersystem.serviceimpl.UserServiceImpl;
import com.clps.managersystem.utils.FileUtil;
import com.clps.managersystem.utils.SystemContext;

public class TestUserService {

	@Test
	public void test1(){
		IUserService ius=new UserServiceImpl();
		User user=new User();
		user.setUserName("hu");
		user.setUserPassword("hu12");
		boolean flag=ius.checkUser(user);
		System.out.println(flag);
	}
	
	@Test
	public void testProxy(){
		IUserService ius=(IUserService)FileUtil.createNewInstance("IUserService");
		
		User user=new User();
		user.setUserName("hu");
		user.setUserPassword("hu123");
		
		boolean flag=ius.checkUser(user);
		System.out.println(flag);
	}
	/**
	 * 
	  * testPage
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: testPage
	  * @Description: 测试用户分页
	  * @param     
	  * @return void   
	  * @throws
	 */
	@Test
	public void testPage(){
		LogHandler logHandler=new LogHandler();
		Properties properties=FileUtil.getProperties(FileUtil.getClassesFile("reflectFile.properties"));
		String fileName=properties.getProperty("IUserService");
		System.out.println("dd"+fileName);
		IUserService ius=(IUserService)logHandler.newProxyInstance(FileUtil.getClassInstance(fileName));
		
		SystemContext.setPageNo(1);
		SystemContext.setPageSize(5);
		
		List<User> users=ius.getUserByPage();
		for(User user:users){
			System.out.println(user.toString());
		}
	
	
	
	}
	
	
	
	
	
}
