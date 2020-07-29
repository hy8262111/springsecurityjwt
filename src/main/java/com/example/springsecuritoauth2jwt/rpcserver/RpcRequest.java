package com.example.springsecuritoauth2jwt.rpcserver;

import java.io.Serializable;

/**
 * @Author: houyong
 * @Date: 2020/5/26 14:26
 * @describe
 */
public class RpcRequest implements Serializable {
    //todo  试试不序列化该类
    private static final long serialVersionUID = -3440814767947221036L;
    private String className;
    private String methodName;
    private Object[] params;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
