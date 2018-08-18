package com.perspicace.ai.deepbot;

import com.perspicace.ai.deepbot.service.thriftclient.DemoClientProxy;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: deepbot
 * @description: 测试thrift
 * @author: Destiny
 * @create: 2018-07-31 00:29
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ThriftTest extends Thread{
    @Autowired
    private DemoClientProxy demoClientProxy;

    @Test
    public void tset() throws TException {
        for (int i = 0; i < 100; i++) {
            String res = demoClientProxy.ping ( "111" );
            log.info ( res );
        }
    }
}
