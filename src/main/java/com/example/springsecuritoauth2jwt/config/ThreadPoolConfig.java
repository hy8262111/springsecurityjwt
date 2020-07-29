package com.example.springsecuritoauth2jwt.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: houyong
 * @Date: 2020/4/29 11:33
 * @describe
 */
@Configuration
public class ThreadPoolConfig {
    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("send-email-%d").build();
        return new ThreadPoolExecutor(10,
                20, 2, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(5), namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());
    }
}
