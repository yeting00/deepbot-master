[["java:package:com.perspicace.modules.Controller"]]
module ControllerDevice{
	/**
	*
	*调用设备控制需要的参数
	**/
	struct ControllerObj{
		int result;
		string positionId;/**家庭区域id**/
		string account;/**账号**/
		string groupId;/**家庭组编号**/
		string deviceId;/**设备编号**/
		string operateType;/**操作类型**/
		string operateValue;/**操作值**/
	};
	
	/**
	*
	*调用设备控制返回的参数
	**/
	struct ControllerResultObj{
		int result;
		string msg;
	};
	
	/**
	*
	*控制设备
	**/
	interface ControllerDeviceService{
		ControllerResultObj ControllerDevice(ControllerObj controllerObj);
	};
};