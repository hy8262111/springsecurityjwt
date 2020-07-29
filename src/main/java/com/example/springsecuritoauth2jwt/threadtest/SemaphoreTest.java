package com.example.springsecuritoauth2jwt.threadtest;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author: houyong
 * @Date: 2020/4/26 15:07
 * @describe
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        //Semaphore 信号量，它应用得场景有点像吃海底捞火锅，停车位  ，2
        // 0辆车抢占10个停车位，10个用完了，剩下得车可以等待，等别的车走了，它又可以进来
        Semaphore  semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }


            },String.valueOf(i)).start();
        }
    }
}
