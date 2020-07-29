package com.example.springsecuritoauth2jwt.volatileAndCAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: houyong
 * @Date: 2020/6/2 10:48
 * @describe
 */
public class NumUtils {
    public static AtomicInteger atomicInteger = new AtomicInteger();

    public static void add() {
        System.out.println(atomicInteger.incrementAndGet());
    }
}
