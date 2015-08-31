package com.clps.managersystem.dao;

import org.junit.Test;

import com.clps.managersystem.exception.DaoException;
import com.clps.managersystem.exception.ServiceException;

/**
 * 
  * @ClassName: TestException
  * @Description: 测试异常
  * @author Comsys-huweijia
 * @param <Testexception>
  * @date 2015年8月31日 上午7:45:16
  *
 */
public class Testexception{

	@Test
	public void test(){
		T t=new T();
		try{
			t.method1();
		}catch(Exception e){
			if(e instanceof DaoException){
				System.out.println(e.getMessage());
			}else if(e instanceof ServiceException){
				System.out.println("业务："+e.getMessage());
			}else{
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}

class T{
	//代表action
	public void method1(){

			method2(0);
	
		
	}
	//代表service
	public void method2(int number){
		
			try{
				method3(number);
			}catch(Exception e){
				throw new ServiceException("业务拦截",2);
			}
		
	
		
	}
	
	//代表dao
	public boolean method3(int number){
		if(number==1){
			return true;
		}else{
			throw new RuntimeException("runTime异常");
//			throw new DaoException("数目不正确",1);
		}
	}
}













