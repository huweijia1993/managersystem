package com.clps.managersystem.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.clps.managersystem.model.User;
import com.clps.managersystem.service.IUserService;
import com.clps.managersystem.utils.FileUtil;
import com.clps.managersystem.utils.SystemContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;


/**
 * 
  * @ClassName: UserAction
  * @Description: 该类处理所有与用户有关的action
  * @author Comsys-huweijia
  * @date 2015年9月1日 下午12:57:47
  *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>,SessionAware{

	/**
	  * @Fields serialVersionUID : TODO
	  */
	
	private static final long serialVersionUID = 1586953554228121484L;
	private IUserService ius=(IUserService)FileUtil.createNewInstance("IUserService");
	private User user=new User();
	private List<User> users=new ArrayList<User>();
	private int pageNo;
	private int pageCount;
	
	//加一个备用消息
	private String message;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private Map<String,Object> session;
	
	
	
	

	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public void setUser(User user) {
		this.user = user;
	}



	public String showUserInfo(){
		if(pageNo==0){
			pageNo=1;
		}
		SystemContext.setPageNo(pageNo);//设置页数
		SystemContext.setPageSize(5);
		users=ius.getUserByPage();
		pageCount=SystemContext.getPageCount();
		return "showUserInfo";
	}

	/**
	 * 
	  * editUserInfoForm
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: editUserInfoForm
	  * @Description: 跳转到修改用户界面
	  * @param @return    
	  * @return String   
	  * @throws
	 */
	public String editUserInfoForm(){
		 ValueStack valueStack = ServletActionContext.getContext().getValueStack();  
	     valueStack.pop();  
	     valueStack.push(session.get("user"));  
		
		
		user=(User)session.get("user");
		return "go";
	}
	/**
	 * 
	  * editUserInfo
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: editUserInfo
	  * @Description: 修改用户
	  * @param @return    
	  * @return String   
	  * @throws
	 */
	public String editUserInfo(){
		if(ius.editUser(user)){
			message=this.getText("editSuccess");
			return INPUT;
		}else{
			message=this.getText("editFailed");
			return INPUT;
		}
	}
	
	/**
	 * 
	  * resetPassword
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: resetPassword
	  * @Description: 重置用户
	  * @param @return    
	  * @return String   
	  * @throws
	 */
	public String resetPassword(){
		if(ius.resetPassword(user.getUserPassword(), user.getUserId())){
			this.setMessage("重置成功");
			return SUCCESS;
		}else{
			this.setMessage("重置失败");
			return SUCCESS;
		}
	}
	
	

	@Override
	public User getModel() {		
		return user;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	
	
}
