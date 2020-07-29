package com.example.springsecuritoauth2jwt.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: houyong
 * @Date: 2020/1/16 14:35
 * @describe
 */
public class Test {
    public static void main(String[] args) {
        User user1 = new User(1,"aa");
        User user2 = new User(2,"bb");
        User user3 = new User(3,"cc");
        User user4 = new User(4,"cc");
        User user5 = new User(5,"ee");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        String collect = list.stream().filter(item -> item.getAge() > 2).limit(2).map(User::getName).collect(Collectors.joining( ","));
        long sum = list.stream().mapToLong(User::getAge).sum();
        System.out.println(sum);
        System.out.println(collect);
    }
}

class User{
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
}
