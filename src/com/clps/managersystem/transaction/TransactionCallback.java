package com.clps.managersystem.transaction;

/**
 * 
  * @ClassName: TransactionCallback
  * @Description: 事务回调接口
  * @author Comsys-huweijia
  * @date 2015年8月27日 上午9:19:05
  *
  * @param <T>
 */
public interface TransactionCallback<T> {

	
	/**
	 * 
	  * doInTransaction
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: doInTransaction
	  * @Description: 带返回值
	  * @param @return    
	  * @return T   
	  * @throws
	 */
	public T doInTransaction();
	

	
}
