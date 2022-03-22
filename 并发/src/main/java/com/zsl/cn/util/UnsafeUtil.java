package com.zsl.cn.util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author : Zeusedulous
 * @Date : 2022/3/22 16:38
 * @Desc :
 */
public class UnsafeUtil {

    /**
     * Unsafe是final类，只能反射获取
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Object o = theUnsafe.get(null);
        return (Unsafe) o;
    }
}
