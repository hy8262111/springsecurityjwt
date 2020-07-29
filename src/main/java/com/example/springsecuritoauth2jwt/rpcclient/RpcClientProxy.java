package com.example.springsecuritoauth2jwt.rpcclient;

import java.lang.reflect.Proxy;

/**
 * @Author: houyong
 * @Date: 2020/5/26 14:52
 * @describe
 */

public class RpcClientProxy {
    public <T> T clientProxy(Class<T> interfaces, String host, int port) {
        //ClassLoader loader,
        // Class<?>[] interfaces,
        // InvocationHandler h
        return (T) Proxy.newProxyInstance(interfaces.getClassLoader(), new Class<?>[]{interfaces}, new RpcClientHandler(host, port));
    }
}
