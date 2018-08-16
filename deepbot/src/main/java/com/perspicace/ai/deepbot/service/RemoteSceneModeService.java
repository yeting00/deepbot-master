package com.perspicace.ai.deepbot.service;

import com.alibaba.fastjson.JSONObject;
import com.perspicace.ai.deepbot.model.DeviceGroupData;
import slice.ElectricGenJsonException;
import slice.SceneModelException;


public interface RemoteSceneModeService {
    /**
     * 匹配场景 找到场景id
     *
     * @param groupID
     * @param sceneMode
     * @return
     * @throws
     * @throws
     */
    String getSceneModeID(final String groupID, String sceneMode) throws ElectricGenJsonException, SceneModelException;

    /**
     * 获取场景对象
     *
     * @param groupID
     * @param sceneMode
     * @return
     * @throws ElectricGenJsonException
     * @throws SceneModelException
     */
    JSONObject getSceneObj(final String groupID, String sceneMode) throws ElectricGenJsonException, SceneModelException;


    /**
     * 获取该SHD对应的场景对象
     *
     * @param groupID
     * @param deviceID  设备的ID数据库中的
     * @param sceneMode
     * @return
     * @throws ElectricGenJsonException
     * @throws SceneModelException
     */
    DeviceGroupData.SceneModelsBean getSceneModeBean(final String groupID, final String deviceID, String sceneMode) throws ElectricGenJsonException, SceneModelException;
}
