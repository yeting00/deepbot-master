package com.perspicace.ai.deepbot.nlu.model;

import java.io.Serializable;
import java.util.List;

/**
 * @program: deepbot
 * @description: 缓存会话类
 * @author: Destiny
 * @create: 2018-06-28 12:05
 **/
public class ContextData implements Serializable {

    /**
     * SessionID : 123456
     * GroupID : 样板间
     * DeviceID : 888888
     * DeviceSN : xxxxxx
     * QueryDate : 2018-06-30T09:00:00
     * time : 1999889989
     * Query : 定个明天八点的闹钟
     * CorrectedQuery  : 定个明天八点的闹钟
     * Intents : {"Segment":"打开 厨房 和 卫生 间 的 空调","Domain":"devicecontrol","Intent":"turn_on_device","Implicit":false,"Slots":[{"Type":"location","Text":"厨房","Implicit":false},{"Type":"location","Text":"卫生 间","Implicit":false},{"Type":"device","Text":"空调","Implicit":false}]}
     * ResponseInfo : {"Response":"没问题","Suggest":{"Domain":"turn_on_device","Intent":"turn_on_device","Slots":[{"Type":"location","Text":"厨房"},{"Type":"location","Text":"卫生 间"},{"Type":"device","Text":"空调"}]}}
     */

    private String SessionID;
    private String GroupID;
    private String DeviceID;
    private String DeviceSN;
    private String QueryDate;
    private long time;
    private String Query;
    private String CorrectedQuery;
    private IntentsBean Intents;
    private ResponseInfoBean ResponseInfo;
    private boolean needContext;//是否需要上下文
    private String needEntityType;//需要的上下文实体类型


    public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String SessionID) {
        this.SessionID = SessionID;
    }

    public String getGroupID() {
        return GroupID;
    }

    public void setGroupID(String GroupID) {
        this.GroupID = GroupID;
    }

    public String getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(String DeviceID) {
        this.DeviceID = DeviceID;
    }

    public String getDeviceSN() {
        return DeviceSN;
    }

    public void setDeviceSN(String DeviceSN) {
        this.DeviceSN = DeviceSN;
    }

    public String getQueryDate() {
        return QueryDate;
    }

    public void setQueryDate(String QueryDate) {
        this.QueryDate = QueryDate;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getQuery() {
        return Query;
    }

    public void setQuery(String Query) {
        this.Query = Query;
    }

    public String getCorrectedQuery() {
        return CorrectedQuery;
    }

    public void setCorrectedQuery(String CorrectedQuery) {
        this.CorrectedQuery = CorrectedQuery;
    }

    public boolean isNeedContext() {
        return needContext;
    }

    public void setNeedContext(boolean needContext) {
        this.needContext = needContext;
    }

    public String getNeedEntityType() {
        return needEntityType;
    }

    public void setNeedEntityType(String needEntityType) {
        this.needEntityType = needEntityType;
    }

    public IntentsBean getIntents() {
        return Intents;
    }

    public void setIntents(IntentsBean Intents) {
        this.Intents = Intents;
    }

    public ResponseInfoBean getResponseInfo() {
        return ResponseInfo;
    }

    public void setResponseInfo(ResponseInfoBean ResponseInfo) {
        this.ResponseInfo = ResponseInfo;
    }

    public static class IntentsBean {
        /**
         * Segment : 打开 厨房 和 卫生 间 的 空调
         * Domain : devicecontrol
         * Intent : turn_on_device
         * Implicit : false
         * Slots : [{"Type":"location","Text":"厨房","Implicit":false},{"Type":"location","Text":"卫生 间","Implicit":false},{"Type":"device","Text":"空调","Implicit":false}]
         */

        private String Segment;
        private String Domain;
        private String Intent;
        private boolean Implicit;
        private List<SlotsBean> Slots;

        public String getSegment() {
            return Segment;
        }

        public void setSegment(String Segment) {
            this.Segment = Segment;
        }

        public String getDomain() {
            return Domain;
        }

        public void setDomain(String Domain) {
            this.Domain = Domain;
        }

        public String getIntent() {
            return Intent;
        }

        public void setIntent(String Intent) {
            this.Intent = Intent;
        }

        public boolean isImplicit() {
            return Implicit;
        }

        public void setImplicit(boolean Implicit) {
            this.Implicit = Implicit;
        }

        public List<SlotsBean> getSlots() {
            return Slots;
        }

        public void setSlots(List<SlotsBean> Slots) {
            this.Slots = Slots;
        }

        public static class SlotsBean {
            /**
             * Type : location
             * Text : 厨房
             * Implicit : false
             */

            private String Type;
            private String Text;
            private String NormalizedTextEN;
            private String NormalizedTextCN;
            private boolean Implicit;

            public String getType() {
                return Type;
            }

            public void setType(String Type) {
                this.Type = Type;
            }

            public String getText() {
                return Text;
            }

            public void setText(String Text) {
                this.Text = Text;
            }

            public String getNormalizedTextEN() {
                return NormalizedTextEN;
            }

            public void setNormalizedTextEN(String normalizedTextEN) {
                NormalizedTextEN = normalizedTextEN;
            }

            public String getNormalizedTextCN() {
                return NormalizedTextCN;
            }

            public void setNormalizedTextCN(String normalizedTextCN) {
                NormalizedTextCN = normalizedTextCN;
            }

            public boolean isImplicit() {
                return Implicit;
            }

            public void setImplicit(boolean Implicit) {
                this.Implicit = Implicit;
            }
        }
    }

    public static class ResponseInfoBean {
        /**
         * Response : 没问题
         * Suggest : {"Domain":"turn_on_device","Intent":"turn_on_device","Slots":[{"Type":"location","Text":"厨房"},{"Type":"location","Text":"卫生 间"},{"Type":"device","Text":"空调"}]}
         */

        private String Response;
        private SuggestBean Suggest;

        public String getResponse() {
            return Response;
        }

        public void setResponse(String Response) {
            this.Response = Response;
        }

        public SuggestBean getSuggest() {
            return Suggest;
        }

        public void setSuggest(SuggestBean Suggest) {
            this.Suggest = Suggest;
        }

        public static class SuggestBean {
            /**
             * Domain : turn_on_device
             * Intent : turn_on_device
             * Slots : [{"Type":"location","Text":"厨房"},{"Type":"location","Text":"卫生 间"},{"Type":"device","Text":"空调"}]
             */

            private String Domain;
            private String Intent;
            private List<SlotsBeanX> Slots;

            public String getDomain() {
                return Domain;
            }

            public void setDomain(String Domain) {
                this.Domain = Domain;
            }

            public String getIntent() {
                return Intent;
            }

            public void setIntent(String Intent) {
                this.Intent = Intent;
            }

            public List<SlotsBeanX> getSlots() {
                return Slots;
            }

            public void setSlots(List<SlotsBeanX> Slots) {
                this.Slots = Slots;
            }

            public static class SlotsBeanX {
                /**
                 * Type : location
                 * Text : 厨房
                 */

                private String Type;
                private String Text;

                public String getType() {
                    return Type;
                }

                public void setType(String Type) {
                    this.Type = Type;
                }

                public String getText() {
                    return Text;
                }

                public void setText(String Text) {
                    this.Text = Text;
                }
            }
        }
    }
}
