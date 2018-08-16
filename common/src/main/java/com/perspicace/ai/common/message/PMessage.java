package com.perspicace.ai.common.message;

import java.io.Serializable;

/** 
* @Description: 保存日志信息 
* @Param:  
* @return:  
* @Author: Destiny 
* @Date: 2018/8/2 
*/ 
public class PMessage implements Serializable{
	
	public final long serialVersionUID=1l;
	
	private String type;
	private String content;
	private Object param;
	private long time;
	
	public PMessage(){}
	
	public PMessage(String type, String content, Object param){
		super();
		this.type = type;
		this.content=content;
		this.param = param;
	}
	
	public PMessage(String type, String content, Object param,long time) {
		super();
		this.type = type;
		this.content=content;
		this.param = param;
		this.time=time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Object getParam() {
		return param;
	}
	public void setParam(Object param) {
		this.param = param;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
}
