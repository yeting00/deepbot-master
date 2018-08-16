package com.perspicace.ai.deepbot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.perspicace.ai.deepbot.model.DeviceGroupData;
import com.perspicace.ai.deepbot.service.RemoteService;
import com.perspicace.ai.deepbot.utils.Configure;
import com.perspicace.ai.deepbot.utils.I18NUtil;
import com.perspicace.ai.deepbot.utils.IceInvoker;
import com.perspicace.ai.deepbot.utils.JsonObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import slice.BussinessServiceException;
import slice.ElectricGenJsonException;

import java.io.IOException;
import java.io.InputStream;


/**
 * @author energy
 * @version 1.0.0 创建时间：2017年12月20日
 * 说明
 **/
@Service("remoteService")
@Slf4j
public class RemoteServiceImpl implements RemoteService {

    @Override
    public JSONObject getRemoteDeviceJson(final String groupID) throws ElectricGenJsonException {
        try {
            long time1 = System.currentTimeMillis ( );
//            String deviceJson = ControlDeviceIceInvoke.getElectricApplianceGenJsonServicePrx ( ).ElectricApplianceBigJson ( groupID );
            String deviceJson = IceInvoker.getElectricApplianceGenJsonServicePrx().ElectricApplianceBigJson ( groupID );
            long time2 = System.currentTimeMillis ( );
            log.info ( "cost==" + (time2 - time1) + "   deviceJson==" + deviceJson );
            JSONObject jobj = JSONObject.parseObject ( deviceJson );
            //包括code 说明 发生异常
            if (jobj.containsKey ( "code" )) {
                log.error ( jobj.getString ( "msg" ) );
                throw new ElectricGenJsonException ( Configure.getValue ( "error10020" ) );//获取家电列表失败
            }
            return jobj;
        } catch (BussinessServiceException | Ice.ConnectFailedException e) {
            e.printStackTrace ( );
            throw new ElectricGenJsonException ( Configure.getValue ( "error10020" ) );//获取家电列表失败
        }
    }

    @Override
    public JSONObject getTestDeviceJson(final String groupID) {
        String filePath = "device.json";
        InputStream in = null;
        try {
            ClassLoader CL = Configure.class.getClassLoader ( );
            if (CL != null) {
                in = CL.getResourceAsStream ( filePath );
            } else {
                in = ClassLoader.getSystemResourceAsStream ( filePath );
            }
            int count = in.available ( );
            byte b[] = new byte[count];
            in.read ( b );
            String str = new String ( b , "UTF-8" );
            JSONObject jobj = JSONObject.parseObject ( str );
            return jobj;
        } catch (Exception e) {
            e.printStackTrace ( );
        } finally {
            if (in != null) {
                try {
                    in.close ( );
                } catch (IOException e) {
                    e.printStackTrace ( );
                }
            }
        }
        return null;
    }

    @Override
    public JSONObject getFamilyInfoJson(final String familyID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DeviceGroupData getDeviceGroupData(final String groupID) throws ElectricGenJsonException {
        try {
            long time1 = System.currentTimeMillis ( );
//            String deviceJson = ControlDeviceIceInvoke.getElectricApplianceGenJsonServicePrx ( ).ElectricApplianceBigJson ( groupID );
            String deviceJson = IceInvoker.getElectricApplianceGenJsonServicePrx().ElectricApplianceBigJson ( groupID );

            long time2 = System.currentTimeMillis ( );
            log.info ( "cost==" + (time2 - time1) );
            DeviceGroupData deviceGroupData = JsonObjectUtil.getInstance ( ).CreateBeanByJson ( deviceJson , DeviceGroupData.class );
            //包括code 说明 发生异常
            if (deviceGroupData.getCode ( ) != null) {
                log.error ( deviceGroupData.getMsg ( ) );
                throw new ElectricGenJsonException ( I18NUtil.getMessage ( "devicecontrol_remoteservice_failue" ));//获取家电列表失败
            }
            return deviceGroupData;
        } catch (BussinessServiceException | Ice.ConnectFailedException e) {
            e.printStackTrace ( );
            throw new ElectricGenJsonException (  I18NUtil.getMessage ( "devicecontrol_remoteservice_failue" ) );//获取家电列表失败
        } catch (Exception e) {
            log.error ( e.toString ( ) );
            throw new ElectricGenJsonException (  I18NUtil.getMessage ( "devicecontrol_remoteservice_failue" ) );//获取家电列表失败
        }
    }

    @Override
    public DeviceGroupData getTestDeviceGroupData(final String groupID) {
        String filePath = "device.json";
        InputStream in = null;
        try {
            ClassLoader CL = Configure.class.getClassLoader ( );
            if (CL != null) {
                in = CL.getResourceAsStream ( filePath );
            } else {
                in = ClassLoader.getSystemResourceAsStream ( filePath );
            }
            int count = in.available ( );
            byte b[] = new byte[count];
            in.read ( b );
            String str = new String ( b , "UTF-8" );
            DeviceGroupData deviceGroupData = JsonObjectUtil.getInstance ( ).CreateBeanByJson ( str , DeviceGroupData.class );
            //包括code 说明 发生异常
            if (deviceGroupData.getCode ( ) != null) {
                log.error ( deviceGroupData.getMsg ( ) );
                throw new ElectricGenJsonException (  I18NUtil.getMessage ( "devicecontrol_remoteservice_failue" ));//获取家电列表失败
            }
            return deviceGroupData;
        } catch (Exception e) {
            e.printStackTrace ( );
            log.error ( e.toString ( ) );
        } finally {
            if (in != null) {
                try {
                    in.close ( );
                } catch (IOException e) {
                    e.printStackTrace ( );
                    log.error ( e.toString ( ) );
                }
            }
        }
        return null;
    }
}
