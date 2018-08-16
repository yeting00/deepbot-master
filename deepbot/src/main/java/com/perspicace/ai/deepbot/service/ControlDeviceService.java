package com.perspicace.ai.deepbot.service;

import com.perspicace.gen.electricappliance.slice.ElectricApplianceControlParam;
import com.perspicace.gen.electricappliance.slice.ElectricApplianceControlResult;
import slice.ControlDeviceException;
import slice.ElectricGenJsonException;
import slice.NoAreaException;

import java.util.Map;


/**
 * @author energy
 * @version 1.0.0 创建时间：2017年12月26日
 * 说明
 **/
public interface ControlDeviceService {
    /**
     * 生成执行家电控制的指令组
     *
     * @param
     * @param smartDeviceId
     * @param groupid
     * @return
     * @throws
     * @throws ElectricGenJsonException
     */
    ElectricApplianceControlParam[] generateCommandObj(Map<String, String> eneityMap, String suggest, String smartDeviceId, String groupid) throws ControlDeviceException, ElectricGenJsonException, NoAreaException;

    /**
     * 根据当前操作获取回复消息
     *
     * @param electrical
     * @param operatevalue
     * @return
     */
    String getResponseString(String electrical, String operate, String operatevalue);

    /**
     * 控制家电 远程调用
     *
     * @param groupId
     * @param electricApplianceControlParam 控制指令列表
     * @return
     */
    ElectricApplianceControlResult[] controlElectric(String groupId, ElectricApplianceControlParam[] electricApplianceControlParam);

    /**
     * @param eneityMap
     * @param intent
     * @param smartDeviceId
     * @param groupId
     * @return
     */
    String controlDevice(String text, String domain, Map<String, String> eneityMap, String intent, String smartDeviceId, String groupId) throws NoAreaException;

    /**
     * 情景模式
     *
     * @param groupId
     * @param sceneMode
     * @return
     * @throws ElectricGenJsonException
     * @throws
     */
    String runScene(String text, String groupId, String sceneMode, String _sn, String _deviceid);
}
