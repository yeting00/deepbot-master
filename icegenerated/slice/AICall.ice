[["java:package:com.perspicace.modules.AICall"]]

module AICall{
	
    /**
	*
	*调用TTS需要的参数
	**/
	struct SayObj{
	    string wakeLogId;/**唤醒日志id**/
        string talkSessionId;/**会话id**/
		int isStop;/**说话即休眠1  连续监听0**/
		int isChat;/**android端预留字段 聊天为1  其他为0**/
		string sayingText;/**TTS播报的文本**/
		string sn;/**设备号**/
		int result;/**结果编号 预留字段**/
		string attachParam;/**附加参数(json) **/
		string responseSn;/**响应设备号**/
	};

      /**
        *
        *感知结果返回
        **/
       interface AICallService{
        	string  listionBack(SayObj sayObj);
        	string aiCallTest(string call);
       };



};
