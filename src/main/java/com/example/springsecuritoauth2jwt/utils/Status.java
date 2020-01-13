package com.example.springsecuritoauth2jwt.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: houyong
 * @Date: 2020/1/13 14:11
 * @describe
 */
public enum Status {
    SLOW(0){
        @Override
        void run(String sudu) {
            System.out.println("aaa");
        }
    },
    FAST(1){
        @Override
        void run(String sudu) {
            System.out.println("bbb");
        }
    };

    private int sudu;

    Status(int sudu) {
        this.sudu = sudu;
    }

    public int getSudu() {
        return sudu;
    }

    public static Map<Integer,Status> map = new LinkedHashMap<>();

   static {
        for (Status status : Status.values()){
            map.put( status.getSudu(),status);
        }
    }

    public static Status itemMap(int type){
       return map.get(type);
    }

    abstract void run(String sudu);

}
