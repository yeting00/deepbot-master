package com.perspicace.ai.deepbot.service;

import com.perspicace.ai.deepbot.model.DeviceGroupData;
import com.perspicace.ai.deepbot.nlu.model.NLUResponseData;
import slice.BussinessServiceException;
import slice.ControlDeviceException;
import slice.ElectricGenJsonException;
import slice.NoAreaException;

import java.util.List;

// S 词槽 T查询第三方服务返回信息 B执行指令信息
public interface BusinessServices<S, T, B> {

    String handleService(final String groupId, final String smartDeviceId, final String deviceID, final String sessionID, String query, NLUResponseData.SemanticResultsBean.IntentsBean intentsBean);

    List<S> generateSlot4Service(final String sessionID, final String groupID, final String shdID, DeviceGroupData deviceGroupData, NLUResponseData.SemanticResultsBean.IntentsBean intentsBean) throws ControlDeviceException, ElectricGenJsonException, NoAreaException, ControlDeviceException, NoAreaException;

    T getServiceResults(final String groupID, final String smartDeviceId, S s, B b) throws ElectricGenJsonException, BussinessServiceException, ElectricGenJsonException, BussinessServiceException;

    String getNotifyString(final String groupId, final String smartDeviceId, final String sessionID, S slot4service);
}
