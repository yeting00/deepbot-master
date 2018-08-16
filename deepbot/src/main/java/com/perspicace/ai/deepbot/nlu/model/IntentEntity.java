package com.perspicace.ai.deepbot.nlu.model;

import com.perspicace.ai.deepbot.utils.OToMoreMap;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author energy
 * @version 1.0.0
 **/
public class IntentEntity implements Serializable {
    private String query;
    private String domain;
    private String intent;
    private List<Map<String, String>> entityList;
    private Map<String, String> entityMap;
    private OToMoreMap<String, String> slotMap ;

    public IntentEntity() {
    }

    public IntentEntity(String domain , String intent) {
        this.domain = domain;
        this.intent = intent;
    }

    public IntentEntity(String query , String domain , String intent) {
        this.query = query;
        this.domain = domain;
        this.intent = intent;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<Map<String, String>> getEntityList() {
        return entityList;
    }

    public Map<String, String> getEntityMap() {
        return entityMap;
    }

    public void setEntityMap(Map<String, String> map) {
        entityMap = map;
    }

    public void addEntity(String key , String value) {
        if (entityMap == null) {
            entityMap = new HashMap<> ( );
        }
        entityMap.put ( key , value );

        if (slotMap == null) {
            slotMap = new OToMoreMap<> ( );
        }
        slotMap.put ( key,value );


    }

//    public OToMoreMap<String, String> getSlotMap() {
//        return slotMap;
//    }
//
//    public void setSlotMap(OToMoreMap<String, String> slotMap) {
//        this.slotMap = slotMap;
//    }

    public void setEntityList(List<Map<String, String>> entityList) {
        this.entityList = entityList;
    }

    @Override
    public String toString() {
        return "IntentEntity [domain=" + domain + ", intent=" + intent + ", entityList=" + entityList + ", entityMap="
                + entityMap + "]";
    }

}
