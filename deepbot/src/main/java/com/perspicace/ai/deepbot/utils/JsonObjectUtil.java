package com.perspicace.ai.deepbot.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.perspicace.ai.deepbot.nlu.model.NLUInputData;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* @Description:  
* @Param:  
* @return:  
* @Author: Destiny 
* @Date: 2018/6/26 
*/ 
@Component
public class JsonObjectUtil {

    private static JsonObjectUtil jsonObjectUtil;

    public synchronized static JsonObjectUtil getInstance() {
        if (jsonObjectUtil == null) {
            jsonObjectUtil = new JsonObjectUtil();
        }
        return jsonObjectUtil;
    }
    /*
     * 使用JsonObject生成json数据
     */
    public String JsonObject() {
        JSONObject json = new JSONObject();
        Object nullobj = null;
        try {
            json.put("name", "杨旭");
            json.put("age", 22.5);
            json.put("birthday", "1995-08-18");
            json.put("school", "山东蓝翔");
            json.put("major", new String[] { "理发", "挖掘机" });
            json.put("has_girlfriend", false);
            json.put("car", nullobj);
            json.put("house", nullobj);
            json.put("comment", "这是一个注释!");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String JSON = json.toString(); // 将json格式转为字符串
        return JSON;
    }

    /*
     * 通过HashMap构建JSON数据
     */
    public String CreateJsonByMap() {
        Map<String, Object> json = new HashMap<String, Object>();
        Object nullobj = null;
        json.put("name", "杨旭");
        json.put("age", 22.5);
        json.put("birthday", "1995-08-18");
        json.put("school", "山东蓝翔");
        json.put("major", new String[] { "理发", "挖掘机" });
        json.put("has_girlfriend", false);
        json.put("car", nullobj);
        json.put("house", nullobj);
        json.put("comment", "这是一个注释!");

        return (new JSONObject(json).toString());
    }

//    /*
//     * 通过JavaBean构建JSON
//     */
//    public String CreateJsonByBean() {
//        Person user = new Person();
//        user.setName("杨旭");
//        user.setAge(22.5);
//        user.setBirthday("1995-08-18");
//        user.setSchool("山东蓝翔");
//        user.setMajor(new String []{"理发", "挖掘机"});
//        user.setHas_girlfriend(false);
//        user.setCar(null);
//        user.setHouse(null);
//        user.setComment("这是一个注释!");
//        user.setIgnore("不能看见我!");
//
////		Gson gson = new Gson();
//        //个性化生成json
//        GsonBuilder builder = new GsonBuilder();
//        builder.setPrettyPrinting();
//        //生成json过程中做处理
//        builder.setFieldNamingStrategy(new FieldNamingStrategy(){
//            @Override
//            public String translateName(Field f) {
//                // TODO Auto-generated method stub
//                if(f.getName().equals("name")){
//                    return "Name";
//                }
//                return f.getName();
//            }
//
//        });
//        //个性化创建json,格式化
//        Gson gson = builder.create();
//        String json = gson.toJson(user);
//        return (json);
//    }

    /*
     * 通过JavaBean构建JSON
     */
    public String CreateJsonRootBean() {
        NLUInputData.UserBean user = new NLUInputData.UserBean();
        user.setBirthDate("1997-01-01T00:00:00");
        user.setGender(1);
        user.setNickname("xxxx");

        user.setID("user");


        NLUInputData.DeviceBean.LocationBean.ContentBean locationContent = new NLUInputData.DeviceBean.LocationBean.ContentBean ();
        locationContent.setLatitude(41.2222);
        locationContent.setLongitude(135.2222);
        locationContent.setAddress ( null );
        locationContent.setCity ( null );
        locationContent.setCountryCode ( null );
        locationContent.setCounty ( null );
        locationContent.setProvince ( null );
        locationContent.setPostalCode ( null );

        NLUInputData.DeviceBean.LocationBean location = new NLUInputData.DeviceBean.LocationBean();
        location.setContent (locationContent);
        location.setType(0);

        NLUInputData.DeviceBean.OSBean deviceOS = new NLUInputData.DeviceBean.OSBean();
        deviceOS.setName("xxxxxxxxxxxxx");
        deviceOS.setVersion("1.1");

        NLUInputData.DeviceBean device = new NLUInputData.DeviceBean();
        device.setMake("xxxxxx");
        device.setModel("xxxxxxxxxxx");
        device.setTimeZone("GMT+08:00");
        device.setDeviceIP("123.1.1.1");
        device.setLocation(location);
        device.setOS(deviceOS);
        device.setLocation (location);
        device.setID("xxxxxxxxx");


        NLUInputData InputDataBean = new NLUInputData ();
        InputDataBean.setAppID("a");
        InputDataBean.setAccessToken("a");

        NLUInputData.MessageBean messageBean = new NLUInputData.MessageBean();
        messageBean.setQuery ( "放一首动漫歌曲" );
        InputDataBean.setMessage ( messageBean );
        InputDataBean.setLanguage("zh-CN");
        InputDataBean.setMarket("zh-CN");
        InputDataBean.setMode(0);
        InputDataBean.setUser(user);
        InputDataBean.setDevice(device);

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String json = gson.toJson(InputDataBean);

        return (json);
    }


    public String CreateJsonByBean(Object object) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
                //生成json过程中做处理
//        builder.setFieldNamingStrategy(new FieldNamingStrategy (){
//            @Override
//            public String translateName(Field f) {
//                // TODO Auto-generated method stub
//                if(f.getName().equals("name")){
//                    return "Name";
//                }
//                return f.getName();
//            }
//
//        });
        Gson gson = builder.create();
        String json = gson.toJson(object);

        return (json);
    }


    public <T> T CreateBeanByJson(String json,Class<T> object){
        Gson gson = new GsonBuilder().create();
        T jsonRootBean = gson.fromJson(json, object);
        return jsonRootBean;
    }


    public <T> List<T> parseString2List(String json,Class clazz) {
        Type type = new ParameterizedTypeImpl(clazz);
        List<T> list =  new Gson().fromJson(json, type);
        return list;
    }

    private  class ParameterizedTypeImpl implements ParameterizedType {
        Class clazz;

        public ParameterizedTypeImpl(Class clz) {
            clazz = clz;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{clazz};
        }

        @Override
        public Type getRawType() {
            return List.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }
}
