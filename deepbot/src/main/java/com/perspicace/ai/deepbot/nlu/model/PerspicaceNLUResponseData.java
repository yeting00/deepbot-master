package com.perspicace.ai.deepbot.nlu.model;

import java.util.List;

/**
 * @program: deepbot
 * @description: 百芝龙AI语义解析结果
 * @author: Destiny
 * @create: 2018-06-28 16:59
 **/
public class PerspicaceNLUResponseData {

    /**
     * msg :
     * code : 200
     * data : {"topScene":"QueryWeather","topScore":0.9999966699643951,"suggest":"QueryWeather-weather","entities":[{"text":"上海","type":"city","entityKey":null,"suggestion":null},{"text":"今天","type":"time","entityKey":null,"suggestion":"2018-06-28T08:56:05"}]}
     */

    private String msg;
    private int code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * topScene : QueryWeather
         * topScore : 0.9999966699643951
         * suggest : QueryWeather-weather
         * entities : [{"text":"上海","type":"city","entityKey":null,"suggestion":null},{"text":"今天","type":"time","entityKey":null,"suggestion":"2018-06-28T08:56:05"}]
         */

        private String topScene;
        private double topScore;
        private String suggest;
        private List<EntitiesBean> entities;

        public String getTopScene() {
            return topScene;
        }

        public void setTopScene(String topScene) {
            this.topScene = topScene;
        }

        public double getTopScore() {
            return topScore;
        }

        public void setTopScore(double topScore) {
            this.topScore = topScore;
        }

        public String getSuggest() {
            return suggest;
        }

        public void setSuggest(String suggest) {
            this.suggest = suggest;
        }

        public List<EntitiesBean> getEntities() {
            return entities;
        }

        public void setEntities(List<EntitiesBean> entities) {
            this.entities = entities;
        }

        public static class EntitiesBean {
            /**
             * text : 上海
             * type : city
             * entityKey : null
             * suggestion : null
             */

            private String text;
            private String type;
            private String entityKey;
            private String suggestion;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getEntityKey() {
                return entityKey;
            }

            public void setEntityKey(String entityKey) {
                this.entityKey = entityKey;
            }

            public String getSuggestion() {
                return suggestion;
            }

            public void setSuggestion(String suggestion) {
                this.suggestion = suggestion;
            }
        }
    }

}
