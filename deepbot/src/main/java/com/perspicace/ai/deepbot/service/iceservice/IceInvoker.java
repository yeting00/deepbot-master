package com.perspicace.ai.deepbot.service.iceservice;//package com.perspicace.ai.deepbot.service.iceservice;
//
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import Ice.Communicator;
//import Ice.ObjectPrx;
//
///**
//*@author energy
//*@version 1.0.0 创建时间：2017年12月22日
//*说明
//**/
//public class IceInvoker{
//	private static Logger logger=LoggerFactory.getLogger(IceInvoker.class);
//	private static Map<String,Communicator> communicatorsMap;
//
//	/**
//	 * 从propertis中读取配置
//	 * @param is
//	 * @throws IOException
//	 */
//	public static void initWithInputStream(InputStream is) throws IOException{
//		Properties prop = new Properties();
//		try {
//			logger.info("初始化 IceInvoker");
//
//			prop.load(is);
//
//			communicatorsMap=new HashMap<String,Communicator>();
//
//			String strUrlCount=prop.getProperty("locator_count");
//			int urlCount=Integer.parseInt(strUrlCount);
//
//			logger.info("server_properties content");
//			logger.info("urlCount="+urlCount);
//
//			for(int i=1;i<=urlCount;i++){
//				String url_name=prop.getProperty("locator_name"+i);
//				String url_locator=prop.getProperty("locator_locator"+i);
//
//				logger.info("url_name=="+url_name);
//				logger.info("url_locator=="+url_locator);
//
//				Communicator communicator=createCommunicator(url_locator);
//
//				communicatorsMap.put(url_name, communicator);
//			}
//		} catch (IOException e) {
//			logger.error("初始化 IceInvoker 出错");
//			e.printStackTrace();
//			throw e;
//		}
//	}
//
//	private static ObjectPrx getIceProxy(String locatorName,Class serviceCls){
//		Communicator communicator=getCommunicator(locatorName);
//
//		String serviceName = serviceCls.getSimpleName();
//		int pos = serviceName.lastIndexOf("Prx");
//		if (pos <= 0) {
//			throw new IllegalArgumentException("Invalid ObjectPrx class ,class name must end with Prx");
//		}
//		String realSvName = serviceName.substring(0, pos);
//		try {
//			ObjectPrx base = communicator.stringToProxy(realSvName + "@"+realSvName+"Adapter");
//			return base;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//	}
//
//	private static Communicator getCommunicator(String locatorName){
//		return communicatorsMap.get(locatorName);
//	}
//
//	private static Communicator createCommunicator(String locator){
//		String iceDefaultLocator = "--Ice.Default.Locator=" + locator;
//		String[] initParams = new String[]{iceDefaultLocator};
//		Communicator communicator = Ice.Util.initialize(initParams);
//		return communicator;
//	}
//
//
//	public static ObjectPrx getPrxByName(String prxName,Class serviceCls){
//		try {
//			String clsName=serviceCls.getSimpleName();
//			String packageName=serviceCls.getPackage().getName();
//			ObjectPrx baseProxy=getIceProxy(prxName,serviceCls);
//
//			//ElectricApplianceGenJsonServicePrxHelper
//			//ElectricApplianceGenJsonServicePrxHelper
//			ObjectPrx proxyHelper=(ObjectPrx) Class.forName(packageName+"."+clsName+"Helper").newInstance();
//			Method m1 = proxyHelper.getClass().getDeclaredMethod("uncheckedCast", ObjectPrx.class);
//
//			ObjectPrx proxy = (ObjectPrx)m1.invoke(proxyHelper, baseProxy);
//			return proxy;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//}
