package com.example.springsecuritoauth2jwt.controller;

import com.alibaba.fastjson.JSON;
import com.example.springsecuritoauth2jwt.utils.Resource;
import com.example.springsecuritoauth2jwt.utils.TreeUtils;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: houyong
 * @Date: 2019/12/25 17:13
 * @describe
 */
@RestController
@RequestMapping("/controller")
public class TestController {

    @RequestMapping("/test")
    public List<Resource> test() {
        List<Resource> list = new ArrayList<>();
        Resource resource1 = new Resource();
        resource1.setId(1);
        resource1.setPid(0);
        resource1.setResourceName("系统管理1");

        Resource resource3 = new Resource();
        resource3.setId(3);
        resource3.setPid(1);
        resource3.setResourceName("用户管理1");

        Resource resource4 = new Resource();
        resource4.setId(4);
        resource4.setPid(1);
        resource4.setResourceName("组织管理1");

        Resource resource5 = new Resource();
        resource5.setId(5);
        resource5.setPid(3);
        resource5.setResourceName("用户删除1");

        Resource resource6 = new Resource();
        resource6.setId(6);
        resource6.setPid(3);
        resource6.setResourceName("用户编辑1");

        Resource resource7 = new Resource();
        resource7.setId(7);
        resource7.setPid(6);
        resource7.setResourceName("用户编辑 ----1");


        Resource resource2 = new Resource();
        resource2.setId(2);
        resource2.setPid(0);
        resource2.setResourceName("系统管理2");


        Resource resource8 = new Resource();
        resource8.setId(8);
        resource8.setPid(2);
        resource8.setResourceName("用户管理2");

        Resource resource9 = new Resource();
        resource9.setId(9);
        resource9.setPid(8);
        resource9.setResourceName("用户删除2");


        Resource resource10 = new Resource();
        resource10.setId(10);
        resource10.setPid(8);
        resource10.setResourceName("用户编辑2");

        list.add(resource1);
        list.add(resource2);
        list.add(resource3);
        list.add(resource4);
        list.add(resource5);
        list.add(resource6);
        list.add(resource7);
        list.add(resource8);
        list.add(resource9);
        list.add(resource10);


        System.out.println(list.size());
        List<Resource> childTreeObjects = new TreeUtils().getChildTreeObjects(list, 0);
        return childTreeObjects;
    }


    @PostMapping("/test1")
    public void test1(@RequestBody List<Resource> resourceList) {
        for (Resource resource : resourceList) {
            System.out.println(resource.toString());
        }
        List<Resource> resources = Lists.newArrayList();
        List<Resource> treeInfo = getTreeInfo(resourceList, resources);
        System.out.println(treeInfo.size());
        for (Resource resource : treeInfo) {
            System.out.println(resource.getId());
            System.out.println(resource.getPid());
        }
    }

    private static List<Resource> getTreeInfo(List<Resource> childTreeObjects, List<Resource> list) {
        String string1 = JSON.toJSONString(childTreeObjects);
        List<Resource> resources = JSON.parseArray(string1, Resource.class);
        for (Resource entity : resources) {
            if (entity.getChildren() != null && entity.getChildren().size() > 0) {
                getTreeInfo(entity.getChildren(), list);
            }
            list.add(entity);
        }
        return list;
    }

    @GetMapping("/getcookie")
    public void getcookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("test".equalsIgnoreCase(cookie.getName())) {
                System.out.println(cookie.getValue());
            }
        }
    }
}
