package com.example.springsecuritoauth2jwt.rpcserver;

import java.io.Serializable;

/**
 * @Author: houyong
 * @Date: 2020/5/25 17:47
 * @describe
 */
public class User implements Serializable {
    private static final long serialVersionUID = -511093296328690901L;

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
