// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.2
//
// <auto-generated>
//
// Generated from file `foo.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package java2slice.orig;

public final class TestClassIceHolder extends Ice.ObjectHolderBase<TestClassIce>
{
    public
    TestClassIceHolder()
    {
    }

    public
    TestClassIceHolder(TestClassIce value)
    {
        this.value = value;
    }

    public void
    patch(Ice.Object v)
    {
        if(v == null || v instanceof TestClassIce)
        {
            value = (TestClassIce)v;
        }
        else
        {
            IceInternal.Ex.throwUOE(type(), v);
        }
    }

    public String
    type()
    {
        return TestClassIce.ice_staticId();
    }
}
