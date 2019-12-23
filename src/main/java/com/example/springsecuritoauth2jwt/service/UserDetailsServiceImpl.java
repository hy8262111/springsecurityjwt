package com.example.springsecuritoauth2jwt.service;

import com.example.springsecuritoauth2jwt.model.UserJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       String password = passwordEncoder.encode("123");

       String user_permission_string  = "course_find_list,coursepic_find_list";//多个权限中间以逗号分隔

        UserJwt userDetails = new UserJwt(username,
                password,
                AuthorityUtils.commaSeparatedStringToAuthorityList(user_permission_string));

        //将用户的相关信息加入userDetails，将来在jwt令牌中才包括加入的这些信息
        //企业id
        userDetails.setCompanyId("1");
        //头像
        userDetails.setUserpic("aa");
        //用户名称
        userDetails.setName("bb");

        return userDetails;
    }
}
