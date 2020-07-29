package com.example.springsecuritoauth2jwt.volatileAndCAS;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: houyong
 * @Date: 2020/4/22 16:58
 * @describe
 */
class data {
    volatile int sum = 0;

    public void add() {
        this.sum = 60;
    }

    public void sum() {
        sum++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();


}

public class Test {
    public static Test test = null;

    private Test() {
        System.out.println("instance");
    }

    ;

    public static Test getInstance() {
        if (null == test) {
            test = new Test();
        }
        return test;
    }

    //DCL单例模式多线程情况下出问题   DCL:两次检测+同步代码块
    public static Test getInstanceDCL() {

        if (null == test) {
            synchronized (Test.class) {
                if (null == test) {
                    test = new Test();
                }
            }

        }
        return test;
    }

    public static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    public static void main(String[] args) {
        //seeOkByVolatile();
        //notatomic();
        //Synchronized();
        //cas中引起ABA问题已经解决
        /*CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        Map map = new HashMap();
        Lock lock = new ReentrantLock();

        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){

            }

            atomicReference.compareAndSet(100,101);
            System.out.println(atomicReference.get());
        }).start();*/

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                new NumUtils().add();
            }, String.valueOf(i)).start();
        }

    }

    private static void Synchronized() {
        //单例模式在多线程情况下不安全  解决方式： 1.synchronized  2.DCL不一定多线程安全，原因是有指令重排得存在 + volatile
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                getInstanceDCL();
            }, String.valueOf(i)).start();
        }
    }

    private static void notatomic() {
        //不保证原子性,why不能保证
        data d = new data();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 500; j++) {
                    d.sum();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(d.sum);
    }

    private static void seeOkByVolatile() {
        //证明volatile的可见性
        data d = new data();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
            }
            d.add();
        }, "AAA").start();

        while (d.sum == 0) {

        }
    }
}
