package com.perspicace.ai.deepbot.nlu.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: deepbot
 * @description: 进行意图的映射
 * @author: Destiny
 * @create: 2018-07-11 11:49
 **/
public final class IntentMap {
    private IntentMap() {
    }


    public final static Map<String, String> INTENT_MAP = new HashMap<String, String> ( );

    static {
        INTENT_MAP.put ( Intent.PERSPICACE_GO_HOME_MODE , Intent.GO_HOME_MODE );
        INTENT_MAP.put ( Intent.PERSPICACE_LEAVE_HOME_MODE , Intent.LEAVE_HOME_MODE );
        INTENT_MAP.put ( Intent.PERSPICACE_GET_UP_MODE , Intent.GET_UP_MODE );
        INTENT_MAP.put ( Intent.PERSPICACE_SLEEP_MODE , Intent.SLEEP_MODE );
        INTENT_MAP.put ( Intent.PERSPICACE_DINNER_PARTY_MODE , Intent.DINNER_PARTY_MODE );
        INTENT_MAP.put ( Intent.PERSPICACE_FILM_MODE , Intent.FILM_MODE );
        INTENT_MAP.put ( Intent.PERSPICACE_ALL_OPEN_MODE , Intent.ALL_OPEN_MODE );
        INTENT_MAP.put ( Intent.PERSPICACE_ALL_CLOSE_MODE , Intent.ALL_CLOSE_MODE );


        INTENT_MAP.put ( Intent.PERSPICACE_SET_MODE , Intent.SET_MODE );
        INTENT_MAP.put ( Intent.PERSPICACE_SET_WIND_SPEED , Intent.SET_WIND_SPEED );
        INTENT_MAP.put ( Intent.PERSPICACE_SET_CHANNEL , Intent.SET_MODE_CHANNEL );
        INTENT_MAP.put ( Intent.PERSPICACE_SET_FENG_SPEED , Intent.SET_WIND_SPEED );
        INTENT_MAP.put ( Intent.PERSPICACE_SET_TEMPERATURE , Intent.SET_MODE_TEMPERATURE );
        INTENT_MAP.put ( Intent.PERSPICACE_SET_VOLUME , Intent.SET_MODE_VOLUME );

        INTENT_MAP.put ( Intent.PERSPICACE_WEATHER , Intent.CHECK_WEATHER );
        INTENT_MAP.put ( Intent.PERSPICACE_WASHING , Intent.QUESTION_WEATHER );

        INTENT_MAP.put ( Intent.PERSPICACE_NONE , Intent.NONE );

    }

    public final static Map<String, String> MODE_INTENT_MAP = new HashMap<String, String> ( );

    static {
        MODE_INTENT_MAP.put ( Entity.WIND_SPPEED , Intent.SET_WIND_SPEED );
    }
}
