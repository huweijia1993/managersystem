package com.clps.managersystem.daofactory;

import com.clps.managersystem.dao.IBaseDao;
import com.clps.managersystem.daoimpl.UserDaoImpl;
import com.clps.managersystem.model.User;

public class UserDaoFactory implements IBaseDaoFactory<User>{

	@Override
	public  IBaseDao<User> createDao() {
		// TODO Auto-generated method stub
		//先简单用new形式，可改为反射动态加载
		return new UserDaoImpl();
	}

	
	
}
