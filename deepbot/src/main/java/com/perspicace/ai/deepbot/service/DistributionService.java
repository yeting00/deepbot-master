package com.perspicace.ai.deepbot.service;


import com.perspicace.modules.AICall.AICall.SayObj;
import com.perspicace.modules.Perception.PerceptionTxt.ListionObj;
import com.perspicace.modules.Perception.PerceptionTxt.Source;

/**
 * @author energy
 * @version 1.0.0 创建时间：2017年12月18日
 * 说明
 **/
public interface DistributionService {
    /**
     * 通过墙机输入
     *
     * @param listionObj
     * @return
     */
    SayObj lisition(ListionObj listionObj);

    /**
     * 通过微信端输入
     *
     * @param text
     * @param userId
     * @param groupId
     * @param source
     * @return
     */
    String getPerceptionText(String text, String userId, String groupId, Source source);

}
