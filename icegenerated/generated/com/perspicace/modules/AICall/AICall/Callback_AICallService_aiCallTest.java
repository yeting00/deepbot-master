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
// Generated from file `AICall.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.perspicace.modules.AICall.AICall;

public abstract class Callback_AICallService_aiCallTest
    extends IceInternal.TwowayCallback implements Ice.TwowayCallbackArg1<String>
{
    public final void __completed(Ice.AsyncResult __result)
    {
        AICallServicePrxHelper.__aiCallTest_completed(this, __result);
    }
}