package com.example.springsecuritoauth2jwt.threadtest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: houyong
 * @Date: 2020/4/26 14:39
 * @describe
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("龙珠集齐，召唤神龙");
        });
        for (int i = 0; i < 7; i++) {
            final int tmp = i;
            new Thread(()->{
                System.out.println("第"+tmp+"个龙珠集齐");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } finally {
                }
            }).start();
        }
    }
}
