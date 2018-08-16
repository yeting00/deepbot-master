package com.perspicace.ai.deepbot.service.impl;

import Ice.Current;
import com.perspicace.ai.common.message.PMessage;
import com.perspicace.ai.deepbot.repository.impl.MqRepositoryImpl;
import com.perspicace.ai.deepbot.utils.I18NUtil;
import com.perspicace.ai.deepbot.utils.LocalMessageQueue;
import com.perspicace.ai.deepbot.utils.SpringUtil;
import com.perspicace.modules.AICall.AICall.SayObj;
import com.perspicace.modules.Perception.PerceptionTxt.ListionObj;
import com.perspicace.modules.Perception.PerceptionTxt.Source;
import com.perspicace.modules.Perception.PerceptionTxt._PerceptionServiceDisp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: deepbot
 * @description: ice服务例子
 * @author: Destiny
 * @create: 2018-06-29 14:06
 **/
@Service
@Slf4j
public class PerceptionServiceImpl extends _PerceptionServiceDisp {
    private boolean sendToMq = false;//是否发送到队列中处理
    private final String queueType = "call_server_queue";
    private final int queueCount = 5;
    @Autowired
    private MqRepositoryImpl mqService;
//    @Autowired
//    private CoreServiceImpl coreService;

    @Override
    public void listion(ListionObj listionObj , Current __current) {

        String lang = __current.ctx.get ( "lang" );
        Map<String, String> ctx = new HashMap<> ( );
        ctx.put ( "lang" , lang );
        I18NUtil.ctxLocal.set ( ctx );
        DistributionServiceImpl distributionService = (DistributionServiceImpl) SpringUtil.getBean ( "DistributionService" );
        log.info ( "收到客户端语义解析请求" );
        SayObj sayObj = distributionService.lisition ( listionObj );

        if (!sendToMq) {
            //发送到本地队列
            LocalMessageQueue.getInstance ( ).addMessage ( sayObj );
        } else {
            //发送到mq
            PMessage pMessage = new PMessage( );
            pMessage.setParam ( sayObj );
            pMessage.setTime ( System.currentTimeMillis ( ) );

            try {
                if (mqService == null) {
                    mqService = (MqRepositoryImpl) SpringUtil.getBean ( MqRepositoryImpl.class );
                } else {
                    log.info ( "not init again..." );
                }

                int groupId = Integer.parseInt ( listionObj.groupId );
                int queueIndex = groupId % queueCount + 1;

                log.info ( "发送消息 queueIndex=" + queueIndex );

                mqService.sendMessage ( pMessage , queueType , queueIndex );
            } catch (Exception e) {
                log.error ( "发送tts调用异常 " + e.getMessage ( ) );
                e.printStackTrace ( );
            }
        }
    }

    @Override
    public String userClientListion(String text , String userId , String groupId , Source src , Current __current) {
        return null;
    }

}
