package com.perspicace.ai.deepbot.utils;

import Ice.Communicator;
import Ice.Identity;
import IceBox.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j(topic = "system")
public abstract class AbstractIceBoxService implements Service {

    protected Ice.ObjectAdapter _adapter;
    protected Identity id;
    protected static Sl4jLoggerI iceLogger = new Sl4jLoggerI("communicator");
    public Communicator communicator;

    @Override
    public void start(String name, Communicator communicator, String[] args) {
        this.communicator = communicator;
        Ice.Util.setProcessLogger(iceLogger);
        //创建objectAdapter，这里和service同名
        _adapter = communicator.createObjectAdapter(name);
        //创建servant并激活
        Ice.Object object = this.createMyIceServiceObj(args);
        id = communicator.stringToIdentity(name);
        //自动添加到服务拦截框架中
        _adapter.add(PerfDispatchInterceptor.addIceObject(id, object), id);
        _adapter.activate();
		log.info(name+" service started ,with param size "+args.length+" detail:"+Arrays.toString(args));
    }


    @Override
    public void stop() {
		log.info("stopping service "+id+" ...");
        _adapter.destroy();
        PerfDispatchInterceptor.removeIceObject(id);
		log.info("stopped service "+id+" stoped");
    }

    /**
     * 创建具体的Ice服务器实例对象
     *
     * @param args 服务的配置参数，来自icegrid.xml文件
     * @return Ice.Object
     */
    public abstract Ice.Object createMyIceServiceObj(String[] args);

}
