package com.clps.managersystem.utils;
/**
 * 
  * @ClassName: SystemContext
  * @Description: 需要全局数据，用Threadlocal封装
  * @author Comsys-huweijia
  * @date 2015年8月31日 下午3:58:52
  *
 */
public class SystemContext {

	private static ThreadLocal<Integer> pageNo=new ThreadLocal<Integer>();//当前页号
	
	private static ThreadLocal<Integer> pageCount=new ThreadLocal<Integer>();//总页数
	
	private static ThreadLocal<Integer> pageSize=new ThreadLocal<Integer>();//每页数量

	public static Integer getPageNo() {
		return pageNo.get();
	}

	public static void setPageNo(Integer pageNumber) {
		pageNo.set(pageNumber);
	}

	public static Integer getPageCount() {
		return pageCount.get();
	}

	public static void setPageCount(Integer pagecount) {
		pageCount.set(pagecount);
	}

	public static Integer getPageSize() {
		return pageSize.get();
	}

	public static void setPageSize(Integer pagesize) {
		pageSize.set(pagesize);
	}
	
	
	
	
}
