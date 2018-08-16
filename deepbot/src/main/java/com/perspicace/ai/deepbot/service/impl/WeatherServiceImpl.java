package com.perspicace.ai.deepbot.service.impl;

import com.perspicace.ai.deepbot.common.exception.CustomerException;
import com.perspicace.ai.deepbot.config.PerspicaceProperties;
import com.perspicace.ai.deepbot.model.DeviceGroupData;
import com.perspicace.ai.deepbot.model.Slot4Weather;
import com.perspicace.ai.deepbot.model.WeatherData;
import com.perspicace.ai.deepbot.nlu.constant.Entity;
import com.perspicace.ai.deepbot.nlu.constant.Slot4Service;
import com.perspicace.ai.deepbot.nlu.model.NLUResponseData;
import com.perspicace.ai.deepbot.nlu.service.NLUService;
import com.perspicace.ai.deepbot.repository.CommonRedisDao;
import com.perspicace.ai.deepbot.repository.RedisRepository;
import com.perspicace.ai.deepbot.service.BusinessServices;
import com.perspicace.ai.deepbot.utils.DateUtil;
import com.perspicace.ai.deepbot.utils.HttpClientUtil;
import com.perspicace.ai.deepbot.utils.JsonObjectUtil;
import com.perspicace.ai.deepbot.utils.OToMoreMap;
import com.perspicace.gen.electricappliance.slice.ElectricApplianceControlParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.*;

/**
 * @program: deepbot
 * @description: 从第三方获取天气数据
 * @author: Destiny
 * @create: 2018-06-27 18:10
 **/
@Service("WeatherService")
@Slf4j
public class WeatherServiceImpl implements BusinessServices<Slot4Weather, WeatherData,ElectricApplianceControlParam[]> {
    @Autowired
    private CommonRedisDao commonRedisDao;
    @Autowired
    private RedisRepository redisRepository;
    @Autowired
    private NLUService nluService;
    @Autowired
    private PerspicaceProperties perspicaceProperties;

    private static final Map<String, Integer> WEATHER_INFO_MAP = new HashMap<> ( );
    static {
        WEATHER_INFO_MAP.put ( "晨练指数" , 0 );
        WEATHER_INFO_MAP.put ( "穿衣指数" , 1 );      //穿衣指数
        WEATHER_INFO_MAP.put ( "舒适度" , 2 );
        WEATHER_INFO_MAP.put ( "感冒" , 3 );
        WEATHER_INFO_MAP.put ( "紫外线指数" , 4 );
        WEATHER_INFO_MAP.put ( "出行指数" , 5 );      // 旅行
        WEATHER_INFO_MAP.put ( "洗车指数" , 6 );  // 洗车
        WEATHER_INFO_MAP.put ( "晾晒" , 7 );
        WEATHER_INFO_MAP.put ( "钓鱼指数" , 8 );      //钓鱼
        WEATHER_INFO_MAP.put ( "化妆" , 9 );
        WEATHER_INFO_MAP.put ( "运动指数" , 10 );
        WEATHER_INFO_MAP.put ( "雨" , 11 );
        WEATHER_INFO_MAP.put ( "约会" , 12 );
    }

    @Override
    public WeatherData getServiceResults(final String groupID , final String shdSn , Slot4Weather slot4Weather,ElectricApplianceControlParam[] controlParams ) {
        try {
            WeatherData weatherData;
            String weatherInfo;
            if (commonRedisDao.containsValueKey ( slot4Weather.getLocation ( ) )) {
                weatherInfo = commonRedisDao.getValue ( slot4Weather.getLocation ( ) );
                weatherData = JsonObjectUtil.getInstance ( ).CreateBeanByJson ( weatherInfo , WeatherData.class );
                log.info ( "从缓存中获取天气信息成功" );
            } else {
                weatherInfo = HttpClientUtil.getInstance ( ).sendHttpGet ( MessageFormat.format ( perspicaceProperties.getWeatherUrl ( ) , slot4Weather.getDate ( ) , slot4Weather.getLocation ( ) ) );
                weatherData = JsonObjectUtil.getInstance ( ).CreateBeanByJson ( weatherInfo , WeatherData.class );
                // 缓存数据信息
                commonRedisDao.cacheValue ( slot4Weather.getLocation ( ) , weatherInfo , 30 * 60 );
            }
            return weatherData;
        } catch (CustomerException e) {
            log.error ( e.getMessage ( ) );
        }
        return null;
    }

    // 产生各个业务slot的list
    @Override
    public List<Slot4Weather> generateSlot4Service(final String sessionID , final String groupId , final String shdID , DeviceGroupData deviceGroupData , NLUResponseData.SemanticResultsBean.IntentsBean intentsBean) {
        List<Slot4Weather> slot4WeatherList = new ArrayList<> ( );
        String location;
        String weatherCondition;
        String dateStr;
        String timeStr;
        List<String> slotDateList = new ArrayList<> ( );
        List<String> slotTimeList = new ArrayList<> ( );
        List<String> slotWeatherConditionList = new ArrayList<> ( );
        List<String> slotLocationList = new ArrayList<> ( );

        OToMoreMap<String, String> slotOToMoreMap = nluService.getSlot4Service ( intentsBean , Slot4Service.WEATHER_SLOT_LiST );
        if (slotOToMoreMap != null) {
            long size = slotOToMoreMap.getSize ( );
            for (int i = 0; i < size; i++) {
                Map<String, List<String>> stringListMap = slotOToMoreMap.get ( i );
                if (stringListMap.containsKey ( Entity.DATE )) {
                    slotDateList = stringListMap.get ( Entity.DATE );
                }
                if (stringListMap.containsKey ( Entity.TIME )) {
                    slotTimeList = stringListMap.get ( Entity.TIME );
                }
                if (stringListMap.containsKey ( Entity.WEATHER_CONDITION )) {
                    slotWeatherConditionList = stringListMap.get ( Entity.WEATHER_CONDITION );
                }
                if (stringListMap.containsKey ( Entity.LOCATION )) {
                    slotLocationList = stringListMap.get ( Entity.LOCATION );
                }
            }
        }
        log.info ( "日期列表为----->" + slotDateList );
        log.info ( "时间列表为----->" + slotTimeList );
        log.info ( "天气条件列表为----->" + slotWeatherConditionList );
        log.info ( "城市列表为----->" + slotLocationList );
        int maxIndex = Math.max ( slotLocationList.size ( ) , Math.max ( slotDateList.size ( ) , slotWeatherConditionList.size ( ) ) );
        for (int i = 0; i < maxIndex; i++) {
            Map<Object, Object> slotMap = redisRepository.hmget ( sessionID );

            //先输入,防止list越界
            slotDateList.add ( null );
            slotTimeList.add ( null );
            slotLocationList.add ( null );
            slotWeatherConditionList.add ( null );

            dateStr = slotDateList.get ( i );
            timeStr = slotTimeList.get ( i );
            location = slotLocationList.get ( i );
            weatherCondition = slotWeatherConditionList.get ( i );
            if (StringUtils.isNotEmpty ( dateStr )) {
                String[] timeSplit = dateStr.split ( "T" );
                dateStr = timeSplit[0];
                if (timeSplit.length > 1) {
                    timeStr = timeSplit[1];
                }
            }

            if (StringUtils.isEmpty ( dateStr )) {
                if (slotMap.containsKey ( Entity.DATE )) {
                    dateStr = (String) slotMap.get ( Entity.DATE );
                    log.info ( "缓存中补充日期" + dateStr );
                } else {
                    Date date = new Date ( );
                    dateStr = DateUtil.parseDateToStr ( date , DateUtil.DATE_FORMAT_YYYY_MM_DD , date );
                    log.info ( "采用默认日期" + dateStr );
                }
            }
            if (dateStr != null) {
                Map<String, String> slot4dateStr = new HashMap<> ( );
                slot4dateStr.put ( Entity.DATE , dateStr );
                nluService.saveNLUSlot2Cache ( sessionID , slot4dateStr , 2 * 60 );
            }

            if (StringUtils.isEmpty ( location )) {
                if (slotMap.containsKey ( Entity.LOCATION )) {
                    location = (String) slotMap.get ( Entity.LOCATION );
                    log.info ( "缓存中补充地点" + location );
                } else {
                    location = "上海";
                    log.info ( "采用默认地址补充" + location );
                }
            }
            if (location != null) {
                Map<String, String> slot4location = new HashMap<> ( );
                slot4location.put ( Entity.LOCATION , location );
                nluService.saveNLUSlot2Cache ( sessionID , slot4location , 2 * 60 );
            }

            if (StringUtils.isEmpty ( weatherCondition )) {
                if (slotMap.containsKey ( Entity.WEATHER_CONDITION )) {
                    weatherCondition = (String) slotMap.get ( Entity.WEATHER_CONDITION );
                    log.info ( "缓存中补充天气条件" + weatherCondition );
                } else {
                    weatherCondition = Entity.WEATHER;
                    log.info ( "采用默认天气条件,查询天气" + Entity.WEATHER );
                }
            }
            if (weatherCondition != null) {
                Map<String, Object> slot4weatherCondition = new HashMap<> ( );
                slot4weatherCondition.put ( Entity.WEATHER_CONDITION , weatherCondition );
                nluService.saveNLUSlot2Cache ( sessionID , slot4weatherCondition , 2 * 60 );
            }

            Slot4Weather slot4Weather = new Slot4Weather ( dateStr , timeStr , location , weatherCondition );
            slot4WeatherList.add ( slot4Weather );
        }
        return slot4WeatherList;
    }


    @Override
    public String handleService(final String groupId , final String shdSn , final String shdID,final String sessionID , String query , NLUResponseData.SemanticResultsBean.IntentsBean intentsBean) {
        String resText;
        StringBuffer resStringBuffer = new StringBuffer ( );

        try {
            String intent = intentsBean.getIntent ( );
            List<Slot4Weather> slot4WeatherList = generateSlot4Service ( sessionID , groupId , shdSn , null , intentsBean );
            int slotSize = slot4WeatherList.size ( );
            for (int i = 0; i < slotSize; i++) {
                Slot4Weather slot4Weather = slot4WeatherList.get ( i );
                WeatherData weatherData = getServiceResults ( groupId , shdSn , slot4Weather,null );
                String dateStr = slot4Weather.getDate ( );
                Date date = DateUtil.parseStrToDate ( dateStr , DateUtil.DATE_FORMAT_YYYY_MM_DD );
                // 取得周几
                String week = DateUtil.getDayWeekOfDate1 ( date );
                if (week == null) {
                    week = dateStr;
                }
                String location = slot4Weather.getLocation ( );
                String time = slot4Weather.getTime ( );
                log.info ( "location--->" + location );
                log.info ( "date------->" + date );
                String weatherCondtion = slot4Weather.getWeatherCondition ( );
                if (WEATHER_INFO_MAP.containsKey ( intent )) {
                    log.info ( weatherData.getIndexes ( ).get ( WEATHER_INFO_MAP.get ( intent ) ).getName ( ) );// 获得问题  比如今天适合锻炼吗？
                    log.info ( weatherData.getIndexes ( ).get ( WEATHER_INFO_MAP.get ( intent ) ).getValueV2 ( ) );//简单描述是否适合做什么
                    log.info ( weatherData.getIndexes ( ).get ( WEATHER_INFO_MAP.get ( intent ) ).getDesc ( ) );//详细描述是否适合做什么
                    log.info ( "询问内容为--------》" + query );
                    log.info ( "回复内容为————————————》" + weatherData.getIndexes ( ).get ( WEATHER_INFO_MAP.get ( intent ) ).getDesc ( ) );
                    return weatherData.getIndexes ( ).get ( WEATHER_INFO_MAP.get ( intent ) ).getDesc ( );
                } else {
                    String envQuality = weatherData.getEvn ( ).getQuality ( );// 天气质量
                    String envSuggest = weatherData.getEvn ( ).getSuggest ( ); // 极少数敏感人群应该减少户外活动

                    WeatherData.ForecastBean forecastBean = weatherData.getForecast ( ).get ( 0 );
                    log.info ( "今天白天的天气建议为：" + forecastBean.getDay ( ).getNotice ( ) );   // 获得白天的回复建议
                    log.info ( "今天白天天气情况为：" + forecastBean.getDay ( ).getWthr ( ) );      // 获得白天的天气    晴还是雨还是阴天
                    log.info ( "今天最高温度：" + forecastBean.getHigh ( ) );       // 最高温度
                    log.info ( "今天最低温度：" + forecastBean.getLow ( ) );
                    log.info ( "今天日出时间：" + forecastBean.getSunrise ( ) );
                    log.info ( "今天日落时间：" + forecastBean.getSunset ( ) );
                    log.info ( "今天夜晚的天气建议为：" + forecastBean.getNight ( ).getNotice ( ) );   // 获得白天的回复建议
                    log.info ( "今天夜晚天气情况为：" + forecastBean.getNight ( ).getWthr ( ) );      // 获得白天的天气    晴还是雨还是阴天
                    log.info ( "当前的天气情况为：" + weatherData.getObserve ( ).getWthr ( ) );   // 获得白天的回复建议
                    log.info ( "回复内容为————————————》" + MessageFormat.format ( "今天{0}白天{1},夜间{2},最高气温{3},最低气温{4}" , location , forecastBean.getDay ( ).getWthr ( ) , forecastBean.getNight ( ).getWthr ( ) , forecastBean.getHigh ( ) , forecastBean.getLow ( ) ) );
                    String res = MessageFormat.format ( "{0}{1}白天{2},夜间{3},最高温度{4},最低温度{5}" , week , location , forecastBean.getDay ( ).getWthr ( ) , forecastBean.getNight ( ).getWthr ( ) , forecastBean.getHigh ( ) , forecastBean.getLow ( ) );
                    resStringBuffer.append ( "\n" + res );
                }
            }
            resText = resStringBuffer.toString ( );
        } catch (Exception e) {
            log.error ( e.toString ( ) );
            resText = "出了点故障，待会再问我天气试试吧！";
        }
        return resText;
    }

    @Override
    public String getNotifyString(String groupId , String smartDeviceId , String sessionID , Slot4Weather slot4Weather) {
        return null;
    }


}
