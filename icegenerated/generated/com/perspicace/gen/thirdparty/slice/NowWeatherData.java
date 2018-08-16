// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.3
//
// <auto-generated>
//
// Generated from file `thirdparty.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.perspicace.gen.thirdparty.slice;

public class NowWeatherData implements java.lang.Cloneable, java.io.Serializable
{
    public AqiDetailData aqiDetail;

    public String sd;

    public String temperature;

    public String windDirection;

    public String windPower;

    public NowWeatherData()
    {
        aqiDetail = new AqiDetailData();
        sd = "";
        temperature = "";
        windDirection = "";
        windPower = "";
    }

    public NowWeatherData(AqiDetailData aqiDetail, String sd, String temperature, String windDirection, String windPower)
    {
        this.aqiDetail = aqiDetail;
        this.sd = sd;
        this.temperature = temperature;
        this.windDirection = windDirection;
        this.windPower = windPower;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        NowWeatherData _r = null;
        if(rhs instanceof NowWeatherData)
        {
            _r = (NowWeatherData)rhs;
        }

        if(_r != null)
        {
            if(aqiDetail != _r.aqiDetail)
            {
                if(aqiDetail == null || _r.aqiDetail == null || !aqiDetail.equals(_r.aqiDetail))
                {
                    return false;
                }
            }
            if(sd != _r.sd)
            {
                if(sd == null || _r.sd == null || !sd.equals(_r.sd))
                {
                    return false;
                }
            }
            if(temperature != _r.temperature)
            {
                if(temperature == null || _r.temperature == null || !temperature.equals(_r.temperature))
                {
                    return false;
                }
            }
            if(windDirection != _r.windDirection)
            {
                if(windDirection == null || _r.windDirection == null || !windDirection.equals(_r.windDirection))
                {
                    return false;
                }
            }
            if(windPower != _r.windPower)
            {
                if(windPower == null || _r.windPower == null || !windPower.equals(_r.windPower))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 5381;
        __h = IceInternal.HashUtil.hashAdd(__h, "::slice::NowWeatherData");
        __h = IceInternal.HashUtil.hashAdd(__h, aqiDetail);
        __h = IceInternal.HashUtil.hashAdd(__h, sd);
        __h = IceInternal.HashUtil.hashAdd(__h, temperature);
        __h = IceInternal.HashUtil.hashAdd(__h, windDirection);
        __h = IceInternal.HashUtil.hashAdd(__h, windPower);
        return __h;
    }

    public NowWeatherData
    clone()
    {
        NowWeatherData c = null;
        try
        {
            c = (NowWeatherData)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        AqiDetailData.__write(__os, aqiDetail);
        __os.writeString(sd);
        __os.writeString(temperature);
        __os.writeString(windDirection);
        __os.writeString(windPower);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        aqiDetail = AqiDetailData.__read(__is, aqiDetail);
        sd = __is.readString();
        temperature = __is.readString();
        windDirection = __is.readString();
        windPower = __is.readString();
    }

    static public void
    __write(IceInternal.BasicStream __os, NowWeatherData __v)
    {
        if(__v == null)
        {
            __nullMarshalValue.__write(__os);
        }
        else
        {
            __v.__write(__os);
        }
    }

    static public NowWeatherData
    __read(IceInternal.BasicStream __is, NowWeatherData __v)
    {
        if(__v == null)
        {
             __v = new NowWeatherData();
        }
        __v.__read(__is);
        return __v;
    }
    
    private static final NowWeatherData __nullMarshalValue = new NowWeatherData();

    public static final long serialVersionUID = -1287557493L;
}