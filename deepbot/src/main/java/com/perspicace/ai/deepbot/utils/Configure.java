package com.perspicace.ai.deepbot.utils;
/**
*@author energy
*@version 1.0.0 创建时间：2017年12月27日
*说明
**/

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@Component
@Slf4j
public class Configure {
    private static Properties config = null;
    static{
        loadProperties("response4cn.properties");
    }

    private static void loadProperties(String filePath){
    	config = new Properties();
    	InputStream in=null;
         try {
             ClassLoader CL = Configure.class.getClassLoader();
             if (CL != null) {
                 in = CL.getResourceAsStream(filePath);
             }else {
                 in = ClassLoader.getSystemResourceAsStream(filePath);
             }
             config.load(new InputStreamReader (in, "utf-8"));
         } catch (FileNotFoundException e) {
             log.error("服务器配置文件没有找到");
         } catch (Exception e) {
         	e.printStackTrace();
            log.error("服务器配置信息读取错误");
         }finally{
        	 if(in!=null){
        		 try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	 }
         }
    }
    
    public static String getValue(String key) {
        if (config.containsKey(key)) {
            String value = config.getProperty(key);
            return value;
        }else {
            return null;
        }
    }
    
    public static int getValueInt(String key) {
        String value = getValue(key);
        int valueInt = 0;
        try {
            valueInt = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return valueInt;
        }
        return valueInt;
    }    
}