package com.perspicace.ai.deepbot.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "HomeDevice")
public class Light {
    @Id
    @GeneratedValue
    private Long id;
    private long sqlID;
    private String name;
    private String enName;
    private String key;
    private String nick_name;
    private String company;
    private String homeregion;
    private int state;  //0 -- 关    1----开      2----暖色光    3---冷色光
    private String devID;
    private long ID;

    public Light() {
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getHomeregion() {
        return homeregion;
    }

    public void setHomeregion(String homeregion) {
        this.homeregion = homeregion;
    }

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
}
