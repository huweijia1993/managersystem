package com.clps.managersystem.pool;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionPool {

	public Connection getConnection();
	
	public Connection getCurrentConnection();
	
	public void releaseConn(Connection conn)throws SQLException;
	
	public void destroy();
	
	public boolean isActive();
	
	public void checkPool();
	
	
}
