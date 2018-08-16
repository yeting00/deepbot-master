package com.perspicace.ai.deepbot.service.impl;

import com.perspicace.ai.deepbot.common.constant.Language;
import com.perspicace.ai.deepbot.common.exception.CustomerException;
import com.perspicace.ai.deepbot.domain.Person;
import com.perspicace.ai.deepbot.domain.SHD;
import com.perspicace.ai.deepbot.nlu.constant.Domain;
import com.perspicace.ai.deepbot.nlu.constant.Intent;
import com.perspicace.ai.deepbot.nlu.model.ContextData;
import com.perspicace.ai.deepbot.nlu.model.NLUResponseData;
import com.perspicace.ai.deepbot.nlu.service.ContextService;
import com.perspicace.ai.deepbot.nlu.service.impl.NLUServiceImpl;
import com.perspicace.ai.deepbot.nlu.service.impl.SessionServiceImpl;
import com.perspicace.ai.deepbot.repository.impl.MqRepositoryImpl;
import com.perspicace.ai.deepbot.service.DistributionService;
import com.perspicace.ai.deepbot.utils.I18NUtil;
import com.perspicace.ai.deepbot.utils.JsonObjectUtil;
import com.perspicace.modules.AICall.AICall.SayObj;
import com.perspicace.modules.Perception.PerceptionTxt.ListionObj;
import com.perspicace.modules.Perception.PerceptionTxt.Source;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: ICE启动后调用文件，负责文本分析，业务调用
 * @Param:
 * @return:
 * @Author: Destiny
 * @Date: 2018/6/28
 */
@Service("DistributionService")
@Slf4j
public class DistributionServiceImpl implements DistributionService, Domain {
    @Autowired
    private ControlDeviceServiceImpl controlDeviceService;

    @Autowired
    private WeatherServiceImpl weatherService;

    @Autowired
    private NLUServiceImpl nluService;

    @Autowired
    private MqRepositoryImpl mqService;

    @Autowired
    private ContextService contextService;

    @Autowired
    private SessionServiceImpl sessionService;

    private StringBuffer createLog() {
        return new StringBuffer ( );
    }

    private void appendLog(StringBuffer sb , String strlog) {
        sb.append ( "		" + strlog );
    }

    private void showLog(StringBuffer sb) {
        log.info ( sb.toString ( ) );
    }

    @Override
    public SayObj lisition(ListionObj listionObj) {
        String lang = I18NUtil.ctxLocal.get ( ).get ( "lang" );
        log.info ( "语言为--->" + lang );
//        String message = I18NUtil.getMessage ( "exception" , new String[]{"100" , "200"} );
//        log.info ( message );
        String query = listionObj.text;
        String shdSn = listionObj.sn;
        String shdID = listionObj.deviceId;
        String groupID = listionObj.groupId;
        String sessionID = listionObj.account + "_" + shdID + "_context_key";
        String responseSn = listionObj.responseSn;

        String reText = getReText ( query , groupID , sessionID , listionObj.source , shdSn , shdID );
        SayObj sayObj = new SayObj ( );
        sayObj.attachParam = "";
        sayObj.sn = shdSn;
        sayObj.isChat = 0;
        sayObj.isStop = 0;
        sayObj.result = 1;
        sayObj.talkSessionId = listionObj.talkSessionId;
        sayObj.wakeLogId = listionObj.wakeLogId;
        sayObj.sayingText = reText;
        sayObj.responseSn = responseSn;
        return sayObj;
    }

    //微信端调用返回Text
    @Override
    public String getPerceptionText(String query , String userId , String groupId , Source source) {
        //生成sessionid
        String sessionId = userId + "_" + groupId + "_context_key";
        //墙机号为空
        String smartDeviceId = "000822B0BDFB_1";
        String reText = getReText ( query , groupId , sessionId , source , "" , "" );
        return reText;
    }

    private String getReText(final String query , final String groupId , final String sessionId , final Source source , final String shdSn , final String shdID) {
        long invokeBefore = System.currentTimeMillis ( );
        String reText = I18NUtil.getMessage ( "default_failue_0" );
        ContextData contextData = new ContextData( );
        ContextData.IntentsBean contextIntentsBean = new ContextData.IntentsBean ( );
        String domain = Domain.NONE;
        String intent = Intent.NONE;
        StringBuffer sb = createLog ( );
//        String lang = I18NUtil.ctxLocal.get ( ).get ( "lang" );
        Language language = Language.zh_CN;
        boolean isGetedInentFromCache = false;//是否从缓存中获取了意图

        if (StringUtils.isEmpty ( groupId )) {
            return I18NUtil.getMessage ( "family_id_failue" );
        }
        try {
            long time1 = System.currentTimeMillis ( );
            // 获取语义解析结果
            Person person = new Person ( );
            SHD shd = new SHD ( );
            NLUResponseData nluResponseData = nluService.getNLUInfo ( language , query , person , shd );
            String nluResponseJson = JsonObjectUtil.getInstance ( ).CreateJsonByBean ( nluResponseData );
            log.info ( nluResponseJson );
            if (nluResponseData == null) {
                log.error ( "语义解析失败" );
                return reText;
            } else {
                long time2 = System.currentTimeMillis ( );
                appendLog ( sb , "\n\n --------------------------getReText start--------------------------" );
                appendLog ( sb , "\n\nQuery = " + query );
                appendLog ( sb , "\n调用意图时间	" + (time2 - time1) );
                int nluSegmentSize = nluResponseData.getSemanticResults ( ).size ( );
                for (int i = 0; i < nluSegmentSize; i++) {
                    List<NLUResponseData.SemanticResultsBean.IntentsBean> intentsBeanList = nluResponseData.getSemanticResults ( ).get ( i ).getIntents ( );
                    if (intentsBeanList != null) {
                        int intentsSize = intentsBeanList.size ( );
                        for (int j = 0; j < intentsSize; j++) {
                            NLUResponseData.SemanticResultsBean.IntentsBean intentsBean = intentsBeanList.get ( j );
                            domain = intentsBean.getDomain ( );
                            intent = intentsBean.getIntent ( );
                            appendLog ( sb , "\n【领域】>>  " + domain );
                            appendLog ( sb , "\n【意图】>>  " + intent );
                            // 如果意图为空，则先通过上下文补充，后续可通过模型完成
                            if (Domain.NONE.equals ( domain )) {
                                time1 = System.currentTimeMillis ( );
                                boolean isFilled = contextService.fillIntentWithContext ( sessionId , intentsBean );
                                time2 = System.currentTimeMillis ( );
                                appendLog ( sb , "\n 未知意图 补齐 消耗时间 >>  " + (time2 - time1) );
                                //如果成功通过上下文补齐了意图 则重新赋值意图
                                if (isFilled) {
                                    isGetedInentFromCache = true;
                                    domain = intentsBean.getDomain ( );
                                    intent = intentsBean.getIntent ( );
                                    appendLog ( sb , "\n 补齐后【领域】>>  " + domain );
                                    appendLog ( sb , "\n 补齐后【意图】>>  " + intent );
                                }
                            }
                            time1 = System.currentTimeMillis ( );
                            if (Domain.WEATHER.equals ( domain )) {
                                String res = weatherService.handleService ( groupId , shdSn , shdID , sessionId , query , intentsBean );
                                time2 = System.currentTimeMillis ( );
                                appendLog ( sb , "	\n天气时间>>  " + (time2 - time1) );
                                log.info ( "今天天气为" + res );
                                reText = res;
                            } else if (Domain.CONTROL_DEVICE.equals ( domain )) {
                                String res = controlDeviceService.handleService ( groupId , shdSn , shdID , sessionId , query , intentsBean );
                                time2 = System.currentTimeMillis ( );
                                appendLog ( sb , "	\n天气时间>>  " + (time2 - time1) );
                                log.info ( "家电操控回复为" + res );
                                reText = res;
                            } else {
                                reText = I18NUtil.getMessage ( "exception_no_function" );
                                ;//我现在还不支持这个功能
                            }
                            // 完成需要保存的信息
                            contextIntentsBean.setDomain ( domain );
                            contextIntentsBean.setIntent ( intent );
                        }
                    }
                }
            }
        } catch (CustomerException ce) {
            reText = ce.getMessage ( );
        } catch (Exception e) {
            e.printStackTrace ( );
            reText = I18NUtil.getMessage ( "default_failue_0" );// 我短路了
        } finally {
            //家电控制和天气才保存
            if (Domain.CONTROL_DEVICE.equals ( domain ) || Domain.WEATHER.equals ( domain )) {
                // 保存上下文
                contextData.setIntents ( contextIntentsBean );
                long t1 = System.currentTimeMillis ( );
                sessionService.saveContext ( sessionId , contextData );
                long t2 = System.currentTimeMillis ( );
                appendLog ( sb , "\n 记录上下文消耗>>  " + (t2 - t1) );
            }

            //控制家电的意图并且是缓存中不存在的 则保存到缓存
//            if (!isGetedInentFromCache && Domain.CONTROL_DEVICE.equals ( domain )) {
//                //可以发到队列中存储redis
//                nluService.saveEntityToCache ( question , intentEntity );
//            }
        }

        long invokeAfter = System.currentTimeMillis ( );
        appendLog ( sb , "\n 整体时间>>  " + (invokeAfter - invokeBefore) );
        appendLog ( sb , "\n【回复】>>  " + reText );
        appendLog ( sb , "\n\n --------------------------getReText end--------------------------" );
        showLog ( sb );

        //发送到mq中记录日志
//        try {
//            if (mqService == null) {
//                mqService = (MqRepositoryImpl) SpringUtil.getBean ( MqRepositoryImpl.class );
//            } else {
//                log.info ( "not init again..." );
//            }
//            mqService.sendStringMessage ( sb.toString ( ) , "log_queue" );
//        } catch (IOException e) {
//            //ignore
//        }

        return reText;
    }
}
