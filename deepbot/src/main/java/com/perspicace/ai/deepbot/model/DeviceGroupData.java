package com.perspicace.ai.deepbot.model;

import java.io.Serializable;
import java.util.List;

/**
 * @program: deepbot
 * @description: 家庭设备大json
 * @author: Destiny
 * @create: 2018-06-29 18:02
 **/
public class DeviceGroupData implements Serializable {

    /**
     * floor : [{"area":[{"device":[{"enName":"door_lock","expand":{"mode":"3","temperature":"16.00","wind_speed":"2"},"id":"20","key":"door_lock","name":"智能门锁","state":"OFF"}],"id":"1","key":"entrance","name":"玄关","smart_device":["XXXXXX"]},{"device":[{"enName":"xiding_lamp","expand":{},"id":"1","key":"lamp","name":"吸顶灯","state":"OFF"},{"enName":"ventilation","expand":{},"id":"7","key":"ventilation","name":"新风","state":"ON"},{"enName":"tube_lamp","expand":{},"id":"8","key":"lamp","name":"筒灯","state":"ON"},{"enName":"tube_lamp","expand":{},"id":"9","key":"lamp","name":"筒灯","state":"ON"},{"enName":"central_aircondition","expand":{"mode":"3","temperature":"16.00","wind_speed":"2"},"id":"15","key":"central_aircondition","name":"中央空调","state":"ON"},{"enName":"television","expand":{},"id":"18","key":"television","name":"电视","state":"ON"},{"enName":"aircondition","expand":{},"id":"19","key":"aircondition","name":"空调","state":"ON"},{"enName":"aircondition","expand":{},"id":"29","key":"aircondition","name":"空调","state":"ON"},{"enName":"aircondition","expand":{},"id":"30","key":"aircondition","name":"空调","state":"ON"},{"enName":"oven","expand":{},"id":"32","key":"oven","name":"烤箱","state":"OFF"}],"id":"2","key":"livingroom","name":"客厅","smart_device":["B44BD6630D56","28EDE01FE71B"]},{"device":[{"enName":"top_lamp","expand":{},"id":"2","key":"lamp","name":"顶灯","state":"OFF"},{"enName":"ceiling_lamp","expand":{},"id":"3","key":"lamp","name":"吊灯","state":"OFF"},{"enName":"light_bulb","expand":{},"id":"22","key":"lamp","name":"灯泡","state":"OFF"},{"enName":"light_bulb","expand":{},"id":"23","key":"lamp","name":"灯泡","state":"OFF"}],"id":"3","key":"toilet","name":"卫生间","smart_device":["484848","28EDE01FE6D8"]},{"device":[],"id":"5","key":"secondToilet","name":"次卫","smart_device":["AC35EE2A244D"]},{"device":[{"enName":"ceiling_lamp","expand":{},"id":"4","key":"lamp","name":"吊灯","state":"OFF"},{"enName":"wall_lamp","expand":{},"id":"5","key":"lamp","name":"壁灯","state":"OFF"},{"enName":"floorHeating","expand":{"temperature":"29.00"},"id":"6","key":"floorHeating","name":"地暖","state":"ON"},{"enName":"top_lamp","expand":{},"id":"10","key":"lamp","name":"顶灯","state":"OFF"},{"enName":"spot_lamp","expand":{},"id":"11","key":"lamp","name":"射灯","state":"OFF"},{"enName":"central_aircondition","expand":{"mode":"3","temperature":"19.00","wind_speed":"1"},"id":"21","key":"central_aircondition","name":"中央空调","state":"OFF"}],"id":"6","key":"bedroom","name":"卧室","smart_device":["000D6F000E887ED4"]},{"device":[],"id":"8","key":"mainRoom","name":"主卧","smart_device":["28EDE01FDF9A"]}],"id":"1","key":"F1","name":"一层"}]
     * sceneModels : [{"aiControlShd":"9","enName":"go_home_model","id":"10","name":"回家"},{"aiControlShd":"","enName":"leave_home_model","id":"9","name":"离家"},{"aiControlShd":"9","enName":"all_close_model","id":"8","name":"全关"},{"aiControlShd":"9","enName":"all_open_model","id":"7","name":"全开"},{"aiControlShd":"9","enName":"go_home_model","id":"3","name":"回家"},{"aiControlShd":"","enName":"leave_home_model","id":"2","name":"离家"},{"aiControlShd":"","enName":"go_home_model","id":"1","name":"回家"}]
     * code : 1000
     * msg : 家庭不存在
     */

    private String code;
    private String msg;
    private List<FloorBean> floor;
    private List<SceneModelsBean> sceneModels;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<FloorBean> getFloor() {
        return floor;
    }

    public void setFloor(List<FloorBean> floor) {
        this.floor = floor;
    }

    public List<SceneModelsBean> getSceneModels() {
        return sceneModels;
    }

    public void setSceneModels(List<SceneModelsBean> sceneModels) {
        this.sceneModels = sceneModels;
    }

    public static class FloorBean {
        /**
         * area : [{"device":[{"enName":"door_lock","expand":{"mode":"3","temperature":"16.00","wind_speed":"2"},"id":"20","key":"door_lock","name":"智能门锁","state":"OFF"}],"id":"1","key":"entrance","name":"玄关","smart_device":["XXXXXX"]},{"device":[{"enName":"xiding_lamp","expand":{},"id":"1","key":"lamp","name":"吸顶灯","state":"OFF"},{"enName":"ventilation","expand":{},"id":"7","key":"ventilation","name":"新风","state":"ON"},{"enName":"tube_lamp","expand":{},"id":"8","key":"lamp","name":"筒灯","state":"ON"},{"enName":"tube_lamp","expand":{},"id":"9","key":"lamp","name":"筒灯","state":"ON"},{"enName":"central_aircondition","expand":{"mode":"3","temperature":"16.00","wind_speed":"2"},"id":"15","key":"central_aircondition","name":"中央空调","state":"ON"},{"enName":"television","expand":{},"id":"18","key":"television","name":"电视","state":"ON"},{"enName":"aircondition","expand":{},"id":"19","key":"aircondition","name":"空调","state":"ON"},{"enName":"aircondition","expand":{},"id":"29","key":"aircondition","name":"空调","state":"ON"},{"enName":"aircondition","expand":{},"id":"30","key":"aircondition","name":"空调","state":"ON"},{"enName":"oven","expand":{},"id":"32","key":"oven","name":"烤箱","state":"OFF"}],"id":"2","key":"livingroom","name":"客厅","smart_device":["B44BD6630D56","28EDE01FE71B"]},{"device":[{"enName":"top_lamp","expand":{},"id":"2","key":"lamp","name":"顶灯","state":"OFF"},{"enName":"ceiling_lamp","expand":{},"id":"3","key":"lamp","name":"吊灯","state":"OFF"},{"enName":"light_bulb","expand":{},"id":"22","key":"lamp","name":"灯泡","state":"OFF"},{"enName":"light_bulb","expand":{},"id":"23","key":"lamp","name":"灯泡","state":"OFF"}],"id":"3","key":"toilet","name":"卫生间","smart_device":["484848","28EDE01FE6D8"]},{"device":[],"id":"5","key":"secondToilet","name":"次卫","smart_device":["AC35EE2A244D"]},{"device":[{"enName":"ceiling_lamp","expand":{},"id":"4","key":"lamp","name":"吊灯","state":"OFF"},{"enName":"wall_lamp","expand":{},"id":"5","key":"lamp","name":"壁灯","state":"OFF"},{"enName":"floorHeating","expand":{"temperature":"29.00"},"id":"6","key":"floorHeating","name":"地暖","state":"ON"},{"enName":"top_lamp","expand":{},"id":"10","key":"lamp","name":"顶灯","state":"OFF"},{"enName":"spot_lamp","expand":{},"id":"11","key":"lamp","name":"射灯","state":"OFF"},{"enName":"central_aircondition","expand":{"mode":"3","temperature":"19.00","wind_speed":"1"},"id":"21","key":"central_aircondition","name":"中央空调","state":"OFF"}],"id":"6","key":"bedroom","name":"卧室","smart_device":["000D6F000E887ED4"]},{"device":[],"id":"8","key":"mainRoom","name":"主卧","smart_device":["28EDE01FDF9A"]}]
         * id : 1
         * key : F1
         * name : 一层
         */

        private String id;
        private String key;
        private String name;
        private List<AreaBean> area;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<AreaBean> getArea() {
            return area;
        }

        public void setArea(List<AreaBean> area) {
            this.area = area;
        }

        public static class AreaBean {
            /**
             * device : [{"enName":"door_lock","expand":{"mode":"3","temperature":"16.00","wind_speed":"2"},"id":"20","key":"door_lock","name":"智能门锁","state":"OFF"}]
             * id : 1
             * key : entrance
             * name : 玄关
             * smart_device : ["XXXXXX"]
             */

            private String id;
            private String key;
            private String name;
            private List<DeviceBean> device;
            private List<String> smart_device;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<DeviceBean> getDevice() {
                return device;
            }

            public void setDevice(List<DeviceBean> device) {
                this.device = device;
            }

            public List<String> getSmart_device() {
                return smart_device;
            }

            public void setSmart_device(List<String> smart_device) {
                this.smart_device = smart_device;
            }

            public static class DeviceBean {
                /**
                 * enName : door_lock
                 * expand : {"mode":"3","temperature":"16.00","wind_speed":"2"}
                 * id : 20
                 * key : door_lock
                 * name : 智能门锁
                 * state : OFF
                 */

                private String enName;
                private ExpandBean expand;
                private String id;
                private String key;
                private String name;
                private String state;

                public String getEnName() {
                    return enName;
                }

                public void setEnName(String enName) {
                    this.enName = enName;
                }

                public ExpandBean getExpand() {
                    return expand;
                }

                public void setExpand(ExpandBean expand) {
                    this.expand = expand;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public static class ExpandBean {
                    /**
                     * mode : 3
                     * temperature : 16.00
                     * wind_speed : 2
                     */

                    private String mode;
                    private String temperature;
                    private String wind_speed;

                    public String getMode() {
                        return mode;
                    }

                    public void setMode(String mode) {
                        this.mode = mode;
                    }

                    public String getTemperature() {
                        return temperature;
                    }

                    public void setTemperature(String temperature) {
                        this.temperature = temperature;
                    }

                    public String getWind_speed() {
                        return wind_speed;
                    }

                    public void setWind_speed(String wind_speed) {
                        this.wind_speed = wind_speed;
                    }
                }
            }
        }
    }

    public static class SceneModelsBean {
        /**
         * aiControlShd : 9
         * enName : go_home_model
         * id : 10
         * name : 回家
         */

        private String aiControlShd;
        private String enName;
        private String id;
        private String name;

        public String getAiControlShd() {
            return aiControlShd;
        }

        public void setAiControlShd(String aiControlShd) {
            this.aiControlShd = aiControlShd;
        }

        public String getEnName() {
            return enName;
        }

        public void setEnName(String enName) {
            this.enName = enName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
