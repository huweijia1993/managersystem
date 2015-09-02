package com.clps.managersystem.exception;

public class ExceptionCode {

	/**
	 * 底层出错code，基本上无法修改，无法返回去
	 */
	
	//读取文件失败
	public static int READFILEFAILED=0;
	//读取配置失败
	public static int READCONFIGFAILED=1;
	//关闭资源失败
	public static int CLOSRESOURCEFAILED=2;
	//资源加载出错
	public static int RESOURCELOADFAILED=3;
	//插入出错
	public static int INSERTERROR=4;
	//封装出错
	public static int ENCAPSULATEFAILED=5;
	//获取结果出错
	public static int GETRESULTFAILED=6;
	//更新出错
	public static int UPDATEFAILER=7;
	//获取ps出错
	public static int GETPREPAREDSTATEMENTFAILED=8;
	//查询记录数量出错
	public static int QUERYCOUNTFAILED=9;
	//开启事务出错
	public static int STARTTRAMSACTIONMANAGERFAILED=10;
	//提交事务出错
	public static int COMMITTRANSACTIONFAILED=11;
	//回滚事务出错
	public static int ROLLBACKFAILED=12;
	//没有对象
	public static int NOSUCHOBJECT=13;
	//连接池加载出错
	public static int POOLLOADERROR=14;
	//连接池回收出错
	public static int POOLCLOSEERROR=15;
	//类找不到
	public static int CLASSNOTFOUND=16;

	//发送邮件失败
	public static int SENDMAILFAILED=18;
	
	
	//服务错误
	public static int LOGINERROR=17;
	

	
	
}
