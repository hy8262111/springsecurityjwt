package com.example.springsecuritoauth2jwt.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: houyong
 * @Date: 2020/1/17 17:58
 * @describe
 */
public class GroupNode implements Serializable {
    public GroupNode() {
        //无参构造
    }

    private Long key;

    public List<Long> getCountList() {
        return countList;
    }

    public void setCountList(List<Long> countList) {
        this.countList = countList;
    }

    private List<Long> countList;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    private Long value;

    private String title;

    private Long parentId;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    private Integer count;

    public List<GroupNode> getChildren() {
        return children;
    }

    public void setChildren(List<GroupNode> children) {
        this.children = children;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<GroupNode> children;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    private List<User> userList;

    public Long getkey() {
        return key;
    }

    public void setkey(Long key) {
        this.key = key;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

}
