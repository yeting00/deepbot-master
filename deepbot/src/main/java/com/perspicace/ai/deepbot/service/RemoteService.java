package com.perspicace.ai.deepbot.service;

import com.alibaba.fastjson.JSONObject;
import com.perspicace.ai.deepbot.model.DeviceGroupData;
import slice.ElectricGenJsonException;


/**
 * @author energy
 * @version 1.0.0 创建时间：2017年12月19日
 * 说明
 **/
public interface RemoteService {
    /**
     * 调用客户端获取设备树
     *
     * @param groupID
     * @return
     */
    JSONObject getRemoteDeviceJson(final String groupID) throws ElectricGenJsonException;

    /**
     * 本地解析json文件（测试用）
     *
     * @param groupID
     * @return
     */
    JSONObject getTestDeviceJson(final String groupID);

    /**
     * 调用客户端获取设备树
     *
     * @param
     * @return
     */
    JSONObject getFamilyInfoJson(final String familyID);

    DeviceGroupData getDeviceGroupData(final String groupID) throws ElectricGenJsonException;

    DeviceGroupData getTestDeviceGroupData(final String groupID);
}
