package com.perspicace.ai.deepbot.service.iceservice;

import Ice.Current;
import com.perspicace.ai.deepbot.utils.SpringUtil;
import com.perspicace.gen.controldevice.slice.ControlDeviceService;
import com.perspicace.gen.controldevice.slice._ControlDeviceServiceDisp;
import org.springframework.stereotype.Service;
import slice.NoAreaException;

import java.util.Map;

/** 
* @Description: 将家电控制、情景模式控制单独成服务，注入注册中心 
* @Param:  
* @return:  
* @Author: Destiny 
* @Date: 2018/7/12 
*/ 

@Service("controldeviceIceService")
public class ControldeviceIceService extends _ControlDeviceServiceDisp {

    //@Autowired
    //private ControlDeviceService controlDeviceService;

    @Override
    public String controlDevice(String text , String intent , Map<String, String> entityMap , String suggest , String smartDeviceId , String groupId ,
                                Current __current) throws NoAreaException {

        ControlDeviceService controlDeviceService = SpringUtil.getBean ( ControlDeviceService.class );

        return controlDeviceService.controlDevice ( text , intent , entityMap , suggest , smartDeviceId , groupId );
    }

    @Override
    public String runScene(String text , String groupId , String sceneMode , String _sn , String _deviceid , Current __current) {

        ControlDeviceService controlDeviceService = SpringUtil.getBean ( ControlDeviceService.class );

        return controlDeviceService.runScene ( text , groupId , sceneMode , _sn , _deviceid );
    }
}
