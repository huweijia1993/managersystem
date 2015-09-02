/**
 * @Title: FormatUtil.java
 * @Package com.aust.shuyu.util
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:clps
 * 
 * @author Comsys-huweijia
 * @date 2015年8月1日 下午3:50:55
 * @version V1.0
 */

package com.clps.managersystem.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: FormatUtil
 * @Description: TODO
 * @author Comsys-huweijia
 * @date 2015年8月1日 下午3:50:55
 *
 */

public class FormatUtil {

	/**
	 * 
	  * @Title: regexCheck
	  * @Description: 正则表达式验证
	  * @param @param regex
	  * @param @param str
	  * @param @return    
	  * @return boolean    
	  * @throws
	 */
	public static boolean regexCheck(String regex,String str){
	
		Pattern p=Pattern.compile(regex);
		Matcher matcher=p.matcher(str);
		
		return matcher.find();
	}
	
	/**
	 * 
	  * @Title: getSuffix
	  * @Description: 获取文件名后缀
	  * @param @param fileName
	  * @param @return    
	  * @return String    
	  * @throws
	 */
	public static String getSuffix(String fileName){
		return fileName.substring(fileName.lastIndexOf(".")+1);
	}
	
	/**
	 * 
	  * @Title: getFileName
	  * @Description: 返回路径中的文件名
	  * @param @param filePath
	  * @param @return    
	  * @return String    
	  * @throws
	 */
	public static String getFileName(String filePath){
		int index=filePath.lastIndexOf("/");
		if(-1!=index){
			return filePath.substring(index+1);
		}else{
			return filePath;
		}
	}
	
	
	
}
