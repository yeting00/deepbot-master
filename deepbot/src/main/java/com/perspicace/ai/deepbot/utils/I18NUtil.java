package com.perspicace.ai.deepbot.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@Slf4j
public class I18NUtil {

	public static ThreadLocal<Map<String, String>> ctxLocal = new ThreadLocal<Map<String, String>>();
	protected static MessageSourceAccessor accessor;
	protected static MessageSource messageSource;
	protected static Set<String> set = new HashSet<String>();
	static ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
	// 静态块初始化资源
	static {
		addLocation("classpath*:locales/*.properties");
	}

	// 初始化资源文件的存储器
	protected static void initMessageSourceAccessor() {
		String[] basenames = new String[set.size()];
		set.toArray(basenames);
		ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
		reloadableResourceBundleMessageSource.setBasenames(basenames);
		reloadableResourceBundleMessageSource.setCacheSeconds(5);
		accessor = new MessageSourceAccessor(reloadableResourceBundleMessageSource);
		messageSource = reloadableResourceBundleMessageSource;
	}

	// 移除指定位置的资源
	public static void removeLocation(String locationPattern) {
		try {
			Resource[] resources = resourcePatternResolver.getResources(locationPattern);
			for (int i = 0; i < resources.length; i++) {
				String url = resources[i].getURL().toString();
				int lastIndex = url.lastIndexOf("/");
				String prefix = url.substring(0, lastIndex + 1);
				String suffix = url.substring(lastIndex + 1);
				suffix = suffix.split("\\.")[0].split("_")[0];
				set.remove(prefix + suffix);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		initMessageSourceAccessor();
	}

	// 加载指定位置的资源文件
	public static void addLocation(String locationPattern) {
		try {
			Resource[] resources = resourcePatternResolver.getResources(locationPattern);
			for (int i = 0; i < resources.length; i++) {
				String url = resources[i].getURL().toString();
				int lastIndex = url.lastIndexOf("/");
				String prefix = url.substring(0, lastIndex + 1);
				String suffix = url.substring(lastIndex + 1);
				suffix = suffix.split("\\.")[0].split("_")[0];
				set.add(prefix + suffix);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		initMessageSourceAccessor();
	}

	private I18NUtil() {
	}

	public static String getMessage(String code) {
		try{
			return accessor.getMessage(code, I18NUtil.getLocaleFromRequest() );
		}catch (NoSuchMessageException e){
			log.info("NoSuchMessageException...");
			return null;
		}
	}

	public static String getMessage(String code, String defaultMessage) {
		return accessor.getMessage(code, defaultMessage, I18NUtil.getLocaleFromRequest() );
	}

	public static String getMessage(String code, Object[] args) {
		try{
			return accessor.getMessage(code, args, I18NUtil.getLocaleFromRequest() );
		}catch (NoSuchMessageException e){
			log.info("NoSuchMessageException...");
			return null;
		}
	}

	public static String getMessage(String code, Object[] args, String defaultMessage) {
		return accessor.getMessage(code, args, defaultMessage, I18NUtil.getLocaleFromRequest() );
	}

	public static MessageSource getMessageSource() {
		return messageSource;
	}

	public static Locale getLocaleFromRequest() {
		Map<String, String> ctx = I18NUtil.ctxLocal.get();
		String str =  "zh_CN";
		if(ctx != null)
			 str = ctx.get("lang");
		if (str == null){
			str = "zh_CN";
		}
		str = str.replace("-", "_");
		String[] p = StringUtils.split(str, "_");
		switch (p.length) {
			case 2:
				return new Locale(p[0], p[1]);
			case 3:
				return new Locale(p[0], p[1], p[2]);
			default:
				return new Locale(p[0]);
		}
	}
}