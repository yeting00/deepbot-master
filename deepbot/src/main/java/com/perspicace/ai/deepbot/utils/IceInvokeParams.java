package com.perspicace.ai.deepbot.utils;

import java.util.Properties;

public class IceInvokeParams {
	
	public static IceInvokeParams createWithPropties(Properties prop){
		IceInvokeParams iceInvokeParams=new IceInvokeParams();
		iceInvokeParams.setController_device_url(prop.getProperty("ai_controller_device_url"));
		iceInvokeParams.setTts_url(prop.getProperty("tts_url"));
		return iceInvokeParams;
	}
	
	private  String controller_device_url;
	private String tts_url;
	
	public String getController_device_url() {
		return controller_device_url;
	}
	
	public void setController_device_url(String controller_device_url) {
		this.controller_device_url = controller_device_url;
	}
	
	public String getTts_url() {
		return tts_url;
	}
	
	public void setTts_url(String tts_url) {
		this.tts_url = tts_url;
	}
	
}
