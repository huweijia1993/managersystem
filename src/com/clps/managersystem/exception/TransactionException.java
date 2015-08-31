package com.clps.managersystem.exception;

public class TransactionException extends ManagerSystemException{

	
	public TransactionException(int code){
		super(code);
	}
	

	public TransactionException(String msg,int code){
		super(msg,code);
	}

	public TransactionException(String msg, Throwable cause, int code) {
		super(msg, cause, code);
	}

	/**
	  * @Fields serialVersionUID : TODO
	  */
	
	private static final long serialVersionUID = 2342127124615670841L;

}
