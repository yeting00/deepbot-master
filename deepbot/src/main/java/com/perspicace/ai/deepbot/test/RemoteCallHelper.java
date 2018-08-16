package com.perspicace.ai.deepbot.test;

import Ice.Communicator;
import Ice.ObjectPrx;
import com.perspicace.modules.Perception.PerceptionTxt.PerceptionServicePrx;
import com.perspicace.modules.Perception.PerceptionTxt.PerceptionServicePrxHelper;

/**
 * @Author: yeting
 * @Date: Created in 11:32 2018/1/29
 * @Description: 远程代理获取类
 * @Modified By:
 */
public class RemoteCallHelper {



    public static Communicator communicator;

    public static ObjectPrx createIceProxy(@SuppressWarnings("rawtypes") Class serviceCls) {
        if (communicator == null) {
//            String iceDefaultLocator = "--Ice.Default.Locator=" + Global.getConfig("Ice.Default.Locator");
            String iceDefaultLocator = "--Ice.Default.Locator=SmartHomeTestIceGrid/Locator:tcp -h 172.16.13.37 -p 4061";
            String[] initParams = new String[] { iceDefaultLocator };
            communicator = Ice.Util.initialize(initParams);
        }

        String serviceName = serviceCls.getSimpleName();
        int pos = serviceName.lastIndexOf("Prx");
        if (pos <= 0) {
            throw new IllegalArgumentException("Invalid ObjectPrx class ,class name must end with Prx");
        }
        String realSvName = serviceName.substring(0, pos);
        try {

            ObjectPrx base = communicator.stringToProxy(realSvName + "@" + realSvName + "Adapter");
            return base;

//            String environmentVariable = Global.getConfig("environment.variable");
//            if("dev".equals(environmentVariable)){
//                Ice.ObjectPrx base = communicator.stringToProxy(realSvName + "@" + realSvName + "Adapter");
//                return base;
//            }else if("product".equals(environmentVariable)){
//                Ice.ObjectPrx base = communicator.stringToProxy(realSvName);
//                return base;
//            }else if("test".equals(environmentVariable)){
//                Ice.ObjectPrx base = communicator.stringToProxy(realSvName + "@" + realSvName + "Adapter");
//                return base;
//            }else{
//                return null;
//            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    /**
     * AI感知服务代理
     */
    private static PerceptionServicePrx perceptionServicePrx;

    /**
     * 获取感知(AI)服务
     * @return
     */
//    public static PerceptionServicePrx getPerceptionServicePrx(){
//
//        if(perceptionServicePrx == null){
//            perceptionServicePrx = PerceptionServicePrxHelper.checkedCast(
//                    Ice.Util.initialize(new String[] {}).stringToProxy(Config.SERVER_CONFIG.getProperty("perceptionService")));
//        }
//        return perceptionServicePrx;
//    }



    public static PerceptionServicePrx getPerceptionServicePrx() {
        if (perceptionServicePrx == null) {

            try {


                perceptionServicePrx = PerceptionServicePrxHelper.checkedCast(createIceProxy(PerceptionServicePrx.class));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return perceptionServicePrx;
    }



}
