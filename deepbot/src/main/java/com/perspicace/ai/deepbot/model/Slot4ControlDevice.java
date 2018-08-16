package com.perspicace.ai.deepbot.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: deepbot
 * @description: 控制家电的词槽
 * @author: Destiny
 * @create: 2018-07-10 17:26
 **/
public class Slot4ControlDevice {
    private String device;
    private String floor;
    private String homeRegion;
    private String operate;
    private String mode;
    private String operateValue;
    private String operateContent;
    private String _operate;
    private String _operateValue;       // 映射后的值
    private String _operateContent; // 映射后的值

    private List<String> deviceList = new ArrayList ( );
    private List<String> floorList = new ArrayList ( );
    private List<String> homeRegionList = new ArrayList ( );
    private List<String> operateList = new ArrayList ( );
    private List<String> modeList = new ArrayList ( );
    private List<String> operateValueList = new ArrayList ( );
    private List<String> operateContentList = new ArrayList ( );
    private List<String> _operateList = new ArrayList ( );
    private List<String> _operateValueList = new ArrayList ( );
    private List<String> _operateContentList = new ArrayList ( );

    public Slot4ControlDevice(String device , String floor , String homeRegion , String operate , String operateValue , String mode) {
        this.device = device;
        this.floor = floor;
        this.homeRegion = homeRegion;
        this.operate = operate;
        this.operateValue = operateValue;
        this.mode = mode;
    }

    public Slot4ControlDevice(String device , String floor , String homeRegion , String operate , String operateValue ,String operateContent, String mode) {
        this.device = device;
        this.floor = floor;
        this.homeRegion = homeRegion;
        this.operate = operate;
        this.operateValue = operateValue;
        this.operateContent = operateContent;
        this.mode = mode;
    }

    public Slot4ControlDevice(String device , String floor , String homeRegion , String operate ,String _operate, String operateValue ,String operateContent, String mode) {
        this.device = device;
        this.floor = floor;
        this.homeRegion = homeRegion;
        this.operate = operate;
        this.operateValue = operateValue;
        this.operateContent = operateContent;
        this.mode = mode;
    }

    public Slot4ControlDevice(String device , String homeRegion , String operate , String operateValue , String mode) {
        this.device = device;
        this.homeRegion = homeRegion;
        this.operate = operate;
        this.operateValue = operateValue;
        this.mode = mode;
    }

    public Slot4ControlDevice(String device , String operate) {
        this.device = device;
        this.operate = operate;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getHomeRegion() {
        return homeRegion;
    }

    public void setHomeRegion(String homeRegion) {
        this.homeRegion = homeRegion;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getOperateValue() {
        return operateValue;
    }

    public void setOperateValue(String operateValue) {
        this.operateValue = operateValue;
    }

    public String getOperateContent() {
        return operateContent;
    }

    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent;
    }

    public String get_operate() {
        return _operate;
    }

    public void set_operate(String _operate) {
        this._operate = _operate;
    }

    public String get_operateValue() {
        return _operateValue;
    }

    public void set_operateValue(String _operateValue) {
        this._operateValue = _operateValue;
    }

    public String get_operateContent() {
        return _operateContent;
    }

    public void set_operateContent(String _operateContent) {
        this._operateContent = _operateContent;
    }

    public List<String> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<String> deviceList) {
        this.deviceList = deviceList;
    }

    public List<String> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<String> floorList) {
        this.floorList = floorList;
    }

    public List<String> getHomeRegionList() {
        return homeRegionList;
    }

    public void setHomeRegionList(List<String> homeRegionList) {
        this.homeRegionList = homeRegionList;
    }

    public List<String> getOperateList() {
        return operateList;
    }

    public void setOperateList(List<String> operateList) {
        this.operateList = operateList;
    }

    public List<String> getModeList() {
        return modeList;
    }

    public void setModeList(List<String> modeList) {
        this.modeList = modeList;
    }

    public List<String> getOperateValueList() {
        return operateValueList;
    }

    public void setOperateValueList(List<String> operateValueList) {
        this.operateValueList = operateValueList;
    }

    public List<String> getOperateContentList() {
        return operateContentList;
    }

    public void setOperateContentList(List<String> operateContentList) {
        this.operateContentList = operateContentList;
    }

    public List<String> get_operateList() {
        return _operateList;
    }

    public void set_operateList(List<String> _operateList) {
        this._operateList = _operateList;
    }

    public List<String> get_operateValueList() {
        return _operateValueList;
    }

    public void set_operateValueList(List<String> _operateValueList) {
        this._operateValueList = _operateValueList;
    }

    public List<String> get_operateContentList() {
        return _operateContentList;
    }

    public void set_operateContentList(List<String> _operateContentList) {
        this._operateContentList = _operateContentList;
    }
}
