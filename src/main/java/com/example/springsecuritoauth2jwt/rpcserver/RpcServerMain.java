package com.example.springsecuritoauth2jwt.rpcserver;

/**
 * @Author: houyong
 * @Date: 2020/5/26 14:46
 * @describe
 */
public class RpcServerMain {
    public static void main(String[] args) {
        IHelloService iHelloService = new HelloServiceImpl();
        RpcServerProxy rpcServerProxy = new RpcServerProxy();
        rpcServerProxy.publish(iHelloService,40401);
    }
}
