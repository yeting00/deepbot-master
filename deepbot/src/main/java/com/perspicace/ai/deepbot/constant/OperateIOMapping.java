package com.perspicace.ai.deepbot.constant;

import com.perspicace.ai.common.constant.Actions;
import com.perspicace.ai.deepbot.nlu.constant.Entity;
import com.perspicace.ai.deepbot.nlu.constant.Intent;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: deepbot
 * @description: 将预测意图和映射成第三方家电操作接口包括操作方式和操作值
 * @author: Destiny
 * @create: 2018-08-02 19:17
 **/
public final class OperateIOMapping {
    private OperateIOMapping() {
    }

    // 操作映射表
    public final static Map<String, String> OPERATE_IO_MAPPING = new HashMap<String, String> ( );

    static {
        OPERATE_IO_MAPPING.put ( Intent.PERSPICACE_ON_OFF , Actions.OPERATE_IO );
        OPERATE_IO_MAPPING.put ( Intent.TURN_ON_DEVICE , Actions.OPERATE_IO );
        OPERATE_IO_MAPPING.put ( Intent.TURN_OFF_DEVICE , Actions.OPERATE_IO );

        OPERATE_IO_MAPPING.put ( Intent.SET_MODE , Actions.OPERATE_MODE );
        OPERATE_IO_MAPPING.put ( Intent.SET_MODE_WIND , Actions.OPERATE_MODE );
        OPERATE_IO_MAPPING.put ( Intent.SET_MODE_COOL , Actions.OPERATE_MODE );
        OPERATE_IO_MAPPING.put ( Intent.SET_MODE_DRY , Actions.OPERATE_MODE );
        OPERATE_IO_MAPPING.put ( Intent.SET_MODE_HEAT , Actions.OPERATE_MODE );

        OPERATE_IO_MAPPING.put ( Intent.SET_WIND_SPEED , Actions.OPERATE_FAN_SPEED );
        OPERATE_IO_MAPPING.put ( Intent.SET_MODE_TEMPERATURE , Actions.OPERATE_TEMPERATURE );

        OPERATE_IO_MAPPING.put ( Intent.SET_MODE_VOLUME , Actions.OPERATE_TV );
        OPERATE_IO_MAPPING.put ( Intent.SET_MODE_CHANNEL , Actions.OPERATE_TV );
        OPERATE_IO_MAPPING.put ( Intent.SET_MODE_TV , Actions.OPERATE_TV );
        OPERATE_IO_MAPPING.put ( Intent.SET_MODE_HDMI , Actions.OPERATE_TV );
    }

    public final static Map<String, String> OPERATE_VALUE_IO_MAPPING = new HashMap<String, String> ( );

    static {
        OPERATE_VALUE_IO_MAPPING.put ( Entity.HIGH_VALUE , Actions.OPERATE_VALUE_HIGH );
        OPERATE_VALUE_IO_MAPPING.put ( Entity.LOW_VALUE , Actions.OPERATE_VALUE_LOW );
        OPERATE_VALUE_IO_MAPPING.put ( Entity.MIDDLE_VALUE , Actions.OPERATE_VALUE_MIDDLE );

        OPERATE_VALUE_IO_MAPPING.put ( Entity.TV_CHANNEL_NEXT , Actions.OPERATE_VALUE_CHANNEL_NEXT );
        OPERATE_VALUE_IO_MAPPING.put ( Entity.TV_CHANNEL_PREV , Actions.OPERATE_VALUE_CHANNEL_PREV );

        OPERATE_VALUE_IO_MAPPING.put ( Intent.SET_MODE_VOLUME + Entity.VOL_MIDDLE_VALUE , Actions.OPERATE_VALUE_MIDDLE );
        OPERATE_VALUE_IO_MAPPING.put ( Intent.SET_MODE_VOLUME + Entity.VOL_MUTE_VALUE , Actions.OPERATE_VALUE_VOL_MUTE );
        OPERATE_VALUE_IO_MAPPING.put ( Intent.SET_MODE_VOLUME + Entity.VOL_HIGH_VALUE , Actions.OPERATE_VALUE_VOL_HIGH );
        OPERATE_VALUE_IO_MAPPING.put ( Intent.SET_MODE_VOLUME + Entity.VOL_LOW_VALUE , Actions.OPERATE_VALUE_VOL_LOW );

        OPERATE_VALUE_IO_MAPPING.put ( Intent.TURN_ON_DEVICE , Actions.OPERATE_VALUE_ON );
        OPERATE_VALUE_IO_MAPPING.put ( Intent.TURN_OFF_DEVICE , Actions.OPERATE_VALUE_OFF );

        OPERATE_VALUE_IO_MAPPING.put ( Intent.SET_MODE_WIND , Actions.OPERATE_MODE_WIND );
        OPERATE_VALUE_IO_MAPPING.put ( Intent.SET_MODE_COOL , Actions.OPERATE_MODE_COOL );
        OPERATE_VALUE_IO_MAPPING.put ( Intent.SET_MODE_DRY , Actions.OPERATE_MODE_DRY );
        OPERATE_VALUE_IO_MAPPING.put ( Intent.SET_MODE_HEAT , Actions.OPERATE_MODE_HEAT );
    }

//    public final static Map<String, String> OPERATE_CONTENT_IO_MAPPING = new HashMap<String, String> ( );
//    static {
//        OPERATE_CONTENT_IO_MAPPING.put ( "" , "bedroom" );
//    }
}
