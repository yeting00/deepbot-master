package com.perspicace.ai.deepbot.test;

import com.perspicace.modules.Perception.PerceptionTxt.ListionObj;
import com.perspicace.modules.Perception.PerceptionTxt.PerceptionServicePrx;
import com.perspicace.modules.Perception.PerceptionTxt.Source;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * @Author: yeting
 * @Date: Created in 17:37 2018/1/29
 * @Description: 简单测试ai接口调用
 * @Modified By:
 */
//@Service("AICallTest")
@Service
public class AICallTest {


    /**
     * 调用ai的感知服务
     * @param sends
     */
    public static void testCallAI(ListionObj sends){
//        RemoteCallHelper.getPerceptionServicePrx().begin_listion(sends);
//        RemoteCallHelper.getPerceptionServicePrx().listion(sends);
        PerceptionServicePrx perceptionServicePrx = RemoteCallHelper.getPerceptionServicePrx();
        perceptionServicePrx.listion(sends);
    }


//    public static String testAop(int i,String s){
//
//        System.out.println("--------testAop---------");
//
//        return "testAop call";
//    }


    public static void main(String[] args) {

//        SpringUtil.getBean(null);

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-context.xml");

//        AICallTest math = ctx.getBean("AICallTest", AICallTest.class);


        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("command>");
            try {
                Thread.sleep(1000);
                String voiceStr = bufferedreader.readLine();

                ListionObj sends = new ListionObj(voiceStr,
                        "wakeLogId","talkSessionId","4TH-TEST",
                        "account1","groupid1", Source.SmartHomeCall,"","deviceId01","resSn");
                
//                ListionObj sends = new ListionObj(voiceStr,
//                        "wakeLogId","talkSessionId","4TH-TEST",
//                        "account1","groupid1", Source.SmartHomeCall,"");
                
                testCallAI(sends);


            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } while (true);
    }



}
