package com.perspicace.ai.deepbot.model;

import java.io.Serializable;

/**
 * @program: deepbot
 * @description: 定义天气包含的slot
 * @author: Destiny
 * @create: 2018-07-03 20:47
 **/
public class Slot4Weather implements Serializable {
    private String date;
    private String location;
    private String weatherCondition;
    private String time;


    public Slot4Weather() {
    }

    public Slot4Weather(String date , String location) {
        this.date = date;
        this.location = location;
    }


    public Slot4Weather(String date , String location , String weatherCondition) {
        this.date = date;
        this.location = location;
        this.weatherCondition = weatherCondition;
    }

    public Slot4Weather(String date , String time , String location , String weatherCondition) {
        this.date = date;
        this.location = location;
        this.weatherCondition = weatherCondition;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

}
