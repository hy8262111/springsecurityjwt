package com.example.springsecuritoauth2jwt.threadtest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: houyong
 * @Date: 2020/4/26 10:55
 * @describe
 */
class myCache {
    private volatile Map<String, Object> map = new HashMap<>();
    private final ReentrantReadWriteLock
            rwl = new ReentrantReadWriteLock();

    public synchronized void write(String key, Object value) {
        try {
            rwl.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "\t正在写数据");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t写入成功" + value);
        } finally {
            rwl.writeLock().unlock();
        }

    }

    public synchronized void read(String key) {
        try {
            rwl.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "\t正在读数据");
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读成功" + key);
        } finally {
            rwl.readLock().unlock();
        }

    }
}

public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        //需求：多个线程同时读一个资源类是没有问题的，所以为了满足并发量，读取共享资源是可以同时进行得
        //      但是如果有一个线程需要去修改共享资源，就不应该有其他得线程进来写或读操作
        //
        //   总结
        //   即：读读可以共存
        //       读写不可以共存
        //       写写不可以共存

        //写操作 ：原子+独占  整个过程是一个完整得统一体，不允许被打断
        myCache myCache = new myCache();
        for (int i = 0; i < 5; i++) {
            final int tmp = i;
            new Thread(() -> {
                myCache.read(tmp + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tmp = i;
            new Thread(() -> {
                myCache.write(tmp + "", tmp + "");
            }, String.valueOf(i)).start();
        }


    }
}
