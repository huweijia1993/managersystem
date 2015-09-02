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



import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.clps.managersystem.exception.DaoException;
import com.clps.managersystem.exception.ExceptionCode;
import com.clps.managersystem.model.User;
import com.clps.managersystem.service.IUserService;
import com.clps.managersystem.utils.FileUtil;
import com.clps.managersystem.utils.MailUtil;
import com.clps.managersystem.utils.Md5Util;
import com.clps.managersystem.utils.MySessionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @ClassName: RegistAction
 * @Description: 处理注册跳转
 * @author Comsys-Administrator
 * @date 2015年8月31日 下午3:19:28
 *
 */

public class RegistAction extends ActionSupport implements ModelDriven<User>{

	private User user=new User();
	
	
	/**
	  * @Fields serialVersionUID : TODO
	  */
	
	private static final long serialVersionUID = 5148040687273451862L;
	private  IUserService ius=(IUserService)FileUtil.createNewInstance("IUserService");

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
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
	
		String id=session.getId();
		//将sessionid放在里面放送给邮箱
		String email=user.getUserEmail();
		String key=Md5Util.getMD5Code(user.getUserName());
		session.setAttribute("key", key);
		session.setAttribute("registeruser",user);
		String url="http://localhost:8080/ManagerSystem/Validator.action?key="+key+"&id="+id;
		String message="只差最后一步激活链接"+url;
	
		try {
			MailUtil.sendMail(email, "激活", message);
			return SUCCESS;
		} catch (MessagingException e) {
			throw new DaoException("激活邮件发送失败，请联系管理员",e,ExceptionCode.SENDMAILFAILED);
		}
		
		
		
	}
	/**
	 * 
	  * checkRegisterMail
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: checkRegisterMail
	  * @Description: 验证注册邮箱
	  * @param @return    
	  * @return String   
	  * @throws
	 */
	public String checkRegisterMail(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String sessionId=request.getParameter("id");
		String key=request.getParameter("key");
		MySessionContext myc=MySessionContext.getInstance();
		HttpSession session=myc.getSession(sessionId);
		if(null==session){
			//过期了
			return INPUT;
		}
		System.out.println("sdfs获取到"+myc);
		
		User user=(User) session.getAttribute("registeruser");
		if(Md5Util.getMD5Code(user.getUserName()).equals(key)){
			//匹配成功 将数据存到数据库中
			if(ius.addUser(user)){
				return SUCCESS;
			}else{
				return INPUT;
			}
		}else{
			return INPUT;
		}
	}
	
	

	public void setUser(User user){
		this.user=user;
	}
	
	@Override
	public User getModel() {
		return user;
	}
	
	
}
