package com.perspicace.ai.deepbot.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.ArrayList;
import java.util.List;

@NodeEntity(label = "HomeDevice")
public class Television{
    @Id
    @GeneratedValue
    private Long id;
    private long sqlID;
    private String name;
    private String enName;
    private String key;
    private String nick_name;
    private String company;
    private String state;  //0 -- 关    1----开
    private String homeregion;
    private int volume;
    private List<Integer> list_volume = new ArrayList<Integer>();
    private List<String> list_channel = new ArrayList<String>();
    private String devID;
    private int minVolValue;
    private int maxVolValue;


    public void addVolume(int vol)
    {
        list_volume.add(vol);
    }

    public void addChannel(String channel)
    {
        list_channel.add(channel);
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public List<Integer> getList_volume() {
        return list_volume;
    }

    public void setList_volume(List<Integer> list_volume) {
        this.list_volume = list_volume;
    }

    public List<String> getList_channel() {
        return list_channel;
    }

    public void setList_channel(List<String> list_channel) {
        this.list_channel = list_channel;
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

    public int getMinVolValue() {
        return minVolValue;
    }

    public void setMinVolValue(int minVolValue) {
        this.minVolValue = minVolValue;
    }

    public int getMaxVolValue() {
        return maxVolValue;
    }

    public void setMaxVolValue(int maxVolValue) {
        this.maxVolValue = maxVolValue;
    }
}
