package com.example.springsecuritoauth2jwt.rpcserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: houyong
 * @Date: 2020/5/25 17:52
 * @describe
 */
public class RpcServerProxy {
    //bio
    ExecutorService executorService = Executors.newCachedThreadPool();

    public void publish(Object service, int port) {
        ServerSocket serverSocket = null;
        try {
            while (true) {
                serverSocket = new ServerSocket(port);
                Socket socket = serverSocket.accept();
                executorService.execute(new ProccessHandler(socket, service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
