package com.perspicace.ai.deepbot.test;

import com.perspicace.ai.deepbot.nlu.constant.Domain;
import com.perspicace.ai.deepbot.utils.OToMoreMap;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: deepbot
 * @description: 测试小函数
 * @author: Destiny
 * @create: 2018-07-01 21:12
 **/
@Slf4j
public class test2 implements Domain {

    public static void main(String[] args) {
        OToMoreMap<String, String> slotMap = new OToMoreMap();
        slotMap.put ( "time","6" );
        slotMap.put ( "time","2" );
        slotMap.put ( "time","1" );
        slotMap.put ( "time","2" );
        slotMap.put ( "time","3" );
        slotMap.put ( "time","4" );
        slotMap.put ( "date","789" );

        System.out.println ( slotMap.getAll () );
        long size = slotMap.getSize ();
        for (int i = 0;i<size;i++){
            System.out.println (slotMap.get ( i ).get("time"));
        }

    }
}
