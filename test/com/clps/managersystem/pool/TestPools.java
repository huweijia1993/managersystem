package com.clps.managersystem.pool;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 
  * @ClassName: TestPools
  * @Description: 测试连接池
  * @author Comsys-huweijia
  * @date 2015年8月27日 上午11:28:38
  *
 */
public class TestPools {

	private Logger logger=Logger.getLogger(TestPools.class);
	
	@Test
	public void test1(){
		
		
		ThreadConnection t=new ThreadConnection();
		
		int size=3000;
		long startTime=System.currentTimeMillis();
		for(int i=0;i<size;i++){
			Thread thread=new Thread(t);
			thread.start();
		}
		long endTime=System.currentTimeMillis();
		logger.info("所需时间为:"+(endTime-startTime));
		
		
	
	}
	
	
}

class ThreadConnection implements Runnable{
	
	private ConnectionPoolManager manager;
	
	public void run(){
		
		
		for(int i=0;i<1000;i++){
			manager=ConnectionPoolManager.getInstance();
			Connection conn=manager.getConnection();
			System.out.println(conn);
			manager.close(conn);
		}
		
	
//		Connection conn=getConnection();
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public Connection getConnection(){
		Connection conn=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/managersystem","root","huweijia");
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
		
	}
	
	
	
	
	
}

