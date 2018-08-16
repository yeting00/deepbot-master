package com.perspicace.ai.deepbot.nlu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.perspicace.ai.deepbot.common.constant.Constant;
import com.perspicace.ai.deepbot.common.constant.HeaderType;
import com.perspicace.ai.deepbot.common.constant.Language;
import com.perspicace.ai.deepbot.common.exception.CustomerException;
import com.perspicace.ai.deepbot.config.PerspicaceProperties;
import com.perspicace.ai.deepbot.domain.Person;
import com.perspicace.ai.deepbot.domain.SHD;
import com.perspicace.ai.deepbot.nlu.model.IntentEntity;
import com.perspicace.ai.deepbot.nlu.model.NLUResponseData;
import com.perspicace.ai.deepbot.nlu.model.PerspicaceNLUResponseData;
import com.perspicace.ai.deepbot.nlu.service.NLUService;
import com.perspicace.ai.deepbot.utils.HttpClientUtil;
import com.perspicace.ai.deepbot.utils.JsonObjectUtil;
import com.perspicace.ai.deepbot.utils.OToMoreMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: deepbot
 * @description: 百芝龙语义解析用户意图分析
 * @author: Destiny
 * @create: 2018-06-27 17:45
 **/
@Service("PerspicaceNLUService")
@Slf4j
public class PerspicaceNLUServiceImpl implements NLUService<String, PerspicaceNLUResponseData> {
    @Autowired
    private PerspicaceProperties perspicaceProperties;

    @Override
    public String generateInputBean(String query , Person person , SHD shd) {
        Map values = new HashMap ( );
        values.put ( "text" , query );
        String postJson = JSON.toJSONString ( values );
        return postJson;
    }

    @Override
    public PerspicaceNLUResponseData getNLUInfo(Language language , String query , Person user , SHD shd) throws CustomerException {
        String queryJson = generateInputBean ( query , user , shd );
        log.info ( "输入json为--------->" + queryJson );
        PerspicaceNLUResponseData perspicaceNLUResponseData;
        try {
            String resultJson = HttpClientUtil.getInstance ( ).sendHttpPost ( perspicaceProperties.getNluUrl ( ) , queryJson , HeaderType.PERSPICACE_HEADER );
            perspicaceNLUResponseData = JsonObjectUtil.getInstance ( ).CreateBeanByJson ( resultJson , PerspicaceNLUResponseData.class );
            int code = perspicaceNLUResponseData.getCode ( );
            if (200 != code) {
                String msg = perspicaceNLUResponseData.getMsg ( );
                String message = "调用意图返回 " + code + " " + msg;
                log.error ( message );
                throw new CustomerException ( Constant.error100004 , message );
            }
            log.info ( "调用百芝龙语义解析结果成功" );
            log.info ( "百芝龙语义解析结果————————>" + resultJson );
            return perspicaceNLUResponseData;
        } catch (CustomerException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace ( );
            log.error ( e.getMessage ( ) , e );
        }
        return null;
    }

    @Override
    public PerspicaceNLUResponseData getNLUInfoFromCache(String query) {
        return null;
    }

    @Override
    public void saveNLUInfo2Cache(String query , PerspicaceNLUResponseData inputBean) {

    }

    @Override
    public void saveNLUSlot2Cache(String sessionId , Map<String, Object> slotmMap , long time) {

    }

    @Override
    public OToMoreMap<String, String> getSlot4Service(NLUResponseData.SemanticResultsBean.IntentsBean intentsBean , List<String> slot4serviceList) {
        return null;
    }

    @Override
    public String getMode2Intent(String intent , String mode) {
        return null;
    }


    //留着测试
    public IntentEntity getEntity(String query , Person user , SHD shd) throws CustomerException {
        String queryJson = generateInputBean ( query , user , shd );
        log.info ( "输入json为--------->" + queryJson );

        //从缓存中获取分析结果（待完成）

        try {
            IntentEntity intentEntity;
            String resultJson = HttpClientUtil.getInstance ( ).sendHttpPost ( perspicaceProperties.getNluUrl ( ) , queryJson , HeaderType.PERSPICACE_HEADER );
            System.out.println ( "rejson==" + resultJson );

            JSONObject jobj = JSON.parseObject ( resultJson );
            int code = jobj.getIntValue ( "code" );
            // 200为正确码
            if (code == 200) {
                JSONObject dataObj = jobj.getJSONObject ( "data" );
                String intent = dataObj.getString ( "topScene" );
                String suggest = dataObj.getString ( "suggest" );

                String suggests[] = suggest.split ( "-" );
                if (suggests.length > 1) {
                    String operate = suggests[1];
                    suggest = operate;
                }

                intentEntity = new IntentEntity ( intent , suggest );
                intentEntity.addEntity ( "operate" , suggest );

                JSONArray entities = dataObj.getJSONArray ( "entities" );
                for (int i = 0; i < entities.size ( ); i++) {
                    JSONObject entityObj = entities.getJSONObject ( i );
                    String type = entityObj.getString ( "type" );
                    String entityKey = entityObj.getString ( "entityKey" ) == null ? entityObj.getString ( "text" )
                            : entityObj.getString ( "entityKey" );
                    String suggestion = entityObj.getString ( "suggestion" );
                    intentEntity.addEntity ( type , entityKey );
                    intentEntity.addEntity ( type + "__suggestion" , suggestion );
                }

                if (intentEntity.getEntityMap ( ) == null) {
                    intentEntity.setEntityMap ( new HashMap ( ) );
                }
                return intentEntity;
            } else {
                String msg = jobj.getString ( "msg" );
                String message = "调用意图返回 " + code + " " + msg;
                log.error ( message );
                throw new CustomerException ( Constant.error100004 , message );
            }
        } catch (CustomerException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace ( );
            log.error ( e.getMessage ( ) , e );
        }
        return null;
    }

}
