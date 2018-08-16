package com.perspicace.ai.deepbot.nlu.service.impl;

import com.perspicace.ai.deepbot.nlu.model.ContextData;
import com.perspicace.ai.deepbot.repository.CommonRedisDao;
import com.perspicace.ai.deepbot.repository.RedisRepository;
import com.perspicace.ai.deepbot.utils.JsonObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 构建上下文会话管理类 （参照xbb代码）
 * @Param:
 * @return:
 * @Author: Destiny
 * @Date: 2018/7/9
 */
@Service("SessionService")
@Slf4j
public class SessionServiceImpl {
    @Autowired
    private CommonRedisDao commonRedisDao;
    @Autowired
    private RedisRepository redisRepository;

    public static final int listSize = -3;     // 保存三个会话

    public static final int itemTimeout = 20 * 60;//item expire time unit s

    public static final int listTimeout = 1 * 60;//list expore time  unit s

    public static final int ContextTimeout = 60 * 60; //上下文会话最多保存60s

    private final boolean checkExistIntent = false;//是否覆盖相同意图上下文

    /**
     * @Description: 保存会话内容，根据sessionId 保存
     * @Param: [sessionId , contextData]
     * @return: void
     * @Author: Destiny
     * @Date: 2018/7/9
     */
    public void saveContext(String sessionId , ContextData contextData) {
//        redisRepository.lSet ( sessionId , contextData , ContextTimeout );
        // 只保留listSize条上下文
//        long len = commonRedisDao.getListSize ( sessionId );
//        if (len >= listSize) {
//            commonRedisDao.removeOneOfList ( sessionId );
//        } else {
//            String contextStr = JsonObjectUtil.getInstance ( ).CreateJsonByBean ( contextData );
//            commonRedisDao.cacheList ( sessionId , contextStr , ContextTimeout );
//        }
        String contextStr = JsonObjectUtil.getInstance ( ).CreateJsonByBean ( contextData );
        commonRedisDao.cacheList ( sessionId , contextStr , ContextTimeout );

    }

    // 获取最近的contextData
    public ContextData getLastContext(String sessionId) {
        try {
            List<String> contextList = commonRedisDao.getList ( sessionId , -1 , -1 );
            if (contextList != null) {
                for (int i = contextList.size ( ) - 1; i >= 0; i--) {
                    String cachObjStr = contextList.get ( i );
                    ContextData contextData = JsonObjectUtil.getInstance ( ).CreateBeanByJson ( cachObjStr , ContextData.class );
                    return contextData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return null;
    }


    public List<ContextData> getContextList(String sessionId) {
        List<ContextData> contextDataList = new ArrayList<> ( );
        try {
            List<String> contextList = commonRedisDao.getList ( sessionId , listSize ,  -1 );
            if (contextList != null) {
                for (int i = 0; i < contextList.size ( ); i++) {
                    String cachObjStr = contextList.get ( i );
                    ContextData contextData = JsonObjectUtil.getInstance ( ).CreateBeanByJson ( cachObjStr , ContextData.class );
                    contextDataList.add ( contextData );
                }
            }
        } catch (Exception e) {
            log.error ( e.toString ( ) );
        }
        return contextDataList;
    }


    /**
     * 删除过期的对象 同时返回删除的数量
     * 不负责jedis的管理
     *
     * @param key
     * @return
     */
    public int clearExpireContext(String key) {
        long now = System.currentTimeMillis ( );
        int count = 0;
        List<String> contextList = commonRedisDao.getList ( key , 0 ,  - 1 );
        if (contextList != null) {
            for (int i = 0; i < contextList.size ( ); i++) {
                String cachObjStr = contextList.get ( i );
                ContextData contextData = JsonObjectUtil.getInstance ( ).CreateBeanByJson ( cachObjStr , ContextData.class );
                //过期
                if (now - contextData.getTime ( ) >= itemTimeout) {
                    //delete
//                    commonRedisDao.removeList ( key  );
                    commonRedisDao.removeListfValue ( key , 1 , cachObjStr );
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 从列表中查找有相同Domain属性的Context对象
     * 不负责jedis的管理
     *
     * @param key
     * @return
     */
    private ContextData findContextByIntent(String key , ContextData contextObj) {
        List<String> contextList = commonRedisDao.getList ( key , 0 ,  - 1 );
        if (contextList != null) {
            for (int i = 0; i < contextList.size ( ); i++) {
                String cachObjStr = contextList.get ( i );
                ContextData contextData = JsonObjectUtil.getInstance ( ).CreateBeanByJson ( cachObjStr , ContextData.class );
                if (contextData != null) {
                    if (contextData.getIntents ( ).getDomain ( ).equals ( contextObj.getIntents ( ).getDomain ( ) )) {
                        return contextData;
                    }
                }
            }
        }
        return null;
    }

    /**
     * 删除过期的对象
     * 对放入的内容进行检查 如果有重复 则删除原来的 将当前内容放入末尾
     * 放入列表末尾后删除列表的第一个元素 保持列表长度在 3
     *
     * @param key
     * @param contextData
     * @param clearExpire 是否检查过期的key并删除
     */
    public void checkAndSaveContext(String key , ContextData contextData , boolean clearExpire) {
        try {
            ContextData cachContextData = null;
            long now = System.currentTimeMillis ( );
            //设置上下文条目的时间
            contextData.setTime ( now );
            // 检查过期的删除
            if (clearExpire) {
                clearExpireContext ( key );
            }
            // 只保留listSize条上下文
            long len = commonRedisDao.getListSize ( key );

            if (len >= listSize) {
                commonRedisDao.removeOneOfList ( key );
            } else {
                saveContext ( key , contextData );
            }

        } catch (Exception e) {
            e.printStackTrace ( );
            log.error ( "保存上下文失败   " + e.getMessage ( ) );
        }
    }
}