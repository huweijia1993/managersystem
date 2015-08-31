package com.clps.managersystem.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
  * @ClassName: PageUtil
  * @Description: 该类用于实现Page封装
  * @author Comsys-huweijia
  * @date 2015年8月26日 下午11:29:23
  *
 */
public class PageUtil<E> {

	private int pageNo=1;
	private int pageSize=5;
	private int total=0;
	private List<E> list=new ArrayList<E>();
	private String sort="asc";
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	
	
	
	
}
