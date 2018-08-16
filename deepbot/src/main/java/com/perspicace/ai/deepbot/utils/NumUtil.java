package com.perspicace.ai.deepbot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: deepbot
 * @description: 进行数字方面的处理
 * @author: Destiny
 * @create: 2018-08-10 23:38
 **/
public class NumUtil {
    public static boolean isNumeric(String str) {
        if(str == null){
            return false;
        }
        Pattern pattern = Pattern.compile ( "[0-9]*" );
        Matcher isNum = pattern.matcher ( str );
        if (!isNum.matches ( )) {
            return false;
        }
        return true;
    }
}
