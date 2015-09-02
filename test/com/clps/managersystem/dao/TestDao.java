package com.clps.managersystem.dao;

import java.sql.Date;
import java.util.List;

import org.junit.Test;

import com.clps.managersystem.daofactory.IBaseDaoFactory;
import com.clps.managersystem.daofactory.UserDaoFactory;
import com.clps.managersystem.model.User;

public class TestDao {

	@Test
	public void testAdd(){
		String sql="insert into user (user_name,user_password,user_gender,user_birthday,user_hometown,user_height,user_active,user_email) values(?,?,?,?,?,?,?,?)";
		String[] paras=new String[]{"huweijia","12345","F",new Date(1993,12,13).toString(),"anhuiprovice","1.7","1","1316809562@qq.com"};
		IBaseDaoFactory<User> ibf=new UserDaoFactory();
		int id=ibf.createDao().add(sql,paras);
		System.out.println(id);
		
	}
	@Test
	public void testUpdate(){
		String sql="update users set userName=?,password=?,address=?,age=?,phone=?,rank=?";
		String[] paras=new String[]{"huweijiahuweiji","1234567890","anhuiprovice","23","18130172620","0",""};
		IBaseDaoFactory<User> ibf=new UserDaoFactory();
		boolean flag=ibf.createDao().update(sql,paras);
		System.out.println(flag);
	}
	@Test
	public void testDel(){
		String sql="delete from users where userName=?";
		String paras[]=new String[]{"huweijiahuweiji"};
		IBaseDaoFactory<User> ibf=new UserDaoFactory();
		boolean flag=ibf.createDao().delete(sql,paras);
		System.out.println(flag);
	}
	
	@Test
	public void testList(){
		String sql="select * from user limit 10,5";
		IBaseDaoFactory<User> ibf=new UserDaoFactory();
		List<User> list=ibf.createDao().list(sql);
		for(User user:list){
			System.out.println(user);
		}
		
		
	}
	
	
	
	
	
	
}
