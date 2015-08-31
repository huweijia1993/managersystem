package com.clps.managersystem.exception;

/**
 * 
  * @ClassName: DaoException
  * @Description: 该异常类处理与dao相关的异常
  * 检查型异常，代码执行正常，但不可达 继承的是Exception
  * 非检查型异常，编程出错，如数组越界，除零等，继承的是RuntimeException
  * 对可恢复的情况使用检查型异常，对编程错误使用运行时异常。
  * 
  * 本次异常处理方式：
  * 在底层dao抛出runtimeException
  * 在service层抛出自定义异常
  * 在action层处理异常用异常拦截器拦截，到达错误页面
  * 
  * 通常的异常处理模式包括业务委托模式（Business Delegate）
  * 、前端控制器模式（Front Controller）、拦截过滤器模式（Intercepting Filter）、AOP 模式、模板方法模式等。
  * 
  * 为了解决检查异常带来的缺陷，我们可以利用异常转译的方法，将检查异常转化为非检查异常，由异常 Service 拦截处理。
  * 
  * 
  * 重要:分支控制应该尽可能减少异常负担
  * 
  * 底层抛出系统异常，如关闭资源出错等
  * 业务层抛出业务异常，由拦截器处理返回之前页面
  * 
  * 
  * 
  * @author Comsys-huweijia
  * @date 2015年8月28日 下午2:03:20
  *
 */
public class DaoException extends ManagerSystemException{

	/**
	  * @Fields serialVersionUID : TODO
	  */
	
	private static final long serialVersionUID = -3955453474687566321L;

	public DaoException(int code) {
		super(code);
	}
	public DaoException(String msg,int code){
		super(msg,code);
	}
	
	public DaoException(String msg,Throwable cause,int code){
		super(msg,cause,code);
	
	}
	
	
	
	

}
