package com.perspicace.ai.deepbot;


import com.perspicace.ai.deepbot.config.MicrosoftProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MicrosoftPropertiesTests {

    @Autowired
    private MicrosoftProperties microsoftProperties;

    @Test
    public void set() {
        String url = microsoftProperties.getNluUrl();
        log.info("*******************************8");
        System.out.println(url);
    }
}
