package com.perspicace.ai.deepbot;

import com.perspicace.ai.common.exception.CustomerException;
import com.perspicace.ai.deepbot.config.MicrosoftProperties;
import com.perspicace.ai.deepbot.nlu.model.LUISResData;
import com.perspicace.ai.deepbot.utils.HttpClientUtil;
import com.perspicace.ai.deepbot.utils.JsonObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @program: deepbot
 * @description:
 * @author: Destiny
 * @create: 2018-07-28 04:12
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LuisTest {
    @Autowired
    private MicrosoftProperties microsoftProperties;

    @Test
    public void tset() {
        String query = "明日の東京の天気";
        try {
            String res = HttpClientUtil.getInstance ( ).sendHttpGet ( microsoftProperties.getLuisUrl ( ) + query );
            log.info ( res );
            LUISResData luisResData = JsonObjectUtil.getInstance ( ).CreateBeanByJson ( res , LUISResData.class );
            String[] domain_intent = luisResData.getTopScoringIntent ().getIntent ().split ( "\\." );
            log.info(String.valueOf ( domain_intent.length ));

            String domain = domain_intent[0];
            String intent = domain_intent[1];
            log.info ( domain );
        } catch (CustomerException e) {
            e.printStackTrace ( );
        }
    }
}
