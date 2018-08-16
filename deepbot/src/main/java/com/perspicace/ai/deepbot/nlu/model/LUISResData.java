package com.perspicace.ai.deepbot.nlu.model;

import java.util.List;

/**
 * @program: deepbot
 * @description:
 * @author: Destiny
 * @create: 2018-07-28 04:28
 **/
public class LUISResData {

    /**
     * query : わたしはテレビを見ます
     * topScoringIntent : {"intent":"devicecontrol.turn_on_device","score":0.918870032}
     * entities : [{"entity":"テレビ","type":"device","startIndex":4,"endIndex":6,"resolution":{"values":["television"]}},{"entity":"わたし","type":"builtin.dimension","startIndex":0,"endIndex":2,"score":0.70422864},{"entity":"テレビ","type":"builtin.dimension","startIndex":4,"endIndex":6,"score":0.9147576},{"entity":"テレビ","type":"builtin.temperature","startIndex":4,"endIndex":6,"score":0.616418}]
     */
    private String query;
    private TopScoringIntentBean topScoringIntent;
    private List<EntitiesBean> entities;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public TopScoringIntentBean getTopScoringIntent() {
        return topScoringIntent;
    }

    public void setTopScoringIntent(TopScoringIntentBean topScoringIntent) {
        this.topScoringIntent = topScoringIntent;
    }

    public List<EntitiesBean> getEntities() {
        return entities;
    }

    public void setEntities(List<EntitiesBean> entities) {
        this.entities = entities;
    }

    public static class TopScoringIntentBean {
        /**
         * intent : devicecontrol.turn_on_device
         * score : 0.918870032
         */

        private String intent;
        private double score;

        public String getIntent() {
            return intent;
        }

        public void setIntent(String intent) {
            this.intent = intent;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }

    public static class EntitiesBean {
        /**
         * entity : テレビ
         * type : device
         * startIndex : 4
         * endIndex : 6
         * resolution : {"values":["television"]}
         * score : 0.70422864
         */

        private String entity;
        private String type;
        private int startIndex;
        private int endIndex;
        private ResolutionBean resolution;
        private double score;

        public String getEntity() {
            return entity;
        }

        public void setEntity(String entity) {
            this.entity = entity;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }

        public ResolutionBean getResolution() {
            return resolution;
        }

        public void setResolution(ResolutionBean resolution) {
            this.resolution = resolution;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public static class ResolutionBean {
            private List<String> values;

            public List<String> getValues() {
                return values;
            }

            public void setValues(List<String> values) {
                this.values = values;
            }
        }
    }
}
