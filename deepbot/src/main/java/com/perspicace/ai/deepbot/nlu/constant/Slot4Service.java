package com.perspicace.ai.deepbot.nlu.constant;

import com.perspicace.ai.common.constant.Electrical;

import java.util.*;

/** 
* @Description: 用于根据上下文补充完善意图 
* @Param:  
* @return:  
* @Author: Destiny
* @Date: 2018/7/24 
*/ 
public final class Slot4Service {
    private Slot4Service() {
    }
    public static final String TYPE = "Type";
    public static final String TEXT = "Text";
    public static final String NORMALIZED_TEXT = "NormalizedText";
    public static final String IMPLICIT = "Implicit";

    public static final List<String> WEATHER_SLOT_LiST = new ArrayList<> (Arrays.asList(Entity.LOCATION, Entity.DATE, Entity.TIME, Entity.WEATHER_CONDITION));
    public static final List<String> DEVICE_CONTROL_SLOT_LiST = new ArrayList<> (Arrays.asList(Entity.HOME_REGION, Entity.DEVICE, Entity.OPERATE_MODE, Entity.OPERATE_CONTENT, Entity.OPERATE_VALUE));
    /**
     * 需要补齐的意图实体
     */
    public static final Map<String, Map<String, String>> FILL_INTENT_MAP = new HashMap<String, Map<String, String>> ( );

    static {
        Map<String, String> queryWeatherEntityMap = new HashMap<String, String> ( );
        queryWeatherEntityMap.put ( Entity.LOCATION , "1" );
        queryWeatherEntityMap.put ( Entity.DATE , "1" );
        queryWeatherEntityMap.put ( Entity.WEATHER_CONDITION , "1" );

        Map<String, String> controlDeviceEntityMap = new HashMap<String, String> ( );
        controlDeviceEntityMap.put ( Entity.DEVICE , "1" );
        controlDeviceEntityMap.put( Entity.OPERATE, "1");
        controlDeviceEntityMap.put(Entity.HOME_REGION, "1");
//        controlDeviceEntityMap.put(Entity.LOCATION, "1");
        controlDeviceEntityMap.put(Entity.OPERATE_MODE, "1");
        controlDeviceEntityMap.put(Entity.OPERATE_VALUE,"1");

//        Map<String, String> queryHealthEntityMap = new HashMap<String, String> ( );
//        queryHealthEntityMap.put ( ENTITY.家庭成员.toString ( ) , "1" );
//        queryHealthEntityMap.put ( ENTITY.生理指标.toString ( ) , "1" );
//        queryHealthEntityMap.put ( ENTITY.日期.toString ( ) , "1" );
//
//
//        Map<String, String> shoppingEntityMap = new HashMap<String, String> ( );
//        shoppingEntityMap.put ( ENTITY.否定词.toString ( ) , "1" );
//        shoppingEntityMap.put ( ENTITY.肯定词.toString ( ) , "1" );
//        shoppingEntityMap.put ( ENTITY.更换商品.toString ( ) , "1" );
//        shoppingEntityMap.put ( ENTITY.商品类型.toString ( ) , "1" );
//        shoppingEntityMap.put ( ENTITY.外卖标签.toString ( ) , "1" );

        //打车
//        Map<String, String> transportationEntityMap = new HashMap<String, String> ( );
//        transportationEntityMap.put ( ENTITY.否定词.toString ( ) , "1" );
//        transportationEntityMap.put ( ENTITY.肯定词.toString ( ) , "1" );
//
//        //Horoscope 星座
//        Map<String, String> horoscopeEntityMap = new HashMap<String, String> ( );
//        horoscopeEntityMap.put ( ENTITY.time.toString ( ) , "1" );



//        FILL_INTENT_MAP.put ( Domain.PERSPICACE_QUERY_HEALTHY , queryHealthEntityMap );
//        FILL_INTENT_MAP.put ( Domain.PERSPICACE_SHOPPING , shoppingEntityMap );
//        FILL_INTENT_MAP.put ( Domain.PERSPICACE_TRANSPORATION , transportationEntityMap );
//        FILL_INTENT_MAP.put ( Domain.PERSPICACE_HOROSCOPE , horoscopeEntityMap );
        FILL_INTENT_MAP.put ( Domain.WEATHER , queryWeatherEntityMap );
        FILL_INTENT_MAP.put ( Domain.CONTROL_DEVICE , controlDeviceEntityMap );

    }

    /**
     * 流程意图中需要的实体词
     */
    /**
     * public static final Map<String,Map<String,String>> tempMap=new HashMap<String,Map<String,String>>();
     * static{
     * Map<String,String> leavemessageEntityMap=new HashMap<String,String>();
     * leavemessageEntityMap.put(ENTITY.家庭成员.toString(), "1");
     * leavemessageEntityMap.put(ENTITY.肯定词.toString(), "1");
     * leavemessageEntityMap.put(ENTITY.否定词.toString(), "1");
     * leavemessageEntityMap.put(ENTITY.操作方式.toString(), "1");
     * <p>
     * Map<String,String> alarmRemindEntityMap=new HashMap<String,String>();
     * alarmRemindEntityMap.put(ENTITY.日期.toString(), "1");
     * alarmRemindEntityMap.put(ENTITY.time.toString(), "1");
     * alarmRemindEntityMap.put(ENTITY.肯定词.toString(), "1");
     * alarmRemindEntityMap.put(ENTITY.否定词.toString(), "1");
     * leavemessageEntityMap.put(ENTITY.操作方式.toString(), "1");
     * <p>
     * Map<String,String> expressDeliveryEntityMap=new HashMap<String,String>();
     * expressDeliveryEntityMap.put(ENTITY.快递公司.toString(), "1");
     * expressDeliveryEntityMap.put(ENTITY.number.toString(), "1");
     * <p>
     * //打车
     * Map<String,String> transportationTaxiEntityMap=new HashMap<String,String>();
     * transportationTaxiEntityMap.put(ENTITY.文本.toString(), "1");
     * transportationTaxiEntityMap.put(ENTITY.address.toString(), "1");
     * <p>
     * //查询健康
     * Map<String,String> queryHealthEntityMap=new HashMap<String,String>();
     * queryHealthEntityMap.put(ENTITY.家庭成员.toString(), "1");
     * queryHealthEntityMap.put(ENTITY.生理指标.toString(), "1");
     * <p>
     * tempMap.put(EntityConstant.leavemessage, leavemessageEntityMap);
     * tempMap.put(EntityConstant.schedule, alarmRemindEntityMap);
     * tempMap.put(EntityConstant.express_delivery, expressDeliveryEntityMap);
     * tempMap.put(EntityConstant.transportationTaxi, transportationTaxiEntityMap);
     * tempMap.put(EntityConstant.queryHealth, queryHealthEntityMap);
     * }
     **/
    //属性和实体对应
    //温度对应空调  声音对应电视
    public static final Map<String, String> ACTION_DEVICE_MAPPING = new HashMap<String, String> ( );
    static {
        ACTION_DEVICE_MAPPING.put ( Intent.SET_MODE_VOLUME , Electrical.TELEVISION );//设置音量-电视
        ACTION_DEVICE_MAPPING.put ( Intent.SET_MODE_CHANNEL , Electrical.TELEVISION );//设置频道-电视
        ACTION_DEVICE_MAPPING.put ( Intent.SET_MODE_TEMPERATURE , Electrical.AIRCONDITION + "|" + Electrical.FLOOR_HEATING );//设置温度-空调
        ACTION_DEVICE_MAPPING.put ( Intent.SET_MODE_COOL , Electrical.AIRCONDITION );//设置模式-空调
        ACTION_DEVICE_MAPPING.put ( Intent.SET_MODE_DRY , Electrical.AIRCONDITION );//设置模式-空调
        ACTION_DEVICE_MAPPING.put ( Intent.SET_MODE_HEAT , Electrical.AIRCONDITION );//设置模式-空调
        ACTION_DEVICE_MAPPING.put ( Intent.SET_MODE_WIND , Electrical.VENTILATION );//设置模式-空调
    }
}
