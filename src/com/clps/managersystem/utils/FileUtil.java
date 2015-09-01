/**
 * @Title: PropertiesUtil.java
 * @Package com.clps.managersystem.util
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:clps
 * 
 * @author Comsys-huweijia
 * @date 2015年8月6日 上午9:43:35
 * @version V1.0
 */

package com.clps.managersystem.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.clps.managersystem.exception.ExceptionCode;
import com.clps.managersystem.exception.ServiceException;
import com.clps.managersystem.logproxy.LogHandler;
import com.clps.managersystem.service.IUserService;

/**
 * @ClassName: PropertiesUtil
 * @Description: 文件处理工具类
 * @author Comsys-huweijia
 * @date 2015年8月6日 上午9:43:35
 *
 */

public class FileUtil {

	private static Logger logger=Logger.getLogger(FileUtil.class);
	
	/**
	 * 
	  * @Title: getClassesFile
	  * @Description: 获取classes文件夹下的文件
	  * @param @param fileName
	  * @param @return    
	  * @return String    
	  * @throws
	 */
	public static String getClassesFile(String fileName){
		String path=FileUtil.class.getResource("/").getPath();
		return path+fileName;
	}
	
	
	
	/**
	 * 
	  * @Title: getWebInfFile
	  * @Description: 获取web－inf下的配置文件路径
	  * @param @param fileName
	  * @param @return    
	  * @return String    
	  * @throws
	 */
	public static String getWebInfFile(String fileName){
		String path=FileUtil.class.getResource("/").getPath();
		logger.info("根目录："+path);
		path=path.substring(0,path.indexOf("classes"));
		logger.info("web-inf目录："+path);
		path=path+fileName;
		return path;
	}
	
	
	
	/**
	 * 
	  * @Title: getProperties
	  * @Description: 返回properties文件
	  * @param @param path
	  * @param @return    
	  * @return Properties    
	  * @throws
	 */
	public static Properties getProperties(String path){
		System.out.println("路径是："+path);
		Properties properties=new Properties();
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(path);
			properties.load(fis);
			
		} catch (FileNotFoundException e) {
			logger.error("文件工具类中getProperties方法path找不到"+e.getMessage());
		}catch (IOException e) {
			logger.error("properties文件下加载文件出错"+e.getMessage());
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		return properties;
	}
	
	/**
	 * 
	  * getClassInstance
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: getClassInstance
	  * @Description: 反射生成实例
	  * @param @param className
	  * @param @return    
	  * @return Object   
	  * @throws
	 */
	public static Object getClassInstance(String className){
		try {
			Object obj= Class.forName(className).newInstance();
			System.out.println(obj+"实例");
			return obj;
		} catch (InstantiationException e) {
			logger.error("创建"+className+"实例失败");
			throw new ServiceException("创建实例失败，请检查类路径"+className,e,ExceptionCode.CLASSNOTFOUND);
		} catch (IllegalAccessException e) {//抛出的异常表明向方法传递了一个不合法或不正确的参数。 
			logger.error("反射创建"+className+"实例时向方法传递了一个不合法或不正确的参数");
			throw new ServiceException("创建实例失败，向方法传递了一个不合法参数"+className,e,ExceptionCode.CLASSNOTFOUND);
		} catch (ClassNotFoundException e) {
			logger.error("反射创建实例时找不到类"+className);			
			throw new ServiceException("创建实例失败，类找不到"+className,e,ExceptionCode.CLASSNOTFOUND);

		}
	}
	
	/**
	 * 
	  * createNewInstance
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: createNewInstance
	  * @Description: 封装接口反射
	  * @param @param interfaceName
	  * @param @return    
	  * @return Object   
	  * @throws
	 */
	public static Object createNewInstance(String interfaceName){
		LogHandler logHandler=new LogHandler();
		Properties properties=FileUtil.getProperties(FileUtil.getClassesFile("reflectFile.properties"));
		String fileName=properties.getProperty(interfaceName);
		return logHandler.newProxyInstance(FileUtil.getClassInstance(fileName));
		
	}
	
	
	
	
	
}
