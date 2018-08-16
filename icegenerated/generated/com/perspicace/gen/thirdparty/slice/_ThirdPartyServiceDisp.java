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

public abstract class _ThirdPartyServiceDisp extends Ice.ObjectImpl implements ThirdPartyService
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
        throws java.lang.CloneNotSupportedException
    {
        throw new java.lang.CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::slice::ThirdPartyService"
    };

    public boolean ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[] ice_ids()
    {
        return __ids;
    }

    public String[] ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String ice_id()
    {
        return __ids[1];
    }

    public String ice_id(Ice.Current __current)
    {
        return __ids[1];
    }

    public static String ice_staticId()
    {
        return __ids[1];
    }

    /**
     * 路况数据获取
     * cityName = 城市名
     * startPlace = 起始地点
     * destination = 目的地
     **/
    public final DistanceData getDistanceInfo(String cityName, String startPlace, String destination)
        throws slice.BussinessServiceException
    {
        return getDistanceInfo(cityName, startPlace, destination, null);
    }

    /**
     * 股票数据获取
     * type = 查询类型枚举
     * name = 股票名或代码
     **/
    public final SharesData[] getSharesList(SharesType type, String name)
        throws slice.BussinessServiceException
    {
        return getSharesList(type, name, null);
    }

    public final SimpleWeatherData getWeather(String cityName, String date)
        throws slice.BussinessServiceException
    {
        return getWeather(cityName, date, null);
    }

    public final WeatherData getWeatherApiData(String cityName)
        throws slice.BussinessServiceException
    {
        return getWeatherApiData(cityName, null);
    }

    public static Ice.DispatchStatus ___getWeather(ThirdPartyService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String cityName;
        String date;
        cityName = __is.readString();
        date = __is.readString();
        __inS.endReadParams();
        try
        {
            SimpleWeatherData __ret = __obj.getWeather(cityName, date, __current);
            IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
            SimpleWeatherData.__write(__os, __ret);
            __inS.__endWriteParams(true);
            return Ice.DispatchStatus.DispatchOK;
        }
        catch(slice.BussinessServiceException ex)
        {
            __inS.__writeUserException(ex, Ice.FormatType.DefaultFormat);
            return Ice.DispatchStatus.DispatchUserException;
        }
    }

    public static Ice.DispatchStatus ___getWeatherApiData(ThirdPartyService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String cityName;
        cityName = __is.readString();
        __inS.endReadParams();
        try
        {
            WeatherData __ret = __obj.getWeatherApiData(cityName, __current);
            IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
            WeatherData.__write(__os, __ret);
            __inS.__endWriteParams(true);
            return Ice.DispatchStatus.DispatchOK;
        }
        catch(slice.BussinessServiceException ex)
        {
            __inS.__writeUserException(ex, Ice.FormatType.DefaultFormat);
            return Ice.DispatchStatus.DispatchUserException;
        }
    }

    public static Ice.DispatchStatus ___getSharesList(ThirdPartyService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        SharesType type;
        String name;
        type = SharesType.__read(__is);
        name = __is.readString();
        __inS.endReadParams();
        try
        {
            SharesData[] __ret = __obj.getSharesList(type, name, __current);
            IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
            sharesDataSequenceHelper.write(__os, __ret);
            __inS.__endWriteParams(true);
            return Ice.DispatchStatus.DispatchOK;
        }
        catch(slice.BussinessServiceException ex)
        {
            __inS.__writeUserException(ex, Ice.FormatType.DefaultFormat);
            return Ice.DispatchStatus.DispatchUserException;
        }
    }

    public static Ice.DispatchStatus ___getDistanceInfo(ThirdPartyService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String cityName;
        String startPlace;
        String destination;
        cityName = __is.readString();
        startPlace = __is.readString();
        destination = __is.readString();
        __inS.endReadParams();
        try
        {
            DistanceData __ret = __obj.getDistanceInfo(cityName, startPlace, destination, __current);
            IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
            DistanceData.__write(__os, __ret);
            __inS.__endWriteParams(true);
            return Ice.DispatchStatus.DispatchOK;
        }
        catch(slice.BussinessServiceException ex)
        {
            __inS.__writeUserException(ex, Ice.FormatType.DefaultFormat);
            return Ice.DispatchStatus.DispatchUserException;
        }
    }

    private final static String[] __all =
    {
        "getDistanceInfo",
        "getSharesList",
        "getWeather",
        "getWeatherApiData",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping"
    };

    public Ice.DispatchStatus __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if(pos < 0)
        {
            throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return ___getDistanceInfo(this, in, __current);
            }
            case 1:
            {
                return ___getSharesList(this, in, __current);
            }
            case 2:
            {
                return ___getWeather(this, in, __current);
            }
            case 3:
            {
                return ___getWeatherApiData(this, in, __current);
            }
            case 4:
            {
                return ___ice_id(this, in, __current);
            }
            case 5:
            {
                return ___ice_ids(this, in, __current);
            }
            case 6:
            {
                return ___ice_isA(this, in, __current);
            }
            case 7:
            {
                return ___ice_ping(this, in, __current);
            }
        }

        assert(false);
        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
    }

    protected void __writeImpl(IceInternal.BasicStream __os)
    {
        __os.startWriteSlice(ice_staticId(), -1, true);
        __os.endWriteSlice();
    }

    protected void __readImpl(IceInternal.BasicStream __is)
    {
        __is.startReadSlice();
        __is.endReadSlice();
    }

    public static final long serialVersionUID = 0L;
}