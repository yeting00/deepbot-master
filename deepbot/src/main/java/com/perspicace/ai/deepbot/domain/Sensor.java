package com.perspicace.ai.deepbot.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.ArrayList;
import java.util.List;


@NodeEntity(label = "Sensor")
public class Sensor {
    @Id
    @GeneratedValue
    private Long id;
    private long sqlID;
    private String name;
    private String enName;
    private String key;
    private String nick_name;

    private String value;
    private String company;
    private List<Float> list_value = new ArrayList<Float>();
    private String devID;

    public Sensor() {
    }

    public void addListValue(Float value)
    {
        list_value.add(value);
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Float> getList_value() {
        return list_value;
    }

    public void setList_value(List<Float> list_value) {
        this.list_value = list_value;
    }

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }
}
