package com.perspicace.ai.deepbot.service.thriftclient;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;

/**
 * @program: deepbot
 * @description:
 * @author: Destiny
 * @create: 2018-07-30 15:52
 **/
@Slf4j
public class DemoThriftClient {

    private ThriftClient<com.perspicace.ai.deepbot.gen.DemoService.Client> thriftClient;

    public DemoThriftClient(String host , int port) {
        thriftClient = new ThriftClient<>( host , port , "DemoService" );
        thriftClient.setClient ( new com.perspicace.ai.deepbot.gen.DemoService.Client ( thriftClient.getMultiplexedprotocol ( ) ) );
    }

    public String ping(String test) throws TException {
        thriftClient.open ( );
        String res = thriftClient.getClient ( ).ping ( test );
        thriftClient.close ( );
        return res;
    }

//    public DemoObject ping(String dataModelId) throws TException {
//        thriftClient.open();
//        commonRes res = thriftClient.getClient().train(dataModelId);
//        thriftClient.close();
//        return res;
//    }
}
