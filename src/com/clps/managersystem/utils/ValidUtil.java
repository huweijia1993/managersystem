/**   
 * @Title: ValidUtil.java 
 * @Package: com.clps.systemmanagement.user.utils 
 */
package com.clps.managersystem.utils;

import java.util.Collection;

/**  
 * @Title: ValidUtil.java 
 * @Package com.clps.systemmanagement.user.utils 
 * @Description 效验工具类
 * @author Osborn(LiYiJie)
 * @date 2015年8月28日 上午11:04:52 
 * @version v1.0
 */
public class ValidUtil {

	/**
	 * @Description 判断字符串有效性 
	 */
	public static boolean isValid(String src){
		if(src==null || "".equals(src.trim())){
			return false;
		}
		return true;
	}
	
	/**
	 * @Description 判断字符串包含空格 
	 */
	public static boolean isValidTrim(String src){
		if(src.trim().length()==src.length()){
			return false;
		}
		return true;
	}
	/**
	 * @Description 判断集合的有效性  
	 */
	public static boolean isValid(Collection coll){
		if(coll==null || coll.isEmpty()){
			return false;
		} 
		return true;
	}
	
}
