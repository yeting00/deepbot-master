package com.perspicace.ai.common.exception;
/**
*@author energy
*@version 1.0.0 
*自定义异常
**/
public class CustomerException extends BaseException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int errorNo;
	
	public CustomerException(String msg){
		super(msg);
	}
	
	public CustomerException(int _errorNo,String msg){
		super(msg);
		
		errorNo=_errorNo;
	}
}
