package com.clps.managersystem.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.clps.managersystem.exception.DaoException;
import com.clps.managersystem.exception.ExceptionCode;

public class ConnectionPoolImpl implements IConnectionPool{

	private static Logger logger=Logger.getLogger(ConnectionPoolImpl.class);
	
	private DBBean dbBean;
	private boolean isActive=false;//连接池活动状态
	private int conActive=0;//记录创建的总的连接数
	
	//空闲连接
	private List<Connection> freeConnection=new Vector<Connection>();
	
	//活动连接
	private List<Connection> activeConnection=new Vector<Connection>();
	
	//将线程和连接绑定中，保证事务能统一执行
	private static ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();
	
	public ConnectionPoolImpl(DBBean dbBean){
		this.dbBean=dbBean;
		init();
		checkPool();
	}
	
	
	
	
	//初始化
	private void init(){
		try{	
			logger.info("pool init start");
			Class.forName(dbBean.getDriverName());
			for(int i=0;i<dbBean.getInitConnection();i++){
				Connection conn=newConnection();
				if(conn!=null){
					freeConnection.add(conn);
					conActive++;
				}
			}
			isActive=true;
		}catch(ClassNotFoundException e){
			logger.info("pool init error");
			throw new DaoException("加载资源出错，请检查driver:"+dbBean.getDriverName(),e,ExceptionCode.POOLLOADERROR);
		
		}
		logger.info("pool init success");
	
	}
	
	public synchronized Connection newConnection(){
		Connection conn=null;
		if(dbBean!=null){	
		
			//	Class.forName(dbBean.getDriverName());
			try {
				conn=DriverManager.getConnection(dbBean.getUrl(),
						dbBean.getUserName(),dbBean.getPassword());
			} catch (SQLException e) {
				throw new DaoException("加载连接出错，请检查url,userName,password正确性",e,ExceptionCode.POOLLOADERROR);
			}
		
		}
		
		return conn;
	}
	
	public void checkPool(){
		if(dbBean.isCheckPool()){
			new Timer().schedule(new TimerTask(){
				public void run(){
					//对线程里面的连接状态检查
					logger.info("空闲连接数"+freeConnection.size());
					logger.info("活动连接数"+activeConnection.size());
					logger.info("总的连接数"+conActive);
				}
			}, dbBean.getLazyCheck(),dbBean.getPeriodCheck());
		}
	}


	@Override
	public synchronized Connection getConnection() {
		// TODO Auto-generated method stub
		Connection conn=null;
		try{
			//判断是否超过最大连接数限制
			if(conActive<this.dbBean.getMaxActiveConnection()){
				if(freeConnection.size()>0){
					conn=freeConnection.get(0);
					if(conn!=null){
						threadLocal.set(conn);
					}
					freeConnection.remove(0);
				}else{
					//没有资源了
					conn=newConnection();
				}
			}else{
				//等待直到重新获得连接
				wait(this.dbBean.getConnectionTimeOut());
				conn=getConnection();
			}
			if(isValid(conn)){
				//活动连接加入
				activeConnection.add(conn);
				conActive++;
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		return conn;
	}


	private boolean isValid(Connection conn) {
		try{
			if(null==conn||conn.isClosed()){
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}


	@Override
	public synchronized Connection getCurrentConnection() {
		//从ThreadLocal中获取连接
		Connection conn=threadLocal.get();
		if(isValid(conn)){
			conn=getConnection();
		}
		
		return conn;
	}


	@Override
	public synchronized void releaseConn(Connection conn) throws SQLException {
		//如果连接有效并且没有超过最大连接的话
		if(isValid(conn)&&!(freeConnection.size()>dbBean.getMaxActiveConnection())){
			freeConnection.add(conn);
			activeConnection.remove(conn);
			
			conActive--;
			threadLocal.remove();
			//唤醒所有正在等待的线程，去获取
			notifyAll();
		}
	}

	
	@Override
	public synchronized void destroy() {
		// TODO Auto-generated method stub
		for(Connection conn:freeConnection){
			try{
				if(isValid(conn)){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		for(Connection conn:activeConnection){
			try{
				if(isValid(conn)){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			isActive=false;
			conActive=0;
		}
	}


	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return isActive;
	}
	
	
	
	
	
	
	
	
}
