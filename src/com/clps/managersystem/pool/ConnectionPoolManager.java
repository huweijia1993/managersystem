package com.clps.managersystem.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.clps.managersystem.exception.DaoException;
import com.clps.managersystem.exception.ExceptionCode;
import com.clps.managersystem.utils.DBUtil;


public class ConnectionPoolManager {

	private static Logger logger=Logger.getLogger(ConnectionPoolManager.class);
	private static String defaultPoolName;
	
	
	public Hashtable<String,IConnectionPool> pools=
			new Hashtable<String,IConnectionPool>();
	
	private ConnectionPoolManager(){
		init();
	}
	
	public static ConnectionPoolManager getInstance(){
		return Singtonle.instance;
	}
	
	/**
	 * 
	  * @ClassName: Singtonle
	  * @Description: 单例实现
	  * @author Comsys-huweijia
	  * @date 2015年8月27日 上午10:56:34
	  *
	 */
	private static class Singtonle{
		private static ConnectionPoolManager instance=
				new ConnectionPoolManager();
	}
	
	/**
	 * 
	  * init
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: init
	  * @Description: 初始化dbBean属性
	  * @param     
	  * @return void   
	  * @throws
	 */
	private void init(){
		logger.info("poolManager init start");
		try{
			DBBean dbBean=DBUtil.getDefaultDBBean();
			ConnectionPoolImpl pool=new ConnectionPoolImpl(dbBean);
			defaultPoolName=dbBean.getPoolName();
			pools.put(dbBean.getPoolName(), pool);
			logger.info(dbBean.getPoolName()+" init success");
		}catch(Exception e){
			logger.info("poolManager init error");
			throw new DaoException("连接池初使化失败，请检查init方法",e,ExceptionCode.POOLLOADERROR);
		}
		
		
			
	
	}
	
	public Connection getConnection(){
		return getConnection(defaultPoolName);
	}
	
	/**
	 * 
	  * getConnection
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: getConnection
	  * @Description: 通过连接池名获取连接池连接
	  * @param @param poolName
	  * @param @return    
	  * @return Connection   
	  * @throws
	 */
	public Connection getConnection(String poolName){
		logger.info("getConnection start");
		Connection conn=null;
		if(pools.size()>0&&pools.containsKey(poolName)){
			conn=getPool(poolName).getConnection();
			logger.info("getConnection success");
		}else{
			logger.error("getConnection error:can't find this connection pool "+poolName);
			throw new DaoException("连接池获取连接出错，请检查getConnection方法.",null,ExceptionCode.POOLLOADERROR);
		}
		return conn;
	}
	
	/**
	 * 
	  * close
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: close
	  * @Description: 回收默认连接池连接
	  * @param @param conn    
	  * @return void   
	  * @throws
	 */
	public void close(Connection conn){
		close(defaultPoolName,conn);
	}
	
	
	
	/**
	 * 
	  * close
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: close
	  * @Description: 关闭，回收连接
	  * @param @param poolName
	  * @param @param conn    
	  * @return void   
	  * @throws
	 */
	public void close(String poolName,Connection conn){
		logger.info("close PoolConnection start");
		IConnectionPool pool=getPool(poolName);
		try{
			if(pool!=null){
				pool.releaseConn(conn);
			}
		}catch(SQLException e){
			logger.error("close PoolConnection error");
			throw new DaoException("回收连接池失败，请检查close方法",e,ExceptionCode.POOLCLOSEERROR);
		}
		logger.info("close PoolConnection success");
	}
	
	
	
	/**
	 * 
	  * destroy
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: destroy
	  * @Description: 销毁连接池，但保留默认连接池
	  * @param @param poolName    
	  * @return void   
	  * @throws
	 */
	public void destroy(String poolName){
		IConnectionPool pool=getPool(poolName);
		if(pool!=null&&!poolName.equals(defaultPoolName)){
			pool.destroy();
		}
	}
	
	
	
	/**
	 * 
	  * getPool
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: getPool
	  * @Description: 获得连接池
	  * @param @param poolName
	  * @param @return    
	  * @return IConnectionPool   
	  * @throws
	 */
	private IConnectionPool getPool(String poolName){
		IConnectionPool pool=null;
		if(pools.size()>0){
			pool=pools.get(poolName);
		}
		return pool;
	}
	
	
	
	
	
}
