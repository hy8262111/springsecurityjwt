package com.example.springsecuritoauth2jwt.threadtest;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author: houyong
 * @Date: 2020/4/28 10:42
 * @describe
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("send-email-%d").build();
        //noinspection AlibabaThreadShouldSetName
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                3, 10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1), namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());

        try {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName()+"1");
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //threadPoolExecutor.shutdown();
        }

        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }*/


        try {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "2");
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //threadPoolExecutor.shutdown();
        }


        try {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "3");
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //threadPoolExecutor.shutdown();
        }


        try {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "4");
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //threadPoolExecutor.shutdown();
        }
    }
}
