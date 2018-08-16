[["java:package:com.perspicace.gen.scene"]]

#include "base/Exception.ice"

module slice {

	/** 
	 * 场景服务
	 */
	interface SceneService {
		
		/** 
	 	* 运行场景
	 	*/
		bool runScene(string sceneId, string groupId) throws BussinessServiceException;
		
	};
	
};
