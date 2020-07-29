package com.example.springsecuritoauth2jwt.rpcserver;

/**
 * @Author: houyong
 * @Date: 2020/5/25 17:50
 * @describe
 */
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String say) {
        return "hello world"+say;
    }

    @Override
    public String saveuser(User user) {
        System.out.println(user);
        return "success";
    }
}
