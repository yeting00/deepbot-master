package com.perspicace.ai.deepbot.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "Sensor")
public class Wifi {
    @Id
    @GeneratedValue
    private Long id;
    private long sqlID;
    private String name;
    private String enName;
    private String key;
    private String nick_name;
    private String company;
    private int isNobody;  //0 -- 有人    1----无人
    private int isFall;  //0 -- 未摔倒    1---- 摔倒
    private Long devID;

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

    public int getIsNobody() {
        return isNobody;
    }

    public void setIsNobody(int isNobody) {
        this.isNobody = isNobody;
    }

    public int getIsFall() {
        return isFall;
    }

    public void setIsFall(int isFall) {
        this.isFall = isFall;
    }

    public Long getDevID() {
        return devID;
    }

    public void setDevID(Long devID) {
        this.devID = devID;
    }
}
