package com.example.springsecuritoauth2jwt.threadtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author: houyong
 * @Date: 2020/5/22 9:54
 * @describe
 */
public class SemaphoreTest1 {

    public static void main(String[] args) {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index;
                Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 获取许可
                        semp.acquire();
                        System.out.println("Accessing: " + NO);
                        TimeUnit.SECONDS.sleep(3);
                        // 访问完后，释放 ，如果屏蔽下面的语句，则在控e799bee5baa6e78988e69d8331333363383332制台只能打印5条记录，之后线程一直阻塞
                        semp.release();
                    } catch (InterruptedException e) {
                    }
                }
            };
            exec.execute(run);
        }
        // 退出线程池
        exec.shutdown();


       /* Semaphore semaphore1 = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            new Thread(() -> {
                try {
                    semaphore1.acquire();
                    System.out.println(index);
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore1.release();
                }
            }).start();
        }*/
    }
}
