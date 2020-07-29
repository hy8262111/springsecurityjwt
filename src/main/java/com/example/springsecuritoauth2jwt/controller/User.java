package com.example.springsecuritoauth2jwt.controller;

import com.example.springsecuritoauth2jwt.utils.TreeUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.*;
import java.util.Objects;

/**
 * @Author: houyong
 * @Date: 2020/4/30 9:49
 * @describe
 */

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -2278893558530939879L;
    private String name;
    private Integer age;
    private Integer store;
}
