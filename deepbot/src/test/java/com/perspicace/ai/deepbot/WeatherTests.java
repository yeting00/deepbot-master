package com.perspicace.ai.deepbot;

import com.perspicace.ai.deepbot.nlu.constant.Slot4Service;
import com.perspicace.ai.deepbot.nlu.model.PerspicaceNLUResponseData;
import com.perspicace.ai.deepbot.service.impl.WeatherServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: deepbot
 * @description: 测试天气查询业务
 * @author: Destiny
 * @create: 2018-06-27 18:12
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WeatherTests {
    @Autowired
	WeatherServiceImpl weatherService;

    @Test
    public void getWeather() {
        PerspicaceNLUResponseData perspicaceNLUResponseData = new PerspicaceNLUResponseData( );
        PerspicaceNLUResponseData.DataBean dataBean = new PerspicaceNLUResponseData.DataBean ( );
        dataBean.setTopScene ( "Weather" );

        perspicaceNLUResponseData.setData ( dataBean );

        List<String> slotList = Slot4Service.WEATHER_SLOT_LiST;
        Map<String, String> eneityMap = new HashMap<> ( );

        for (int k = 0; k < 5; k++) {
            String type = "location";
            if (slotList.contains ( type )) {
                eneityMap.put(type,"上海");
            } else {
                log.error ( "not found" );
                break;
            }

//        NLUResponseData nluResponseData = new NLUResponseData ();
//        nluResponseData.setPerspicaceNLUResponseData ( perspicaceNLUResponseData );
//        weatherService.getResponse(nluResponseData);
        }
    }
}
