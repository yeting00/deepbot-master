package com.perspicace.ai.deepbot.domain;

import com.perspicace.ai.deepbot.model.DeviceGroupData;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: deepbot
 * @description: 家电类
 * @author: Destiny
 * @create: 2018-08-08 12:23
 **/
@NodeEntity
public class HomeDevice {
    @Id
    @GeneratedValue
    private Long ID;
    private String id;
    private String floor;
    private String homeregion;
    private String key;
    private String company;
    private String name;
    private String enName;
    private String nick_name;
    private String state;  //
    private DeviceGroupData.FloorBean.AreaBean.DeviceBean.ExpandBean expand;

    public HomeDevice() {

    }

    public HomeDevice(String id , String floor , String homeregion , String key , String name , String enName , String state , DeviceGroupData.FloorBean.AreaBean.DeviceBean.ExpandBean expand) {
        this.id = id;
        this.floor = floor;
        this.homeregion = homeregion;
        this.key = key;
        this.name = name;
        this.enName = enName;
        this.state = state;
        this.expand = expand;
    }

    private List<Integer> list_value = new ArrayList<Integer> ( );

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getHomeregion() {
        return homeregion;
    }

    public void setHomeregion(String homeregion) {
        this.homeregion = homeregion;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public DeviceGroupData.FloorBean.AreaBean.DeviceBean.ExpandBean getExpand() {
        return expand;
    }

    public void setExpand(DeviceGroupData.FloorBean.AreaBean.DeviceBean.ExpandBean expand) {
        this.expand = expand;
    }

    public List<Integer> getList_value() {
        return list_value;
    }

    public void setList_value(List<Integer> list_value) {
        this.list_value = list_value;
    }
}
