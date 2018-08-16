package com.perspicace.ai.deepbot.service.impl;

import com.perspicace.ai.deepbot.common.constant.Actions;
import com.perspicace.ai.deepbot.common.constant.Electrical;
import com.perspicace.ai.deepbot.common.constant.ElectricalState;
import com.perspicace.ai.deepbot.common.constant.OperateIOMapping;
import com.perspicace.ai.deepbot.config.MyRabbitConfig;
import com.perspicace.ai.deepbot.domain.HomeDevice;
import com.perspicace.ai.deepbot.model.DeviceGroupData;
import com.perspicace.ai.deepbot.model.Slot4ControlDevice;
import com.perspicace.ai.deepbot.nlu.constant.Entity;
import com.perspicace.ai.deepbot.nlu.constant.Intent;
import com.perspicace.ai.deepbot.nlu.constant.Slot4Service;
import com.perspicace.ai.deepbot.nlu.model.NLUResponseData;
import com.perspicace.ai.deepbot.nlu.service.NLUService;
import com.perspicace.ai.deepbot.repository.RedisRepository;
import com.perspicace.ai.deepbot.service.BusinessServices;
import com.perspicace.ai.deepbot.utils.*;
import com.perspicace.gen.electricappliance.slice.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slice.BussinessServiceException;
import slice.ControlDeviceException;
import slice.ElectricGenJsonException;
import slice.NoAreaException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.perspicace.ai.deepbot.common.constant.OperateIOMapping.OPERATE_VALUE_IO_MAPPING;

/**
 * @program: deepbot
 * @description: 家电控制类
 * @author: Destiny
 * @create: 2018-07-12 11:34
 **/
@Service("controlDeviceService")
@Slf4j
public class ControlDeviceServiceImpl implements BusinessServices<Slot4ControlDevice, ElectricApplianceControlResult[], ElectricApplianceControlParam[]> {
    @Autowired
    private RedisRepository redisRepository;

    @Autowired
    private NLUService nluService;

    @Autowired
    private RemoteServiceImpl remoteService;

    @Autowired
    private MyRabbitConfig myRabbitConfig;

    private void appendLog(StringBuffer sb, String strlog) {
        sb.append("		" + strlog);
    }

    private void showLog(StringBuffer sb) {
        log.info(sb.toString());
    }

    @Override
    public String handleService(final String groupID, final String shdSn, final String shdID, final String sessionID, String query, NLUResponseData.SemanticResultsBean.IntentsBean intentsBean) {
        String resText = I18NUtil.getMessage("default_failue_0");
//        StringBuffer resStringBuffer = new StringBuffer ( );        // 组织回复内容
        StringBuffer stringBuffer = new StringBuffer();          // 记录日志内容
        try {
            long time1 = System.currentTimeMillis();
            String intent = intentsBean.getIntent();
            appendLog(stringBuffer, "controlDevice >> query= " + query + " intent=" + intent);
            DeviceGroupData deviceGroupData = remoteService.getDeviceGroupData(groupID);
//            DeviceGroupData deviceGroupData = remoteService.getTestDeviceGroupData ( groupID ); // 测试用
            List<Slot4ControlDevice> slot4ControlDeviceList = generateSlot4Service(sessionID, groupID, shdSn, deviceGroupData, intentsBean);
            int slotSize = slot4ControlDeviceList.size();
            for (int i = 0; i < slotSize; i++) {
                Slot4ControlDevice slot4ControlDevice = slot4ControlDeviceList.get(i);
                ElectricApplianceControlParam[] electricCommands = generateCommandObj(groupID, shdSn, deviceGroupData, intent, slot4ControlDevice);
                String notifyTxt = getNotifyString(groupID, shdSn, sessionID, slot4ControlDevice);
                long time2 = System.currentTimeMillis();
//                记录控制家电调用参数
                appendLog(stringBuffer, "\n 调用家电参数列表>>");
                for (int j = 0; j < electricCommands.length; j++) {
                    ElectricApplianceControlParam electricApplianceControlParam = electricCommands[i];
                    appendLog(stringBuffer, "ElectricApplianceId >>" + electricApplianceControlParam.ElectricApplianceId);
                    ElectricAppliancePressParam[] eps = electricApplianceControlParam.electricAppliancePressParamList;
                    for (int k = 0; k < eps.length; k++) {
                        ElectricAppliancePressParam ep = eps[j];
                        if (ep != null) {
                            appendLog(stringBuffer, "electricAppliancePressKeyEo >> " + ep.electricAppliancePressKeyEo);
                            appendLog(stringBuffer, "pressValue >> " + ep.pressValue);
                        } else {
                            appendLog(stringBuffer, "electricAppliancePressParamList[" + (j + 1) + "] >> null");
                        }
                    }
                }
                appendLog(stringBuffer, "\n 调用家电列表耗时>>  " + (time2 - time1));
                appendLog(stringBuffer, "\n 实际操作家电数量>>  " + electricCommands.length + " 个");
                ElectricApplianceControlResult[] electricApplianceControlResults = getServiceResults(groupID, shdSn, slot4ControlDevice, electricCommands);
                long time3 = System.currentTimeMillis();
                appendLog(stringBuffer, "\n 家电控制耗时>>  " + (time3 - time2));
                //控制家电组结果 暂时只获取第一个结果
                ElectricApplianceControlResult electricResult0 = electricApplianceControlResults[0];
                //操作成功
                if (electricResult0.result) {
                    //如果定制的回复不为空 则使用定制的回复
                    if (notifyTxt != null) {
                        resText = notifyTxt;
                    } else {
                        resText = I18NUtil.getMessage("default_success_2");
                    }
                } else {
                    resText = I18NUtil.getMessage("default_failue_0");
                }
                //记录家电组的控制结果
                String ss = "";
                for (int k = 0; k < electricApplianceControlResults.length; k++) {
                    ss += electricApplianceControlResults[k].result + "  ";
                }
                appendLog(stringBuffer, "\n 家电控制操作结果>>  " + ss);
            }
        } catch (ControlDeviceException e) {
            log.error(e.message);
        } catch (ElectricGenJsonException e) {
            resText = e.message;
            log.error(e.message);
        } catch (NoAreaException nae) {
            resText = I18NUtil.getMessage("devicecontrol_no_homeRegion");
        } catch (BussinessServiceException bse) {
            resText = I18NUtil.getMessage("devicecontrol_failue_ice");
        } catch (Exception e) {
            resText = I18NUtil.getMessage("devicecontrol_failue_exception");
        } finally {
            showLog(stringBuffer);
//            try {
//                //防止注入失败
//                if(myRabbitConfig!=null){
//                    //mqService.sendStringMessage(sb.toString());
//                    //rabbitTemplate.convertAndSend("log_queue",sb.toString());
//                    myRabbitConfig.sendStringMessage(sb.toString());
//                }else{
//                    logger.info("rabbitTemplate is null!");
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
        return resText;
    }


    @Override
    public List<Slot4ControlDevice> generateSlot4Service(final String sessionID, final String groupID, final String shdID, DeviceGroupData deviceGroupData, NLUResponseData.SemanticResultsBean.IntentsBean intentsBean) throws ControlDeviceException, ElectricGenJsonException, NoAreaException {
        List<Slot4ControlDevice> slot4ControlDeviceList = new ArrayList<>();
        String device;
        String floor;
        String homeRegion;
        String operate;
        String _operate; // 映射值
        String mode;
        String operateValue;
        String _operateValue; // 映射值
        String operateContent;
        String _operateContent; // 映射值

        operate = intentsBean.getIntent();
        if (operate == null) {
            // 后续可以结合传感器和家电状态以及用户画像进行操作方式补全
            throw new ControlDeviceException(I18NUtil.getMessage("devicecontrol_no_operate"));
        }
        List<String> slotOperateList = new ArrayList<>();
        List<String> slotDeviceList = new ArrayList<>();
        List<String> slotFloorList = new ArrayList<>();
        List<String> slotHomeRegionList = new ArrayList<>();
        List<String> slotModeList = new ArrayList<>();
        List<String> slotOperateValueList = new ArrayList<>();
        List<String> slotOperateContentList = new ArrayList<>();

        OToMoreMap<String, String> slotOToMoreMap = nluService.getSlot4Service(intentsBean, Slot4Service.DEVICE_CONTROL_SLOT_LiST);
        if (slotOToMoreMap != null) {
            long size = slotOToMoreMap.getSize();
            for (int i = 0; i < size; i++) {
                Map<String, List<String>> stringListMap = slotOToMoreMap.get(i);
                if (stringListMap.containsKey(Entity.DEVICE)) {
                    slotDeviceList = stringListMap.get(Entity.DEVICE);
                }
                if (stringListMap.containsKey(Entity.FLOOR)) {
                    slotFloorList = stringListMap.get(Entity.FLOOR);
                }
                if (stringListMap.containsKey(Entity.HOME_REGION)) {
                    slotHomeRegionList = stringListMap.get(Entity.HOME_REGION);
                }
                if (stringListMap.containsKey(Entity.OPERATE_MODE)) {
                    slotModeList = stringListMap.get(Entity.OPERATE_MODE);
                }
                if (stringListMap.containsKey(Entity.OPERATE_VALUE)) {
                    slotOperateValueList = stringListMap.get(Entity.OPERATE_VALUE);
                }
                if (stringListMap.containsKey(Entity.OPERATE_CONTENT)) {
                    slotOperateContentList = stringListMap.get(Entity.OPERATE_CONTENT);
                }
            }
        }
        slotOperateList.add(operate);
        if (Intent.SET_MODE_HEAT.equals(operate) || Intent.SET_MODE_COOL.equals(operate)) {
            for (int j = 0; j < slotOperateValueList.size(); j++) {
                if (NumUtil.isNumeric(slotOperateValueList.get(j))) {
                    slotOperateList.add(Intent.SET_MODE_TEMPERATURE);
                }
            }
        }
        int maxIndex = Math.max(slotOperateList.size(), Math.max(Math.max(Math.max(Math.max(slotHomeRegionList.size(), Math.max(slotDeviceList.size(), slotModeList.size())), slotOperateValueList.size()), slotOperateContentList.size()), slotFloorList.size()));
        for (int i = 0; i < maxIndex; i++) {
            Map<Object, Object> slotMap = redisRepository.hmget(sessionID);
            //先输入,防止list越界
            slotOperateList.add(operate);
            slotDeviceList.add(null);
            slotFloorList.add(null);
            slotHomeRegionList.add(null);
            slotModeList.add(null);
            slotOperateValueList.add(null);
            slotOperateContentList.add(null);

            device = slotDeviceList.get(i);
            floor = slotFloorList.get(i);
            homeRegion = slotHomeRegionList.get(i);
            mode = slotModeList.get(i);
            operate = slotOperateList.get(i);
            operateValue = slotOperateValueList.get(i);
            operateContent = slotOperateContentList.get(i);

            // 根据mode值进行意图补充
            String res = nluService.getMode2Intent(operate, mode);
            if (StringUtils.isNotEmpty(res)) {
                operate = res;
            }

            if (StringUtils.isEmpty(floor)) {
                HomeDevice homeDevice = getHomeRegionBySmartDeviceId(deviceGroupData, shdID);      // 根据墙机查找区域
                floor = homeDevice.getFloor();

                if (slotMap.containsKey(Entity.FLOOR) && floor == null) {
                    floor = (String) slotMap.get(Entity.FLOOR);
                }

                if (StringUtils.isEmpty(floor)) {
                    floor = "F1";
                }
            }
            if (floor != null) {
                Map<String, String> slot4Floor = new HashMap<>();
                slot4Floor.put(Entity.FLOOR, floor);
                nluService.saveNLUSlot2Cache(sessionID, slot4Floor, 2 * 60);
            }

            if (StringUtils.isEmpty(device)) {
                //根据操作方式补全
                device = Slot4Service.ACTION_DEVICE_MAPPING.get(operate);
                // 缓存中取得
                if (slotMap.containsKey(Entity.DEVICE) && device == null) {
                    device = (String) slotMap.get(Entity.DEVICE);
                }
                // 如果仍然为空，则返回
                if (StringUtils.isEmpty(device)) {
                    throw new ControlDeviceException(I18NUtil.getMessage("devicecontrol_no_device_0"));
                }
            }
            if (device != null) {
                Map<String, String> slot4deviceStr = new HashMap<>();
                slot4deviceStr.put(Entity.DEVICE, device);
                nluService.saveNLUSlot2Cache(sessionID, slot4deviceStr, 2 * 60);
            }

            if (StringUtils.isEmpty(homeRegion)) {
                HomeDevice homeDevice = getHomeRegionBySmartDeviceId(deviceGroupData, shdID);      // 根据墙机查找区域
                homeRegion = homeDevice.getHomeregion();

                if (slotMap.containsKey(Entity.HOME_REGION) && homeRegion == null) {
                    homeRegion = (String) slotMap.get(Entity.HOME_REGION);
                }

                if (StringUtils.isEmpty(homeRegion)) {
                    throw new NoAreaException(I18NUtil.getMessage("devicecontrol_no_homeRegion"));
                }
            }
            if (homeRegion != null) {
                Map<String, String> slot4HomeRegion = new HashMap<>();
                slot4HomeRegion.put(Entity.HOME_REGION, homeRegion);
                nluService.saveNLUSlot2Cache(sessionID, slot4HomeRegion, 2 * 60);
            }

            ///////
            if (StringUtils.isEmpty(operateValue)) {
                if (slotMap.containsKey(Entity.VALUE)) {
                    operateValue = (String) slotMap.get(Entity.VALUE);
                }
            }
            if (operateValue != null) {
                Map<String, String> slot4operateValueStr = new HashMap<>();
                slot4operateValueStr.put(Entity.VALUE, operateValue);
                nluService.saveNLUSlot2Cache(sessionID, slot4operateValueStr, 2 * 60);
            }

            if (StringUtils.isEmpty(operateContent)) {
                if (slotMap.containsKey(Entity.CONTENT)) {
                    operateContent = (String) slotMap.get(Entity.CONTENT);
                }
            }
            if (operateContent != null) {
                Map<String, String> slot4operateContentStr = new HashMap<>();
                slot4operateContentStr.put(Entity.CONTENT, operateContent);
                nluService.saveNLUSlot2Cache(sessionID, slot4operateContentStr, 2 * 60);
            }
            log.info("映射前 operate is " + operate + "  operateValue is " + operateValue);

            _operate = OperateIOMapping.OPERATE_IO_MAPPING.get(operate);
//            if (StringUtils.isNotEmpty ( _operate )) {
//                operate = _operate;
//            }
            if (operateValue != null) {
                if (Intent.SET_MODE_VOLUME.equals(operate)) {
                    _operateValue = OPERATE_VALUE_IO_MAPPING.get(Intent.SET_MODE_VOLUME + operateValue);
                } else {
                    _operateValue = OPERATE_VALUE_IO_MAPPING.get(operateValue);
                }
            } else {
                _operateValue = OPERATE_VALUE_IO_MAPPING.get(operate);
            }
//            if (StringUtils.isNotEmpty ( _operateValue )) {
//                operateValue = _operateValue;
//            }
            log.info("映射后 operate is " + _operate + "  operateValue is " + _operateValue);
            // 如果不是设置温度，但是缺少操作值，则返回提示
            if (Actions.OPERATE_FAN_SPEED.equals(operate) && operateValue == null) {
                log.info("缺少操作值...");
                throw new ControlDeviceException(I18NUtil.getMessage("devicecontrol_no_value"));
            }
            log.info("家电为----->" + device);
            log.info("楼层为----->" + floor);
            log.info("区域为----->" + homeRegion);
            log.info("操作模式为----->" + mode);
            log.info("操作值为----->" + operateValue);
            log.info("操作内容为----->" + operateContent);
            Slot4ControlDevice slot4ControlDevice = new Slot4ControlDevice(device, floor, homeRegion, operate, operateValue, operateContent, mode);
            slot4ControlDevice.set_operate(_operate);
            slot4ControlDevice.set_operateValue(_operateValue);
            slot4ControlDeviceList.add(slot4ControlDevice);
        }
        return slot4ControlDeviceList;
    }


    @Override
    public ElectricApplianceControlResult[] getServiceResults(final String groupID, final String smartDeviceId, Slot4ControlDevice slot4ControlDevice, ElectricApplianceControlParam[] electricCommands) throws ElectricGenJsonException, BussinessServiceException {
        ElectricApplianceControlResult[] results = controlElectric(groupID, electricCommands);
        return results;
    }

    @Override
    public String getNotifyString(String groupId, String smartDeviceId, String sessionID, Slot4ControlDevice slot4ControlDevice) {
        String reText = null;
        String device = slot4ControlDevice.getDevice();
        String deviceTxt = I18NUtil.getMessage(device);   // 获取设备名称
        String operate = slot4ControlDevice.getOperate();             // 映射前的值    fanS
        String operateTxt = I18NUtil.getMessage(operate);   //
        String operateValue = slot4ControlDevice.getOperateValue();   // 映射前的值    +

        if (Electrical.TELEVISION.equals(device) || (Electrical.LAMP.equals(device))) {//电视操作
            boolean isNight = DateUtil.isNight();
            if (operateValue.equals(Actions.OPEN)) {
                if (isNight) {
                    reText = I18NUtil.getMessage("night_turn_on_0");
                }
            } else if (operateValue.equals(Actions.CLOSE)) {
                if (isNight) {
                    reText = I18NUtil.getMessage("night_turn_off_0", deviceTxt);
                }
            }
        } else if ((Electrical.AIRCONDITION.equals(device) || Electrical.CENTRAL_AIRCONDITION.equals(device))) {
            if (StringUtils.isNotEmpty(operateTxt)) {
                reText = I18NUtil.getMessage("devicecontrol_aircondition_mode_0", operateTxt);//已切换到<指定>模式
            } else {
                reText = I18NUtil.getMessage("devicecontrol_aircondition_mode");//已切换到<指定>模式
            }
        }
        return reText;
    }

    /**
     * 判断是否是支持状态上报的家电种类
     *
     * @param electrical
     * @return
     */
    private boolean hasRealState(String electrical) {
        if (Electrical.LAMP.equals(electrical) || Electrical.FLOOR_HEATING.equals(electrical)
                || Electrical.VENTILATION.equals(electrical) || Electrical.CENTRAL_AIRCONDITION.equals(electrical)) {
            return true;
        }
        return false;
    }

    public ElectricApplianceControlParam[] generateCommandObj(final String groupID, final String shdSn, DeviceGroupData deviceGroupData, String intent, Slot4ControlDevice slot4ControlDevice) throws ControlDeviceException, ElectricGenJsonException, NoAreaException {
        //操作方式转成枚举
        String device = slot4ControlDevice.getDevice();
        String deviceTxt = I18NUtil.getMessage(device);   // 获取设备名称
//        String floor = slot4ControlDevice.getFloor ( );
//        String homeRegion = slot4ControlDevice.getHomeRegion ( );
        String operate = slot4ControlDevice.getOperate();             // 映射前的值    set_wind_speed
        String operateValue = slot4ControlDevice.getOperateValue();   // 映射前的值    +
        String _operate = slot4ControlDevice.get_operate();             // 映射后的值    fanSpeed
        String _operateValue = slot4ControlDevice.get_operateValue();   // 映射后的值    high
//        String operateContent = slot4ControlDevice.getOperateContent ( );
//        String pressKey;
        String pressValue = null;          // 实际按下的操作值
        int operateValueint = 24;
        if (StringUtils.isNotEmpty(operateValue) && NumUtil.isNumeric(operateValue)) {
            operateValueint = Integer.parseInt(operateValue);
        }

        // 找到该家庭中对应的家电设备 有可能是多个，比如电视甚至同一个区域有好几个
        List<HomeDevice> homeDeviceList = getHomeDeviceBeanList(deviceGroupData, slot4ControlDevice);
        if (homeDeviceList.size() <= 0) {
            throw new ControlDeviceException(I18NUtil.getMessage("devicecontrol_no_device"));
        }
//        else if (homeDeviceList.size ( ) > 1) {
//            throw new NoAreaException ( I18NUtil.getMessage ( "exception_no_homeRegion" ) );
//        }

        //合成家电指令组
        int deviceSize = homeDeviceList.size();
        ElectricApplianceControlParam[] electricApplianceControlParams = new ElectricApplianceControlParam[deviceSize];
        for (int i = 0; i < deviceSize; i++) {
            HomeDevice homeDevice = homeDeviceList.get(i);
            String deviceType = homeDevice.getKey();   //比如所有的灯都为lamp
            String state = homeDevice.getState();
            // 操作方式映射
            ElectricAppliancePressKeyEo electricAppliancePressKeyEo = ElectricAppliancePressKeyEo.valueOf(_operate);
            //如果直接对 中央 空调 地暖 新风进行模式操作 则先判断是否开启
            if (Electrical.FLOOR_HEATING.equals(deviceType) || Electrical.VENTILATION.equals(deviceType) || Electrical.CENTRAL_AIRCONDITION.equals(deviceType)) {
                if (electricAppliancePressKeyEo != ElectricAppliancePressKeyEo.io) {//不是打开操作
                    //如果是关着的，提醒用户先打开，后续自动先打开
                    if (ElectricalState.OFF.equals(state)) {
                        throw new ControlDeviceException(I18NUtil.getMessage("devicecontrol_suggest_0", new String[]{deviceTxt}));
                    }
                }
            }
            if (hasRealState(deviceType)) {
                if (Actions.OPERATE_VALUE_ON.equals(_operateValue) && ElectricalState.ON.equals(state)) {
                    throw new ControlDeviceException(I18NUtil.getMessage("devicecontrol_is_on_0", deviceTxt));
                } else if (Actions.OPERATE_VALUE_OFF.equals(_operateValue) && ElectricalState.OFF.equals(state)) {
                    throw new ControlDeviceException(I18NUtil.getMessage("devicecontrol_is_off_0", deviceTxt));
                }
            }
            // 操作值映射
            if (electricAppliancePressKeyEo == ElectricAppliancePressKeyEo.io) {//开关
                ElectricApplianceIoEo electricApplianceIoEo = ElectricApplianceIoEo.valueOf(_operateValue);
                pressValue = String.valueOf(electricApplianceIoEo.value());
                log.info(pressValue);
            } else if (electricAppliancePressKeyEo == ElectricAppliancePressKeyEo.mode) {//空调模式  就要从原operate中取得对应的操控值
                ElectricApplianceModeEo electricApplianceModeEo = ElectricApplianceModeEo.valueOf(OPERATE_VALUE_IO_MAPPING.get(operate));
                pressValue = String.valueOf(electricApplianceModeEo.value());
                log.info(pressValue);
            } else if (electricAppliancePressKeyEo == ElectricAppliancePressKeyEo.fanSpeed) {//风速
                ElectricApplianceFanSpeedEo electricApplianceFanSpeedEo = ElectricApplianceFanSpeedEo.valueOf(_operateValue);
                pressValue = String.valueOf(electricApplianceFanSpeedEo.value());
                log.info(pressValue);
            } else if (electricAppliancePressKeyEo == ElectricAppliancePressKeyEo.temperature) {//调温度
                //调温度的时候 操作值是增量的 没有数值 则需要自己计算温度值
                if (Actions.OPERATE_VALUE_HIGH.equals(_operateValue) || Actions.OPERATE_VALUE_LOW.equals(_operateValue)) {
                    String temperature = homeDevice.getExpand().getTemperature();
                    int int_temperature = (int) Float.parseFloat(temperature);
                    //如果当前空调已经是最高温度或者最低温度
                    if (int_temperature <= 16) {
                        throw new ControlDeviceException(I18NUtil.getMessage("devicecontrol_lowest_temperature"));//当前温度已经最低
                    } else if (int_temperature >= 30) {
                        throw new ControlDeviceException(I18NUtil.getMessage("devicecontrol_highest_temperature"));//当前温度已经最低
                    }

                    if (Actions.OPERATE_VALUE_HIGH.equals(_operateValue)) {
                        int_temperature += 2;
                    } else if (Actions.OPERATE_VALUE_LOW.equals(_operateValue)) {
                        int_temperature -= 2;
                    }

                    if (int_temperature < 16) {
                        int_temperature = 16;
                    } else if (int_temperature > 30) {
                        int_temperature = 30;
                    }
                    pressValue = String.valueOf(int_temperature);
                } else {
                    if (operateValue == null) {
                        log.info("设置温度 没解析到operateValue 程序设置为24度");
                        operateValue = "24";
                        operateValueint = Integer.parseInt(operateValue);
                    }
                    if (operateValueint < 16) {
                        operateValue = "16";
                    } else if (operateValueint > 30) {
                        operateValue = "30";
                    }
                    pressValue = operateValue;//温度值为具体的数值
                }

            } else if (electricAppliancePressKeyEo == ElectricAppliancePressKeyEo.tvControl) {//电视控制
                ElectricApplianceTvControlKey electricApplianceTvControlKey = ElectricApplianceTvControlKey.valueOf(_operateValue);
                pressValue = electricApplianceTvControlKey.name();//电视控制传枚举的key 而不是value
            }

            //电视的开关操作类型不能为io  为tvControl
            if (electricAppliancePressKeyEo == ElectricAppliancePressKeyEo.io && Electrical.TELEVISION.equals(deviceType)) {
                pressValue = ElectricApplianceTvControlKey.power.name();
                electricAppliancePressKeyEo = ElectricAppliancePressKeyEo.tvControl;
            }
            log.info("映射到ICE接口的操作方式为---->" + electricAppliancePressKeyEo + "	pressValue===" + pressValue);
            String deviceID = homeDevice.getId();
            log.info("待操作设备ID为---->" + deviceID);
            //家电
            ElectricApplianceControlParam electricApplianceControlParam = new ElectricApplianceControlParam();
            electricApplianceControlParam.ElectricApplianceId = deviceID;//家电ID
            //指令列表
            ElectricAppliancePressParam[] electricAppliancePressParams = new ElectricAppliancePressParam[deviceSize];
            ElectricAppliancePressParam electricAppliancePressParam = new ElectricAppliancePressParam();
            //指令类型
            electricAppliancePressParam.electricAppliancePressKeyEo = electricAppliancePressKeyEo;
            //指令值
            electricAppliancePressParam.pressValue = pressValue;
            electricAppliancePressParams[0] = electricAppliancePressParam;
            electricApplianceControlParam.electricAppliancePressParamList = electricAppliancePressParams;
            // 完成指令
            electricApplianceControlParams[i] = electricApplianceControlParam;
        }
        log.info("--------------------------------generateCommandObj end ---------------------------------");
        return electricApplianceControlParams;
    }

    public ElectricApplianceControlResult[] controlElectric(String groupId, ElectricApplianceControlParam[] electricApplianceControlParam) {
        try {
//            ElectricApplianceControlResult[] results = ControlDeviceIceInvoke.getElectricApplianceControlServicePrx ( ).electricApplianceControl ( groupId , electricApplianceControlParam );
            ElectricApplianceControlResult[] results = IceInvoker.getElectricApplianceControlServicePrx().electricApplianceControl(groupId, electricApplianceControlParam);
            return results;
        } catch (BussinessServiceException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据设备名称查找该设备 ，如果该家庭有多个同样的设备，返回设备列表
     *
     * @param
     * @return
     */

    public List<HomeDevice> getHomeDeviceBeanList(DeviceGroupData deviceGroupData, Slot4ControlDevice slot4ControlDevice) {
        String deviceName = slot4ControlDevice.getDevice();
        String homeRegion = slot4ControlDevice.getHomeRegion();
        String floor = slot4ControlDevice.getFloor();
        List<HomeDevice> homeDeviceList = new ArrayList<>();      // 实际家庭中带操控的具体设备
        if (deviceGroupData != null) {
            List<DeviceGroupData.FloorBean> floorBeanList = deviceGroupData.getFloor();
            int floorSize = floorBeanList.size();
            for (int i = 0; i < floorSize; i++) {
                DeviceGroupData.FloorBean floorBean = floorBeanList.get(i);
                String cnFloor = floorBean.getName();  //F1
                String enFloor = floorBean.getKey();  //F1
                List<DeviceGroupData.FloorBean.AreaBean> areaBeanList = floorBean.getArea();
                int areaSize = areaBeanList.size();
                for (int j = 0; j < areaSize; j++) {
                    String enAreaName = areaBeanList.get(j).getKey();
                    List<DeviceGroupData.FloorBean.AreaBean.DeviceBean> deviceBeanList = areaBeanList.get(j).getDevice();
                    String cnHomeRegion = areaBeanList.get(j).getName();   // 中文的区域名称
                    String enHomeregion = areaBeanList.get(j).getKey();
                    int deviceSize = deviceBeanList.size();
                    for (int k = 0; k < deviceSize; k++) {
                        String name = deviceBeanList.get(k).getName();   // 中文名称
                        String enDeviceName = deviceBeanList.get(k).getEnName(); //英文名字
                        String id = deviceBeanList.get(k).getId();
                        String type = deviceBeanList.get(k).getKey();  // 英文的type 设备组 比如lamp 同时防止设备自定义昵称
                        String state = deviceBeanList.get(k).getState();
                        DeviceGroupData.FloorBean.AreaBean.DeviceBean.ExpandBean expandBean = deviceBeanList.get(k).getExpand();
                        HomeDevice homeDevice = new HomeDevice(id, enFloor, enHomeregion, type, name, enDeviceName, state, expandBean);
                        // 需要防止名称未被统一到英文
                        if ((enDeviceName.equals(deviceName) || name.equals(deviceName))
                                && (enFloor.equals(floor) || cnFloor.equals(floor))
                                && (enHomeregion.equals(homeRegion) || cnHomeRegion.equals(homeRegion))) {
                            homeDeviceList.add(homeDevice);
                        } else if ((enDeviceName.equals(deviceName) || name.equals(deviceName))
                                && (enFloor.equals(floor) || cnFloor.equals(floor))
                                && (!enHomeregion.equals(homeRegion) || !cnHomeRegion.equals(homeRegion))) {
                            homeDeviceList.add(homeDevice);
                        }
                    }
                }
            }
            return homeDeviceList;
        }
        return homeDeviceList;
    }

    /**
     * 根据墙机id反查区域
     *
     * @param
     * @return 家庭区域的英文名字或者
     */
    public HomeDevice getHomeRegionBySmartDeviceId(DeviceGroupData deviceGroupData, final String _smartDeviceId) {
        HomeDevice homeDevice = new HomeDevice();
        String homeRegion;
        if (deviceGroupData != null) {
            List<DeviceGroupData.FloorBean> floorBeanList = deviceGroupData.getFloor();
            int floorSize = floorBeanList.size();
            for (int i = 0; i < floorSize; i++) {
                DeviceGroupData.FloorBean floorBean = floorBeanList.get(i);
                String floorName = floorBean.getName();
                String floorEnName = floorBean.getKey();
                List<DeviceGroupData.FloorBean.AreaBean> areaBeanList = floorBean.getArea();
                int areaSize = areaBeanList.size();
                for (int j = 0; j < areaSize; j++) {
                    String areaNameEn = areaBeanList.get(j).getKey();
                    String areaName = areaBeanList.get(j).getName();
                    List<String> smartDeviceList = areaBeanList.get(j).getSmart_device();
                    if (smartDeviceList == null) {
                        continue;
                    }
                    int shdSize = smartDeviceList.size();
                    for (int k = 0; k < shdSize; k++) {
                        String smartDeviceID = smartDeviceList.get(k);
                        if (_smartDeviceId.equals(smartDeviceID)) {
                            homeRegion = areaNameEn;   //返回英文区域名字
                            homeDevice.setHomeregion(homeRegion);
                            homeDevice.setFloor(floorEnName);
                            return homeDevice;
                        }
                    }
                }
            }
        }
        return homeDevice;
    }
}