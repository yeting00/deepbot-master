package com.perspicace.ai.deepbot.model;

import java.io.Serializable;
import java.util.List;

/**
 * @program: deepbot
 * @description: 天气数据bean
 * @author: Destiny
 * @create: 2018-06-27 18:35
 **/
public class WeatherData implements Serializable {

    /**
     * indexes : [{"ext":{"icon":"http://static.etouch.cn/icon/chenlian.png","statsKey":"-1055"},"valueV2":"较适宜晨练","name":"晨练指数","value":"较适宜","desc":"早晨气象条件较适宜晨练，但风力稍大，晨练时会感觉有点凉，部分地面较湿滑，请选择合适的地点晨练。"},{"ext":{"icon":"http://static.etouch.cn/icon/tianqi.png","statsKey":"-1053"},"valueV2":"天气炎热","name":"穿衣指数","value":"炎热","desc":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"},{"ext":{"icon":"http://static.etouch.cn/icon/shushidu.png","statsKey":"-1059"},"valueV2":"很不舒适","name":"舒适度指数","value":"很不舒适","desc":"白天天气晴好，但烈日炎炎您会感到很热，很不舒适。"},{"ext":{"icon":"http://static.etouch.cn/icon/ganmao.png","statsKey":"-1056"},"valueV2":"少发感冒","name":"感冒指数","value":"少发","desc":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"},{"ext":{"icon":"http://static.etouch.cn/icon/ziwaixian.png","statsKey":"-1054"},"valueV2":"紫外线中等","name":"紫外线强度指数","link":"http://m.weathercn.com/index.do?language=zh-cn&smartid=101010100&partner=1000001009","value":"中等","desc":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"},{"ext":{"icon":"http://static.etouch.cn/icon/lvyou.png","statsKey":"-1057"},"valueV2":"较不宜旅游","name":"旅游指数","link":"http://m.weathercn.com/index.do?language=zh-cn&smartid=101010100&partner=1000001009","value":"较不宜","desc":"天气较好，温度很高，4、5级风可以缓解天气给您带来的炎热。可以选择水上娱乐等清凉项目并注意防晒。"},{"ext":{"icon":"http://static.etouch.cn/icon/xiche.png","statsKey":"-1052"},"valueV2":"较适宜洗车","name":"洗车指数","link":"http://m.weathercn.com/index.do?language=zh-cn&smartid=101010100&partner=1000001009","value":"较适宜","desc":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},{"ext":{"icon":"http://static.etouch.cn/icon/liangshai.png","statsKey":"-1058"},"valueV2":"适宜晾晒","name":"晾晒指数","link":"http://m.weathercn.com/index.do?language=zh-cn&smartid=101010100&partner=1000001009","value":"适宜","desc":"天气不错，适宜晾晒。赶紧把久未见阳光的衣物搬出来吸收一下太阳的味道吧！"},{"ext":{"icon":"","statsKey":""},"valueV2":"不宜钓鱼","name":"钓鱼指数","value":"不宜","desc":"天气太热，不适合垂钓。"},{"ext":{"icon":"","statsKey":""},"valueV2":"防脱水防晒化妆","name":"化妆指数","value":"防脱水防晒","desc":"天气炎热，用防脱水防晒化妆品，少用粉底和胭脂，常补粉。"},{"ext":{"icon":"","statsKey":""},"valueV2":"较适宜运动","name":"运动指数","value":"较适宜","desc":"天气较好，但因风力稍强，户外可选择对风力要求不高的运动，推荐您进行室内运动。"},{"ext":{"icon":"","statsKey":""},"valueV2":"不带伞","name":"雨伞指数","value":"不带伞","desc":"天气较好，不会降水，因此您可放心出门，无须带雨伞。"},{"ext":{"icon":"","statsKey":""},"valueV2":"不适宜约会","name":"约会指数","value":"不适宜","desc":"风卷起热浪袭来，外出约会可能会因此败兴而归，最好在凉爽的室内约会。"}]
     * meta : {"circle_count":41040,"post_id":"501391","citykey":"101010100","city":"北京市","upper":"北京","html_url":"http://yun.rili.cn/tianqi/index.html?city=101010100","wcity":["w_101010100"],"up_time":"17:41","post_count":6753,"status":1000,"desc":"看看离你最近的历友在哪里"}
     * weatherUrls : {"w_life_index_more":"http://m.weathercn.com/livingindex.do?language=zh-cn&smartid=101010100&partner=1000001009#Indices","w_forecast_90":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&partner=1000001009","w_gradual_hour":""}
     * forecast15 : [{"date":"20180626","sunrise":"04:47","high":36,"forecastUrl":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=0&partner=1000001009","low":25,"sunset":"19:47","night":{"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505371453.2293.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505215052.3458.jpg","wp":"<3级","type":1,"wd":"南风","notice":"祝你有个晴朗的梦"},"aqi":89,"forecastAirUrl":"","day":{"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371463.3431.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284459.5844.jpg","wp":"3-4级","type":2,"wd":"西南风","notice":"阴晴之间，谨防紫外线侵扰"}},{"date":"20180627","sunrise":"04:47","high":38,"forecastUrl":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=1&partner=1000001009","low":25,"sunset":"19:47","night":{"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505371453.2293.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505215052.3458.jpg","wp":"<3级","type":1,"wd":"无持续风向","notice":"祝你有个晴朗的梦"},"aqi":27,"forecastAirUrl":"","day":{"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371463.3431.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284459.5844.jpg","wp":"3-4级","type":2,"wd":"东北风","notice":"阴晴之间，谨防紫外线侵扰"}},{"date":"20180628","sunrise":"04:48","high":35,"forecastUrl":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=2&partner=1000001009","low":24,"sunset":"19:47","night":{"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505371453.2293.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505215052.3458.jpg","wp":"<3级","type":1,"wd":"西南风","notice":"祝你有个晴朗的梦"},"aqi":41,"forecastAirUrl":"","day":{"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371463.3431.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284459.5844.jpg","wp":"<3级","type":2,"wd":"无持续风向","notice":"阴晴之间，谨防紫外线侵扰"}},{"date":"20180629","sunrise":"04:48","high":37,"forecastUrl":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=3&partner=1000001009","low":25,"sunset":"19:47","night":{"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505371453.2293.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505215052.3458.jpg","wp":"<3级","type":1,"wd":"西南风","notice":"祝你有个晴朗的梦"},"aqi":58,"forecastAirUrl":"","day":{"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505379621.3163.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505181366.5006.jpg","wp":"<3级","type":1,"wd":"西南风","notice":"愿你拥有比阳光明媚的心情"}},{"date":"20180630","sunrise":"04:48","high":36,"forecastUrl":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=4&partner=1000001009","low":25,"sunset":"19:47","night":{"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371467.4939.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284464.307.jpg","wp":"<3级","type":2,"wd":"东南风","notice":"夜晚多云，愿你梦里有月光"},"aqi":88,"forecastAirUrl":"","day":{"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505379621.3163.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505181366.5006.jpg","wp":"<3级","type":1,"wd":"西南风","notice":"愿你拥有比阳光明媚的心情"}},{"date":"20180701","sunrise":"04:49","high":36,"forecastUrl":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=5&partner=1000001009","low":23,"sunset":"19:47","night":{"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505371453.2293.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505215052.3458.jpg","wp":"<3级","type":1,"wd":"东南风","notice":"祝你有个晴朗的梦"},"aqi":77,"forecastAirUrl":"","day":{"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371463.3431.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284459.5844.jpg","wp":"3-4级","type":2,"wd":"东南风","notice":"阴晴之间，谨防紫外线侵扰"}},{"date":"20180702","sunrise":"04:49","high":34,"forecastUrl":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=6&partner=1000001009","low":24,"sunset":"19:47","night":{"wthr":"雷阵雨","bgPic":"http://static.etouch.cn/imgs/upload/1505371519.9399.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284529.1501.jpg","wp":"<3级","type":4,"wd":"东南风","notice":"夜间有雷阵雨，早点回家哦"},"aqi":84,"forecastAirUrl":"","day":{"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371463.3431.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284459.5844.jpg","wp":"<3级","type":2,"wd":"东南风","notice":"阴晴之间，谨防紫外线侵扰"}},{"date":"20180703","sunrise":"04:50","high":31,"forecastUrl":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=7&partner=1000001009","low":22,"sunset":"19:47","night":{"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371467.4939.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284464.307.jpg","wp":"<3级","type":2,"wd":"西风","notice":"夜晚多云，愿你梦里有月光"},"day":{"wthr":"雷阵雨","bgPic":"http://static.etouch.cn/imgs/upload/1505371516.4294.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284525.7604.jpg","wp":"<3级","type":4,"wd":"东南风","notice":"带好雨具，别在树下躲雨"}},{"date":"20180704","sunrise":"04:50","high":34,"forecastUrl":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=8&partner=1000001009","low":24,"sunset":"19:46","night":{"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371467.4939.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284464.307.jpg","wp":"<3级","type":2,"wd":"西风","notice":"夜晚多云，愿你梦里有月光"},"day":{"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505379621.3163.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505181366.5006.jpg","wp":"<3级","type":1,"wd":"北风","notice":"愿你拥有比阳光明媚的心情"}},{"date":"20180705","sunrise":"04:51","high":37,"forecastUrl":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=9&partner=1000001009","low":24,"sunset":"19:46","night":{"wthr":"小雨","bgPic":"http://static.etouch.cn/imgs/upload/1505371554.566.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284577.5363.jpg","wp":"<3级","type":8,"wd":"东北风","notice":"别看雨还小，冒雨要不得"},"day":{"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371463.3431.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284459.5844.jpg","wp":"<3级","type":2,"wd":"南风","notice":"阴晴之间，谨防紫外线侵扰"}},{"date":"20180706","sunrise":"04:51","high":37,"forecastUrl":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=10&partner=1000001009","low":25,"sunset":"19:46","night":{"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371467.4939.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284464.307.jpg","wp":"<3级","type":2,"wd":"东北风","notice":"夜晚多云，愿你梦里有月光"},"day":{"wthr":"阴","bgPic":"http://static.etouch.cn/imgs/upload/1505371479.5574.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284484.5873.jpg","wp":"<3级","type":34,"wd":"西南风","notice":"不要被阴云遮挡住好心情"}},{"date":"20180707","sunrise":"04:52","high":37,"forecastUrl":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=11&partner=1000001009","low":24,"sunset":"19:46","night":{"wthr":"小雨","bgPic":"http://static.etouch.cn/imgs/upload/1505371554.566.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284577.5363.jpg","wp":"<3级","type":8,"wd":"北风","notice":"别看雨还小，冒雨要不得"},"day":{"wthr":"小雨","bgPic":"http://static.etouch.cn/imgs/upload/1505371550.6113.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284574.0261.jpg","wp":"<3级","type":8,"wd":"北风","notice":"雨虽小，注意保暖别感冒"}},{"date":"20180708","sunrise":"04:52","high":35,"forecastUrl":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=12&partner=1000001009","low":24,"sunset":"19:45","night":{"wthr":"小雨","bgPic":"http://static.etouch.cn/imgs/upload/1505371554.566.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284577.5363.jpg","wp":"<3级","type":8,"wd":"东风","notice":"别看雨还小，冒雨要不得"},"day":{"wthr":"小雨","bgPic":"http://static.etouch.cn/imgs/upload/1505371550.6113.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284574.0261.jpg","wp":"<3级","type":8,"wd":"东南风","notice":"雨虽小，注意保暖别感冒"}},{"date":"20180709","sunrise":"04:53","high":33,"forecastUrl":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=13&partner=1000001009","low":25,"sunset":"19:45","night":{"wthr":"小雨","bgPic":"http://static.etouch.cn/imgs/upload/1505371554.566.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284577.5363.jpg","wp":"<3级","type":8,"wd":"东南风","notice":"别看雨还小，冒雨要不得"},"day":{"wthr":"小雨","bgPic":"http://static.etouch.cn/imgs/upload/1505371550.6113.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284574.0261.jpg","wp":"<3级","type":8,"wd":"东南风","notice":"雨虽小，注意保暖别感冒"}},{"date":"20180710","sunrise":"04:54","high":34,"forecastUrl":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=14&partner=1000001009","low":25,"sunset":"19:45","night":{"wthr":"小雨","bgPic":"http://static.etouch.cn/imgs/upload/1505371554.566.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284577.5363.jpg","wp":"<3级","type":8,"wd":"东风","notice":"别看雨还小，冒雨要不得"},"day":{"wthr":"小雨","bgPic":"http://static.etouch.cn/imgs/upload/1505371550.6113.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284574.0261.jpg","wp":"<3级","type":8,"wd":"东南风","notice":"雨虽小，注意保暖别感冒"}},{"date":"20180711","sunrise":"04:54","high":32,"forecastUrl":"http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=15&partner=1000001009","low":24,"sunset":"19:44","night":{"wthr":"小雨","bgPic":"http://static.etouch.cn/imgs/upload/1505371554.566.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284577.5363.jpg","wp":"<3级","type":8,"wd":"西北风","notice":"别看雨还小，冒雨要不得"},"day":{"wthr":"小雨","bgPic":"http://static.etouch.cn/imgs/upload/1505371550.6113.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284574.0261.jpg","wp":"<3级","type":8,"wd":"东风","notice":"雨虽小，注意保暖别感冒"}}]
     * forecast : [{"date":"20180626","sunrise":"04:47","high":36,"low":25,"sunset":"19:47","night":{"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505371453.2293.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505215052.3458.jpg","wp":"<3级","type":1,"wd":"南风","notice":"祝你有个晴朗的梦"},"aqi":89,"day":{"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371463.3431.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284459.5844.jpg","wp":"3-4级","type":2,"wd":"西南风","notice":"阴晴之间，谨防紫外线侵扰"}},{"date":"20180627","sunrise":"04:47","high":38,"low":25,"sunset":"19:47","night":{"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505371453.2293.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505215052.3458.jpg","wp":"<3级","type":1,"wd":"无持续风向","notice":"祝你有个晴朗的梦"},"aqi":27,"day":{"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371463.3431.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284459.5844.jpg","wp":"3-4级","type":2,"wd":"东北风","notice":"阴晴之间，谨防紫外线侵扰"}},{"date":"20180628","sunrise":"04:48","high":35,"low":24,"sunset":"19:47","night":{"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505371453.2293.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505215052.3458.jpg","wp":"<3级","type":1,"wd":"西南风","notice":"祝你有个晴朗的梦"},"aqi":41,"day":{"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371463.3431.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284459.5844.jpg","wp":"<3级","type":2,"wd":"无持续风向","notice":"阴晴之间，谨防紫外线侵扰"}},{"date":"20180629","sunrise":"04:48","high":37,"low":25,"sunset":"19:47","night":{"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505371453.2293.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505215052.3458.jpg","wp":"<3级","type":1,"wd":"西南风","notice":"祝你有个晴朗的梦"},"aqi":58,"day":{"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505379621.3163.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505181366.5006.jpg","wp":"<3级","type":1,"wd":"西南风","notice":"愿你拥有比阳光明媚的心情"}},{"date":"20180630","sunrise":"04:48","high":36,"low":25,"sunset":"19:47","night":{"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371467.4939.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284464.307.jpg","wp":"<3级","type":2,"wd":"东南风","notice":"夜晚多云，愿你梦里有月光"},"aqi":88,"day":{"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505379621.3163.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505181366.5006.jpg","wp":"<3级","type":1,"wd":"西南风","notice":"愿你拥有比阳光明媚的心情"}},{"date":"20180701","sunrise":"04:49","high":36,"low":23,"sunset":"19:47","night":{"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505371453.2293.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505215052.3458.jpg","wp":"<3级","type":1,"wd":"东南风","notice":"祝你有个晴朗的梦"},"aqi":77,"day":{"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371463.3431.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284459.5844.jpg","wp":"3-4级","type":2,"wd":"东南风","notice":"阴晴之间，谨防紫外线侵扰"}}]
     * hourfc : [{"wthr":36,"shidu":"23%","hourfcUrl":"","wp":"6-7级","type_desc":"晴","time":"201806271800","type":1,"wd":"东北风"},{"wthr":35,"shidu":"26%","hourfcUrl":"","wp":"6-7级","type_desc":"晴","time":"201806271900","type":1,"wd":"北风"},{"wthr":33,"shidu":"28%","hourfcUrl":"","wp":"6-7级","type_desc":"晴","time":"201806272000","type":1,"wd":"北风"},{"wthr":31,"shidu":"29%","hourfcUrl":"","wp":"5-6级","type_desc":"晴","time":"201806272100","type":1,"wd":"北风"},{"wthr":30,"shidu":"28%","hourfcUrl":"","wp":"5-6级","type_desc":"晴","time":"201806272200","type":1,"wd":"北风"},{"wthr":29,"shidu":"26%","hourfcUrl":"","wp":"5-6级","type_desc":"晴","time":"201806272300","type":1,"wd":"北风"},{"wthr":28,"shidu":"27%","hourfcUrl":"","wp":"5-6级","type_desc":"晴","time":"201806280000","type":1,"wd":"北风"},{"wthr":27,"shidu":"28%","hourfcUrl":"","wp":"5-6级","type_desc":"晴","time":"201806280100","type":1,"wd":"北风"},{"wthr":27,"shidu":"29%","hourfcUrl":"","wp":"5-6级","type_desc":"晴","time":"201806280200","type":1,"wd":"北风"},{"wthr":26,"shidu":"30%","hourfcUrl":"","wp":"5-6级","type_desc":"晴","time":"201806280300","type":1,"wd":"西北风"},{"wthr":26,"shidu":"31%","hourfcUrl":"","wp":"5-6级","type_desc":"晴","time":"201806280400","type":1,"wd":"西北风"},{"wthr":25,"shidu":"31%","hourfcUrl":"","wp":"5-6级","type_desc":"晴","time":"201806280500","type":1,"wd":"西北风"},{"wthr":26,"shidu":"31%","hourfcUrl":"","wp":"5-6级","type_desc":"晴","time":"201806280600","type":1,"wd":"西北风"},{"wthr":28,"shidu":"30%","hourfcUrl":"","wp":"5-6级","type_desc":"晴","time":"201806280700","type":1,"wd":"西北风"},{"wthr":30,"shidu":"27%","hourfcUrl":"","wp":"5-6级","type_desc":"晴","time":"201806280800","type":1,"wd":"西北风"},{"wthr":31,"shidu":"26%","hourfcUrl":"","wp":"5-6级","type_desc":"晴","time":"201806280900","type":1,"wd":"北风"},{"wthr":32,"shidu":"24%","hourfcUrl":"","wp":"5-6级","type_desc":"晴","time":"201806281000","type":1,"wd":"北风"},{"wthr":33,"shidu":"23%","hourfcUrl":"","wp":"5-6级","type_desc":"晴","time":"201806281100","type":1,"wd":"东北风"},{"wthr":33,"shidu":"21%","hourfcUrl":"","wp":"6-7级","type_desc":"晴","time":"201806281200","type":1,"wd":"东北风"},{"wthr":34,"shidu":"21%","hourfcUrl":"","wp":"6-7级","type_desc":"晴","time":"201806281300","type":1,"wd":"东北风"},{"wthr":34,"shidu":"20%","hourfcUrl":"","wp":"6-7级","type_desc":"多云","time":"201806281400","type":2,"wd":"东北风"},{"wthr":35,"shidu":"19%","hourfcUrl":"","wp":"6-7级","type_desc":"多云","time":"201806281500","type":2,"wd":"东北风"},{"wthr":35,"shidu":"18%","hourfcUrl":"","wp":"6-7级","type_desc":"晴","time":"201806281600","type":1,"wd":"东北风"},{"wthr":34,"shidu":"19%","hourfcUrl":"","wp":"6-7级","type_desc":"晴","time":"201806281700","type":1,"wd":"东北风"}]
     * xianhao : [{"f_date":"20131202","f_number":"无","action_type":"webview","item_id":"458184767","click_url":"http://yun.rili.cn/tianqi/traffic.html?city=101010100","title":"限行"},{"f_date":"20180626","f_number":"5,0","action_type":"webview","item_id":"458184767","click_url":"http://yun.rili.cn/tianqi/traffic.html?city=101010100","title":"限行"},{"f_date":"20180627","f_number":"1,6","action_type":"webview","item_id":"458186311","click_url":"http://yun.rili.cn/tianqi/traffic.html?city=101010100","title":"限行"},{"f_date":"20180628","f_number":"2,7","action_type":"webview","item_id":"458187493","click_url":"http://yun.rili.cn/tianqi/traffic.html?city=101010100","title":"限行"},{"f_date":"20180629","f_number":"3,8","action_type":"webview","item_id":"458188731","click_url":"http://yun.rili.cn/tianqi/traffic.html?city=101010100","title":"限行"},{"f_date":"20180702","f_number":"4,9","action_type":"webview","item_id":"471081795","click_url":"http://yun.rili.cn/tianqi/traffic.html?city=101010100","title":"限行"},{"f_date":"20180703","f_number":"5,0","action_type":"webview","item_id":"471088597","click_url":"http://yun.rili.cn/tianqi/traffic.html?city=101010100","title":"限行"},{"f_date":"20180704","f_number":"1,6","action_type":"webview","item_id":"471089419","click_url":"http://yun.rili.cn/tianqi/traffic.html?city=101010100","title":"限行"}]
     * source : {"link":"http://m.weathercn.com/index.do?language=zh-cn&smartid=101010100&partner=1000001009","icon":"http://static.etouch.cn/icon/tianqitong.png","title":"中国天气通"}
     * evn : {"no2":12,"mp":"","pm25":7,"o3":86,"so2":2,"aqi":47,"pm10":23,"suggest":"各类人群可自由活动","time":"17:00:00","co":0,"quality":"优"}
     * observe : {"shidu":"17%","wthr":"晴","temp":37,"night":{"bgPic":"http://static.etouch.cn/imgs/upload/1505371453.2293.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505215052.3458.jpg"},"up_time":"17:41","wp":"5级","tigan":"36","type":1,"wd":"北风","day":{"bgPic":"http://static.etouch.cn/imgs/upload/1505379621.3163.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505181366.5006.jpg"}}
     */

    private MetaBean meta;
    private WeatherUrlsBean weatherUrls;
    private SourceBean source;
    private EvnBean evn;
    private ObserveBean observe;
    private List<IndexesBean> indexes;
    private List<Forecast15Bean> forecast15;
    private List<ForecastBean> forecast;
    private List<HourfcBean> hourfc;
    private List<XianhaoBean> xianhao;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public WeatherUrlsBean getWeatherUrls() {
        return weatherUrls;
    }

    public void setWeatherUrls(WeatherUrlsBean weatherUrls) {
        this.weatherUrls = weatherUrls;
    }

    public SourceBean getSource() {
        return source;
    }

    public void setSource(SourceBean source) {
        this.source = source;
    }

    public EvnBean getEvn() {
        return evn;
    }

    public void setEvn(EvnBean evn) {
        this.evn = evn;
    }

    public ObserveBean getObserve() {
        return observe;
    }

    public void setObserve(ObserveBean observe) {
        this.observe = observe;
    }

    public List<IndexesBean> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<IndexesBean> indexes) {
        this.indexes = indexes;
    }

    public List<Forecast15Bean> getForecast15() {
        return forecast15;
    }

    public void setForecast15(List<Forecast15Bean> forecast15) {
        this.forecast15 = forecast15;
    }

    public List<ForecastBean> getForecast() {
        return forecast;
    }

    public void setForecast(List<ForecastBean> forecast) {
        this.forecast = forecast;
    }

    public List<HourfcBean> getHourfc() {
        return hourfc;
    }

    public void setHourfc(List<HourfcBean> hourfc) {
        this.hourfc = hourfc;
    }

    public List<XianhaoBean> getXianhao() {
        return xianhao;
    }

    public void setXianhao(List<XianhaoBean> xianhao) {
        this.xianhao = xianhao;
    }

    public static class MetaBean {
        /**
         * circle_count : 41040
         * post_id : 501391
         * citykey : 101010100
         * city : 北京市
         * upper : 北京
         * html_url : http://yun.rili.cn/tianqi/index.html?city=101010100
         * wcity : ["w_101010100"]
         * up_time : 17:41
         * post_count : 6753
         * status : 1000
         * desc : 看看离你最近的历友在哪里
         */

        private int circle_count;
        private String post_id;
        private String citykey;
        private String city;
        private String upper;
        private String html_url;
        private String up_time;
        private int post_count;
        private int status;
        private String desc;
        private List<String> wcity;

        public int getCircle_count() {
            return circle_count;
        }

        public void setCircle_count(int circle_count) {
            this.circle_count = circle_count;
        }

        public String getPost_id() {
            return post_id;
        }

        public void setPost_id(String post_id) {
            this.post_id = post_id;
        }

        public String getCitykey() {
            return citykey;
        }

        public void setCitykey(String citykey) {
            this.citykey = citykey;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getUpper() {
            return upper;
        }

        public void setUpper(String upper) {
            this.upper = upper;
        }

        public String getHtml_url() {
            return html_url;
        }

        public void setHtml_url(String html_url) {
            this.html_url = html_url;
        }

        public String getUp_time() {
            return up_time;
        }

        public void setUp_time(String up_time) {
            this.up_time = up_time;
        }

        public int getPost_count() {
            return post_count;
        }

        public void setPost_count(int post_count) {
            this.post_count = post_count;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public List<String> getWcity() {
            return wcity;
        }

        public void setWcity(List<String> wcity) {
            this.wcity = wcity;
        }
    }

    public static class WeatherUrlsBean {
        /**
         * w_life_index_more : http://m.weathercn.com/livingindex.do?language=zh-cn&smartid=101010100&partner=1000001009#Indices
         * w_forecast_90 : http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&partner=1000001009
         * w_gradual_hour :
         */

        private String w_life_index_more;
        private String w_forecast_90;
        private String w_gradual_hour;

        public String getW_life_index_more() {
            return w_life_index_more;
        }

        public void setW_life_index_more(String w_life_index_more) {
            this.w_life_index_more = w_life_index_more;
        }

        public String getW_forecast_90() {
            return w_forecast_90;
        }

        public void setW_forecast_90(String w_forecast_90) {
            this.w_forecast_90 = w_forecast_90;
        }

        public String getW_gradual_hour() {
            return w_gradual_hour;
        }

        public void setW_gradual_hour(String w_gradual_hour) {
            this.w_gradual_hour = w_gradual_hour;
        }
    }

    public static class SourceBean {
        /**
         * link : http://m.weathercn.com/index.do?language=zh-cn&smartid=101010100&partner=1000001009
         * icon : http://static.etouch.cn/icon/tianqitong.png
         * title : 中国天气通
         */

        private String link;
        private String icon;
        private String title;

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class EvnBean {
        /**
         * no2 : 12
         * mp :
         * pm25 : 7
         * o3 : 86
         * so2 : 2
         * aqi : 47
         * pm10 : 23
         * suggest : 各类人群可自由活动
         * time : 17:00:00
         * co : 0
         * quality : 优
         */

        private int no2;
        private String mp;
        private int pm25;
        private int o3;
        private int so2;
        private int aqi;
        private int pm10;
        private String suggest;
        private String time;
        private int co;
        private String quality;

        public int getNo2() {
            return no2;
        }

        public void setNo2(int no2) {
            this.no2 = no2;
        }

        public String getMp() {
            return mp;
        }

        public void setMp(String mp) {
            this.mp = mp;
        }

        public int getPm25() {
            return pm25;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public int getO3() {
            return o3;
        }

        public void setO3(int o3) {
            this.o3 = o3;
        }

        public int getSo2() {
            return so2;
        }

        public void setSo2(int so2) {
            this.so2 = so2;
        }

        public int getAqi() {
            return aqi;
        }

        public void setAqi(int aqi) {
            this.aqi = aqi;
        }

        public int getPm10() {
            return pm10;
        }

        public void setPm10(int pm10) {
            this.pm10 = pm10;
        }

        public String getSuggest() {
            return suggest;
        }

        public void setSuggest(String suggest) {
            this.suggest = suggest;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getCo() {
            return co;
        }

        public void setCo(int co) {
            this.co = co;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }
    }

    public static class ObserveBean {
        /**
         * shidu : 17%
         * wthr : 晴
         * temp : 37
         * night : {"bgPic":"http://static.etouch.cn/imgs/upload/1505371453.2293.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505215052.3458.jpg"}
         * up_time : 17:41
         * wp : 5级
         * tigan : 36
         * type : 1
         * wd : 北风
         * day : {"bgPic":"http://static.etouch.cn/imgs/upload/1505379621.3163.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505181366.5006.jpg"}
         */

        private String shidu;
        private String wthr;
        private int temp;
        private NightBean night;
        private String up_time;
        private String wp;
        private String tigan;
        private int type;
        private String wd;
        private DayBean day;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public String getWthr() {
            return wthr;
        }

        public void setWthr(String wthr) {
            this.wthr = wthr;
        }

        public int getTemp() {
            return temp;
        }

        public void setTemp(int temp) {
            this.temp = temp;
        }

        public NightBean getNight() {
            return night;
        }

        public void setNight(NightBean night) {
            this.night = night;
        }

        public String getUp_time() {
            return up_time;
        }

        public void setUp_time(String up_time) {
            this.up_time = up_time;
        }

        public String getWp() {
            return wp;
        }

        public void setWp(String wp) {
            this.wp = wp;
        }

        public String getTigan() {
            return tigan;
        }

        public void setTigan(String tigan) {
            this.tigan = tigan;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getWd() {
            return wd;
        }

        public void setWd(String wd) {
            this.wd = wd;
        }

        public DayBean getDay() {
            return day;
        }

        public void setDay(DayBean day) {
            this.day = day;
        }

        public static class NightBean {
            /**
             * bgPic : http://static.etouch.cn/imgs/upload/1505371453.2293.jpg
             * smPic : http://static.etouch.cn/imgs/upload/1505215052.3458.jpg
             */

            private String bgPic;
            private String smPic;

            public String getBgPic() {
                return bgPic;
            }

            public void setBgPic(String bgPic) {
                this.bgPic = bgPic;
            }

            public String getSmPic() {
                return smPic;
            }

            public void setSmPic(String smPic) {
                this.smPic = smPic;
            }
        }

        public static class DayBean {
            /**
             * bgPic : http://static.etouch.cn/imgs/upload/1505379621.3163.jpg
             * smPic : http://static.etouch.cn/imgs/upload/1505181366.5006.jpg
             */

            private String bgPic;
            private String smPic;

            public String getBgPic() {
                return bgPic;
            }

            public void setBgPic(String bgPic) {
                this.bgPic = bgPic;
            }

            public String getSmPic() {
                return smPic;
            }

            public void setSmPic(String smPic) {
                this.smPic = smPic;
            }
        }
    }

    public static class IndexesBean {
        /**
         * ext : {"icon":"http://static.etouch.cn/icon/chenlian.png","statsKey":"-1055"}
         * valueV2 : 较适宜晨练
         * name : 晨练指数
         * value : 较适宜
         * desc : 早晨气象条件较适宜晨练，但风力稍大，晨练时会感觉有点凉，部分地面较湿滑，请选择合适的地点晨练。
         * link : http://m.weathercn.com/index.do?language=zh-cn&smartid=101010100&partner=1000001009
         */

        private ExtBean ext;
        private String valueV2;
        private String name;
        private String value;
        private String desc;
        private String link;

        public ExtBean getExt() {
            return ext;
        }

        public void setExt(ExtBean ext) {
            this.ext = ext;
        }

        public String getValueV2() {
            return valueV2;
        }

        public void setValueV2(String valueV2) {
            this.valueV2 = valueV2;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public static class ExtBean {
            /**
             * icon : http://static.etouch.cn/icon/chenlian.png
             * statsKey : -1055
             */

            private String icon;
            private String statsKey;

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getStatsKey() {
                return statsKey;
            }

            public void setStatsKey(String statsKey) {
                this.statsKey = statsKey;
            }
        }
    }

    public static class Forecast15Bean {
        /**
         * date : 20180626
         * sunrise : 04:47
         * high : 36
         * forecastUrl : http://m.weathercn.com/daily-weather-forecast.do?language=zh-cn&smartid=101010100&day=0&partner=1000001009
         * low : 25
         * sunset : 19:47
         * night : {"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505371453.2293.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505215052.3458.jpg","wp":"<3级","type":1,"wd":"南风","notice":"祝你有个晴朗的梦"}
         * aqi : 89
         * forecastAirUrl :
         * day : {"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371463.3431.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284459.5844.jpg","wp":"3-4级","type":2,"wd":"西南风","notice":"阴晴之间，谨防紫外线侵扰"}
         */

        private String date;
        private String sunrise;
        private int high;
        private String forecastUrl;
        private int low;
        private String sunset;
        private NightBeanX night;
        private int aqi;
        private String forecastAirUrl;
        private DayBeanX day;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public int getHigh() {
            return high;
        }

        public void setHigh(int high) {
            this.high = high;
        }

        public String getForecastUrl() {
            return forecastUrl;
        }

        public void setForecastUrl(String forecastUrl) {
            this.forecastUrl = forecastUrl;
        }

        public int getLow() {
            return low;
        }

        public void setLow(int low) {
            this.low = low;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public NightBeanX getNight() {
            return night;
        }

        public void setNight(NightBeanX night) {
            this.night = night;
        }

        public int getAqi() {
            return aqi;
        }

        public void setAqi(int aqi) {
            this.aqi = aqi;
        }

        public String getForecastAirUrl() {
            return forecastAirUrl;
        }

        public void setForecastAirUrl(String forecastAirUrl) {
            this.forecastAirUrl = forecastAirUrl;
        }

        public DayBeanX getDay() {
            return day;
        }

        public void setDay(DayBeanX day) {
            this.day = day;
        }

        public static class NightBeanX {
            /**
             * wthr : 晴
             * bgPic : http://static.etouch.cn/imgs/upload/1505371453.2293.jpg
             * smPic : http://static.etouch.cn/imgs/upload/1505215052.3458.jpg
             * wp : <3级
             * type : 1
             * wd : 南风
             * notice : 祝你有个晴朗的梦
             */

            private String wthr;
            private String bgPic;
            private String smPic;
            private String wp;
            private int type;
            private String wd;
            private String notice;

            public String getWthr() {
                return wthr;
            }

            public void setWthr(String wthr) {
                this.wthr = wthr;
            }

            public String getBgPic() {
                return bgPic;
            }

            public void setBgPic(String bgPic) {
                this.bgPic = bgPic;
            }

            public String getSmPic() {
                return smPic;
            }

            public void setSmPic(String smPic) {
                this.smPic = smPic;
            }

            public String getWp() {
                return wp;
            }

            public void setWp(String wp) {
                this.wp = wp;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getWd() {
                return wd;
            }

            public void setWd(String wd) {
                this.wd = wd;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        public static class DayBeanX {
            /**
             * wthr : 多云
             * bgPic : http://static.etouch.cn/imgs/upload/1505371463.3431.jpg
             * smPic : http://static.etouch.cn/imgs/upload/1505284459.5844.jpg
             * wp : 3-4级
             * type : 2
             * wd : 西南风
             * notice : 阴晴之间，谨防紫外线侵扰
             */

            private String wthr;
            private String bgPic;
            private String smPic;
            private String wp;
            private int type;
            private String wd;
            private String notice;

            public String getWthr() {
                return wthr;
            }

            public void setWthr(String wthr) {
                this.wthr = wthr;
            }

            public String getBgPic() {
                return bgPic;
            }

            public void setBgPic(String bgPic) {
                this.bgPic = bgPic;
            }

            public String getSmPic() {
                return smPic;
            }

            public void setSmPic(String smPic) {
                this.smPic = smPic;
            }

            public String getWp() {
                return wp;
            }

            public void setWp(String wp) {
                this.wp = wp;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getWd() {
                return wd;
            }

            public void setWd(String wd) {
                this.wd = wd;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }

    public static class ForecastBean {
        /**
         * date : 20180626
         * sunrise : 04:47
         * high : 36
         * low : 25
         * sunset : 19:47
         * night : {"wthr":"晴","bgPic":"http://static.etouch.cn/imgs/upload/1505371453.2293.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505215052.3458.jpg","wp":"<3级","type":1,"wd":"南风","notice":"祝你有个晴朗的梦"}
         * aqi : 89
         * day : {"wthr":"多云","bgPic":"http://static.etouch.cn/imgs/upload/1505371463.3431.jpg","smPic":"http://static.etouch.cn/imgs/upload/1505284459.5844.jpg","wp":"3-4级","type":2,"wd":"西南风","notice":"阴晴之间，谨防紫外线侵扰"}
         */

        private String date;
        private String sunrise;
        private int high;
        private int low;
        private String sunset;
        private NightBeanXX night;
        private int aqi;
        private DayBeanXX day;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public int getHigh() {
            return high;
        }

        public void setHigh(int high) {
            this.high = high;
        }

        public int getLow() {
            return low;
        }

        public void setLow(int low) {
            this.low = low;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public NightBeanXX getNight() {
            return night;
        }

        public void setNight(NightBeanXX night) {
            this.night = night;
        }

        public int getAqi() {
            return aqi;
        }

        public void setAqi(int aqi) {
            this.aqi = aqi;
        }

        public DayBeanXX getDay() {
            return day;
        }

        public void setDay(DayBeanXX day) {
            this.day = day;
        }

        public static class NightBeanXX {
            /**
             * wthr : 晴
             * bgPic : http://static.etouch.cn/imgs/upload/1505371453.2293.jpg
             * smPic : http://static.etouch.cn/imgs/upload/1505215052.3458.jpg
             * wp : <3级
             * type : 1
             * wd : 南风
             * notice : 祝你有个晴朗的梦
             */

            private String wthr;
            private String bgPic;
            private String smPic;
            private String wp;
            private int type;
            private String wd;
            private String notice;

            public String getWthr() {
                return wthr;
            }

            public void setWthr(String wthr) {
                this.wthr = wthr;
            }

            public String getBgPic() {
                return bgPic;
            }

            public void setBgPic(String bgPic) {
                this.bgPic = bgPic;
            }

            public String getSmPic() {
                return smPic;
            }

            public void setSmPic(String smPic) {
                this.smPic = smPic;
            }

            public String getWp() {
                return wp;
            }

            public void setWp(String wp) {
                this.wp = wp;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getWd() {
                return wd;
            }

            public void setWd(String wd) {
                this.wd = wd;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        public static class DayBeanXX {
            /**
             * wthr : 多云
             * bgPic : http://static.etouch.cn/imgs/upload/1505371463.3431.jpg
             * smPic : http://static.etouch.cn/imgs/upload/1505284459.5844.jpg
             * wp : 3-4级
             * type : 2
             * wd : 西南风
             * notice : 阴晴之间，谨防紫外线侵扰
             */

            private String wthr;
            private String bgPic;
            private String smPic;
            private String wp;
            private int type;
            private String wd;
            private String notice;

            public String getWthr() {
                return wthr;
            }

            public void setWthr(String wthr) {
                this.wthr = wthr;
            }

            public String getBgPic() {
                return bgPic;
            }

            public void setBgPic(String bgPic) {
                this.bgPic = bgPic;
            }

            public String getSmPic() {
                return smPic;
            }

            public void setSmPic(String smPic) {
                this.smPic = smPic;
            }

            public String getWp() {
                return wp;
            }

            public void setWp(String wp) {
                this.wp = wp;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getWd() {
                return wd;
            }

            public void setWd(String wd) {
                this.wd = wd;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }

    public static class HourfcBean {
        /**
         * wthr : 36
         * shidu : 23%
         * hourfcUrl :
         * wp : 6-7级
         * type_desc : 晴
         * time : 201806271800
         * type : 1
         * wd : 东北风
         */

        private int wthr;
        private String shidu;
        private String hourfcUrl;
        private String wp;
        private String type_desc;
        private String time;
        private int type;
        private String wd;

        public int getWthr() {
            return wthr;
        }

        public void setWthr(int wthr) {
            this.wthr = wthr;
        }

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public String getHourfcUrl() {
            return hourfcUrl;
        }

        public void setHourfcUrl(String hourfcUrl) {
            this.hourfcUrl = hourfcUrl;
        }

        public String getWp() {
            return wp;
        }

        public void setWp(String wp) {
            this.wp = wp;
        }

        public String getType_desc() {
            return type_desc;
        }

        public void setType_desc(String type_desc) {
            this.type_desc = type_desc;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getWd() {
            return wd;
        }

        public void setWd(String wd) {
            this.wd = wd;
        }
    }

    public static class XianhaoBean {
        /**
         * f_date : 20131202
         * f_number : 无
         * action_type : webview
         * item_id : 458184767
         * click_url : http://yun.rili.cn/tianqi/traffic.html?city=101010100
         * title : 限行
         */

        private String f_date;
        private String f_number;
        private String action_type;
        private String item_id;
        private String click_url;
        private String title;

        public String getF_date() {
            return f_date;
        }

        public void setF_date(String f_date) {
            this.f_date = f_date;
        }

        public String getF_number() {
            return f_number;
        }

        public void setF_number(String f_number) {
            this.f_number = f_number;
        }

        public String getAction_type() {
            return action_type;
        }

        public void setAction_type(String action_type) {
            this.action_type = action_type;
        }

        public String getItem_id() {
            return item_id;
        }

        public void setItem_id(String item_id) {
            this.item_id = item_id;
        }

        public String getClick_url() {
            return click_url;
        }

        public void setClick_url(String click_url) {
            this.click_url = click_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
