package com.clps.managersystem.action;

import java.util.ArrayList;
import java.util.List;

import com.clps.managersystem.model.User;
import com.clps.managersystem.service.IUserService;
import com.clps.managersystem.utils.FileUtil;
import com.clps.managersystem.utils.SystemContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * 
  * @ClassName: UserAction
  * @Description: 该类处理所有与用户有关的action
  * @author Comsys-huweijia
  * @date 2015年9月1日 下午12:57:47
  *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{

	/**
	  * @Fields serialVersionUID : TODO
	  */
	
	private static final long serialVersionUID = 1586953554228121484L;
	private IUserService ius=(IUserService)FileUtil.createNewInstance("IUserService");
	private User user=new User();
	private List<User> users=new ArrayList<User>();
	private int pageNo;
	private int pageCount;
	
	
	

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
		System.out.println("pageNo"+pageNo);
		if(pageNo==0){
			pageNo=1;
		}
		SystemContext.setPageNo(pageNo);//设置页数
		SystemContext.setPageSize(5);
		users=ius.getUserByPage();
		pageCount=SystemContext.getPageCount();
		return "showUserInfo";
	}



	@Override
	public User getModel() {		
		return user;
	}
	
	
	
}
