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

public interface FoodsMenuServicePrx extends Ice.ObjectPrx
{
    /**
     * 外卖菜单
     **/
    public FoodsMenuEntity[] getFoodsMenuByLabelName(String labelName, String name)
        throws slice.BussinessServiceException;

    /**
     * 外卖菜单
     * @param __ctx The Context map to send with the invocation.
     **/
    public FoodsMenuEntity[] getFoodsMenuByLabelName(String labelName, String name, java.util.Map<String, String> __ctx)
        throws slice.BussinessServiceException;

    /**
     * 外卖菜单
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getFoodsMenuByLabelName(String labelName, String name);

    /**
     * 外卖菜单
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getFoodsMenuByLabelName(String labelName, String name, java.util.Map<String, String> __ctx);

    /**
     * 外卖菜单
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getFoodsMenuByLabelName(String labelName, String name, Ice.Callback __cb);

    /**
     * 外卖菜单
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getFoodsMenuByLabelName(String labelName, String name, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * 外卖菜单
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getFoodsMenuByLabelName(String labelName, String name, Callback_FoodsMenuService_getFoodsMenuByLabelName __cb);

    /**
     * 外卖菜单
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getFoodsMenuByLabelName(String labelName, String name, java.util.Map<String, String> __ctx, Callback_FoodsMenuService_getFoodsMenuByLabelName __cb);

    /**
     * 外卖菜单
     * @param __responseCb The lambda response callback.
     * @param __userExceptionCb The lambda user exception callback.
     * @param __exceptionCb The lambda exception callback.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getFoodsMenuByLabelName(String labelName, 
                                                         String name, 
                                                         IceInternal.Functional_GenericCallback1<FoodsMenuEntity[]> __responseCb, 
                                                         IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    /**
     * 外卖菜单
     * @param __responseCb The lambda response callback.
     * @param __userExceptionCb The lambda user exception callback.
     * @param __exceptionCb The lambda exception callback.
     * @param __sentCb The lambda sent callback.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getFoodsMenuByLabelName(String labelName, 
                                                         String name, 
                                                         IceInternal.Functional_GenericCallback1<FoodsMenuEntity[]> __responseCb, 
                                                         IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                         IceInternal.Functional_BoolCallback __sentCb);

    /**
     * 外卖菜单
     * @param __ctx The Context map to send with the invocation.
     * @param __responseCb The lambda response callback.
     * @param __userExceptionCb The lambda user exception callback.
     * @param __exceptionCb The lambda exception callback.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getFoodsMenuByLabelName(String labelName, 
                                                         String name, 
                                                         java.util.Map<String, String> __ctx, 
                                                         IceInternal.Functional_GenericCallback1<FoodsMenuEntity[]> __responseCb, 
                                                         IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    /**
     * 外卖菜单
     * @param __ctx The Context map to send with the invocation.
     * @param __responseCb The lambda response callback.
     * @param __userExceptionCb The lambda user exception callback.
     * @param __exceptionCb The lambda exception callback.
     * @param __sentCb The lambda sent callback.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getFoodsMenuByLabelName(String labelName, 
                                                         String name, 
                                                         java.util.Map<String, String> __ctx, 
                                                         IceInternal.Functional_GenericCallback1<FoodsMenuEntity[]> __responseCb, 
                                                         IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                         IceInternal.Functional_BoolCallback __sentCb);

    /**
     * 外卖菜单
     * @param __result The asynchronous result object.
     **/
    public FoodsMenuEntity[] end_getFoodsMenuByLabelName(Ice.AsyncResult __result)
        throws slice.BussinessServiceException;
}
