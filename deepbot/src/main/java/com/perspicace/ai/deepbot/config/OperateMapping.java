package com.perspicace.ai.deepbot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "operatemapping", ignoreUnknownFields = false)
@PropertySource("classpath:operatemapping.properties")
@Component
public class OperateMapping {
    private Map<String, String> operatemappingMaps;

    private Map<String, String> operatemappingValueMaps;

    public String getOperateKey(String key) {
        return operatemappingMaps.get ( key );
    }

    public String getOperateValue(String key) {
        return operatemappingValueMaps.get ( key );
    }

    public Map<String, String> getOperatemappingMaps() {
        return operatemappingMaps;
    }

    public void setOperatemappingMaps(Map<String, String> operatemappingMaps) {
        this.operatemappingMaps = operatemappingMaps;
    }

    public Map<String, String> getOperatemappingValueMaps() {
        return operatemappingValueMaps;
    }

    public void setOperatemappingValueMaps(Map<String, String> operatemappingValueMaps) {
        this.operatemappingValueMaps = operatemappingValueMaps;
    }
}
