package com.example.springsecuritoauth2jwt.controller;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: houyong
 * @Date: 2020/4/24 10:41
 * @describe
 */
public class ArrayListTest {
    public static synchronized void main(String[] args) {
        double a = 1;
        double b = 1.1;
        Double c = 1.1;


        List<User> list = new ArrayList();//CopyOnWriteArrayList();//new Vector();
        /*list.add(new User(21, "A"));
        list.add(new User(22, "B"));
        list.add(new User(23, "C"));
        list.add(new User(24, "D"));
        list.add(new User(26, "F"));
        list.add(new User(25, "E"));*/
        //list.stream().forEach(System.out::println);


        LinkedHashMap<Integer, String> collect = list.stream().filter(u1 ->
                u1.getAge() % 2 == 0 && u1.getAge() >= 24
        ).sorted(Comparator.comparing(User::getAge).reversed().thenComparing(User::getName).reversed()).limit(1).collect
                (Collectors.toMap(User::getAge, User::getName, (x1, x2) -> x1, LinkedHashMap::new));



       /* Object object = new Object();
        System.out.println(object.getClass().getClassLoader());  //运行结果：null  bootstrap加载器加载的

        User user = new User();
        System.out.println(user.getClass().getClassLoader());  //运结果：sun.misc.Launcher$AppClassLoader@18b4aac2*/


        Set<User> set = new HashSet<>();
        /*set.add(new User(1, "aa"));
        set.add(new User(1, "aa"));
        set.add(new User(2, "bb"));*/
       /* User aa = new User("aa",1,1);
        System.out.println(JSON.toJSONString(aa));
        set.stream().forEach(u1 -> System.out.println(u1));*/
    }
}
