package com.perspicace.ai.deepbot.service.impl;

import com.perspicace.ai.deepbot.config.MyRabbitConfig;
import com.perspicace.ai.deepbot.model.*;
import com.perspicace.ai.deepbot.nlu.model.NLUResponseData;
import com.perspicace.ai.deepbot.nlu.service.NLUService;
import com.perspicace.ai.deepbot.repository.RedisRepository;
import com.perspicace.ai.deepbot.service.RemoteSceneModeService;
import com.perspicace.ai.deepbot.utils.I18NUtil;
import com.perspicace.ai.deepbot.utils.IceInvoker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: deepbot
 * @description: 控制情景模式服务
 * @author: Destiny
 * @create: 2018-08-12 20:01
 **/
@Slf4j
@Service("controlSceneModeServiceImpl")
public class ControlSceneModeServiceImpl {
    @Autowired
    private RedisRepository redisRepository;

    @Autowired
    private NLUService nluService;

    @Autowired
    private RemoteServiceImpl remoteService;

    @Autowired
    private RemoteSceneModeService remoteSceneModeService;

    @Autowired
    private MyRabbitConfig myRabbitConfig;

    private StringBuffer createLog() {
        return new StringBuffer ( );
    }

    private void appendLog(StringBuffer sb , String strlog) {
        sb.append ( "		" + strlog );
    }

    private void showLog(StringBuffer sb) {
        log.info ( sb.toString ( ) );
    }

    public String handleService(final String groupID , final String shdSn , final String shdID , String sessionID , String query , NLUResponseData.SemanticResultsBean.IntentsBean intentsBean) {
        String resText = I18NUtil.getMessage ( "default_failue_0" );
        StringBuffer resStringBuffer = new StringBuffer ( );        // 组织回复内容
        StringBuffer stringBuffer = new StringBuffer ( );          // 记录日志内容
        String sceneModeName = intentsBean.getIntent ( );
        try {
            DeviceGroupData.SceneModelsBean sceneModelsBean = remoteSceneModeService.getSceneModeBean ( groupID , shdID , sceneModeName );
            if (sceneModelsBean == null) {
                resText = I18NUtil.getMessage ( "devicecontrol_remotescenemode_failue" );
            } else {
                String sceneId = sceneModelsBean.getId ( );
                appendLog ( stringBuffer , "runScene >> text=" + query + " sceneId=" + sceneId );
                long time1 = System.currentTimeMillis ( );
                //调用控制场景
                boolean res = IceInvoker.getSceneServicePrx ( ).runScene ( sceneId , groupID );//,_sn,_deviceid
                if (res) {
                    resText = I18NUtil.getMessage ( "default_success_2" );
                } else {
                    resText = I18NUtil.getMessage ( "default_failue_0" );
                }
                long time2 = System.currentTimeMillis ( );
                appendLog ( stringBuffer , "\n 控制场景 耗时>> " + (time2 - time1) );
                appendLog ( stringBuffer , "\n 控制场景 结果>> " + res );
            }
        } catch (Exception e) {
            resText = I18NUtil.getMessage ( "default_failue_0" );
        }
        return resText;
    }

}
