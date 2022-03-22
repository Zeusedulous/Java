package com.zsl.cn.atomic;

import com.zsl.cn.entity.User;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author : Zeusedulous
 * @Date : 2022/3/22 16:23
 * @Desc :
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        User user = new User("张三",24);
        User user1 = new User("李四", 39);
        User user2 = new User("王五", 29);

        //初始化为user
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(user);

        //把user1的值给atomicReference
        atomicReference.compareAndSet(user, user1);
        System.out.println(atomicReference.get());

        //把user2的值给atomicReference
        atomicReference.compareAndSet(user, user2);
        System.out.println(atomicReference.get());

        atomicReference.compareAndSet(user1, user2);
        System.out.println(atomicReference.get());


    }
}
