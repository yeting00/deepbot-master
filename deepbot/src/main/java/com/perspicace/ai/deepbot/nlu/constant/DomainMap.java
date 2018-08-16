package com.perspicace.ai.deepbot.nlu.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: deepbot
 * @description:
 * @author: Destiny
 * @create: 2018-07-11 00:49
 **/
public final class DomainMap {
    private DomainMap() {

    }
    //家电的中文对照
    public final static Map<String, String> domainMap = new HashMap<String, String> ( );

    static {
        domainMap.put ( Domain.PERSPICACE_ALARM , Domain.ALARM );
        domainMap.put ( Domain.PERSPICACE_SCENE_MODE  , Domain.SCENE_MODE );
        domainMap.put ( Domain.PERSPICACE_CALCULATE , Domain.CALCULATE );
        domainMap.put ( Domain.PERSPICACE_CONTROL_DEVICE , Domain.CONTROL_DEVICE );
        domainMap.put ( Domain.PERSPICACE_QUERY_WEATHER, Domain.WEATHER );
        domainMap.put ( Domain.PERSPICACE_QUERY_DATE , Domain.CALENDAR );
        domainMap.put ( Domain.PERSPICACE_RADIO , Domain.RADIO );
        domainMap.put ( Domain.PERSPICACE_SHARES , Domain.STOCK );
//        domainMap.put ( Domain.PERSPICACE_CHAT , Domain.CHAT )
        domainMap.put ( Domain.PERSPICACE_CHAT , Domain.JOKE );
        domainMap.put ( Domain.PERSPICACE_NONE , Domain.NONE );
        domainMap.put ( Domain.PERSPICACE_TRANSPORATION , Domain.TRANSPORATION );

    }
}
