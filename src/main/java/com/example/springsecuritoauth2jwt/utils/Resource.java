package com.example.springsecuritoauth2jwt.utils;

import java.io.Serializable;

/**
 * @Author: houyong
 * @Date: 2019/12/27 9:54
 * @describe
 */
public class Resource extends BaseTree implements Serializable {
    private String resourceName;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

}
