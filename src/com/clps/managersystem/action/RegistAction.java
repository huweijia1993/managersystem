/**
 * @Title: RegistAction.java
 * @Package com.clps.systemmanagement.user.action
 * @Description: TODO
 * 
 * @author Comsys-Administrator
 * @date 2015年8月31日 下午3:19:28
 * @version V1.0
 */

package com.clps.managersystem.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @ClassName: RegistAction
 * @Description: 处理注册跳转
 * @author Comsys-Administrator
 * @date 2015年8月31日 下午3:19:28
 *
 */

public class RegistAction extends ActionSupport{

	/**
	  * @Fields serialVersionUID : TODO
	  */
	
	private static final long serialVersionUID = 5148040687273451862L;

	/**
	 * 
	  * gotoRegisterForm
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: gotoRegisterForm
	  * @Description: 为注册提供信息
	  * @param @return    
	  * @return String   
	  * @throws
	 */
	public String gotoRegisterForm(){
		return SUCCESS;
	}
	
	
}
