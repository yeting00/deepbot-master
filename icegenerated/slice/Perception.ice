[["java:package:com.perspicace.modules.Perception"]]

module PerceptionTxt{

    /**来源**/
	enum Source{SmartHomeCall=1,MMCall=2,AppCall=3,WeChatCall=4};

	/**
	*
	*client端传过来的参数
	**/
	struct ListionObj{
		string text;/**说的话**/
		string wakeLogId;/**唤醒日志id**/
		string talkSessionId;/**会话id**/
		string sn;/**设备sn**/
		string account;/**账号**/
		string groupId;/**家庭组编号**/
		Source source;/***来源**/
		string attachParam;/**附加参数(json) **/
		string deviceId;/**设备编号**/
		string responseSn;/**响应设备sn**/
	};

    /**
    *
    *感知
    **/
    interface PerceptionService{
        void  listion(ListionObj listionObj);
        
         /**
         *  用户端语音控制(询问天气，聊天，控制家电等  Source只有3和4)
         *  return 返回ai的回复
         */
        string userClientListion(string text,string userId,string groupId,Source src);
    };

};


