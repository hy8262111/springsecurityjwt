package com.example.springsecuritoauth2jwt.rpcclient;

import com.example.springsecuritoauth2jwt.rpcserver.RpcRequest;
import sun.misc.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: houyong
 * @Date: 2020/5/26 15:03
 * @describe
 */
public class RpcClientTransfer {
    String host;
    int port;

    public RpcClientTransfer(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Socket getSocket() throws Exception {
        return new Socket(host, port);
    }

    public Object sendRequest(RpcRequest rpcRequest) {
        Socket socket = null;
        try {
            socket = getSocket();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();


            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            objectOutputStream.close();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
