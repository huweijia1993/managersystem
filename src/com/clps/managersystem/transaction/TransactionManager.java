package com.clps.managersystem.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.clps.managersystem.exception.ExceptionCode;
import com.clps.managersystem.exception.TransactionException;

public class TransactionManager {

	private Connection conn=null;
	private static Logger log=Logger.getLogger(TransactionManager.class);
	public static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	
	public TransactionManager(Connection conn){
		this.conn=conn;
		tl.set(conn);
	}
	
	/**
	 * 
	  * beginTransaction
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: beginTransaction
	  * @Description: 开启事务
	  * @param     
	  * @return void   
	  * @throws
	 */
	public void beginTransaction(){
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			StringBuilder sb=new StringBuilder("开启事务失败，请检查连接,具体信息")
					.append(e.getMessage());
			log.error(sb.toString());
			throw new TransactionException(sb.toString(),e,ExceptionCode.STARTTRAMSACTIONMANAGERFAILED);
		}
	}
	
	/**
	 * 
	  * commitAndClose
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: commitAndClose
	  * @Description: 提交事务
	  * @param     
	  * @return void   
	  * @throws
	 */
	public void commitAndClose(){
		try{
			conn.commit();
		}catch(SQLException e){
			StringBuilder sb=new StringBuilder("提交事务失败，请检查连接;具体信息：")
					.append(e.getMessage());
			log.error(sb.toString());
			throw new TransactionException(sb.toString(),e,ExceptionCode.COMMITTRANSACTIONFAILED);
		
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	  * rollbackAndClose
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: rollbackAndClose
	  * @Description: 回
	  * @param     
	  * @return void   
	  * @throws
	 */
	public void rollbackAndClose(){
		try{
			conn.rollback();
		}catch(SQLException e){
			StringBuilder sb=new StringBuilder("回滚事务失败，请检查连接;具体信息：")
					.append(e.getMessage());
			log.error(sb.toString());
			throw new TransactionException(sb.toString(),e,ExceptionCode.ROLLBACKFAILED);
		
		
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	
	
	
	
}
