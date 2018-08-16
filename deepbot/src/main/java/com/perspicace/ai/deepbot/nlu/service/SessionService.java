package com.perspicace.ai.deepbot.nlu.service;

import com.perspicace.ai.deepbot.nlu.model.ContextData;

import java.util.List;

/**
 * @author energy
 * @version 1.0.0 创建时间：2017年6月14日
 * 说明 用户会话管理
 **/
public interface SessionService {
    /**
     * 保存上下文 (暂不使用)
     *
     * @param sessionId
     * @param context
     */
    void saveContext(String sessionId, ContextData context);

    /**
     * 获取上一个上下文
     *
     * @param sessionId
     * @return
     */
    ContextData getLastContext(String sessionId);

    /**
     * 检查重复和过期 设置后重新排序
     *
     * @param key
     * @param sessionData
     */
    void checkAndSaveContext(String key, ContextData sessionData, boolean clearExpire);

    /**
     * 获取上下文列表
     *
     * @param sessionId
     * @return
     */
    List<ContextData> getContextList(String sessionId);

    /**
     * 删除指定意图的上下文
     *
     * @param sessionId
     */
    void clearContextByIntent(String sessionId, String intent);
}
