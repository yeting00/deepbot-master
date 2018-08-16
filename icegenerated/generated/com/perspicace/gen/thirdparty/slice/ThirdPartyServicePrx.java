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

public interface ThirdPartyServicePrx extends Ice.ObjectPrx
{
    public SimpleWeatherData getWeather(String cityName, String date)
        throws slice.BussinessServiceException;

    public SimpleWeatherData getWeather(String cityName, String date, java.util.Map<String, String> __ctx)
        throws slice.BussinessServiceException;

    public Ice.AsyncResult begin_getWeather(String cityName, String date);

    public Ice.AsyncResult begin_getWeather(String cityName, String date, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getWeather(String cityName, String date, Ice.Callback __cb);

    public Ice.AsyncResult begin_getWeather(String cityName, String date, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_getWeather(String cityName, String date, Callback_ThirdPartyService_getWeather __cb);

    public Ice.AsyncResult begin_getWeather(String cityName, String date, java.util.Map<String, String> __ctx, Callback_ThirdPartyService_getWeather __cb);

    public Ice.AsyncResult begin_getWeather(String cityName, 
                                            String date, 
                                            IceInternal.Functional_GenericCallback1<SimpleWeatherData> __responseCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getWeather(String cityName, 
                                            String date, 
                                            IceInternal.Functional_GenericCallback1<SimpleWeatherData> __responseCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                            IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_getWeather(String cityName, 
                                            String date, 
                                            java.util.Map<String, String> __ctx, 
                                            IceInternal.Functional_GenericCallback1<SimpleWeatherData> __responseCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getWeather(String cityName, 
                                            String date, 
                                            java.util.Map<String, String> __ctx, 
                                            IceInternal.Functional_GenericCallback1<SimpleWeatherData> __responseCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                            IceInternal.Functional_BoolCallback __sentCb);

    public SimpleWeatherData end_getWeather(Ice.AsyncResult __result)
        throws slice.BussinessServiceException;

    public WeatherData getWeatherApiData(String cityName)
        throws slice.BussinessServiceException;

    public WeatherData getWeatherApiData(String cityName, java.util.Map<String, String> __ctx)
        throws slice.BussinessServiceException;

    public Ice.AsyncResult begin_getWeatherApiData(String cityName);

    public Ice.AsyncResult begin_getWeatherApiData(String cityName, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getWeatherApiData(String cityName, Ice.Callback __cb);

    public Ice.AsyncResult begin_getWeatherApiData(String cityName, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_getWeatherApiData(String cityName, Callback_ThirdPartyService_getWeatherApiData __cb);

    public Ice.AsyncResult begin_getWeatherApiData(String cityName, java.util.Map<String, String> __ctx, Callback_ThirdPartyService_getWeatherApiData __cb);

    public Ice.AsyncResult begin_getWeatherApiData(String cityName, 
                                                   IceInternal.Functional_GenericCallback1<WeatherData> __responseCb, 
                                                   IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                   IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getWeatherApiData(String cityName, 
                                                   IceInternal.Functional_GenericCallback1<WeatherData> __responseCb, 
                                                   IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                   IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                   IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_getWeatherApiData(String cityName, 
                                                   java.util.Map<String, String> __ctx, 
                                                   IceInternal.Functional_GenericCallback1<WeatherData> __responseCb, 
                                                   IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                   IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getWeatherApiData(String cityName, 
                                                   java.util.Map<String, String> __ctx, 
                                                   IceInternal.Functional_GenericCallback1<WeatherData> __responseCb, 
                                                   IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                   IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                   IceInternal.Functional_BoolCallback __sentCb);

    public WeatherData end_getWeatherApiData(Ice.AsyncResult __result)
        throws slice.BussinessServiceException;

    /**
     * 股票数据获取
     * type = 查询类型枚举
     * name = 股票名或代码
     **/
    public SharesData[] getSharesList(SharesType type, String name)
        throws slice.BussinessServiceException;

    /**
     * 股票数据获取
     * type = 查询类型枚举
     * name = 股票名或代码
     * @param __ctx The Context map to send with the invocation.
     **/
    public SharesData[] getSharesList(SharesType type, String name, java.util.Map<String, String> __ctx)
        throws slice.BussinessServiceException;

    /**
     * 股票数据获取
     * type = 查询类型枚举
     * name = 股票名或代码
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getSharesList(SharesType type, String name);

    /**
     * 股票数据获取
     * type = 查询类型枚举
     * name = 股票名或代码
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getSharesList(SharesType type, String name, java.util.Map<String, String> __ctx);

    /**
     * 股票数据获取
     * type = 查询类型枚举
     * name = 股票名或代码
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getSharesList(SharesType type, String name, Ice.Callback __cb);

    /**
     * 股票数据获取
     * type = 查询类型枚举
     * name = 股票名或代码
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getSharesList(SharesType type, String name, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * 股票数据获取
     * type = 查询类型枚举
     * name = 股票名或代码
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getSharesList(SharesType type, String name, Callback_ThirdPartyService_getSharesList __cb);

    /**
     * 股票数据获取
     * type = 查询类型枚举
     * name = 股票名或代码
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getSharesList(SharesType type, String name, java.util.Map<String, String> __ctx, Callback_ThirdPartyService_getSharesList __cb);

    /**
     * 股票数据获取
     * type = 查询类型枚举
     * name = 股票名或代码
     * @param __responseCb The lambda response callback.
     * @param __userExceptionCb The lambda user exception callback.
     * @param __exceptionCb The lambda exception callback.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getSharesList(SharesType type, 
                                               String name, 
                                               IceInternal.Functional_GenericCallback1<SharesData[]> __responseCb, 
                                               IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                               IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    /**
     * 股票数据获取
     * type = 查询类型枚举
     * name = 股票名或代码
     * @param __responseCb The lambda response callback.
     * @param __userExceptionCb The lambda user exception callback.
     * @param __exceptionCb The lambda exception callback.
     * @param __sentCb The lambda sent callback.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getSharesList(SharesType type, 
                                               String name, 
                                               IceInternal.Functional_GenericCallback1<SharesData[]> __responseCb, 
                                               IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                               IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                               IceInternal.Functional_BoolCallback __sentCb);

    /**
     * 股票数据获取
     * type = 查询类型枚举
     * name = 股票名或代码
     * @param __ctx The Context map to send with the invocation.
     * @param __responseCb The lambda response callback.
     * @param __userExceptionCb The lambda user exception callback.
     * @param __exceptionCb The lambda exception callback.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getSharesList(SharesType type, 
                                               String name, 
                                               java.util.Map<String, String> __ctx, 
                                               IceInternal.Functional_GenericCallback1<SharesData[]> __responseCb, 
                                               IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                               IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    /**
     * 股票数据获取
     * type = 查询类型枚举
     * name = 股票名或代码
     * @param __ctx The Context map to send with the invocation.
     * @param __responseCb The lambda response callback.
     * @param __userExceptionCb The lambda user exception callback.
     * @param __exceptionCb The lambda exception callback.
     * @param __sentCb The lambda sent callback.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getSharesList(SharesType type, 
                                               String name, 
                                               java.util.Map<String, String> __ctx, 
                                               IceInternal.Functional_GenericCallback1<SharesData[]> __responseCb, 
                                               IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                               IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                               IceInternal.Functional_BoolCallback __sentCb);

    /**
     * 股票数据获取
     * type = 查询类型枚举
     * name = 股票名或代码
     * @param __result The asynchronous result object.
     **/
    public SharesData[] end_getSharesList(Ice.AsyncResult __result)
        throws slice.BussinessServiceException;

    /**
     * 路况数据获取
     * cityName = 城市名
     * startPlace = 起始地点
     * destination = 目的地
     **/
    public DistanceData getDistanceInfo(String cityName, String startPlace, String destination)
        throws slice.BussinessServiceException;

    /**
     * 路况数据获取
     * cityName = 城市名
     * startPlace = 起始地点
     * destination = 目的地
     * @param __ctx The Context map to send with the invocation.
     **/
    public DistanceData getDistanceInfo(String cityName, String startPlace, String destination, java.util.Map<String, String> __ctx)
        throws slice.BussinessServiceException;

    /**
     * 路况数据获取
     * cityName = 城市名
     * startPlace = 起始地点
     * destination = 目的地
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getDistanceInfo(String cityName, String startPlace, String destination);

    /**
     * 路况数据获取
     * cityName = 城市名
     * startPlace = 起始地点
     * destination = 目的地
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getDistanceInfo(String cityName, String startPlace, String destination, java.util.Map<String, String> __ctx);

    /**
     * 路况数据获取
     * cityName = 城市名
     * startPlace = 起始地点
     * destination = 目的地
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getDistanceInfo(String cityName, String startPlace, String destination, Ice.Callback __cb);

    /**
     * 路况数据获取
     * cityName = 城市名
     * startPlace = 起始地点
     * destination = 目的地
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getDistanceInfo(String cityName, String startPlace, String destination, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * 路况数据获取
     * cityName = 城市名
     * startPlace = 起始地点
     * destination = 目的地
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getDistanceInfo(String cityName, String startPlace, String destination, Callback_ThirdPartyService_getDistanceInfo __cb);

    /**
     * 路况数据获取
     * cityName = 城市名
     * startPlace = 起始地点
     * destination = 目的地
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getDistanceInfo(String cityName, String startPlace, String destination, java.util.Map<String, String> __ctx, Callback_ThirdPartyService_getDistanceInfo __cb);

    /**
     * 路况数据获取
     * cityName = 城市名
     * startPlace = 起始地点
     * destination = 目的地
     * @param __responseCb The lambda response callback.
     * @param __userExceptionCb The lambda user exception callback.
     * @param __exceptionCb The lambda exception callback.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getDistanceInfo(String cityName, 
                                                 String startPlace, 
                                                 String destination, 
                                                 IceInternal.Functional_GenericCallback1<DistanceData> __responseCb, 
                                                 IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                 IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    /**
     * 路况数据获取
     * cityName = 城市名
     * startPlace = 起始地点
     * destination = 目的地
     * @param __responseCb The lambda response callback.
     * @param __userExceptionCb The lambda user exception callback.
     * @param __exceptionCb The lambda exception callback.
     * @param __sentCb The lambda sent callback.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getDistanceInfo(String cityName, 
                                                 String startPlace, 
                                                 String destination, 
                                                 IceInternal.Functional_GenericCallback1<DistanceData> __responseCb, 
                                                 IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                 IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                 IceInternal.Functional_BoolCallback __sentCb);

    /**
     * 路况数据获取
     * cityName = 城市名
     * startPlace = 起始地点
     * destination = 目的地
     * @param __ctx The Context map to send with the invocation.
     * @param __responseCb The lambda response callback.
     * @param __userExceptionCb The lambda user exception callback.
     * @param __exceptionCb The lambda exception callback.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getDistanceInfo(String cityName, 
                                                 String startPlace, 
                                                 String destination, 
                                                 java.util.Map<String, String> __ctx, 
                                                 IceInternal.Functional_GenericCallback1<DistanceData> __responseCb, 
                                                 IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                 IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    /**
     * 路况数据获取
     * cityName = 城市名
     * startPlace = 起始地点
     * destination = 目的地
     * @param __ctx The Context map to send with the invocation.
     * @param __responseCb The lambda response callback.
     * @param __userExceptionCb The lambda user exception callback.
     * @param __exceptionCb The lambda exception callback.
     * @param __sentCb The lambda sent callback.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getDistanceInfo(String cityName, 
                                                 String startPlace, 
                                                 String destination, 
                                                 java.util.Map<String, String> __ctx, 
                                                 IceInternal.Functional_GenericCallback1<DistanceData> __responseCb, 
                                                 IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                 IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                 IceInternal.Functional_BoolCallback __sentCb);

    /**
     * 路况数据获取
     * cityName = 城市名
     * startPlace = 起始地点
     * destination = 目的地
     * @param __result The asynchronous result object.
     **/
    public DistanceData end_getDistanceInfo(Ice.AsyncResult __result)
        throws slice.BussinessServiceException;
}