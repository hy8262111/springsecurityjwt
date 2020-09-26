package com.example.springsecuritoauth2jwt.entity;

import lombok.Data;

/*
 * @author: houyong
 * @description:
 * @create: 2020-08-17 11:44
 **/
@Data
public class UserWrapper {
    private User passengerUser;
    private User driverUser;
}
