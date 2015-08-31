package com.clps.managersystem.daofactory;

import com.clps.managersystem.dao.IBaseDao;

public interface IBaseDaoFactory<T> {

	public  IBaseDao<T> createDao();
		

	
	
}
