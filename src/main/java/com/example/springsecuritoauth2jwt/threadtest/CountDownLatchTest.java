package com.example.springsecuritoauth2jwt.threadtest;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: houyong
 * @Date: 2020/4/26 14:00
 * @describe
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        //办公室锁门： 例如关门大爷需要所有的人都走完了才可以锁门

        for (int i = 0; i < 5; i++) {
            final int tmp = i;
            new Thread(() -> {
                System.out.println("第" + tmp + "个人走了");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        System.out.println("大爷锁门");
    }
}
