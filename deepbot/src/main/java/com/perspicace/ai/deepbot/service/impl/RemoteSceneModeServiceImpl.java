package com.perspicace.ai.deepbot.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.perspicace.ai.deepbot.model.DeviceGroupData;
import com.perspicace.ai.deepbot.service.RemoteSceneModeService;
import com.perspicace.ai.deepbot.service.RemoteService;
import com.perspicace.ai.deepbot.utils.I18NUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slice.ElectricGenJsonException;
import slice.SceneModelException;

import java.util.List;


@Service("remoteSceneModeService")
public class RemoteSceneModeServiceImpl implements RemoteSceneModeService {
    @Autowired
    private RemoteService remoteService;

    @Override
    public String getSceneModeID(final String groupID , String sceneMode) throws ElectricGenJsonException, SceneModelException {
        JSONObject deviceinfoObj = remoteService.getRemoteDeviceJson ( groupID );
        JSONArray sceneModels = deviceinfoObj.getJSONArray ( "sceneModels" );
        if (sceneModels == null || sceneModels.size ( ) <= 0) {
            throw new SceneModelException ( I18NUtil.getMessage ( "devicecontrol_remotescenemode_failue" ) );//没有场景模式
        }
        boolean isFind = false;
        String sceneId = "";
        for (int i = 0; i < sceneModels.size ( ); i++) {
            JSONObject jobj = sceneModels.getJSONObject ( i );
            String enName = jobj.getString ( "enName" );

            if (enName.equals ( sceneMode )) {
                isFind = true;
                sceneId = jobj.getString ( "id" );
            }
        }
        if (!isFind) {
            throw new SceneModelException ( I18NUtil.getMessage ( "devicecontrol_remotescenemode_failue" ) );//没有这个场景模式
        }
        return sceneId;
    }

    @Override
    public JSONObject getSceneObj(String groupID , String sceneMode)
            throws ElectricGenJsonException, SceneModelException {

        JSONObject deviceinfoObj = remoteService.getRemoteDeviceJson ( groupID );
        JSONArray sceneModels = deviceinfoObj.getJSONArray ( "sceneModels" );
        if (sceneModels == null || sceneModels.size ( ) <= 0) {
            throw new SceneModelException ( I18NUtil.getMessage ( "devicecontrol_remotescenemode_failue" ) );//没有场景模式
        }
        boolean isFind = false;
        for (int i = 0; i < sceneModels.size ( ); i++) {
            JSONObject jobj = sceneModels.getJSONObject ( i );
            String enName = jobj.getString ( "enName" );

            if (enName.equals ( sceneMode )) {
                return jobj;
            }
        }

        if (!isFind) {
            throw new SceneModelException ( I18NUtil.getMessage ( "devicecontrol_remotescenemode_failue" ) );//没有这个场景模式
        }

        return null;
    }

    @Override
    public DeviceGroupData.SceneModelsBean getSceneModeBean(final String groupID , final String shdID , String sceneMode) throws ElectricGenJsonException, SceneModelException {
        DeviceGroupData deviceGroupData = remoteService.getDeviceGroupData ( groupID );
//        DeviceGroupData deviceGroupData = remoteService.getTestDeviceGroupData ( groupID );
        List<DeviceGroupData.SceneModelsBean> sceneModelsBeanList = deviceGroupData.getSceneModels ( );
        if (sceneModelsBeanList == null || sceneModelsBeanList.size ( ) <= 0) {
            throw new SceneModelException ( I18NUtil.getMessage ( "devicecontrol_remotescenemode_failue" ) );//没有场景模式
        } else {
            for (int i = 0; i < sceneModelsBeanList.size ( ); i++) {
                DeviceGroupData.SceneModelsBean sceneModelsBean = sceneModelsBeanList.get ( i );
                if (sceneMode.equals ( sceneModelsBean.getEnName ( ) ) && shdID.equals ( sceneModelsBean.getAiControlShd ( ) )) {
                    return sceneModelsBean;
                }
            }
        }
        return null;
    }

}
