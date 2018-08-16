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
// Generated from file `electricAppliance.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.perspicace.gen.electricappliance.slice;

public interface _ElectricApplianceGenJsonServiceOperations
{
    /**
     * 家电大接口
     * @param
     * groupId 群组Id
     * @param __current The Current object for the invocation.
     * @return json
     **/
    String ElectricApplianceBigJson(String groupId, Ice.Current __current)
        throws slice.BussinessServiceException;
}