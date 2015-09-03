package com.clps.managersystem.service;

import java.util.List;

import com.clps.managersystem.model.User;

/**
 * 
  * @ClassName: IUserService
  * @Description: user服务类
  * @author Comsys-huweijia
  * @date 2015年8月28日 上午10:50:41
  *
 */
public interface IUserService {

	/**
	 * 
	  * checkUser
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: checkUser
	  * @Description: 查询用户是否存在
	  * @param @param user
	  * @param @return    
	  * @return boolean   
	  * @throws
	 */
	public boolean checkUser(User user);
	
	/**
	 * 
	  * getUserByPage
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: getUserByPage
	  * @Description: 根据分页获取用户
	  * @param @return    
	  * @return List<User>   
	  * @throws
	 */
	public List<User> getUserByPage();
	
	/**
	 * 
	  * editUser
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: editUser
	  * @Description: 修改用户信息
	  * @param @return    
	  * @return boolean   
	  * @throws
	 */
	public boolean editUser(User user);
	
	/**
	 * 
	  * addUser
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: addUser
	  * @Description: 添加用户
	  * @param @param user
	  * @param @return    
	  * @return boolean   
	  * @throws
	 */
	public boolean addUser(User user);
	
	/**
	 * 
	  * resetPassword
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: resetPassword
	  * @Description: 重置用户密码
	  * @param @param password
	  * @param @param userId
	  * @param @return    
	  * @return boolean   
	  * @throws
	 */
	public boolean resetPassword(String password,int userId);
	
	
}
