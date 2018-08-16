[["java:package:com.perspicace.gen.controldevice"]]

#include <base/ai_controldevice_exception.ice>

module slice {
	
	dictionary<string,string> EntityMap;
	
	/** 
	 * 场景服务
	 */
	interface ControlDeviceService {
		
		string controlDevice(string text,string intent,EntityMap entityMap,string suggest, string smartDeviceId,string groupId) throws NoAreaException;
		
		string runScene(string text,string groupId,string sceneMode,string sn,string deviceid);
	};
	
};