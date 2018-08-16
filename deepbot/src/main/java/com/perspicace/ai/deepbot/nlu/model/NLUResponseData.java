package com.perspicace.ai.deepbot.nlu.model;

import java.io.Serializable;
import java.util.List;

/**
 * @program: deepbot
 * @description: 整合第三方及百芝龙语义解析结果
 * @author: Destiny
 * @create: 2018-06-28 17:13
 **/
public class NLUResponseData implements Serializable {
    /**
     * Message : {"Query":"放一首动漫歌曲","CorrectedQuery":null,"WordBrokenQuery":null}
     * SemanticResults : [{"Confidence":1,"Intents":[{"Segment":null,"SegmentConfidence":0,"Service":null,"Domain":"Music","DomainConfidence":1,"Intent":"play_media","IntentConfidence":1,"Implicit":false,"Slots":[{"Type":"keyword","Text":"动漫","entityKey":"kitchen","NormalizedText":null,"Implicit":false},{"Type":"type","Text":"歌曲","entityKey":"kitchen","NormalizedText":null,"Implicit":false}],"Data":null}],"MultiTurn":null}]
     */

    private MessageBean Message;
    private List<SemanticResultsBean> SemanticResults;

    public MessageBean getMessage() {
        return Message;
    }

    public void setMessage(MessageBean Message) {
        this.Message = Message;
    }

    public List<SemanticResultsBean> getSemanticResults() {
        return SemanticResults;
    }

    public void setSemanticResults(List<SemanticResultsBean> SemanticResults) {
        this.SemanticResults = SemanticResults;
    }

    public static class MessageBean {
        /**
         * Query : 放一首动漫歌曲
         * CorrectedQuery : null
         * WordBrokenQuery : null
         */

        private String Query;
        private String CorrectedQuery;
        private String WordBrokenQuery;

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

        public String getWordBrokenQuery() {
            return WordBrokenQuery;
        }

        public void setWordBrokenQuery(String WordBrokenQuery) {
            this.WordBrokenQuery = WordBrokenQuery;
        }
    }

    public static class SemanticResultsBean {
        /**
         * Confidence : 1
         * Intents : [{"Segment":null,"SegmentConfidence":0,"Service":null,"Domain":"Music","DomainConfidence":1,"Intent":"play_media","IntentConfidence":1,"Implicit":false,"Slots":[{"Type":"keyword","Text":"动漫","entityKey":"kitchen","NormalizedText":null,"Implicit":false},{"Type":"type","Text":"歌曲","entityKey":"kitchen","NormalizedText":null,"Implicit":false}],"Data":null}]
         * MultiTurn : null
         */

        private double Confidence;
        private String MultiTurn;
        private List<IntentsBean> Intents;

        public double getConfidence() {
            return Confidence;
        }

        public void setConfidence(double Confidence) {
            this.Confidence = Confidence;
        }

        public String getMultiTurn() {
            return MultiTurn;
        }

        public void setMultiTurn(String MultiTurn) {
            this.MultiTurn = MultiTurn;
        }

        public List<IntentsBean> getIntents() {
            return Intents;
        }

        public void setIntents(List<IntentsBean> Intents) {
            this.Intents = Intents;
        }

        public static class IntentsBean {
            /**
             * Segment : null
             * SegmentConfidence : 0
             * Service : null
             * Domain : Music
             * DomainConfidence : 1
             * Intent : play_media
             * IntentConfidence : 1
             * Implicit : false
             * Slots : [{"Type":"keyword","Text":"动漫","entityKey":"kitchen","NormalizedText":null,"Implicit":false},{"Type":"type","Text":"歌曲","entityKey":"kitchen","NormalizedText":null,"Implicit":false}]
             * Data : null
             */

            private String Segment;
            private double SegmentConfidence;
            private String Service;
            private String Domain;
            private double DomainConfidence;
            private String Intent;
            private double IntentConfidence;
            private boolean Implicit;
            private String Data;
            private List<SlotsBean> Slots;

            public String getSegment() {
                return Segment;
            }

            public void setSegment(String Segment) {
                this.Segment = Segment;
            }

            public double getSegmentConfidence() {
                return SegmentConfidence;
            }

            public void setSegmentConfidence(double SegmentConfidence) {
                this.SegmentConfidence = SegmentConfidence;
            }

            public String getService() {
                return Service;
            }

            public void setService(String Service) {
                this.Service = Service;
            }

            public String getDomain() {
                return Domain;
            }

            public void setDomain(String Domain) {
                this.Domain = Domain;
            }

            public double getDomainConfidence() {
                return DomainConfidence;
            }

            public void setDomainConfidence(double DomainConfidence) {
                this.DomainConfidence = DomainConfidence;
            }

            public String getIntent() {
                return Intent;
            }

            public void setIntent(String Intent) {
                this.Intent = Intent;
            }

            public double getIntentConfidence() {
                return IntentConfidence;
            }

            public void setIntentConfidence(double IntentConfidence) {
                this.IntentConfidence = IntentConfidence;
            }

            public boolean isImplicit() {
                return Implicit;
            }

            public void setImplicit(boolean Implicit) {
                this.Implicit = Implicit;
            }

            public String getData() {
                return Data;
            }

            public void setData(String Data) {
                this.Data = Data;
            }

            public List<SlotsBean> getSlots() {
                return Slots;
            }

            public void setSlots(List<SlotsBean> Slots) {
                this.Slots = Slots;
            }

            public static class SlotsBean {
                /**
                 * Type : keyword
                 * Text : 动漫
                 * entityKey : kitchen
                 * NormalizedText : null
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
    }


}
