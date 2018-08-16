package com.perspicace.ai.deepbot.model;

/**
 * @program: deepbot
 * @description: 路况
 * @author: Destiny
 * @create: 2018-08-09 17:28
 **/
public class Slot4Transportation {
    private String startLocation;
    private String finalLocation;

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getFinalLocation() {
        return finalLocation;
    }

    public void setFinalLocation(String finalLocation) {
        this.finalLocation = finalLocation;
    }
}
