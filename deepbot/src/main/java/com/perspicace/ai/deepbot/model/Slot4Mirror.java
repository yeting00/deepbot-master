package com.perspicace.ai.deepbot.model;

/**
 * @program: deepbot
 * @description: 魔镜用词槽信息
 * @author: Destiny
 * @create: 2018-08-09 17:32
 **/
public class Slot4Mirror {
    private String intent;
    private String personName;
    private String applicationName;
    private String content;

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
