package com.perspicace.ai.common.constant;
/**
*@author energy
*@version 1.0.0
**/
public final class Constant {
	//天气接口
	public final static String WEATHER_URL = "http://zhwnlapi.etouch.cn/Ecalender/api/v2/weather?date={0}&city={1}";

	//微软luis
	//public final static String intentMLUISUrl="https://westus.api.cognitive.microsoft.com/luis/v2.0/apps/506e3b7e-bbaf-4658-b04f-6ec6cce9853a?subscription-key=47bce0f70081424f9e3f3f9223fdaba7&timezoneOffset=480&verbose=true&q=";

	//东南亚luis
	//public final static String microsoftUrl="https://southeastasia.api.cognitive.microsoft.com/luis/v2.0/apps/6a92ea67-8ec5-4f53-986a-f7ebf40ab90c?subscription-key=f688b793ef8a415e9d388ef362db0322&timezoneOffset=0&verbose=true&q=";

	//百芝龙luis
	public final static String intentBZLLUISUrl="http://139.219.224.30/TCF/v3/models/HomeRose/predict?type=BAYS&isTagging=True&query=";//

	//自定义聊天
	public final static String ChatFunctionUrl="http://139.219.224.30:3000/chatbot/v1/api/query?q=";

	//知识图谱
	public final static String intentBZLKLGUrl="http://139.219.197.178:3978/DBpedia/v2/entitys/parseEntities?key=!admin123&q=";

	//图灵url
	public final static String tulinurl="http://www.tuling123.com/openapi/api?key=cb82238de3dc48848cc2e7b99c7ef3c0&info=mytext&userid=xxoo";


	//自定义聊天
	public final static String ChatFunctionUrl_V2="http://42.159.238.38:4102/semanticengine/v0.1/api/applications/5a97d64fb6ccfd0001853bc3/chats/predict";

	//意图实体合集url
	public final static String intent_entity_url="http://42.159.238.38:4102/semanticengine/v0.1/api/applications/5a97d64fb6ccfd0001853bc3/predictAndEntities";

	//医疗问答
	//public final static String qaurl="http://10.10.9.233/qaserver/queryAnswer";

	//医疗问答feedback
	//public final static String qafeedbackurl="http://10.10.9.233/qaserver/feedBack";

	//获取token
	//http://10.10.11.29:8080/tokenlogin

	//public final static String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwidXNlcm5hbWUiOiJhYmMiLCJyb2xlTmFtZXMiOltdLCJleHAiOjE1MDYxNjAxNDZ9.XqbCDrNe7_I0sV3ZA5Uk4GlDijDPothOM9OPcoCn7UrA-1HhDIv_1DEMZ08lKUU0QTGxYKLc_OI7Fv0W2NqthA";

	//阿里天气
	public final static String aliweatherurl="http://ali-weather.showapi.com/area-to-weather";

	//股票
	public final static String ali_stock_url="http://stock.market.alicloudapi.com";

	//文本为空异常
	public final static int error100000=100000;

	//返回给客户端的错误信息
	public final static int error100001=100001;

	//http�?00返回
	public final static int error100002=100002;

	//http超时或�?异常
	public final static int error100003=100003;

	//其他异常
	public final static int error100004=100004;
}
