package com.perspicace.ai.deepbot.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.ArrayList;
import java.util.List;

@NodeEntity(label = "HomeDevice")
public class AirConditioner {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String enName;
    private String key;
    private String nick_name;
    private long sqlID;
    private String company;
    private String state;  //
    private String homeregion;
    private String mode;// 0----制冷    1---制热   2 除湿    3 送风
    private String devID;
    private List<Integer> list_value = new ArrayList<Integer> ( );
    private int maxTemValue = 16 ;   //最大温度值
    private int minTemValue = 30;   //最小温度值


    public void addListValue(int value) {
        list_value.add ( value );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getHomeregion() {
        return homeregion;
    }

    public void setHomeregion(String homeregion) {
        this.homeregion = homeregion;
    }

    public List<Integer> getList_value() {
        return list_value;
    }

    public void setList_value(List<Integer> list_value) {
        this.list_value = list_value;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }

    public int getMaxTemValue() {
        return maxTemValue;
    }

    public void setMaxTemValue(int maxTemValue) {
        this.maxTemValue = maxTemValue;
    }

    public int getMinTemValue() {
        return minTemValue;
    }

    public void setMinTemValue(int minTemValue) {
        this.minTemValue = minTemValue;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getSqlID() {
        return sqlID;
    }

    public void setSqlID(long sqlID) {
        this.sqlID = sqlID;
    }
}
