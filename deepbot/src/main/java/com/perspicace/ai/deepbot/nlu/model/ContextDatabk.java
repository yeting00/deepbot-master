package com.perspicace.ai.deepbot.nlu.model;

import java.io.Serializable;
import java.util.Map;

/**
 * @author energy
 * @version 1.0.0 创建时间：2017年6月12日
 * 说明
 * 上下文对象 描述了一个意图和该意图需要的实体列表
 * 项宝宝放到common项目中的
 **/
public class ContextDatabk implements Serializable {

    private String query;//文本
    private String domain;
    private String intent;//意图
    private Map<String, String> contextEntityMap;
    private long time;//当前时间 时间戳 单位秒
    private boolean needContext;//是否需要上下文
    private String needEntityType;//需要的上下文实体类型

    public ContextDatabk() {

    }

    public ContextDatabk(String _query , String intent , Map<String, String> _contextEntityMap) {
        this.query = _query;
        this.intent = intent;
        this.contextEntityMap = _contextEntityMap;
    }

    public ContextDatabk(String _query , String intent , Map<String, String> _contextEntityMap , long time) {
        this.query = _query;
        this.intent = intent;
        this.contextEntityMap = _contextEntityMap;
        this.time = time;
    }

    public Map<String, String> getContextEntityMap() {
        return contextEntityMap;
    }

    public void setContextEntityMap(Map<String, String> contextEntityMap) {
        this.contextEntityMap = contextEntityMap;
    }

    public String getText() {
        return query;
    }

    public void setText(String query) {
        this.query = query;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isNeedContext() {
        return needContext;
    }

    public void setNeedContext(boolean needContext) {
        this.needContext = needContext;
    }

    public String getNeedEntityType() {
        return needEntityType;
    }

    public void setNeedEntityType(String needEntityType) {
        this.needEntityType = needEntityType;
    }
}
