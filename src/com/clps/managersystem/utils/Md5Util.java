package com.clps.managersystem.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javassist.compiler.ast.StringL;

/**
 * 
  * @ClassName: Md5Util
  * @Description: md5加密解密处理
  * @author Comsys-huweijia
  * @date 2015年9月2日 上午10:03:10
  *
 */
public class Md5Util {
	
	private final static String[] strDigits={ "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
	public Md5Util(){
		
	}
	private static String byteToArrayString(byte bByte){
		int iRet=bByte;
		if(iRet<0){
			iRet+=256;
		}
		int id1=iRet/16;
		int id2=iRet%16;
		return strDigits[id1]+strDigits[id2];
	}
	
	private static String byteToNum(byte bByte){
		int iRet=bByte;
		if(iRet<0){
			iRet+=256;
		}
		return String.valueOf(iRet);
	}
	
	private static String byteToString(byte[] bByte){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<bByte.length;i++){
			sb.append(byteToArrayString(bByte[i]));
		}
		return sb.toString();
		
	}
	
//	private static String byteToString(byte[] bByte){
//		StringBuilder sb=new StringBuilder();
//		for(int i=0;i<bByte.length;i++){
//			sb.append(byteToArrayString(bByte[i]));
//		}
//		return sb.toString();
//	}
	
	public static String getMD5Code(String strObj){
		String resultString=null;
		try{
			resultString=new String(strObj);
			MessageDigest md=MessageDigest.getInstance("MD5");
			resultString=byteToString(md.digest(strObj.getBytes()));
		}catch(NoSuchAlgorithmException ex){
			ex.printStackTrace();
		}
		return resultString;
	}
	
	
	
	

	
}
