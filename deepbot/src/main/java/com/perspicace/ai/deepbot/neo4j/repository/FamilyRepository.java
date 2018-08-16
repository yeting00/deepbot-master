package com.perspicace.ai.deepbot.neo4j.repository;

import com.alibaba.fastjson.JSONObject;
import slice.ElectricGenJsonException;

public interface FamilyRepository<D,P> {
    /**
     * 调用客户端获取设备树
     * @param groupid
     * @return
     */
     D  getRemoteDeviceJson(String groupid) throws ElectricGenJsonException;
    /**
     * 本地解析json文件（测试用）
     * @param groupid
     * @return
     */
    public JSONObject getTestDeviceJson(String groupid);

    /**
     * 调用客户端获取家庭成员信息
     * @param
     * @return
     */
    P  getPersonInfoJson(String groupid);
}
