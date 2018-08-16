package com.perspicace.ai.common.constant;

/**
 * @Description: 存放ICE定义的家电操作接口
 * @Param:
 * @return:
 * @Author: Destiny
 * @Date: 2018/8/2
 */
public final class Actions {
    private Actions() {
    }

    public static final String OPEN="open";
    public static final String CLOSE="close";
    public static final String SET_MODE="setmode";

    public static final String OPERATE_IO = "io";
    public static final String OPERATE_MODE = "mode";
    public static final String OPERATE_FAN_SPEED = "fanSpeed";
    public static final String OPERATE_TEMPERATURE = "temperature";
    public static final String OPERATE_TV = "tvControl";

    public static final String OPERATE_VALUE_ON = "on";
    public static final String OPERATE_VALUE_OFF = "off";

    public static final String OPERATE_MODE_DRY = "dry";
    public static final String OPERATE_MODE_HEAT = "heat";
    public static final String OPERATE_MODE_COOL = "cool";
    public static final String OPERATE_MODE_WIND = "fan";

    // 风速  温度
    public static final String OPERATE_VALUE_LOW= "low";
    public static final String OPERATE_VALUE_MIDDLE= "middle";
    public static final String OPERATE_VALUE_HIGH= "high";

    // 声音
    public static final String OPERATE_VALUE_VOL_LOW= "volminus";
    public static final String OPERATE_VALUE_VOL_HIGH= "voladd";
    public static final String OPERATE_VALUE_VOL_MUTE= "mute";

    // 频道
    public static final String OPERATE_VALUE_CHANNEL_PREV= "chminus";
    public static final String OPERATE_VALUE_CHANNEL_NEXT= "chadd";
//    public static final String OPERATE_VALUE_TV = "io";
//    public static final String OPERATE_VALUE_TV = "mode";
//    public static final String OPERATE_VALUE_TV = "fanSpeed";
//    public static final String OPERATE_VALUE_TV = "temperature";
//    public static final String OPERATE_VALUE_TV = "tvControl";
}

