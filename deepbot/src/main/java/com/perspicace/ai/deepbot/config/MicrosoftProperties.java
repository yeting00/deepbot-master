package com.perspicace.ai.deepbot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties("microsoft")
public class MicrosoftProperties {
    private String nluUrl;
    private String nluAppID;
    private String nluAccessToken;
    private String luisUrl;

    public String getNluUrl() {
        return nluUrl;
    }

    public void setNluUrl(String nluUrl) {
        this.nluUrl = nluUrl;
    }

    public String getNluAppID() {
        return nluAppID;
    }

    public String getNluAccessToken() {
        return nluAccessToken;
    }

    public void setNluAccessToken(String nluAccessToken) {
        this.nluAccessToken = nluAccessToken;
    }

    public void setNluAppID(String nluAppID) {

        this.nluAppID = nluAppID;
    }

    public String getLuisUrl() {
        return luisUrl;
    }

    public void setLuisUrl(String luisUrl) {
        this.luisUrl = luisUrl;
    }
}
