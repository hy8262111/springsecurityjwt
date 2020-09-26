package com.example.springsecuritoauth2jwt.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

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
    private Integer age;
    private String name;
    private Integer store;
}
