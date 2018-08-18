package com.perspicace.ai.deepbot;

import com.perspicace.ai.deepbot.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * @program: deepbot
 * @description:
 * @author: Destiny
 * @create: 2018-07-11 20:16
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ReadJsonTest {
    @Test
    public void read(){
        FileUtil.getJson("device.json");
    }

}
