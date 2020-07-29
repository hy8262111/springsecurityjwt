package com.example.springsecuritoauth2jwt.threadtest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.concurrent.TimeUnit;

/**
 * @Author: houyong
 * @Date: 2020/4/29 14:36
 * @describe
 */
@Data
@NoArgsConstructor
class DeadLockTest implements Runnable{
    private String lockA;
    private String lockB;
    public DeadLockTest(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + "持有锁A,尝试获取B");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + "持有锁B,尝试获取A");
            }
        }
    }
}
public class DeadLock {
    //死锁：两个或以上的线程因为抢占资源而互相等待
    public static void main(String[] args) {
        String lockA = "locka";
        String lockB = "lockb";
        new Thread(new DeadLockTest(lockA,lockB),"a").start();
        new Thread(new DeadLockTest(lockB,lockA),"b").start();
    }
}
