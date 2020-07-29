package com.example.springsecuritoauth2jwt.rpcserver;

/**
 * @Author: houyong
 * @Date: 2020/5/25 17:49
 * @describe
 */
public interface IHelloService {
    String sayHello(String say);

    String saveuser(User user);
}
