package com.perspicace.ai.deepbot.nlu.model;

import java.io.Serializable;

public class NLUInputData implements Serializable {


    /**
     * AppID : BZL
     * AccessToken : A89AA045-3ABA-4D01-B6D0-12FC7617285A
     * Message : {"Query":"电视声音大一点"}
     * Market : zh-CN
     * Language : zh-CN
     * Mode : 0
     * Context : {}
     * User : {"ID":"fafdaaa","Nickname":"xxxx","BirthDate":"1997-01-01T00:00:00","Gender":1}
     * Device : {"ID":"xxxxxxxxx","GroupId":"xaaaaa","Make":"xxxxxx","Model":"xxxxxxxxxxx","DeviceIP":"123.1.1.1","TimeZone":"GMT+08:00","Location":{"Type":0,"Content":{"Latitude":41.2222,"Longitude":135.2222,"CountryCode":null,"Province":null,"City":null,"County":null,"Address":null,"PostalCode":null}},"OS":{"Name":"xxxxxxxxxxxxx","Version":"1.1"}}
     * Parameters : {"source":"edge web test","debug":true}
     * RequestInfo : {"TraceId":"de5a2f4e-1adc-4521-b455-c4525e149f25","UserAgent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/17.17134"}
     */

    private String AppID;
    private String AccessToken;
    private MessageBean Message;
    private String Market;
    private String Language;
    private int Mode;
    private ContextBean Context;
    private UserBean User;
    private DeviceBean Device;
    private ParametersBean Parameters;
    private RequestInfoBean RequestInfo;

    public String getAppID() {
        return AppID;
    }

    public void setAppID(String AppID) {
        this.AppID = AppID;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String AccessToken) {
        this.AccessToken = AccessToken;
    }

    public MessageBean getMessage() {
        return Message;
    }

    public void setMessage(MessageBean Message) {
        this.Message = Message;
    }

    public String getMarket() {
        return Market;
    }

    public void setMarket(String Market) {
        this.Market = Market;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public int getMode() {
        return Mode;
    }

    public void setMode(int Mode) {
        this.Mode = Mode;
    }

    public ContextBean getContext() {
        return Context;
    }

    public void setContext(ContextBean Context) {
        this.Context = Context;
    }

    public UserBean getUser() {
        return User;
    }

    public void setUser(UserBean User) {
        this.User = User;
    }

    public DeviceBean getDevice() {
        return Device;
    }

    public void setDevice(DeviceBean Device) {
        this.Device = Device;
    }

    public ParametersBean getParameters() {
        return Parameters;
    }

    public void setParameters(ParametersBean Parameters) {
        this.Parameters = Parameters;
    }

    public RequestInfoBean getRequestInfo() {
        return RequestInfo;
    }

    public void setRequestInfo(RequestInfoBean RequestInfo) {
        this.RequestInfo = RequestInfo;
    }

    public static class MessageBean {
        /**
         * Query : 电视声音大一点
         */

        private String Query;

        public String getQuery() {
            return Query;
        }

        public void setQuery(String Query) {
            this.Query = Query;
        }
    }

    public static class ContextBean {
    }

    public static class UserBean {
        /**
         * ID : fafdaaa
         * Nickname : xxxx
         * BirthDate : 1997-01-01T00:00:00
         * Gender : 1
         */

        private String ID;
        private String Nickname;
        private String BirthDate;
        private int Gender;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getNickname() {
            return Nickname;
        }

        public void setNickname(String Nickname) {
            this.Nickname = Nickname;
        }

        public String getBirthDate() {
            return BirthDate;
        }

        public void setBirthDate(String BirthDate) {
            this.BirthDate = BirthDate;
        }

        public int getGender() {
            return Gender;
        }

        public void setGender(int Gender) {
            this.Gender = Gender;
        }
    }

    public static class DeviceBean {
        /**
         * ID : xxxxxxxxx
         * GroupId : xaaaaa
         * Make : xxxxxx
         * Model : xxxxxxxxxxx
         * DeviceIP : 123.1.1.1
         * TimeZone : GMT+08:00
         * Location : {"Type":0,"Content":{"Latitude":41.2222,"Longitude":135.2222,"CountryCode":null,"Province":null,"City":null,"County":null,"Address":null,"PostalCode":null}}
         * OS : {"Name":"xxxxxxxxxxxxx","Version":"1.1"}
         */

        private String ID;
        private String GroupId;
        private String Make;
        private String Model;
        private String DeviceIP;
        private String TimeZone;
        private LocationBean Location;
        private OSBean OS;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getGroupId() {
            return GroupId;
        }

        public void setGroupId(String GroupId) {
            this.GroupId = GroupId;
        }

        public String getMake() {
            return Make;
        }

        public void setMake(String Make) {
            this.Make = Make;
        }

        public String getModel() {
            return Model;
        }

        public void setModel(String Model) {
            this.Model = Model;
        }

        public String getDeviceIP() {
            return DeviceIP;
        }

        public void setDeviceIP(String DeviceIP) {
            this.DeviceIP = DeviceIP;
        }

        public String getTimeZone() {
            return TimeZone;
        }

        public void setTimeZone(String TimeZone) {
            this.TimeZone = TimeZone;
        }

        public LocationBean getLocation() {
            return Location;
        }

        public void setLocation(LocationBean Location) {
            this.Location = Location;
        }

        public OSBean getOS() {
            return OS;
        }

        public void setOS(OSBean OS) {
            this.OS = OS;
        }

        public static class LocationBean {
            /**
             * Type : 0
             * Content : {"Latitude":41.2222,"Longitude":135.2222,"CountryCode":null,"Province":null,"City":null,"County":null,"Address":null,"PostalCode":null}
             */

            private int Type;
            private ContentBean Content;

            public int getType() {
                return Type;
            }

            public void setType(int Type) {
                this.Type = Type;
            }

            public ContentBean getContent() {
                return Content;
            }

            public void setContent(ContentBean Content) {
                this.Content = Content;
            }

            public static class ContentBean {
                /**
                 * Latitude : 41.2222
                 * Longitude : 135.2222
                 * CountryCode : null
                 * Province : null
                 * City : null
                 * County : null
                 * Address : null
                 * PostalCode : null
                 */

                private double Latitude;
                private double Longitude;
                private String CountryCode;
                private String Province;
                private String City;
                private String County;
                private String Address;
                private String PostalCode;

                public double getLatitude() {
                    return Latitude;
                }

                public void setLatitude(double Latitude) {
                    this.Latitude = Latitude;
                }

                public double getLongitude() {
                    return Longitude;
                }

                public void setLongitude(double Longitude) {
                    this.Longitude = Longitude;
                }

                public String getCountryCode() {
                    return CountryCode;
                }

                public void setCountryCode(String CountryCode) {
                    this.CountryCode = CountryCode;
                }

                public String getProvince() {
                    return Province;
                }

                public void setProvince(String Province) {
                    this.Province = Province;
                }

                public String getCity() {
                    return City;
                }

                public void setCity(String City) {
                    this.City = City;
                }

                public String getCounty() {
                    return County;
                }

                public void setCounty(String County) {
                    this.County = County;
                }

                public String getAddress() {
                    return Address;
                }

                public void setAddress(String Address) {
                    this.Address = Address;
                }

                public String getPostalCode() {
                    return PostalCode;
                }

                public void setPostalCode(String PostalCode) {
                    this.PostalCode = PostalCode;
                }
            }
        }

        public static class OSBean {
            /**
             * Name : xxxxxxxxxxxxx
             * Version : 1.1
             */

            private String Name;
            private String Version;

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getVersion() {
                return Version;
            }

            public void setVersion(String Version) {
                this.Version = Version;
            }
        }
    }

    public static class ParametersBean {
        /**
         * source : edge web test
         * debug : true
         */

        private String source;
        private boolean debug;

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public boolean isDebug() {
            return debug;
        }

        public void setDebug(boolean debug) {
            this.debug = debug;
        }
    }

    public static class RequestInfoBean {
        /**
         * TraceId : de5a2f4e-1adc-4521-b455-c4525e149f25
         * UserAgent : Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/17.17134
         */

        private String TraceId;
        private String UserAgent;

        public String getTraceId() {
            return TraceId;
        }

        public void setTraceId(String TraceId) {
            this.TraceId = TraceId;
        }

        public String getUserAgent() {
            return UserAgent;
        }

        public void setUserAgent(String UserAgent) {
            this.UserAgent = UserAgent;
        }
    }
}

