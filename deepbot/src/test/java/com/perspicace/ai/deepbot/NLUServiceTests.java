package com.perspicace.ai.deepbot;

import com.perspicace.ai.common.constant.Language;
import com.perspicace.ai.deepbot.domain.Person;
import com.perspicace.ai.deepbot.domain.SHD;
import com.perspicace.ai.deepbot.nlu.model.NLUResponseData;
import com.perspicace.ai.deepbot.nlu.service.impl.NLUServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: deepbot
 * @description: 测试语义解析服务
 * @author: Destiny
 * @create: 2018-06-28 19:42
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class NLUServiceTests {
    @Autowired
    private NLUServiceImpl nluService;

    @Test
    public void tset() throws Exception {
//        NLUInputData.UserBean.InfoBean userInfo = new NLUInputData.UserBean.InfoBean();
//        userInfo.setBirthDate("1997-01-01T00:00:00");
//        userInfo.setGender(1);
//        userInfo.setNickname("xxxx");
//
//        NLUInputData.UserBean user = new NLUInputData.UserBean();
//        user.setID("user");
//        user.setInfo(userInfo);
//
//
//        NLUInputData.DeviceBean.InfoBeanX.LocationBean.ContentBean locationContent = new NLUInputData.DeviceBean.InfoBeanX.LocationBean.ContentBean ();
//        locationContent.setLatitude(41.2222);
//        locationContent.setLongitude(135.2222);
//        locationContent.setAddress ( null );
//        locationContent.setCity ( null );
//        locationContent.setCountryCode ( null );
//        locationContent.setCounty ( null );
//        locationContent.setProvince ( null );
//        locationContent.setPostalCode ( null );
//
//        NLUInputData.DeviceBean.InfoBeanX.LocationBean location = new NLUInputData.DeviceBean.InfoBeanX.LocationBean();
//        location.setContent (locationContent);
//        location.setType(0);
//
//        NLUInputData.DeviceBean.InfoBeanX.OSBean deviceOS = new NLUInputData.DeviceBean.InfoBeanX.OSBean();
//        deviceOS.setName("xxxxxxxxxxxxx");
//        deviceOS.setVersion("1.1");
//
//        NLUInputData.DeviceBean.InfoBeanX deviceInfo = new NLUInputData.DeviceBean.InfoBeanX();
//        deviceInfo.setMake("xxxxxx");
//        deviceInfo.setModel("xxxxxxxxxxx");
//        deviceInfo.setTimeZone("GMT+08:00");
//        deviceInfo.setDeviceIP("123.1.1.1");
//        deviceInfo.setLocation(location);
//        deviceInfo.setOS(deviceOS);
//
//        NLUInputData.DeviceBean device = new NLUInputData.DeviceBean();
//        device.setInfo(deviceInfo);
//        device.setID("xxxxxxxxx");
//
//
//        NLUInputData InputDataBean = new NLUInputData ();
//        InputDataBean.setAppID("a");
//        InputDataBean.setAccessToken("a");
//
//        NLUInputData.MessageBean messageBean = new NLUInputData.MessageBean();
//        messageBean.setQuery ( "放一首动漫歌曲" );
//        InputDataBean.setMessage ( messageBean );
//        InputDataBean.setLanguage("zh-CN");
//        InputDataBean.setMarket("zh-CN");
//        InputDataBean.setMode(0);
//        InputDataBean.setUser(user);
//        InputDataBean.setDevice(device);
//
        Person person = new Person( );
        SHD shd = new SHD( );
        String question = "今天下午三点天气怎么样";

        NLUResponseData nluResponseData = nluService.getNLUInfo ( Language.zh_CN , question , person , shd );
        log.info ( "************************" + nluResponseData );

//        AzureNLUResponseData azureNLUResponseData = null;
//        String azureResponseJson = JsonObjectUtil.getInstance ( ).CreateJsonByBean ( azureNLUResponseData );
//        log.info ( azureResponseJson );
//        if("null".equals ( azureResponseJson ))
//        {
//            log.info ( "******" );
//        }
//        else {
//            log.error ( "1111" );
//        }
    }
}
