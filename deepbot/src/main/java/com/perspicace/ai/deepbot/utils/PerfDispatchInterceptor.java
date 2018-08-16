package com.perspicace.ai.deepbot.utils;

import Ice.DispatchInterceptor;
import Ice.DispatchStatus;
import Ice.Identity;
import Ice.Request;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 分发拦截器，本拦截器用于日志记录
 *
 */
@Slf4j(topic = "system")
public class PerfDispatchInterceptor extends DispatchInterceptor {
	
	private static final Map<Identity, Ice.Object> id2ObjectMap = new ConcurrentHashMap<Identity, Ice.Object>();
	private static final PerfDispatchInterceptor self = new PerfDispatchInterceptor();
	private static final long serialVersionUID = 1L;
	
	public static PerfDispatchInterceptor getInstance(){
		return self;
	}
	
	//添加我们要拦截的服务Servant
	public static DispatchInterceptor addIceObject(Identity id, Ice.Object iceObj){
		id2ObjectMap.put(id, iceObj);
		return self;
	}
	
	/**
	 * 此方法可以做任何拦截，类似AOP
	 */
	@Override
	public DispatchStatus dispatch(Request request) {
		Identity theId = request.getCurrent().id;
		//request.getCurrent().con 会打印出来local address=localhost:50907
		//(回车换行)remote address=localhost:51147这样的信息
		/*其中local address为被访问的服务地址端口，remote address为客户端的地址端口*/
		String inf = "dispach req,method: "+request.getCurrent().operation
				+" service:"+theId.name
				+" server address:"+request.getCurrent().con;
		log.info(inf+" begin");
		try{
			DispatchStatus reslt = id2ObjectMap.get(request.getCurrent().id).ice_dispatch(request);
			log.info(inf+" success");
			return reslt;
		}catch(Exception e){
			log.error(inf+" error "+e);
			throw e;
			
		}
	}
	
	public static void removeIceObject(Identity id){
		log.info("remove ice object "+id);
		id2ObjectMap.remove(id);
	}

}
