package com.example.springsecuritoauth2jwt.threadtest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: houyong
 * @Date: 2020/4/26 9:49
 * @describe
 */
class phone {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int num;

    public void incr() throws Exception {
        try {
            lock.lock();
            while (num != 0) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void decr() throws Exception {
        try {
            lock.lock();
            while (num == 0) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

public class ThreadTest {

    /**题目1：
     * 两个线程，实现十次轮转，一个线程加，一个线程减
     * 总结：多线程代码写做：线程  操作  资源类
     *       多线程之间得轮转：判断  操作  唤醒     注意判断一定要用while,防止虚假唤醒
     *
     * 题目二：
     * 多线程之前按照顺序执行，A->B->C  三个线程启动：需求如下
     *   A打印5次->B打印10次->C打印15次，来个10次
     *
     *
     *
     */
    public static void main(String[] args) {
        phone p = new phone();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    p.incr();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    p.decr();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    p.incr();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    p.decr();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();




        //2问题解决方案new多个Condition  Condition condition = lock.newCondition();
    }
}
