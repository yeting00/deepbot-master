package com.perspicace.ai.deepbot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: deepbot
 * @description: 加载百芝龙的相关服务API
 * @author: Destiny
 * @create: 2018-06-28 16:36
 **/
@Component
@EnableConfigurationProperties
@ConfigurationProperties("perspicace")
public class PerspicaceProperties {
    private String knowledgeUrl;
    private String luisUrl;
    private String nluUrl;
    private String weatherUrl;

    public String getKnowledgeUrl() {
        return knowledgeUrl;
    }

    public void setKnowledgeUrl(String knowledgeUrl) {
        this.knowledgeUrl = knowledgeUrl;
    }

    public String getLuisUrl() {
        return luisUrl;
    }

    public void setLuisUrl(String luisUrl) {
        this.luisUrl = luisUrl;
    }

    public String getNluUrl() {
        return nluUrl;
    }

    public void setNluUrl(String nluUrl) {
        this.nluUrl = nluUrl;
    }

    public String getWeatherUrl() {
        return weatherUrl;
    }

    public void setWeatherUrl(String weatherUrl) {
        this.weatherUrl = weatherUrl;
    }
}
