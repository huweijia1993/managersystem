package com.clps.managersystem.transaction;

import org.apache.log4j.Logger;

import com.clps.managersystem.utils.DBUtil;

public class TransactionTemplate {

	private static Logger logger=Logger.getLogger(TransactionTemplate.class);
	
	public static <T> T execute(TransactionCallback<T> callback){
		
		T result=null;
		TransactionManager tx=null;
		logger.info("TransactionManager init");
		tx=DBUtil.getTransactionManager();
		//开启事务
		tx.beginTransaction();
		//执行回调方法
		result=callback.doInTransaction();
		//提交事务并关闭
		tx.commitAndClose();
			
		logger.info("TransactionManager end");
		return result;
	}
	
	
	public static<T> void executeWithoutResult(TransactionCallbackWithoutResult callback){
		TransactionManager tx=null;
		logger.info("TransactionManager init");
		
		tx=DBUtil.getTransactionManager();
		tx.beginTransaction();
		callback.doInTransactionWithoutResoult();
		tx.commitAndClose();
		logger.info("TransactionManager end");
		
		
	}
	
	
	
}
