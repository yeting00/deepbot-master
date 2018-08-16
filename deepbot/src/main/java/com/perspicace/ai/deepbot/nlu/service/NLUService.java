package com.perspicace.ai.deepbot.nlu.service;

import com.perspicace.ai.common.constant.Language;
import com.perspicace.ai.common.exception.CustomerException;
import com.perspicace.ai.deepbot.domain.Person;
import com.perspicace.ai.deepbot.domain.SHD;
import com.perspicace.ai.deepbot.nlu.model.NLUResponseData;
import com.perspicace.ai.deepbot.utils.OToMoreMap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: 参照EntityService
 * @Param:
 * @return:
 * @Author: Destiny
 * @Date: 2018/7/9
 */

@Service
public interface NLUService<I, R> {
    /**
     * @Description: 生成获取语义解析结果的输入数据
     * @Param:
     * @return:
     * @Author: Destiny
     * @Date: 2018/7/9
     */
    I generateInputBean(String query, Person person, SHD shd);

    /**
     * @Description: 获取语义信息
     * @Param:
     * @return:
     * @Author: Destiny
     * @Date: 2018/7/9
     */

    R getNLUInfo(Language language, String query, Person user, SHD shd) throws CustomerException;

    /**
     * @Description: 从缓存中获取语义文本信息
     * @Param:
     * @return:
     * @Author: Destiny
     * @Date: 2018/7/9
     */
    R getNLUInfoFromCache(String query);

    /**
     * @Description: 保存语义解析信息到文本
     * @Param:
     * @return:
     * @Author: Destiny
     * @Date: 2018/7/9
     */
    void saveNLUInfo2Cache(String query, R nluRes);

    /**
     * @Description: 保存词槽信息
     * @Param:
     * @return:
     * @Author: Destiny
     * @Date: 2018/7/12
     */
    void saveNLUSlot2Cache(String sessionId, Map<String, Object> slotmMap, long time);


    /**
     * @Description: 解析词槽信息
     * @Param:
     * @return:
     * @Author: Destiny
     * @Date: 2018/7/22
     */
    OToMoreMap<String, String> getSlot4Service(NLUResponseData.SemanticResultsBean.IntentsBean intentsBean, final List<String> slot4serviceList);


    String getMode2Intent(String intent, String mode);
}
