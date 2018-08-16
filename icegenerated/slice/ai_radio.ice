[["java:package:com.perspicace.gen.radio"]]

#include <base/ai_radio_exception.ice>

module slice {
	
	dictionary<string,string> EntityMap;
	
	/** 
	 * 控制电台服务
	 */
	interface ControlRadioService {
		
		string operationRadio(string text,string intent,EntityMap entityMap,string suggest, string smartDeviceId,string groupId) throws NotFoundException;
	};
	
};