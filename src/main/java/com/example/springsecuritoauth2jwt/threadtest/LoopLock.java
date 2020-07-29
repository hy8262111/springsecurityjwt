package com.example.springsecuritoauth2jwt.threadtest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: houyong
 * @Date: 2020/4/26 10:29
 * @describe
 */


public class LoopLock {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "干活");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void myUnlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(thread.getName() + "干完活");
    }


    public static void main(String[] args) {
        LoopLock loopLock = new LoopLock();
        //手写一个自旋锁
        new Thread(() -> {
            loopLock.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                loopLock.myUnlock();
            }
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }

        new Thread(() -> {
            loopLock.myLock();
            loopLock.myUnlock();
        },"B").start();
    }
}