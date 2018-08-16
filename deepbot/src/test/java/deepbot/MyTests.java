package deepbot;

import com.alibaba.fastjson.JSON;
import com.perspicace.ai.common.constant.HeaderType;
import com.perspicace.ai.deepbot.config.MicrosoftProperties;
import com.perspicace.ai.deepbot.config.PerspicaceProperties;
import com.perspicace.ai.deepbot.domain.Person;
import com.perspicace.ai.deepbot.domain.SHD;
import com.perspicace.ai.deepbot.nlu.model.NLUInputData;
import com.perspicace.ai.deepbot.nlu.service.impl.AzureNLUServiceImpl;
import com.perspicace.ai.deepbot.nlu.service.impl.PerspicaceNLUServiceImpl;
import com.perspicace.ai.deepbot.utils.HttpClientUtil;
import com.perspicace.ai.deepbot.utils.JsonObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MyTests {
    @Autowired
    private PerspicaceProperties perspicaceProperties;

    @Autowired
    private AzureNLUServiceImpl azureNLUService;

    @Autowired
    private MicrosoftProperties microsoftProperties;

    @Autowired
    private PerspicaceNLUServiceImpl perspicaceNLUService;

    @Test
    public void tset() throws Exception {

        String query = "打开客厅和卧室的空调";
        Map values = new HashMap ();
        values.put("text", query);
        String postjson = JSON.toJSONString(values);

        NLUInputData.UserBean user = new NLUInputData.UserBean();
        user.setBirthDate("1997-01-01T00:00:00");
        user.setGender(1);
        user.setNickname("xxxx");

        user.setID("user");


        NLUInputData.DeviceBean.LocationBean.ContentBean locationContent = new NLUInputData.DeviceBean.LocationBean.ContentBean ();
        locationContent.setLatitude(41.2222);
        locationContent.setLongitude(135.2222);
        locationContent.setAddress ( null );
        locationContent.setCity ( null );
        locationContent.setCountryCode ( null );
        locationContent.setCounty ( null );
        locationContent.setProvince ( null );
        locationContent.setPostalCode ( null );

        NLUInputData.DeviceBean.LocationBean location = new NLUInputData.DeviceBean.LocationBean();
        location.setContent (locationContent);
        location.setType(0);

        NLUInputData.DeviceBean.OSBean deviceOS = new NLUInputData.DeviceBean.OSBean();
        deviceOS.setName("xxxxxxxxxxxxx");
        deviceOS.setVersion("1.1");

        NLUInputData.DeviceBean device = new NLUInputData.DeviceBean();
        device.setMake("xxxxxx");
        device.setModel("xxxxxxxxxxx");
        device.setTimeZone("GMT+08:00");
        device.setDeviceIP("123.1.1.1");
        device.setLocation(location);
        device.setOS(deviceOS);
        device.setLocation (location);
        device.setID("xxxxxxxxx");


        NLUInputData InputDataBean = new NLUInputData();
        InputDataBean.setAppID("a");
        InputDataBean.setAccessToken("a");

        NLUInputData.MessageBean messageBean = new NLUInputData.MessageBean();
        messageBean.setQuery ( "放一首动漫歌曲" );
        InputDataBean.setMessage ( messageBean );
        InputDataBean.setLanguage("zh-CN");
        InputDataBean.setMarket("zh-CN");
        InputDataBean.setMode(0);
        InputDataBean.setUser(user);
        InputDataBean.setDevice(device);

        Person person = new Person(  );
        SHD shd = new SHD(  );

//      根据bean创建json 请求数据
        String requestJson = JsonObjectUtil.getInstance().CreateJsonByBean(InputDataBean);
        System.out.println(requestJson);

//      创建bean  根据请求数据
        NLUInputData obj = JsonObjectUtil.getInstance().CreateBeanByJson(requestJson, NLUInputData.class);
        System.out.println(obj);
        System.out.println(obj.getUser().getBirthDate());

        String result = HttpClientUtil.getInstance().sendHttpPost(microsoftProperties.getNluUrl(), requestJson, HeaderType.AZURE_HEADER);
        System.out.println(result);


//        String perspicace_result = HttpClientUtil.getInstance().sendHttpPost(perspicaceProperties.getNluUrl(), postjson, HeaderType.PERSPICACE_HEADER);
//        log.info("111111111111111111111111");
//        System.out.println(perspicace_result);
//
//        AzureNLUResponseData azureNLUResponseData = azureNLUService.getNLUInfo(query,person,shd);
//        log.info("************************");
//        String azureJson = JsonObjectUtil.getInstance().CreateJsonByBean(azureNLUResponseData);
//        System.out.println(azureJson);
//        NLUResponseData nluBean = JsonObjectUtil.getInstance().CreateBeanByJson(azureJson, NLUResponseData.class);
//        System.out.println(nluBean.getSematicResults ().get(0).getIntents ().get(0).getSlots ().get(0).getEntityKey ());
//
//        PerspicaceNLUResponseData perspicaceNLUResponseData = perspicaceNLUService.getNLUInfo (query,null,null);
//        log.info("************************");
//        String perspicaceJson = JsonObjectUtil.getInstance().CreateJsonByBean(perspicaceNLUResponseData);
//        System.out.println(perspicaceJson);


//        System.out.println(perspicaceNLUResponseData.getData ().getSuggest ();
    }
}
