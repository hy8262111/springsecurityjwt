package com.example.springsecuritoauth2jwt.threadtest;

import org.junit.rules.Timeout;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: houyong
 * @Date: 2020/4/26 17:38
 * @describe
 */
class MyResource {
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void increa() {
        String data = null;
        boolean offer;
        while (flag) {
            try {
                System.out.println("生产者开始生产");
                data = atomicInteger.incrementAndGet() + "";
                offer = blockingQueue.offer(data, 1L, TimeUnit.SECONDS);
                if (offer) {
                    System.out.println("生产者生产成功" + data);
                } else {
                    System.out.println("生产者生产失败");
                }
                //Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }

    public void decre() {
        while (flag) {
            try {
                String poll = blockingQueue.poll(2L, TimeUnit.SECONDS);
                if (null == poll) {
                    flag = false;
                    System.out.println(Thread.currentThread().getName() + "超过时间取蛋糕，失败");
                    return ;
                }
                System.out.println(Thread.currentThread().getName() + "\t消费成功" + poll);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }


    public void stop() {
        this.flag = false;
    }
}

public class FinalThreadTest {

    public static void main(String[] args) {
      /*  题目1： 两个线程，一个线程加，一个线程减
                 总结：多线程代码写做：线程  操作  资源类
                  多线程之间得轮转：判断  操作  唤醒     注意判断一定要用while,防止虚假唤醒
                  使用阻塞队列实现*/
        BlockingQueue blockingQueue = new ArrayBlockingQueue(4);
        MyResource myResource = new MyResource(blockingQueue);
        new Thread(() -> {
            myResource.decre();
        },"consumer").start();

        new Thread(() -> {
            myResource.increa();
        },"product").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        myResource.stop();
    }
}
