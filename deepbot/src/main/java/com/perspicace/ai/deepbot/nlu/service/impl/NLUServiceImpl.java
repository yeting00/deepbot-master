package com.perspicace.ai.deepbot.nlu.service.impl;

import com.perspicace.ai.common.constant.Language;
import com.perspicace.ai.common.exception.CustomerException;
import com.perspicace.ai.deepbot.domain.Person;
import com.perspicace.ai.deepbot.domain.SHD;
import com.perspicace.ai.deepbot.nlu.constant.*;
import com.perspicace.ai.deepbot.nlu.model.*;
import com.perspicace.ai.deepbot.nlu.service.NLUService;
import com.perspicace.ai.deepbot.repository.RedisRepository;
import com.perspicace.ai.deepbot.utils.JsonObjectUtil;
import com.perspicace.ai.deepbot.utils.OToMoreMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.perspicace.ai.deepbot.nlu.constant.IntentMap.MODE_INTENT_MAP;

/**
 * @program: deepbot
 * @description: 整合语义解析结果
 * @author: Destiny
 * @create: 2018-06-28 18:45
 **/
@Service("nluService")
@Slf4j
public class NLUServiceImpl implements NLUService<NLUInputData, NLUResponseData> {
    @Autowired
    private AzureNLUServiceImpl azureNLUService;

    @Autowired
    private PerspicaceNLUServiceImpl perspicaceNLUService;

    @Autowired
    private LUISServiceImpl luisService;

    @Autowired
    private RedisRepository redisRepository;

    @Override
    public NLUInputData generateInputBean(String query , Person person , SHD shd) {
        return null;
    }

    @Override
    public NLUResponseData getNLUInfo(Language language , String query , Person person , SHD shd) throws CustomerException {
        try {
            int code = 0;
            NLUResponseData nluResponseData = new NLUResponseData( );

            if (language == Language.ja_JP) {
                LUISResData luisResData = luisService.getNLUInfo ( language , query , person , shd );
                nluResponseData = unifyLUISResponse ( query , luisResData , nluResponseData );
            } else {
                AzureNLUResponseData azureNLUResponseData = azureNLUService.getNLUInfo ( language , query , person , shd );
                String azureResponseJson = JsonObjectUtil.getInstance ( ).CreateJsonByBean ( azureNLUResponseData );
                if (!"null".equals ( azureResponseJson )) {
                    code = azureNLUResponseData.getResponseInfo ( ).getCode ( );
                }
                if (200 == code) {
                    nluResponseData = JsonObjectUtil.getInstance ( ).CreateBeanByJson ( azureResponseJson , NLUResponseData.class );
                } else {
                    PerspicaceNLUResponseData perspicaceNLUResponseData = perspicaceNLUService.getNLUInfo ( language , query , person , shd );
                    nluResponseData = unifyNLUResponse ( query , perspicaceNLUResponseData , nluResponseData );
                }
            }
            // 保存
            saveNLUInfo2Cache ( query , nluResponseData );
            return nluResponseData;
        } catch (CustomerException e) {
            log.error ( e.getMessage ( ) , e );
            throw e;
        } catch (Exception e) {
            e.printStackTrace ( );
            log.error ( e.getMessage ( ) , e );
        }
        return null;
    }


    @Override
    public NLUResponseData getNLUInfoFromCache(String query) {
        NLUResponseData nluResponseData = (NLUResponseData) redisRepository.get ( query );
        return nluResponseData;
    }

    @Override
    public void saveNLUInfo2Cache(String query , NLUResponseData nluResponseData) {
//        boolean ifSave = redisRepository.set ( query , nluResponseData );
//        if (ifSave) {
//            log.info ( "语义解析结果缓存成功" );
//        } else {
//            log.error ( "语义解析结果缓存失败" );
//        }

    }

    @Override
    public void saveNLUSlot2Cache(String sessionId , Map<String, Object> slotmMap , long time) {
        boolean ifSave = redisRepository.hmset ( sessionId , slotmMap , time );
        if (ifSave) {
            log.info ( "词槽结果缓存成功" );
        } else {
            log.error ( "词槽结果缓存失败" );
        }
    }

    @Override
    public OToMoreMap<String, String> getSlot4Service(NLUResponseData.SemanticResultsBean.IntentsBean intentsBean , final List<String> slot4serviceList) {
        OToMoreMap<String, String> slotMap = new OToMoreMap ( );
        if (intentsBean != null && intentsBean.getSlots ( ) != null) {
            int slotsSize = intentsBean.getSlots ( ).size ( );
            for (int i = 0; i < slotsSize; i++) {
                String type = intentsBean.getSlots ( ).get ( i ).getType ( );
                String text = intentsBean.getSlots ( ).get ( i ).getText ( ).replaceAll ( " " , "" );
                String normalizedTextEN = intentsBean.getSlots ( ).get ( i ).getNormalizedTextEN ( );
                String normalizedTextCN = intentsBean.getSlots ( ).get ( i ).getNormalizedTextCN ( );
                String isImplicit = String.valueOf ( intentsBean.getSlots ( ).get ( i ).isImplicit ( ) );
                String normalizedText;
                if (normalizedTextEN == null) {
                    if (normalizedTextCN == null) {
                        normalizedText = text;
                    } else {
                        normalizedText = normalizedTextCN;
                    }
                } else {
                    normalizedText = normalizedTextEN;
                }

                int slotSize = slot4serviceList.size ( );
                for (int j = 0; j < slotSize; j++) {
                    if (slot4serviceList.get ( j ).equals ( type )) {
                        slotMap.put ( type , normalizedText );
                        slotMap.put ( "text" , text );      // 用于播报
                    }
                }
            }
        }
        return slotMap;
    }

    // 进行意图为set_mode的映射  目前只有风速
    @Override
    public String getMode2Intent(String intent , String mode) {
        if (Intent.SET_MODE.equals ( intent )) {
            intent = MODE_INTENT_MAP.get ( mode );
        }
        return intent;
    }

    // 统一NLU处理结果
    private NLUResponseData unifyNLUResponse(String query , PerspicaceNLUResponseData perspicaceNLUResponseData , NLUResponseData nluResponseData) {
        // 将百芝龙数据格式转换统一为NLUResponse 数据
        NLUResponseData.MessageBean messageBean = new NLUResponseData.MessageBean ( );
        messageBean.setQuery ( query );

        List<NLUResponseData.SemanticResultsBean> semanticResultsBeanList = new ArrayList<> ( );
        NLUResponseData.SemanticResultsBean semanticResultsBean = new NLUResponseData.SemanticResultsBean ( );

        List<NLUResponseData.SemanticResultsBean.IntentsBean> intentsBeanList = new ArrayList<> ( );
        NLUResponseData.SemanticResultsBean.IntentsBean intentsBean = new NLUResponseData.SemanticResultsBean.IntentsBean ( );

        String domain = perspicaceNLUResponseData.getData ( ).getTopScene ( );
        String mapDomain = DomainMap.domainMap.get ( domain );
        if (StringUtils.isEmpty ( mapDomain ))
            intentsBean.setDomain ( domain );
        else {
            intentsBean.setDomain ( mapDomain );
        }
        intentsBean.setDomainConfidence ( perspicaceNLUResponseData.getData ( ).getTopScore ( ) );

        String intent = perspicaceNLUResponseData.getData ( ).getSuggest ( );
        if (null != intent) {
            String intents[] = intent.split ( "-" );
            if (intents.length > 1) {
                if (domain.equals ( intents[0] )) {
                    intent = intents[1];
                } else {
                    intent = Intent.PERSPICACE_NONE;
                }
            }
        }
        String mapIntent = IntentMap.INTENT_MAP.get ( intent );
        if (StringUtils.isEmpty ( mapIntent ))
            intentsBean.setIntent ( intent );
        else {
            intentsBean.setIntent ( mapIntent );
        }

        List<NLUResponseData.SemanticResultsBean.IntentsBean.SlotsBean> slotsBeanlist = new ArrayList<> ( );
        List<PerspicaceNLUResponseData.DataBean.EntitiesBean> entitiesBeanList = perspicaceNLUResponseData.getData ( ).getEntities ( );
        if (null != entitiesBeanList) {
            int entitySize = entitiesBeanList.size ( );
            for (int i = 0; i < entitySize; i++) {
                NLUResponseData.SemanticResultsBean.IntentsBean.SlotsBean slotsBean = new NLUResponseData.SemanticResultsBean.IntentsBean.SlotsBean ( );

                PerspicaceNLUResponseData.DataBean.EntitiesBean entitiesBean = entitiesBeanList.get ( i );
                String enName = entitiesBean.getEntityKey ( );
                String suggestion = entitiesBean.getSuggestion ( );
                String text = entitiesBean.getText ( );
                String type = entitiesBean.getType ( );

                // 百芝龙的原有type和微软的进行映射
                String mapType = EntityMap.ENTITY_MAP.get ( type );
                if (StringUtils.isEmpty ( mapType ))
                    slotsBean.setType ( type );
                else {
                    slotsBean.setType ( mapType );
                }
                if (suggestion != null) {
                    slotsBean.setNormalizedTextCN ( suggestion );
                } else {
                    slotsBean.setNormalizedTextCN ( text );
                }
                slotsBean.setImplicit ( false );
                slotsBean.setNormalizedTextEN ( enName );
                slotsBean.setText ( text );
                slotsBeanlist.add ( slotsBean );
            }
            intentsBean.setSlots ( slotsBeanlist );
        }
        intentsBeanList.add ( intentsBean );

        semanticResultsBean.setIntents ( intentsBeanList );
        semanticResultsBeanList.add ( semanticResultsBean );

        nluResponseData.setSemanticResults ( semanticResultsBeanList );
        nluResponseData.setMessage ( messageBean );
        return nluResponseData;
    }

    // 统一NLU处理结果
    private NLUResponseData unifyLUISResponse(String query , LUISResData luisResData , NLUResponseData nluResponseData) {
        NLUResponseData.MessageBean messageBean = new NLUResponseData.MessageBean ( );
        messageBean.setQuery ( query );
        String intent;
        String domain;

        List<NLUResponseData.SemanticResultsBean> semanticResultsBeanList = new ArrayList<> ( );
        NLUResponseData.SemanticResultsBean semanticResultsBean = new NLUResponseData.SemanticResultsBean ( );

        List<NLUResponseData.SemanticResultsBean.IntentsBean> intentsBeanList = new ArrayList<> ( );
        NLUResponseData.SemanticResultsBean.IntentsBean intentsBean = new NLUResponseData.SemanticResultsBean.IntentsBean ( );

        LUISResData.TopScoringIntentBean intentBean = luisResData.getTopScoringIntent ( );
        String[] domain_intent = luisResData.getTopScoringIntent ( ).getIntent ( ).split ( "\\." );
        domain = domain_intent[0];
        if (domain_intent.length > 1) {
            intent = domain_intent[1];
        } else {
            intent = domain_intent[0];
        }
        String mapDomain = DomainMap.domainMap.get ( domain );
        if (StringUtils.isEmpty ( mapDomain ))
            intentsBean.setDomain ( domain );
        else {
            intentsBean.setDomain ( mapDomain );
        }

        String mapIntent = IntentMap.INTENT_MAP.get ( intent );
        if (StringUtils.isEmpty ( mapIntent ))
            intentsBean.setIntent ( intent );
        else {
            intentsBean.setIntent ( mapIntent );
        }
        intentsBean.setDomainConfidence ( intentBean.getScore ( ) );
        intentsBean.setIntentConfidence ( intentBean.getScore ( ) );

        List<NLUResponseData.SemanticResultsBean.IntentsBean.SlotsBean> slotsBeanlist = new ArrayList<> ( );
        List<LUISResData.EntitiesBean> entitiesBeanList = luisResData.getEntities ( );
        if (null != entitiesBeanList) {
            int entitySize = entitiesBeanList.size ( );
            for (int i = 0; i < entitySize; i++) {
                NLUResponseData.SemanticResultsBean.IntentsBean.SlotsBean slotsBean = new NLUResponseData.SemanticResultsBean.IntentsBean.SlotsBean ( );
                LUISResData.EntitiesBean entitiesBean = entitiesBeanList.get ( i );
                if (entitiesBean.getResolution ( ) != null) {
                    List<String> strings = entitiesBean.getResolution ( ).getValues ( );
                    String entityKey = strings.get ( 0 );
                    slotsBean.setNormalizedTextEN ( entityKey );       // 英文的统一称呼
                }
//                String suggestion = entitiesBean.getSuggestion ( );
                String text = entitiesBean.getEntity ( );
                String type = entitiesBean.getType ( );
//
                // 百芝龙的原有type和微软的进行映射
                String mapType = EntityMap.ENTITY_MAP.get ( type );
                if (StringUtils.isEmpty ( mapType ))
                    slotsBean.setType ( type );
                else {
                    slotsBean.setType ( mapType );
                }

                slotsBean.setImplicit ( false );
                slotsBean.setNormalizedTextCN ( text );
                slotsBean.setText ( text );
                slotsBeanlist.add ( slotsBean );
            }
            intentsBean.setSlots ( slotsBeanlist );
        }
        intentsBeanList.add ( intentsBean );

        semanticResultsBean.setIntents ( intentsBeanList );
        semanticResultsBeanList.add ( semanticResultsBean );

        nluResponseData.setSemanticResults ( semanticResultsBeanList );
        nluResponseData.setMessage ( messageBean );
        return nluResponseData;
    }

    /**
     * @Description:组织封装单个的文本解析bean 百芝龙原有包含Query , Domain.intent , entityMap
     * @Param:
     * @return:
     * @Author: Destiny
     * @Date: 2018/7/12
     */
    public IntentEntity generateIntentEntityData(String query , NLUResponseData.SemanticResultsBean.IntentsBean
            intentsBean) {
        IntentEntity intentEntity = new IntentEntity ( query , intentsBean.getDomain ( ) , intentsBean.getIntent ( ) );
        intentEntity.addEntity ( Entity.OPERATE , intentsBean.getIntent ( ) );

        if (intentsBean != null) {
            int slotSize = intentsBean.getSlots ( ).size ( );
            for (int k = 0; k < slotSize; k++) {
                String type = intentsBean.getSlots ( ).get ( k ).getType ( );
                String text = intentsBean.getSlots ( ).get ( k ).getText ( );
                String normalizationEN = intentsBean.getSlots ( ).get ( k ).getNormalizedTextEN ( );
                String enText = intentsBean.getSlots ( ).get ( k ).getNormalizedTextEN ( );
                // 统一成英文
                if (enText != null) {
                    text = enText;
                }
                Boolean implicit = intentsBean.isImplicit ( );
                intentEntity.addEntity ( type , text );
                intentEntity.addEntity ( type + "__normalizedText" , normalizationEN );
                intentEntity.addEntity ( "implicit" , String.valueOf ( implicit ) );
            }
        }
        return intentEntity;
    }

}
