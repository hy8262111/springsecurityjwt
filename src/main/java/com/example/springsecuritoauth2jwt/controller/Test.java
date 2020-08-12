package com.example.springsecuritoauth2jwt.controller;

import com.google.common.collect.Lists;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @Author: houyong
 * @Date: 2020/7/12 15:20
 * @describe
 */
public class Test {
    public static void main(String[] args) throws Exception{
        List<User> userList= Lists.newArrayList();
        userList.add(new User("houyong",26,100));
        userList.add(new User("yehua",24,100));

        File file = new File("C:\\Users\\houyw\\Desktop\\1.txt");
        OutputStream outputStream = new FileOutputStream(file);
    }
}
