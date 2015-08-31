package com.clps.managersystem.daoimpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.clps.managersystem.dao.BaseDao;
import com.clps.managersystem.dao.IUserDao;
import com.clps.managersystem.model.PageUtil;
import com.clps.managersystem.model.User;
import com.clps.managersystem.utils.SystemContext;


public class UserDaoImpl extends BaseDao<User> implements IUserDao<User>{

	

	/**
	 * 
	  * encapsulateObject
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: encapsulateObject
	  * @Description: 二次封装
	  * @param @param list
	  * @param @return    
	  * @return List<User>   
	  * @throws
	 */
//	| USER_ID | USER_NAME | USER_PASSWORD | USER_GENDER | USER_BIRTHDAY | USER_HOMETOWN | USER_HEIGHT | USER_LEVEL | USER_ACTIVE |

	private List<User> encapsulateObject(List<ArrayList<Object>> list){
		List<User> result=new ArrayList<User>();
		for(ArrayList<Object> array:list){
			User user=new User();
			user.setUserId(Integer.parseInt(array.get(0).toString()));
			user.setUserName(array.get(1).toString());
			user.setUserPassword(array.get(2).toString());
			user.setUserGender(array.get(3).toString());
			user.setUserBirthday((Date)array.get(4));
			user.setUserHometown(array.get(5).toString());
			user.setUserHeight(Float.parseFloat(array.get(6).toString()));
			user.setUserLevel(array.get(7).toString());
		
			result.add(user);
		}
		return result;
	}
	
	
	
	
	
	
	@Override
	public List<User> list(String sql, Object[] paras) {
		return encapsulateObject(this.abstractList(sql, paras));
		
	}

	@Override
	public List<User> list(String sql, Object para) {
		return list(sql,new Object[]{para});
	}

	@Override
	public List<User> list(String sql) {
		return list(sql,null);
	}

	@Override
	public PageUtil<User> listByPage(String sql, Object[] paras) {
		
		PageUtil<User> pages=new PageUtil<User>();
		
		int pageNo=SystemContext.getPageNo();
		int pageSize=SystemContext.getPageSize();
		
		String  countSql="select * from user";
		int count=getPageCount(countSql);
		if(count>0){
			//如果页数大于0，即有数据
			sql=setPages(sql,pageNo,pageSize);
			List<User> result=this.encapsulateObject(abstractList(sql, paras));
			pages.setTotal(count);//设置总数
			pages.setList(result);//将数据放进去
			return pages; 
		}
		
		return null;
	}

	@Override
	public PageUtil<User> listByPage(String sql, Object para) {
		// TODO Auto-generated method stub
		return listByPage(sql,new Object[]{para});
	}

	@Override
	public PageUtil<User> listByPage(String sql) {
		// TODO Auto-generated method stub
		return listByPage(sql,null);
	}


	@Override
	public User queryObject(String sql, Object[] paras) {
		List<ArrayList<Object>> list=new ArrayList<ArrayList<Object>>();
		ArrayList<Object> result=abstractObject(sql,paras);
		if(result==null){
			return null;
		}else{
			list.add(result);
			return encapsulateObject(list).get(0);
		}
		
	}


	@Override
	public User queryObject(String sql, Object para) {
		// TODO Auto-generated method stub
		return this.queryObject(sql, new Object[]{para});
		
	}


	@Override
	public User queryObject(String sql) {
		// TODO Auto-generated method stub
		return this.queryObject(sql,null);
	}




	
	
	
}
