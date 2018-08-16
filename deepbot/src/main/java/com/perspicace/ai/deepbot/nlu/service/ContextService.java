package com.perspicace.ai.deepbot.nlu.service;

import com.perspicace.ai.deepbot.nlu.model.NLUResponseData;


/** 
* @Description: 根据上下文补充相关信息
* @Param:
* @return:
* @Author: Destiny 
* @Date: 2018/7/25 
*/ 
public interface ContextService {
    /**
     * 根据上下文补充意图
     *
     * @return
     */
    boolean fillIntentWithContext(String sessionId, NLUResponseData.SemanticResultsBean.IntentsBean intentsBean);

    /**
     * @param sessionId
     * @param
     * @return
     */
    boolean checkControlDeviceContext(String sessionId, NLUResponseData.SemanticResultsBean.IntentsBean intentsBean);

    /**
     * 通过建议和上下文补齐家电对象
     *
     * @return
     */
    String getElectricalBySuggest(String sessionId, String suggest);
}
