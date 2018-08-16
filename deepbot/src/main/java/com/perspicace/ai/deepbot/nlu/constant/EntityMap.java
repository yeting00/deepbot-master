package com.perspicace.ai.deepbot.nlu.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: deepbot
 * @description: 微软与百芝龙的映射表
 * @author: Destiny
 * @create: 2018-07-12 21:20
 **/
public final class EntityMap {
    private EntityMap() {
    }

    public final static Map<String, String> ENTITY_MAP = new HashMap<> ( );

    static {
        ENTITY_MAP.put ( Entity.CITY , Entity.LOCATION );
        ENTITY_MAP.put ( Entity.PERSPICACE_ELECTRICAL , Entity.DEVICE );
        ENTITY_MAP.put ( Entity.PERSPICACE_OPERATE_VALUE , Entity.OPERATE_VALUE );
        ENTITY_MAP.put ( Entity.PERSPICACE_CHANNEL , Entity.OPERATE_CONTENT );
        ENTITY_MAP.put ( Entity.LUIS_DATE_TIME , Entity.DATE );
        ENTITY_MAP.put ( Entity.TIME , Entity.DATE );
        ENTITY_MAP.put ( Entity.PERSPICACE_HOME_REGION , Entity.HOME_REGION );
        ENTITY_MAP.put ( Entity.PERSPICACE_HIGH_VALUE , Entity.HIGH_VALUE );
        ENTITY_MAP.put ( Entity.PERSPICACE_LOW_VALUE , Entity.LOW_VALUE );
        ENTITY_MAP.put ( Entity.PERSPICACE_VOL_MUTE_VALUE , Entity.VOL_MUTE_VALUE );
    }
}
