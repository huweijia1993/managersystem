package com.clps.managersystem.utils;


import java.util.Properties;

import com.clps.managersystem.pool.ConnectionPoolManager;
import com.clps.managersystem.pool.DBBean;
import com.clps.managersystem.transaction.TransactionManager;

public class DBUtil {

	private static ConnectionPoolManager cpm=ConnectionPoolManager.getInstance();
	/**
	 * 
	  * getTranManager
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: getTranManager
	  * @Description: 获取事务管理器
	  * @param @return    
	  * @return TransactionManager   
	  * @throws
	 */
	public static TransactionManager getTransactionManager(){
		return new TransactionManager(cpm.getConnection());
	}
	


	
	/**
	 * 
	  * getDefaultDBBean
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: getDefaultDBBean
	  * @Description: 默认DBBean属性
	  * @param     
	  * @return void   
	  * @throws
	 */
	public static DBBean getDefaultDBBean(){
		DBBean dbBean=new DBBean();

		Properties properties=FileUtil.getProperties(FileUtil.getClassesFile("dbBean.properties"));
		dbBean.setDriverName(properties.getProperty("driverName"));
		dbBean.setUrl(properties.getProperty("url"));
		dbBean.setUserName(properties.getProperty("userName"));
		dbBean.setPassword(properties.getProperty("password"));
		dbBean.setPoolName(properties.getProperty("poolName"));
		return dbBean;	
	}
	
	
}
