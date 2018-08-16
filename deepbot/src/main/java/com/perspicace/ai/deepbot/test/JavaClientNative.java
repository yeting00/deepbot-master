package com.perspicace.ai.deepbot.test;

import com.perspicace.ai.deepbot.gen.DemoObject;
import com.perspicace.ai.deepbot.gen.DemoService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @program: deepbot
 * @description:
 * @author: Destiny
 * @create: 2018-07-30 02:37
 **/
public class JavaClientNative {
    public static void main(String[] args) {
        TTransport transport;
        try {
            //修改服务器和端口
            transport = new TSocket ("127.0.0.1", 10000);
            TProtocol protocol = new TBinaryProtocol (transport);
            DemoService.Client client = new DemoService.Client(protocol);
            transport.open();
            System.out.println(client.ping("test"));
            DemoObject object = client.getObject("xxx", 2);
            System.out.println(object.getX() + "\t" + object.getY());
            transport.close();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

}
