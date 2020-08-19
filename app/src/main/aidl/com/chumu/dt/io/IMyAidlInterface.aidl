// IMyAidlInterface.aidl
package com.chumu.dt.io;
import com.chumu.dt.io.User;
// Declare any non-default types here with import statements

interface IMyAidlInterface {
//定义与自定义类型相关的业务
                void getWorkInfo();
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
        User getUser(String name);
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

}
