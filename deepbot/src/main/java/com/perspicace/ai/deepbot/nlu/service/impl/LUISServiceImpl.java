package com.perspicace.ai.deepbot.nlu.service.impl;

import com.perspicace.ai.deepbot.common.constant.Language;
import com.perspicace.ai.deepbot.common.exception.CustomerException;
import com.perspicace.ai.deepbot.config.MicrosoftProperties;
import com.perspicace.ai.deepbot.domain.Person;
import com.perspicace.ai.deepbot.domain.SHD;
import com.perspicace.ai.deepbot.nlu.model.LUISResData;
import com.perspicace.ai.deepbot.nlu.model.NLUResponseData;
import com.perspicace.ai.deepbot.nlu.service.NLUService;
import com.perspicace.ai.deepbot.utils.HttpClientUtil;
import com.perspicace.ai.deepbot.utils.JsonObjectUtil;
import com.perspicace.ai.deepbot.utils.OToMoreMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: deepbot
 * @description:获取LUIS结果并进行解析
 * @author: Destiny
 * @create: 2018-07-28 15:14
 **/
@Service("LUISService")
@Slf4j
public class LUISServiceImpl implements NLUService<String, LUISResData> {
    @Autowired
    private MicrosoftProperties microsoftProperties;

    @Override
    public String generateInputBean(String query , Person person , SHD shd) {
        return null;
    }

    @Override
    public LUISResData getNLUInfo(Language language , String query , Person user , SHD shd) throws CustomerException {
        try {
            String resultJson = HttpClientUtil.getInstance ( ).sendHttpGet ( microsoftProperties.getLuisUrl ( ) + query );
            log.info ( "LUIS解析结果————————>" + resultJson );
            LUISResData luisResData = JsonObjectUtil.getInstance ( ).CreateBeanByJson ( resultJson , LUISResData.class );
            return luisResData;
        } catch (CustomerException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace ( );
            log.error ( e.getMessage ( ) , e );
        }
        return null;
    }

    @Override
    public LUISResData getNLUInfoFromCache(String query) {
        return null;
    }

    @Override
    public void saveNLUInfo2Cache(String query , LUISResData luisResData) {

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
}
