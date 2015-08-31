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
	
	
	
}
