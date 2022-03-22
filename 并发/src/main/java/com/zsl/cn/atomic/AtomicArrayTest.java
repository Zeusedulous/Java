package com.zsl.cn.atomic;


import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Author : Zeusedulous
 * @Date : 2022/3/22 16:06
 * @Desc :
 */
public class AtomicArrayTest {

    static int array [] = {1,5,8,9};
    public static void main(String[] args) {

        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array);

        atomicIntegerArray.set(0,4);
        atomicIntegerArray.addAndGet(0,4);
        System.out.println(atomicIntegerArray);
    }
}
