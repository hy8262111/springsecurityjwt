package com.example.springsecuritoauth2jwt.utils;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: houyong
 * @Date: 2019/12/27 9:54
 * @describe
 */
public class Resource extends BaseTree implements Serializable {

    public static void main(String[] args) {
        List list = new ArrayList();
    }

    private String resourceName;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

}

