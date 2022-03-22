package com.zsl.cn.atomic;

import com.zsl.cn.util.UnsafeUtil;
import sun.misc.Unsafe;

/**
 * @Author : Zeusedulous
 * @Date : 2022/3/22 16:32
 * @Desc :
 */
public class CASTest {
    int test = 1;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        CASTest casTest = new CASTest();

        Unsafe unsafe = UnsafeUtil.getUnsafe();
        long offset = unsafe.objectFieldOffset(casTest.getClass().getDeclaredField("test"));
        System.out.println(offset);

        boolean b = unsafe.compareAndSwapInt(casTest, offset, 1, 3);
        System.out.println(b + "\t" + casTest.test);

        boolean b1 = unsafe.compareAndSwapInt(casTest, offset, 1, 5);
        System.out.println(b1 + "\t" + casTest.test);

        boolean b2 = unsafe.compareAndSwapInt(casTest, offset, 3, 5);
        System.out.println(b2 + "\t" + casTest.test);


    }
}
