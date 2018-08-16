package com.perspicace.ai.deepbot.service.iceservice;

import Ice.Object;
import com.perspicace.ai.deepbot.service.impl.PerceptionServiceImpl;
import com.perspicace.ai.deepbot.utils.AbstractIceBoxService;

/**
 * @program: deepbot
 * @description: 感知服务
 * @author: Destiny
 * @create: 2018-06-29 14:12
 **/
public class PerceptionService extends AbstractIceBoxService {
    @Override
    public Object createMyIceServiceObj(String[] args) {

        return new PerceptionServiceImpl ();
    }
}
