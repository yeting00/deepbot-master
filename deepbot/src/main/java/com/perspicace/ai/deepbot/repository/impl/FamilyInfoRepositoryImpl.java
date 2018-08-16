package com.perspicace.ai.deepbot.repository.impl;

import com.alibaba.fastjson.JSONObject;
import com.perspicace.ai.deepbot.domain.Person;
import com.perspicace.ai.deepbot.model.DeviceGroupData;
import com.perspicace.ai.deepbot.neo4j.repository.FamilyRepository;
import com.perspicace.ai.deepbot.utils.Configure;
import com.perspicace.ai.deepbot.utils.IceInvoker;
import com.perspicace.ai.deepbot.utils.JsonObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import slice.BussinessServiceException;
import slice.ElectricGenJsonException;

/**
 * @program: deepbot
        * @description: 调用ICE，获取家庭设备信息、成员信息等
        * @author: Destiny
        * @create: 2018-07-02 15:51
        **/

@Repository
@Slf4j
public class FamilyInfoRepositoryImpl implements FamilyRepository<DeviceGroupData, Person> {
    @Override
    public DeviceGroupData getRemoteDeviceJson(String groupid) throws ElectricGenJsonException {
        try {
            long time1 = System.currentTimeMillis ( );
            String deviceJson = IceInvoker.getElectricApplianceGenJsonServicePrx ( ).ElectricApplianceBigJson ( groupid );
            long time2 = System.currentTimeMillis ( );
            log.info ( "cost==" + (time2 - time1) + "   deviceJson==" + deviceJson );
            JSONObject jobj=JSONObject.parseObject(deviceJson);

            DeviceGroupData deviceGroupData = JsonObjectUtil.getInstance( ).CreateBeanByJson ( deviceJson , DeviceGroupData.class );
            //包括code 说明 发生异常
            if (jobj.containsKey ( "code" )) {
                log.error ( jobj.getString ( "msg" ) );
                throw new ElectricGenJsonException ( Configure.getValue ( "error10020" ) );//获取家电列表失败
            }
            return deviceGroupData;

        } catch (BussinessServiceException | Ice.ConnectFailedException e) {
            e.printStackTrace ( );
            throw new ElectricGenJsonException ( Configure.getValue ( "error10020" ) );//获取家电列表失败
        }
    }

    @Override
    public JSONObject getTestDeviceJson(String groupid) {
        return null;
    }

    @Override
    public Person getPersonInfoJson(String groupid) {
        return null;
    }
}
