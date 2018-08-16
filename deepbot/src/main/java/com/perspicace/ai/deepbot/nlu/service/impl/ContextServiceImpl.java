package com.perspicace.ai.deepbot.nlu.service.impl;

import com.perspicace.ai.deepbot.nlu.constant.Slot4Service;
import com.perspicace.ai.deepbot.nlu.model.ContextData;
import com.perspicace.ai.deepbot.nlu.model.NLUResponseData;
import com.perspicace.ai.deepbot.nlu.service.ContextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author energy
 * @version 1.0.0 创建时间：2017年12月28日
 * 说明
 **/
@Service("ContextService")
@Slf4j
public class ContextServiceImpl implements ContextService {
    @Autowired
    private SessionServiceImpl sessionService;

    @Override
    public boolean fillIntentWithContext(String sessionId , NLUResponseData.SemanticResultsBean.IntentsBean intentsBean) {
        Map<String, String> currentTypeMap = new HashMap<> ( );
        if (intentsBean != null && intentsBean.getSlots ( ) != null) {
            int slotSize = intentsBean.getSlots ( ).size ( );
            for (int k = 0; k < slotSize; k++) {
                String currentType = intentsBean.getSlots ( ).get ( k ).getType ( );
                String currentText = intentsBean.getSlots ( ).get ( k ).getText ( );
                String currentNormalizedTextCN = intentsBean.getSlots ( ).get ( k ).getNormalizedTextCN ( );
                String currentNormalizedTextEN = intentsBean.getSlots ( ).get ( k ).getNormalizedTextEN ( );
                if (currentNormalizedTextEN == null) {
                    if (currentNormalizedTextCN == null) {
                        currentTypeMap.put ( currentType , currentText );
                    } else {
                        currentTypeMap.put ( currentType , currentNormalizedTextCN );
                    }
                } else {
                    currentTypeMap.put ( currentType , currentNormalizedTextEN );
                }
            }
        }

        if (currentTypeMap != null) {
            //获取上下文会话信息
            List<ContextData> contextList = sessionService.getContextList ( sessionId );
            if (contextList == null || contextList.isEmpty ( )) {
                return false;
            }
            int l = contextList.size ( );
            for (int i = l - 1; i >= 0; i--) {
                ContextData contextData = contextList.get ( i );
                if (contextData == null) {
                    continue;
                }
                /***
                 * 遍历上下文中保存的实体和当前的实体是否有重叠   如果有 则返回该实体对应的领域
                 */
                String contextDomain = contextData.getIntents ( ).getDomain ( );
                String contextIntent = contextData.getIntents ( ).getIntent ( );

                Map<String, String> entity4service = Slot4Service.FILL_INTENT_MAP.get ( contextDomain );
                if (entity4service == null) {
                    continue;
                }
                /**
                 * 遍历当前实体列表 如果上下文中包含了当前实体列表中的某一项 则使用上下文中的意图补充到当前意图中
                 * */
                for (String key : currentTypeMap.keySet ( )) {
                    if (entity4service.containsKey ( key )) {
                        intentsBean.setDomain ( contextDomain );
                        intentsBean.setIntent ( contextIntent );
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean checkControlDeviceContext(String sessionId , NLUResponseData.SemanticResultsBean.IntentsBean intentsBean) {
//        Map<String, String> currentEneityMap = intentEntity.getEntityMap ( );
//        String position = currentEneityMap.get ( Entity.POSITION );
//        //String electrical=currentEneityMap.get(Entity.Electrical);
//        String operatevalue = currentEneityMap.get ( Entity.OPERATE_VALUE );
//
//        ContextData lastContext = null;
//        //家庭区域不为空 并且操作值为空
//        //这里解决的是  询问具体位置的家电的上下文的问题
//        if (position != null && operatevalue == null) {
//            //只获取最后一条的上下文
//            lastContext = sessionService.getLastContext ( sessionId );
//
//            if (lastContext == null) {
//                return false;
//            }
//
//            //如果上下文中标记了需要补齐
//            if (lastContext.isNeedContext ( )) {
//                Map contextEntityMap = lastContext.getContextEntityMap ( );
//
//                //把上下文中的实体和意图覆盖到当前实体中
//                currentEneityMap.putAll ( contextEntityMap );
//
//                log.info ( "补齐实体 " + contextEntityMap );
//
//                //用上下文的意图替换当前意图
//                intentEntity.setIntent ( lastContext.getIntent ( ) );
//
//                //重置标记 redis总的标记不需要重置 因为当次条记录保存后 将不会使用上一条的记录
//                lastContext.setNeedContext ( false );
//                return true;
//            }
//        }

        return false;
    }


    /**
     * 通过建议和上下文补充实体
     *
     * @param sessionId
     * @param suggest
     * @return 返回补齐的家电对象
     */
    public String getElectricalBySuggest(String sessionId , String suggest) {
        String reElectrical = null;
        ///////家电对象为空  通过建议和上下文补齐家电对象///////
        //例如1:
        // 打开电视
        // 声音小一点 这里需要补齐家电对象“电视”
        //例如2：
        //打开空调
        //温度高一点 这里需要补齐家电对象 ”空调“

        //通过建议补充的家电必须注册过
//        String strSuggestEntity = Slot4Service.ACTION_DEVICE_MAPPING.get ( suggest );
//        if (strSuggestEntity == null) {
//            log.info ( "未注册的suggest " + suggest );
//            return null;
//        }
//
//        //如果某一个suggest注册的家电对象有多个 则通过上下文来判断
//        //如果某一个suggest注册的家电对象只有一个 则就使用注册家电
//
//        String suggestEntitys[] = strSuggestEntity.split ( "\\|" );
//        if (suggestEntitys.length > 1) {
//            //获取上下文列表
//            List<ContextData> contextList = sessionService.getContextList ( sessionId );
//            if (contextList == null || contextList.isEmpty ( )) {
//                return null;
//            }
//            int l = contextList.size ( );
//            for (int i = l - 1; i >= 0; i--) {
//                ContextData contextData = contextList.get ( i );
//                if (contextData == null) {
//                    continue;
//                }
//
//                Map<String, String> contextEntityMap = contextData.getContextEntityMap ( );
//                String _electrical = contextEntityMap.get ( Entity.PERSPICACE_ELECTRICAL );
//
//                //使用上下文中的实体和suggest对应的实体对比 避免张冠李戴
//                if (strSuggestEntity.indexOf ( _electrical ) != -1) {
//                    reElectrical = _electrical;
//                    break;
//                }
//            }
//        } else {
//            reElectrical = suggestEntitys[0];
//        }

        return reElectrical;
    }

}
