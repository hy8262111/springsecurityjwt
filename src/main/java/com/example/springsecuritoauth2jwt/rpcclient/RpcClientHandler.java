package com.example.springsecuritoauth2jwt.rpcclient;

import com.example.springsecuritoauth2jwt.rpcserver.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: houyong
 * @Date: 2020/5/26 14:57
 * @describe
 */
public class RpcClientHandler implements InvocationHandler {
    String host;
    int port;

    public RpcClientHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParams(args);
        RpcClientTransfer rpcClientTransfer = new RpcClientTransfer(host, port);
        return rpcClientTransfer.sendRequest(rpcRequest);
    }
}
