package com.perspicace.ai.deepbot.utils;


import Ice.Communicator;
import Ice.ObjectPrx;
import com.perspicace.gen.electricappliance.slice.ElectricApplianceControlServicePrx;
import com.perspicace.gen.electricappliance.slice.ElectricApplianceControlServicePrxHelper;
import com.perspicace.gen.electricappliance.slice.ElectricApplianceGenJsonServicePrx;
import com.perspicace.gen.electricappliance.slice.ElectricApplianceGenJsonServicePrxHelper;
import com.perspicace.gen.scene.slice.SceneServicePrx;
import com.perspicace.gen.scene.slice.SceneServicePrxHelper;
import com.perspicace.modules.AICall.AICall.AICallServicePrx;
import com.perspicace.modules.AICall.AICall.AICallServicePrxHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
*@author energy
*@version 1.0.0 创建时间：2017年12月22日
*说明
**/
public class IceInvoker{
	private static Logger logger=LoggerFactory.getLogger(IceInvoker.class);
	
	//控制家电的中心和tts的中心分开
	public final static String controller_device="controller_device";
	public final static String tts="tts";
	
	private static Map<String, Communicator> communicatorMap;
	private static  Map<String,String> communicatorNameMap;
	
	
	public static void initParams(IceInvokeParams iceInvokeParams){
		logger.info("ttsurl="+iceInvokeParams.getTts_url());
		
		logger.info("controller_device_url="+iceInvokeParams.getController_device_url());
		
		communicatorNameMap=new HashMap<String,String>();
		communicatorNameMap.put(IceInvoker.controller_device, iceInvokeParams.getController_device_url());
		//communicatorNameMap.put(IceInvoker.controller_device, "SmartHomeTestIceGrid/Locator:tcp -h 10.10.2.124 -p 4061 -t 3000");
		communicatorNameMap.put(IceInvoker.tts, iceInvokeParams.getTts_url());
		
		//SmartHomeTestIceGrid/Locator:tcp -h 10.10.2.124 -p 4062 -t 3000
		//SmartHomeTestIceGrid /Locator:tcp -h 10.101.1.50 -p 4061 -t 60000
		communicatorMap=new HashMap<String, Communicator>();
		
		Communicator controllerDeviceCommunicator=getCommunicator(IceInvoker.controller_device);
		Communicator ttsCommunicator=getCommunicator(IceInvoker.tts);
		
		communicatorMap.put(IceInvoker.controller_device, controllerDeviceCommunicator);
		communicatorMap.put(IceInvoker.tts, ttsCommunicator);
	}
	
	
	
	private static ObjectPrx getIceProxy(String locatorName, Class serviceCls){
		Communicator communicator=getCommunicator(locatorName);
		
		String serviceName = serviceCls.getSimpleName();
		int pos = serviceName.lastIndexOf("Prx");
		if (pos <= 0) {
			throw new IllegalArgumentException("Invalid ObjectPrx class ,class name must end with Prx");
		}
		String realSvName = serviceName.substring(0, pos);
		try {
			ObjectPrx base = communicator.stringToProxy(realSvName + "@"+realSvName+"Adapter");
			return base;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private static Communicator getCommunicator(String locatorName){
		Communicator communicator=communicatorMap.get(locatorName);
		if(communicator==null){
			String locator=communicatorNameMap.get(locatorName);
			communicator=createCommunicator(locator);
			communicatorMap.put(locatorName, communicator);
		}else{
			communicator=communicatorMap.get(locatorName);
		}
		
		return communicator;
	}
	
	private static Communicator createCommunicator(String locator){
		String iceDefaultLocator = "--Ice.Default.Locator=" + locator;
		String[] initParams = new String[]{iceDefaultLocator};
		Communicator communicator = Ice.Util.initialize(initParams);
		return communicator;
	}
	
	private static AICallServicePrx aiCallServicePrx;
	public static AICallServicePrx getAICallServicePrx(){
		if(aiCallServicePrx==null){
			ObjectPrx prx=(ObjectPrx)getIceProxy(IceInvoker.tts,AICallServicePrx.class);
			aiCallServicePrx=AICallServicePrxHelper.uncheckedCast(prx);
		}
		return aiCallServicePrx;
	}


	private static ElectricApplianceGenJsonServicePrx electricApplianceControlGenServicePrx;

	//获取大JSON服务
	public static ElectricApplianceGenJsonServicePrx getElectricApplianceGenJsonServicePrx(){
		if(electricApplianceControlGenServicePrx == null){
			ObjectPrx prx= (ObjectPrx)getIceProxy(IceInvoker.tts,ElectricApplianceGenJsonServicePrx.class);
			electricApplianceControlGenServicePrx = ElectricApplianceGenJsonServicePrxHelper.uncheckedCast(prx);
		}
		return electricApplianceControlGenServicePrx;
	}



	//场景控制
	private static SceneServicePrx sceneServicePrx;

	public static SceneServicePrx getSceneServicePrx() {
		if (sceneServicePrx == null) {
			ObjectPrx prx= (ObjectPrx)getIceProxy(IceInvoker.tts,SceneServicePrx.class);
			sceneServicePrx = SceneServicePrxHelper.uncheckedCast(prx);
		}
		return sceneServicePrx;
	}

	//家电控制服务
	private static ElectricApplianceControlServicePrx electricApplianceControlServicePrx;
	public static ElectricApplianceControlServicePrx getElectricApplianceControlServicePrx() {
		if (electricApplianceControlServicePrx == null) {
			ObjectPrx prx= (ObjectPrx)getIceProxy(IceInvoker.tts,ElectricApplianceControlServicePrx.class);
			electricApplianceControlServicePrx = ElectricApplianceControlServicePrxHelper.uncheckedCast(prx);
		}
		return electricApplianceControlServicePrx;
	}




}
