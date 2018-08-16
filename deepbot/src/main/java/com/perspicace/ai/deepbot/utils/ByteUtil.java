package com.perspicace.ai.deepbot.utils;

import org.springframework.stereotype.Component;

/**
*@author energy
*@version 1.0.0 创建时间：2017年9月6日
*说明
**/
@Component
public class ByteUtil {
	 public static int byte2Int(byte[] b) {
        int intValue = 0;
        for (int i = 0; i < b.length; i++) {
            intValue += (b[i] & 0xFF) << (8 * (3 - i));
        }
        return intValue;
	 }
}
