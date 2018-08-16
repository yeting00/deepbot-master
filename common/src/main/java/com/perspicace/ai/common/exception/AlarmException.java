package com.perspicace.ai.common.exception;

public class AlarmException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public static int errorNo = 408;
	
	public AlarmException(String msg) {
		this(errorNo, msg);
	}
	
	public AlarmException(int _errorNo,String msg){
		super(msg);
		
		errorNo=_errorNo;
	}
}
