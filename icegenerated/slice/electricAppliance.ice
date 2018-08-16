[["java:package:com.perspicace.gen.electricappliance"]]

#include "base/Exception.ice"

module slice{

	// 家电类型枚举
	enum ElectricApplianceTypeEo{lamp=1,normalAirConditioning=2,tv=3,centralAirConditioning=4,freshAir=5,floorHeating=6};
	// 开关指令枚举
	enum ElectricApplianceIoEo{on=0,off=1};
	// 模式枚举 制冷 制热 送风 除湿
	enum ElectricApplianceModeEo{cool=0,heat=1,fan=3,dry=4};
	// 风速枚举
	enum ElectricApplianceFanSpeedEo{low=1,middle=2,high=3};
	
	// 指令类型枚举  开关 模式(空调) 风速 温度 电视控制
	enum ElectricAppliancePressKeyEo{io=1,mode=2,fanSpeed=3,temperature=4,tvControl=5};
	// 电视控制指令枚举   chminus(频道减)  chadd(频道加)  volminus(音量减) voladd(音量加) mute(静音)
	enum ElectricApplianceTvControlKey{up,down,left,right,menu,power,chminus,chadd,volminus,voladd,back,mute,boot,ok};
	
	struct ElectricAppliancePressParam{
		ElectricAppliancePressKeyEo electricAppliancePressKeyEo;
		string pressValue;
	};
	
	sequence<ElectricAppliancePressParam> ElectricAppliancePressParamList;
	
	// 家电控制输入参数
	struct ElectricApplianceControlParam{
		string ElectricApplianceId; // 家电Id
		ElectricAppliancePressParamList electricAppliancePressParamList;
	};
	
	// 
	struct ElectricApplianceControlResult{
		string ElectricApplianceId; // 家电Id
		bool result; // 控制结果
	};
	
	
	sequence<ElectricApplianceControlParam> ElectricApplianceControlParamList;
	
	sequence<ElectricApplianceControlResult> ElectricApplianceControlResultList;
	
	interface ElectricApplianceControlService{
		
		/**
		* 家电控制
		* @param
		* ElectricApplianceControlParam 家电控制bean
		* @return
		* bool
		*/
		ElectricApplianceControlResultList electricApplianceControl(string groupId,ElectricApplianceControlParamList electricApplianceControlParamList) throws BussinessServiceException;
		
	};
	
	interface ElectricApplianceGenJsonService{
		
		/**
		* 家电大接口
		* @param
		* groupId 群组Id
		* @return json
		*/
		string ElectricApplianceBigJson(string groupId) throws BussinessServiceException;
		
	};	
};