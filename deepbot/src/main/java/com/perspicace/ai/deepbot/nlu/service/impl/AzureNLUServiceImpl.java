package com.perspicace.ai.deepbot.nlu.service.impl;

import com.perspicace.ai.deepbot.common.constant.Constant;
import com.perspicace.ai.deepbot.common.constant.HeaderType;
import com.perspicace.ai.deepbot.common.constant.Language;
import com.perspicace.ai.deepbot.common.exception.CustomerException;
import com.perspicace.ai.deepbot.config.MicrosoftProperties;
import com.perspicace.ai.deepbot.domain.Person;
import com.perspicace.ai.deepbot.domain.SHD;
import com.perspicace.ai.deepbot.nlu.model.AzureNLUResponseData;
import com.perspicace.ai.deepbot.nlu.model.NLUInputData;
import com.perspicace.ai.deepbot.nlu.model.NLUResponseData;
import com.perspicace.ai.deepbot.nlu.service.NLUService;
import com.perspicace.ai.deepbot.utils.HttpClientUtil;
import com.perspicace.ai.deepbot.utils.JsonObjectUtil;
import com.perspicace.ai.deepbot.utils.OToMoreMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: deepbot
 * @description: 微软语义解析用户意图分析
 * @author: Destiny
 * @create: 2018-06-27 17:45
 **/
@Service("AzureNLUService")
@Slf4j
public class AzureNLUServiceImpl implements NLUService<NLUInputData, AzureNLUResponseData> {
    @Autowired
    private MicrosoftProperties microsoftProperties;

    @Override
    public NLUInputData generateInputBean(String query , Person person , SHD shd) {
        NLUInputData.UserBean user = new NLUInputData.UserBean ( );
        user.setBirthDate ( person.getBirthday ( ) );
        user.setGender ( person.getGender ( ) );
        user.setNickname ( person.getNickName ( ) );
        user.setID ( person.getUserID ( ) );

        NLUInputData.DeviceBean.LocationBean.ContentBean locationContent = new NLUInputData.DeviceBean.LocationBean.ContentBean ( );
        locationContent.setLatitude ( shd.getLatitude ( ) );
        locationContent.setLongitude ( shd.getLongitude ( ) );
        locationContent.setAddress ( shd.getAddress ( ) );
        locationContent.setCity ( shd.getCity ( ) );
        locationContent.setCountryCode ( shd.getCountryCode ( ) );
        locationContent.setCounty ( shd.getCounty ( ) );
        locationContent.setProvince ( shd.getProvince ( ) );
        locationContent.setPostalCode ( shd.getPostalCode ( ) );

        NLUInputData.DeviceBean.LocationBean location = new NLUInputData.DeviceBean.LocationBean ( );
        location.setContent ( locationContent );
        location.setType ( shd.getType ( ) );

        NLUInputData.DeviceBean.OSBean deviceOS = new NLUInputData.DeviceBean.OSBean ( );
        deviceOS.setName ( shd.getOsName ( ) );
        deviceOS.setVersion ( shd.getVersion ( ) );

        NLUInputData.DeviceBean device = new NLUInputData.DeviceBean ( );
        device.setID ( shd.getDevID ( ) );
        device.setGroupId ( shd.getGroupId ( ) );
        device.setMake ( shd.getMake ( ) );
        device.setModel ( shd.getModel ( ) );
        device.setDeviceIP ( shd.getDeviceIP ( ) );
        device.setTimeZone ( shd.getTimeZone ( ) );
        device.setLocation ( location );
        device.setOS ( deviceOS );

        NLUInputData.MessageBean messageBean = new NLUInputData.MessageBean ( );
        messageBean.setQuery ( query );

        NLUInputData InputDataBean = new NLUInputData( );
        InputDataBean.setAppID ( microsoftProperties.getNluAppID ( ) );
        InputDataBean.setAccessToken ( microsoftProperties.getNluAccessToken ( ) );
        InputDataBean.setMessage ( messageBean );
        InputDataBean.setLanguage ( "zh-CN" );
        InputDataBean.setMarket ( "zh-CN" );
        InputDataBean.setMode ( 0 );
        InputDataBean.setUser ( user );
        InputDataBean.setDevice ( device );

        return InputDataBean;
    }

    @Override
    public AzureNLUResponseData getNLUInfo(Language language, String query , Person user , SHD shd) {
        NLUInputData inputData = generateInputBean ( query , user , shd );
        String queryJson = JsonObjectUtil.getInstance ( ).CreateJsonByBean ( inputData );
        log.info ( "输入json为--------->" + queryJson );

        //从缓存中获取分析结果（待完成）
        try {
            String resultJson = HttpClientUtil.getInstance ( ).sendHttpPost ( microsoftProperties.getNluUrl ( ) , queryJson , HeaderType.AZURE_HEADER );
            log.info ( resultJson );
            AzureNLUResponseData azureNLUResponseData = JsonObjectUtil.getInstance ( ).CreateBeanByJson ( resultJson , AzureNLUResponseData.class );
            int code = azureNLUResponseData.getResponseInfo ( ).getCode ( );
            if (200 != code) {
                String message = (String) azureNLUResponseData.getResponseInfo ( ).getError ( );
                log.error ( "调用微软语义解析结果失败---->" + message );
                throw new CustomerException ( Constant.error100004 , message );
            }
            log.info ( "调用微软语义解析结果成功---->" + resultJson );
            return azureNLUResponseData;
        } catch (CustomerException e) {
            log.error ( e.getMessage ( ) , e );
        } catch (Exception e) {
            e.printStackTrace ( );
            log.error ( e.getMessage ( ) , e );
        }
        return null;
    }

    @Override
    public AzureNLUResponseData getNLUInfoFromCache(String query) {
        return null;
    }

    @Override
    public void saveNLUInfo2Cache(String query , AzureNLUResponseData inputBean) {

    }

    @Override
    public void saveNLUSlot2Cache(String sessionId , Map<String, Object> slotmMap , long time) {

    }

    @Override
    public OToMoreMap<String, String> getSlot4Service(NLUResponseData.SemanticResultsBean.IntentsBean intentsBean , List<String> slot4serviceList) {
        return null;
    }

    @Override
    public String getMode2Intent(String intent , String mode) {
        return null;
    }

}
