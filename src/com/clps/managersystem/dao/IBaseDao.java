package com.clps.managersystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.clps.managersystem.model.PageUtil;

public interface IBaseDao<T> {

	/**
	 * 
	  * add
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: add
	  * @Description: 增加
	  * @param @param sql
	  * @param @return    
	  * @return int   
	  * @throws
	 */
	public int add(String sql);
	public int add(String sql,Object para);
	public int add(String sql,Object[] paras);

	
	/**
	 * 
	  * update
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: update
	  * @Description: 修改
	  * @param @param sql
	  * @param @return    
	  * @return boolean   
	  * @throws
	 */
	public boolean update(String sql);
	public boolean update(String sql,Object para);
	public boolean update(String sql,Object[] paras);
	
	/**
	 * 
	  * delete
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: delete
	  * @Description: 删除
	  * @param @param sql
	  * @param @return    
	  * @return boolean   
	  * @throws
	 */
	public boolean delete(String sql);
	public boolean delete(String sql,Object para);
	public boolean delete(String sql,Object paras[]);
	

	
	
	/**
	 * 
	  * list
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: list
	  * @Description: 返回列表查询，不带分页
	  * @param @param sql
	  * @param @param paras
	  * @param @return    
	  * @return List<T>   
	  * @throws
	 */
	public List<T> list(String sql,Object[] paras);
	public List<T> list(String sql,Object para);
	public List<T> list(String sql);
	
	/**
	 * 
	  * listByPage
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: listByPage
	  * @Description: 分页查询带分页
	  * @param @param sql
	  * @param @param paras
	  * @param @return    
	  * @return List<T>   
	  * @throws
	 */
	public PageUtil<T> listByPage(String sql,Object[] paras);
	public PageUtil<T> listByPage(String sql,Object para);
	public PageUtil<T> listByPage(String sql);
	
	
	
	/**
	 * 
	  * queryObject
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: queryObject
	  * @Description: 查询单个对象
	  * @param @param sql
	  * @param @param paras
	  * @param @return    
	  * @return T   
	  * @throws
	 */
	public T queryObject(String sql,Object[] paras);
	public T queryObject(String sql,Object para);
	public T queryObject(String sql);
	
	
	/**
	 * 
	  * queryCommon
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: queryCommon
	  * @Description: 普通查询，返回单列
	  * @param @param sql
	  * @param @param paras
	  * @param @return    
	  * @return List<Object>   
	  * @throws
	 */
	public ArrayList<Object> queryCommon(String sql,Object[] paras);
	public ArrayList<Object> queryCommon(String sql,Object para);
	public ArrayList<Object>	queryCommon(String sql);
	
	/**
	 * 
	  * queryCommonList
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: queryCommonList
	  * @Description: 普通查询，返回列表
	  * @param @param sql
	  * @param @param paras
	  * @param @return    
	  * @return List<ArrayList<Object>>   
	  * @throws
	 */
	public List<ArrayList<Object>> queryCommonList(String sql,Object[] paras);
	public List<ArrayList<Object>> queryCommonList(String sql,Object para);
	public List<ArrayList<Object>> queryCommonList(String sql);
	
	

	
	
	
}
