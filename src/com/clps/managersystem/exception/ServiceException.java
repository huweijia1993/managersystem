package com.clps.managersystem.exception;

public class ServiceException extends ManagerSystemException{

	
	public ServiceException(int code){
		super(code);
	}
	public ServiceException(String msg,int code){
		super(msg,code);
	}
	public ServiceException(String msg, Throwable cause, int code) {
		super(msg, cause, code);
	}

	/**
	  * @Fields serialVersionUID : TODO
	  */
	
	private static final long serialVersionUID = -7276108171800158231L;

}
