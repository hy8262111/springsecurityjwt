package com.example.springsecuritoauth2jwt.threadtest;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Author: houyong
 * @Date: 2020/4/26 15:26
 * @describe
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        System.out.println(0x7fffffff);
        //阻塞队列
         BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        //add  remove elment方法当超过数组边界报异常
        /*System.out.println(blockingQueue.add("aaa"));
        System.out.println(blockingQueue.add("bbb"));
        System.out.println(blockingQueue.add("aaa"));
        System.out.println(blockingQueue.add("aaa"));*/

        //offer poll peek方法不报异常，只有true或false
        System.out.println(blockingQueue.offer("aaa"));
        System.out.println(blockingQueue.offer("bbb"));
        System.out.println(blockingQueue.offer("aaa"));
        System.out.println(blockingQueue.offer("aaa"));

        //put  不可用  take


        BlockingQueue<String> blockingQueue1 = new SynchronousQueue<>();
    }

}
