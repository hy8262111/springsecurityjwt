package com.example.springsecuritoauth2jwt.rpcserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @Author: houyong
 * @Date: 2020/5/26 14:15
 * @describe
 */
public class ProccessHandler implements Runnable {
    Socket socket;
    Object service;

    public ProccessHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        Object invoke = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();
            invoke = invoke(rpcRequest);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(invoke);
            objectOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private Object invoke(RpcRequest rpcRequest) {
        Object[] params = rpcRequest.getParams();
        System.out.println(params);
        Class<?>[] parameterTypes = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            parameterTypes[i] = params[i].getClass();
        }
        try {
            Method method = service.getClass().getMethod(rpcRequest.getMethodName(), parameterTypes);
            Object invoke = method.invoke(service, params);
            return invoke;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return null;
    }
}
