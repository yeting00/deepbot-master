package com.perspicace.ai.deepbot.utils;

import java.util.UUID;

public class GenerateSessionID {
    // 构建唯一会话Id
    public static String getSessionId(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
    }

    public static void main(String[] args) {
        System.out.println(getSessionId());


    }
}
