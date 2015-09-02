package com.clps.managersystem.serviceimpl;

import java.util.List;

import com.clps.managersystem.daofactory.IBaseDaoFactory;
import com.clps.managersystem.daofactory.UserDaoFactory;
import com.clps.managersystem.model.PageUtil;
import com.clps.managersystem.model.User;
import com.clps.managersystem.service.IUserService;
import com.clps.managersystem.transaction.TransactionCallback;
import com.clps.managersystem.transaction.TransactionTemplate;

public class UserServiceImpl implements IUserService{

	private static IBaseDaoFactory<User> ibdf=new UserDaoFactory();
	
	@Override
	public boolean checkUser(final User user){
		
		User res=TransactionTemplate.execute(new TransactionCallback<User>() {

			String sql="select * from user where user_name=? and user_password=?";
			String[] paras=new String[]{user.getUserName(),user.getUserPassword()};
			@Override
			public User doInTransaction() {
				return ibdf.createDao().queryObject(sql,paras);
			}

		});
		
	
		if(res!=null){
			copyUser(user,res);
			return true;
		}else{
			return false;
		}
//		}else{
//			throw new ServiceException("用户不存在，请重新登录",ExceptionCode.LOGINERROR);
//		}
	
	}
	
	private void copyUser(User user1,User user2){
		user1.setUserName(user2.getUserName());
		user1.setUserPassword(user2.getUserPassword());
		user1.setUserBirthday(user2.getUserBirthday());
		user1.setUserGender(user2.getUserGender());
		user1.setUserHeight(user2.getUserHeight());
		user1.setUserHometown(user2.getUserHometown());
		user1.setUserId(user2.getUserId());
		user1.setUserLevel(user2.getUserLevel());
		
	}


	@Override
	public List<User> getUserByPage() {
		PageUtil<User> pages=(PageUtil<User>) TransactionTemplate.execute(new TransactionCallback<PageUtil<User>>(){

			@Override
			public PageUtil<User> doInTransaction() {
				
				return ibdf.createDao().listByPage("select * from user");	
				
			}
			
		});
		
		return pages.getList();
	}

	@Override
	public boolean editUser(final User user) {
		boolean flag=TransactionTemplate.execute(new TransactionCallback<Boolean>(){

			@Override
			public Boolean doInTransaction() {
				String sql="update user set user_name=?,user_password=?,user_gender=?,user_birthday=?,user_hometown=?,user_height=?,user_email  where user_id=?";
				String paras[]=new String[]{user.getUserName(),user.getUserPassword(),
						user.getUserGender(),user.getUserBirthday()+"",user.getUserHometown(),
						user.getUserHeight()+"",user.getUserEmail(),user.getUserId()+""};
				
				return ibdf.createDao().update(sql,paras);	
				
			}
			
		});
		
		return flag;
	}

	@Override
	public boolean addUser(final User user) {
		Integer id=TransactionTemplate.execute(new TransactionCallback<Integer>(){

			@Override
			public Integer doInTransaction() {
				String sql="insert into user (user_name,user_password,user_gender,user_birthday,user_hometown,user_height,user_email) values(?,?,?,?,?,?,?)";
				String paras[]=new String[]{user.getUserName(),user.getUserPassword(),
						user.getUserGender(),user.getUserBirthday()+"",user.getUserHometown(),
						user.getUserHeight()+"",user.getUserEmail()};
				
				return ibdf.createDao().add(sql,paras);	
				
			}
			
		});
		if(id!=0){
			user.setUserId(id);
			return true;
		}else{
			return false;
		}
		
	}
	
	
	
	
	
}
