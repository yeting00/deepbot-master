package com.perspicace.ai.deepbot.utils;

import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;

@Component
public class StringUtil {

	/**
	 * 	将words中的带”{name}“ 替换成map中你需要的值
	 * @param words 回复语料
	 * @param map	需要替换的回复语料键值对
	 * @return
	 */
	public static String replaceTheWords(String words, Map<String, String> map) {
		System.out.println(words);
		Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, String> entry = entries.next();
			if(null!=entry.getValue()) {
				words = words.replace("{" + entry.getKey() + "}", entry.getValue());
			}else {
				words = words.replace("{" + entry.getKey() + "}", "");
			}
		}
		return words;

	}
}
