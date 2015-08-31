package com.clps.managersystem.exception;

public class ManagerSystemException extends RuntimeException{

	/**
	  * @Fields serialVersionUID : TODO
	  */
	
	//加一个exceptioncode 方便分支
	
	private static final long serialVersionUID = 6647085800891253923L;
	private int code;
	
	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public ManagerSystemException(String msg,Throwable cause,int code){
		super(msg,cause);
		this.code=code;
		
	}
	
	public ManagerSystemException(String msg,int code){
		super(msg);
		this.code=code;
	}
	
	public ManagerSystemException(int code){
		this.code=code;
	}
	
	
	
	
	
	
	
}
