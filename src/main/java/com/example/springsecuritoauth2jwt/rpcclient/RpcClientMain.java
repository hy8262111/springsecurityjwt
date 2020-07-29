package com.example.springsecuritoauth2jwt.rpcclient;

import com.example.springsecuritoauth2jwt.rpcserver.IHelloService;
import com.example.springsecuritoauth2jwt.rpcserver.User;

/**
 * @Author: houyong
 * @Date: 2020/5/26 15:15
 * @describe
 */
public class RpcClientMain {
    public static void main(String[] args) {
        RpcClientProxy proxy = new RpcClientProxy();
        IHelloService iHelloService = proxy.clientProxy(IHelloService.class, "localhost", 40401);
        User user = new User();
        user.setName("aa");
        System.out.println(iHelloService.saveuser(user));
    }
}
