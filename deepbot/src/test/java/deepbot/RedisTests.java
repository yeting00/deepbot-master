package deepbot;

import com.perspicace.ai.deepbot.nlu.model.ContextData;
import com.perspicace.ai.deepbot.nlu.service.impl.PerspicaceNLUServiceImpl;
import com.perspicace.ai.deepbot.nlu.service.impl.SessionServiceImpl;
import com.perspicace.ai.deepbot.repository.CommonRedisDao;
import com.perspicace.ai.deepbot.repository.RedisRepository;
import com.perspicace.ai.deepbot.utils.JsonObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Component
@Slf4j
public class RedisTests {

    @Autowired
    private RedisRepository redisRepository;

    @Autowired
    private CommonRedisDao commonRedisDao;

    @Autowired
    private SessionServiceImpl sessionService;

    @Autowired
    private PerspicaceNLUServiceImpl perspicaceNLUService;

    @Test
    public void testRedisSerializer() {
        String sessionId = "123456";
//        List<String> personListStr = new ArrayList<> ( );
//        Person u = new Person ( );
//        u.setName ( "鲁进" );
//        u.setGender ( 0 );
//        String personStr = JsonObjectUtil.getInstance ( ).CreateJsonByBean ( u );
//        System.out.println ( personStr );
//        personListStr.add ( personStr );
//
//        redisRepository.lSet ( "lujin" , personListStr );
//        commonRedisDao.cacheList ( "person", personListStr);
//
        ContextData contextData = new ContextData();
        ContextData.IntentsBean contextIntentsBean = new ContextData.IntentsBean();
        contextIntentsBean.setIntent ( "testIntent" );
        contextIntentsBean.setDomain ( "testDomain" );
        contextData.setIntents ( contextIntentsBean );


        ContextData contextData1 = new ContextData();
        ContextData.IntentsBean contextIntentsBean1 = new ContextData.IntentsBean();
        contextIntentsBean1.setIntent ( "testInten2t" );
        contextIntentsBean1.setDomain ( "testDomai2n" );
        contextData1.setIntents ( contextIntentsBean1 );

        String contextStr = JsonObjectUtil.getInstance ( ).CreateJsonByBean ( contextData );
        String contextStr1 = JsonObjectUtil.getInstance ( ).CreateJsonByBean ( contextData1 );
//        commonRedisDao.removeListfValue ( sessionId,0, contextStr);  // 全部删除
//        commonRedisDao.removeListfValue ( sessionId,0, contextStr1);  // 全部删除

//        sessionService.saveContext ( sessionId , contextData );
//        List<ContextData> contextList = sessionService.getContextList ( sessionId );
//        if (contextList == null || contextList.isEmpty ( )) {
//            log.info("****************");
//        }

//        commonRedisDao.cacheList ( sessionId , contextStr , 60*60 );
//        commonRedisDao.cacheList ( sessionId , contextStr1 , 60*60 );
//        List<String> cachObjStrList1= commonRedisDao.getList ( sessionId,0,2 );
//        System.out.println ( cachObjStrList1 );
//        commonRedisDao.removeOneOfList ( sessionId );
//        commonRedisDao.removeListfValue ( sessionId,0, contextStr);
//        int i = sessionService.clearExpireContext ( sessionId );
//        log.info ( String.valueOf ( i ) );
        long size = commonRedisDao.getListSize ( sessionId );
        System.out.println ( size );

        List<String> cachObjStrList= commonRedisDao.getList ( sessionId,-2,-1 );
//        System.out.println ( cachObjStrList );
        for (String cachObjStr :cachObjStrList){
            System.out.println ( cachObjStr );
            ContextData obj = JsonObjectUtil.getInstance ( ).CreateBeanByJson ( cachObjStr , ContextData.class );
            System.out.println ( obj.getIntents ( ).getDomain () );
        }



//        for (int i = 0; i < personObjList.size ( ); i++) {
//            Object obj = personObjList.get ( i );
//            String res =  obj.toString () ;
//            System.out.println ( res );
//            Person p = JsonObjectUtil.getInstance ( ).CreateBeanByJson ( res , Person.class );
//            System.out.println ( p.getName ( ) );
//        }

//        redisRepository.set ( "user",u );
//        Person person = (Person)redisRepository.get ( "user" );
//        System.out.println ( personList1 );
//        Person user = (Person) redisRepository.get ( "user" );
//        System.out.println ( user.getName ( ) );

//        String text = "明天上海天气怎么样";
//        try {
//            IntentEntity intentEntity = perspicaceNLUService.getEntity ( text , null , null );
//            redisRepository.set ( "intentEntity" , intentEntity );
//            IntentEntity entityData1 = (IntentEntity) redisRepository.get ( "intentEntity" );
//            log.info ( entityData1.getDomain ( ) );
//        } catch (CustomerException ce) {
//            ce.getMessage ( );
//        }
    }
}
