package com.zsl.cn.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : Zeusedulous
 * @Date : 2022/3/22 15:42
 * @Desc :
 */
public class AtomicIntegerTest {

    static int sum = 0;
    static CountDownLatch count = new CountDownLatch(10);
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        for (int i =0;i<10;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<1000;j++){
                        sum ++;
                        atomicInteger.incrementAndGet();
                    }
                    count.countDown();
                }
            });
            thread.start();
        }
        count.await();
//        Thread.(3000);
        System.out.println(sum);
        System.out.println(atomicInteger.get());
    }
}
