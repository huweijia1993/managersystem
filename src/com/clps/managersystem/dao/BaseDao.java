package com.clps.managersystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.clps.managersystem.exception.DaoException;
import com.clps.managersystem.exception.ExceptionCode;
import com.clps.managersystem.transaction.TransactionManager;
import com.clps.managersystem.utils.SystemContext;



public abstract class BaseDao<T> implements IBaseDao<T>{

	private Connection conn=TransactionManager.tl.get();
	private PreparedStatement ps;
	private ResultSet rs;

	private static Logger log=Logger.getLogger(BaseDao.class);

	
	
	
	
	

	/**
	 * 
	  * close
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: close
	  * @Description: 关闭资源
	  * @param     
	  * @return void   
	  * @throws
	 */
	private  void close(ResultSet rs,PreparedStatement ps){
		try{
			if(rs!=null){
				rs.close();
			}
		}catch(SQLException e){
			log.error("关闭rs资源出错"+e.getMessage());
			throw new DaoException("关闭rs资源出错",e,ExceptionCode.CLOSRESOURCEFAILED);	
		}
		try{
			if(ps!=null){
				ps.close();
			}
		}catch(SQLException e){
			log.error("关闭ps资源出错"+e.getMessage());
			throw new DaoException("关闭ps资源出错",e,ExceptionCode.CLOSRESOURCEFAILED);
		}
		
		//这里让连接池管理器回收资源	
	}
	
	private void setParameter(PreparedStatement ps,Object[] paras){
		if(paras!=null){
			int i=1;
			for(Object obj:paras){
				try {
					ps.setObject(i++, obj);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					log.error("ps设置参数出错"+e.getMessage());
					//这里ps可能为空就会出现设置错误，并且是无法修改的错误,应该是检查型的异常，但为了上面不处理
					//继续往上抛到拦截器
					throw new DaoException("SQLException ps设置参数出错",e,ExceptionCode.RESOURCELOADFAILED);
					
				}
			}
		}
	}
	/**
	 * 
	  * getPreparedStatement
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: getPreparedStatement
	  * @Description: 将加载sql语句封装出来
	  * @param @param sql
	  * @param @param conn
	  * @param @return    
	  * @return PreparedStatement   
	  * @throws
	 */
	protected  PreparedStatement getPreparedStatement(String sql,Connection conn){
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
		} catch (SQLException e) {
			String msg="connection获取preparedstatment出错,可能connection获取出错";
			log.error(msg);
			throw new DaoException(msg,e,ExceptionCode.GETPREPAREDSTATEMENTFAILED);
		}
		return ps;
	}
	
	protected int execUpdate(PreparedStatement ps,String sql){
		int result=0;
		try {
			result=ps.executeUpdate();
		} catch (SQLException e) {
			StringBuilder sb=new StringBuilder("添加数据出错，请检查sql语句")
					.append(sql)
					.append(" 具体信息：")
					.append(e);
			log.error(sb.toString());
			throw new DaoException(sb.toString(),e,ExceptionCode.UPDATEFAILER);
		}finally{
			close(null,ps);
		}
		return result;
	}
	
	
	
	
	
	@Override
	public int add(String sql) {
		// TODO Auto-generated method stub
		return add(sql,null);
	}

	@Override
	public int add(String sql, Object para) {
		// TODO Auto-generated method stub
		return this.add(sql, new Object[]{para});
	}

	@Override
	public int add(String sql, Object[] paras) {
		ps=getPreparedStatement(sql, conn);
		//设置参数
		setParameter(ps, paras);
		int result=execUpdate(ps,sql);
		if(result!=0){
			//执行正确 获取自增长ID
			int id=0;
			try {
				rs=ps.getGeneratedKeys();
				if(rs.next()){
					id=rs.getInt(1);
				}
			} catch (SQLException e) {
				StringBuilder sb=new StringBuilder("获取自增长id出错，请检查程序")
						.append(" 具体信息：")
						.append(e);
				log.error(sb.toString());
				throw new DaoException(sb.toString(),e,ExceptionCode.INSERTERROR);
			}finally{
				close(rs,ps);
			}
			
			return id;
			
		}else{
			//关闭资源
			close(rs,ps);
			//防止出现插入错误不报错，加一层抛错
			throw new DaoException("插入信息出错，请检查",ExceptionCode.INSERTERROR);
		}
	
		//关闭资源 交给事务!!!!!!!
		//this.close();
	
	}
	@Override
	public boolean update(String sql) {
		return this.update(sql,null);
	}
	@Override
	public boolean update(String sql, Object para) {
		return this.update(sql, new Object[]{para});
	}
	@Override
	public boolean update(String sql, Object[] paras) {
		//conn=getConnection();
		ps=getPreparedStatement(sql, conn);
		setParameter(ps, paras);
		int result=execUpdate(ps,sql);
		
		return result==0?false:true;
		//关闭资源交给事务
	}
	@Override
	public boolean delete(String sql) {
		// TODO Auto-generated method stub
		return this.update(sql);
	}
	@Override
	public boolean delete(String sql, Object para) {
		// TODO Auto-generated method stub
		return this.update(sql, para);
	}
	@Override
	public boolean delete(String sql, Object[] paras) {
		// TODO Auto-generated method stub
		return this.update(sql, paras);
	}

	/**
	 * 
	  * encapsulateList
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: encapsulateList
	  * @Description: 初使封装
	  * @param @param rs
	  * @param @return    
	  * @return List<ArrayList<Object>>   
	  * @throws
	 */
	protected  List<ArrayList<Object>> encapsulateList(ResultSet rs) {
		List<ArrayList<Object>> list=new ArrayList<ArrayList<Object>>();
		try{
			int columnCount=rs.getMetaData().getColumnCount();
			while(rs.next()){
				ArrayList<Object> array=new ArrayList<Object>();
				for(int i=0;i<columnCount;i++){
					array.add(rs.getObject(i+1));
				}
				list.add(array);
			}
		}catch(SQLException e){
			StringBuilder sb=new StringBuilder("封装数据出错，请检查初始封装")
					.append(" 具体信息：")
					.append(e);
			log.error(sb.toString());
			throw new DaoException(sb.toString(),e,ExceptionCode.ENCAPSULATEFAILED);
			
		}finally{
			close(rs,ps);
		}
	
		return list;
	}
	
	protected  ResultSet getResultSet(PreparedStatement ps,String sql){
		ResultSet rs=null;
		try {
			rs=ps.executeQuery();
		} catch (SQLException e) {
			StringBuilder sb=new StringBuilder("添加数据出错，请检查sql语句")
					.append(sql)
					.append(" 具体信息：")
					.append(e);
			log.error(sb.toString());
			throw new DaoException(sb.toString(),e,ExceptionCode.GETRESULTFAILED);
		}
		return rs;
	}
	
	
	/**
	 * 
	  * abstractList
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: abstractList
	  * @Description: 不带分页的列表查询，初始封装
	  * @param @param sql
	  * @param @param paras
	  * @param @return    
	  * @return List<ArrayList<Object>>   
	  * @throws
	 */
	protected List<ArrayList<Object>> abstractList(String sql,Object paras[]){
	//	conn=getConnection();
		ps=getPreparedStatement(sql, conn);
		
		setParameter(ps, paras);
		rs=getResultSet(ps, sql);
		return encapsulateList(rs);
	
	}
	
	/**
	 * 
	  * abstractObject
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: abstractObject
	  * @Description: 单个对象的初始封装
	  * @param @param sql
	  * @param @param paras
	  * @param @return    
	  * @return List<Object>   
	  * @throws
	 */

	protected ArrayList<Object> abstractObject(String sql,Object[] paras){
		List<ArrayList<Object>>res=this.abstractList(sql, paras);
		if(res.size()>0){
			return res.get(0);
		}else{
//			StringBuilder sb=new StringBuilder("没有该用户，请检查sql语句")
//					.append(sql)
//					.append("参数：")
//					.append(paras.toString());
//			throw new DaoException(sb.toString(),ExceptionCode.NOSUCHOBJECT);
			return null;
		}
	}
	
	protected List<ArrayList<Object>> abstractListByPage(String sql,String paras[]){
	//	conn=getConnection();
		ps=getPreparedStatement(sql, conn);
		setParameter(ps, paras);
		rs=getResultSet(ps, sql);
		return encapsulateList(rs);
		
	}
	
	/**
	 * 
	  * getPageCount
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: getPageCount
	  * @Description: 返回表记录
	  * @param @param sql
	  * @param @return    
	  * @return int   
	  * @throws
	 */
	protected int getPageCount(String sql){
		ps=getPreparedStatement(sql, conn);
		rs=getResultSet(ps, sql);
		try{
			if(rs.next()){
				int count=rs.getInt(1);
				int pageSize=SystemContext.getPageSize();
				return count%pageSize==0?count/pageSize:count/pageSize+1;//求出页的总页数
			}
		}catch(SQLException e){
			StringBuilder sb=new StringBuilder("查询数据条数出错，请检查sql语句")
					.append(sql)
					.append(" 具体信息：")
					.append(e);
			log.error(sb.toString());
			throw new DaoException(sb.toString(),e,ExceptionCode.QUERYCOUNTFAILED);
		}finally{
			close(rs, ps);
		}
		
		return -1;
	}
	
	/**
	 * 
	  * setPages
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: setPages
	  * @Description: 设置分页参数
	  * @param @param sql
	  * @param @param pageNo
	  * @param @param pageSize
	  * @param @return    
	  * @return String   
	  * @throws
	 */
	protected String setPages(String sql,int pageNo,int pageSize){
		
		StringBuilder stringBuilder=new StringBuilder(sql);
		stringBuilder.append("  limit ")
					 .append((pageNo-1)*pageSize+"")
					 .append(",")
					 .append(pageSize);
		
		return stringBuilder.toString();
	}
	
	
}