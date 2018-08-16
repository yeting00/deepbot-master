package com.perspicace.ai.deepbot.service.thriftclient;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

/**
 * @program: deepbot
 * @description: 用于调用服务器方法
 * @author: Destiny
 * @create: 2018-07-31 00:24
 **/
@Service
@Slf4j
public class DemoClientProxy {

    public String ping(String test) throws TException{
        DemoThriftClient myClient = new DemoThriftClient("127.0.0.1", 9090);
        String res = myClient.ping (test);
        return res;
    }
}
