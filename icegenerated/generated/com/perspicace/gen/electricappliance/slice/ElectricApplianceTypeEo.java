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

public enum ElectricApplianceTypeEo implements java.io.Serializable
{
    
    lamp(1),
    
    normalAirConditioning(2),
    
    tv(3),
    
    centralAirConditioning(4),
    
    freshAir(5),
    
    floorHeating(6);

    public int
    value()
    {
        return __value;
    }

    public static ElectricApplianceTypeEo
    valueOf(int __v)
    {
        switch(__v)
        {
        case 1:
            return lamp;
        case 2:
            return normalAirConditioning;
        case 3:
            return tv;
        case 4:
            return centralAirConditioning;
        case 5:
            return freshAir;
        case 6:
            return floorHeating;
        }
        return null;
    }

    private
    ElectricApplianceTypeEo(int __v)
    {
        __value = __v;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeEnum(value(), 6);
    }

    public static void
    __write(IceInternal.BasicStream __os, ElectricApplianceTypeEo __v)
    {
        if(__v == null)
        {
            __os.writeEnum(com.perspicace.gen.electricappliance.slice.ElectricApplianceTypeEo.lamp.value(), 6);
        }
        else
        {
            __os.writeEnum(__v.value(), 6);
        }
    }

    public static ElectricApplianceTypeEo
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readEnum(6);
        return __validate(__v);
    }

    private static ElectricApplianceTypeEo
    __validate(int __v)
    {
        final ElectricApplianceTypeEo __e = valueOf(__v);
        if(__e == null)
        {
            throw new Ice.MarshalException("enumerator value " + __v + " is out of range");
        }
        return __e;
    }

    private final int __value;
}
