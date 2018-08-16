package com.perspicace.ai.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 家电类
 * @Param:
 * @return:
 * @Author: Destiny
 * @Date: 2018/6/28
 */
public final class Electrical {
    public final static String TELEVISION = "television";//电视

    public final static String AIRCONDITION = "aircondition";//空调

    public final static String CENTRAL_AIRCONDITION = "central_aircondition";//中央空调

    public final static String FLOOR_HEATING = "floorHeating";//地暖

    public final static String VENTILATION = "ventilation";//新风

    public final static String LAMP = "lamp";//灯

    public final static String CURTAIN = "curtains";//窗帘


    //家电的中文对照
    public final static Map<String, String> DEVICE_MAP = new HashMap<String, String> ( );

    static {
        DEVICE_MAP.put ( Electrical.TELEVISION , "电视" );
        DEVICE_MAP.put ( Electrical.AIRCONDITION , "空调" );
        DEVICE_MAP.put ( Electrical.CENTRAL_AIRCONDITION , "中央空调" );
        DEVICE_MAP.put ( Electrical.FLOOR_HEATING , "地暖" );
        DEVICE_MAP.put ( Electrical.VENTILATION , "新风" );
        DEVICE_MAP.put ( Electrical.LAMP , "灯" );
        DEVICE_MAP.put ( Electrical.CURTAIN , "窗帘" );
    }
}
