package com.perspicace.ai.deepbot.test;

import com.perspicace.ai.deepbot.nlu.constant.Domain;
import com.perspicace.ai.deepbot.utils.Configure;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: deepbot
 * @description: 测试小函数
 * @author: Destiny
 * @create: 2018-07-01 21:12
 **/
@Slf4j
public class test implements Domain {

    public static void main(String[] args) {
//        String intent = "set_mode";
//        String mode = "你好";
//
//        if (Intent.SET_MODE.equals ( intent )) {
//            intent = MODE_INTENT_MAP.get ( mode );
//        }
//        log.info ( intent );
        String res = Configure.getValue ( "error10001" );
        log.info ( res );

        List<String> list = new ArrayList<> (  );
        Map<String,String> map = new HashMap<> (  );
        map.put ( "111","nihao " );

        log.info ( map.get ( "2222" ) );




    }

}
