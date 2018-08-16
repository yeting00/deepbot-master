package com.perspicace.ai.deepbot.model;

/**
 * @program: deepbot
 * @description: 情景模式控制词槽
 * @author: Destiny
 * @create: 2018-08-12 20:06
 **/
public class Slot4SceneMode {
    private String sceneModeName;
    private String sceneModeEnName;
    private String sceneModeID;
    private String groupID;

    public Slot4SceneMode(String sceneModeID , String groupID) {
        this.sceneModeID = sceneModeID;
        this.groupID = groupID;
    }

    public String getSceneModeName() {
        return sceneModeName;
    }

    public void setSceneModeName(String sceneModeName) {
        this.sceneModeName = sceneModeName;
    }

    public String getSceneModeEnName() {
        return sceneModeEnName;
    }

    public void setSceneModeEnName(String sceneModeEnName) {
        this.sceneModeEnName = sceneModeEnName;
    }

    public String getSceneModeID() {
        return sceneModeID;
    }

    public void setSceneModeID(String sceneModeID) {
        this.sceneModeID = sceneModeID;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }
}
