[["java:package:com.perspicace.gen.thirdparty"]]

#include <base/Exception.ice>

module slice{


	/**
	 * 天气小时数据
	 */
	struct HourWeatherData{
		//时间
		string time;
		//天气代码
		string weatherCode;
		//温度
		string temperature;
	};
	
	//小时天气列表
	sequence<HourWeatherData> hourWeatherSequence;
	
	struct WeatherIndexinfo{
	 	//标题
		string title;
	 	//说明
		string desc;
	};
	
	struct AqiDetailData{
		//地区
		string area;
		//空气质量
		string quality;
		//pm2.5 浓度
		int pm25;
		// 空气质量指数(越小越好)
		int aqi;
	
	};
	
	struct NowWeatherData{
		//空气质量对象
		AqiDetailData aqiDetail;
		//湿度
		string sd;
		//当前温度
		string temperature;
		//当前风向
		string windDirection;
		//风力
		string windPower;
	};
	
	
	//指数数据
	struct WeatherIndexData{
	 	//紫外线指数
		WeatherIndexinfo uv;
	 	//空气质量指数，越小越好
		WeatherIndexinfo aqi;
		//舒适度指数
		WeatherIndexinfo comfort;
		//穿衣指数
		WeatherIndexinfo clothes;
	};
	
	/**
	* 天气天数据
	*/
	struct DayWeatherData{
		//当天天气代码
		string dayWeatherCode;
		//当天白天温度(最高温度)
		string dayAirTemperature;
		//当天晚上温度(最低温度)
		string nightAirTemperature;
		//当天天气名称
		string dayWeatherName;
		//日期
		string day;
		//指数数据
		WeatherIndexData index;
		//白天风速
		string dayWindPower;
		//晚上风速
		string nightWindPower;
		//白天风向
		string dayWindDirection;
		 //晚上风向
		string nightWindDirection;
	};
	
	sequence<DayWeatherData> dayWeatherSequence;

	/**
	 * 天气数据
	 */
	struct WeatherData{
		//当天降水概率
		string jiangshui;
		//当天日出日落时间
		string sunBeginEnd;
		//当天天气代码
		string dayWeatherCode;
		//当天天气中文
		string dayWeatherName;
		//天气预报发布时间
		string time;
		//当天白天温度(最高温度)
		string dayAirTemperature;
		//当天晚上温度(最低温度)
		string nightAirTemperature;
		//小时数据列表
		hourWeatherSequence hourWeathers;
		//天气天数据
		dayWeatherSequence dayWeathers;
		//当前天气数据
		NowWeatherData nowWeatherData;
	};










	/****************股票数据***********************/

	struct SharesData{
	     /**
    	 * 股票编码
    	 */
    	string code;
    	/**
    	 * 股票名字
    	 */
    	string name;
    	/**
    	 * 当前价格
    	 */
    	string nowPrice;
    	/**
    	 * 涨跌幅
    	 */
    	string diffRate;
    	/**
    	 * 涨跌额
    	 */
    	string diffMoney;
    	/**
    	 * 昨日收盘价
    	 */
    	string yestodayClosePrice;
    	/**
    	 * 今天最高
    	 */
    	string todayMax;
    	/**
    	 * 今天最低
    	 */
    	string todayMin;
    	/**
    	 * 换手率
    	 */
    	string turnover;
    	/**
    	 * 成交量
    	 */
    	string tradeNum;
    	/**
    	 * 成交额
    	 */
    	string tradeAmount;
    	/**
    	 * 开盘价格
    	 */
    	string openPrice;
    };

    sequence<SharesData> sharesDataSequence;


    //股票查询类型枚举
    enum SharesType{sharesName=1,//股票名字
                    sharesCode=2, //股票代码
                   };


	/**********************股票数据结束**************************/




	/**************************路况数据***************************/

    struct DistanceData{//路况数据
        /**
         * 起点
         */
        string start;
        /**
         * 终点
         */
        string end;

        /**
         * 距离(单位为千米)
         */
        int distance;
        /**
         * 时间（单位为分钟）
         */
        int duration;
        /**
         * 起点坐标
         */
        string startPos;
        /**
         * 终点坐标
         */
        string endPos;
    };

	/**************************路况数据结束***************************/


    struct WeatherListData{
        //天气代码
        string code;
        //天气描述
        string weatherText;
        //日期
        string date;
        //最高温度
        string high;
        //最低温度
        string low;
    };

    sequence<WeatherListData> WeatherList;

    struct SimpleWeatherData{
        //天气代码
        string code;
        //当天天气描述
        string weatherText;
        //日期
        string date;
        //当前温度
        string temp;
        //城市名
        string cityName;
         //最高温度
        string high;
        //最低温度
        string low;

        //7天数据
        WeatherList list;
    };


	interface ThirdPartyService{


	    SimpleWeatherData getWeather(string cityName,string date)throws BussinessServiceException;


		//天气数据获取
		WeatherData getWeatherApiData(string cityName) throws BussinessServiceException;



		/**
		 * 股票数据获取
		 * type = 查询类型枚举
		 * name = 股票名或代码
		 */
		sharesDataSequence getSharesList(SharesType type, string name)throws BussinessServiceException;

        /**
         * 路况数据获取
         * cityName = 城市名
         * startPlace = 起始地点
         * destination = 目的地
         */
        DistanceData getDistanceInfo(string cityName,string startPlace,string destination)throws BussinessServiceException;

	};
	
	
	
	
	struct CookBookEntity{
		// 菜谱名称
		string cookName;
		// 菜谱图片的路径		
		string imgUrl;	
		// 耗时	
		string elapsedTime;	
		// 原料	
		string materials;	
		// 调料	
		string spices;		
		// 烹饪第一步
		string firstStep;	
		// 烹饪第二步	
		string secondStep;		
		// 烹饪第三步
		string thirdStep;		
	};
	
	sequence<CookBookEntity> cookBookEntitySequence;
	
	struct CookMateriaEntity{
		// 食材的名称
		string materialName;
		// 食材的描述		
		string describe;
		string type;
		
		cookBookEntitySequence cookBook;	
	};
	
	sequence<CookMateriaEntity> CookMateriaEntitySequence;
	
	interface CookBookService{
		/**
	 	* 菜谱
		*/
		CookMateriaEntity getCookBook(string materialCode,string language) throws BussinessServiceException;
		
	};
	
	
	
	struct GoogleMapEntity{
		// 状态（OK是成功）
		string status;
		// 距离		
		string distance;
		// 时间	
		string duration;
	};
	
	interface GoogleMapService{
		/**
	 	* 获取google地图的距离和时间
		*/
		GoogleMapEntity getGoogleMaps(string origin,string destination) throws BussinessServiceException;
		
	};
	
		
	struct FoodsMenuEntity{
	
		string menuId;
		//食品名称
		string menuName;
		// 单位
		string unit;
		// 价格
		string price;
		// 语料说明
		string remark;
	};
	
	sequence<FoodsMenuEntity> FoodsMenuEntitySequence;
	
	interface FoodsMenuService{
		/**
	 	* 外卖菜单
		*/
		FoodsMenuEntitySequence getFoodsMenuByLabelName(string labelName, string name) throws BussinessServiceException;
		
	};
	
	struct ShopProductEntity{
		  //编号
		  string id;
		  //系统
		  string system;
		  //地区
		  string region;
		  //分类
		  string category;
		  //类型
		  string type;
		  //图片
		  string pic;
		  //名称
		  string name;
		  //价格
		  string price;
		  //单位
		  string unit;
		  //描述
		  string description;
	};
	
	sequence<ShopProductEntity> shopProductEntitySequence;
		
	interface ShopService{
		
		/**
		* 商品列表
		*/
		shopProductEntitySequence getProductList(string system, string type, string name) throws BussinessServiceException;
		
	};
	
};