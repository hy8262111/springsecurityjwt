/*
package com.example.springsecuritoauth2jwt.utils;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * @Author: houyong
 * @Date: 2020/1/6 10:09
 * @describe
 *//*

public class TreeUtils2 {
    */
/**
     * 递归创建树形结构
     *//*

    private static List<ThreeNode> getTree(List<ThreeNode> nodeList, Integer parentId) {
        List<ThreeNode> threeNodeList = new ArrayList<>();
        for (ThreeNode entity : nodeList) {
            Integer nodeId = entity.getId();
            Integer nodeParentId = entity.getParentId();
            if (parentId.intValue() == nodeParentId.intValue()) {
                List<ThreeNode> childList = getTree(nodeList, nodeId);
                if (childList != null && childList.size() > 0) {
                    entity.setChildNode(childList);
                    entity.setChildNodeSize(childList.size());
                }
                threeNodeList.add(entity);
            }
        }
        return threeNodeList;
    }

    */
/**
     * 获取指定子节点
     *//*

    private static List<ThreeNode> getChildTree(Integer id, List<ThreeNode> nodeList) {
        List<ThreeNode> resultList = new ArrayList<>();
        for (ThreeNode entity : nodeList) {
            if (entity.getParentId().intValue() == id) {
                List<ThreeNode> childList = getChildTree(entity.getId(), nodeList);
                entity.setChildNode(childList);
                entity.setChildNodeSize(childList.size());
                resultList.add(entity);
            }
        }
        return resultList;
    }

    */
/**
     * 遍历树形结构
     *//*

    private static transient List<Integer> treeIdList = new ArrayList<>();

    private static List<Integer> getTreeInfo(List<ThreeNode> treeList) {
        for (ThreeNode entity : treeList) {
            if (entity.getChildNodeSize() != null && entity.getChildNodeSize() > 0) {
                getTreeInfo(entity.getChildNode());
            }
            treeIdList.add(entity.getId());
        }
        return treeIdList;
    }

    */
/**
     * 判断节是否是叶子节点
     *//*

    private static boolean hasChildNode(Integer id, List<ThreeNode> nodeList) {
        for (ThreeNode entity : nodeList) {
            if (entity.getParentId().intValue() == id) {
                return true;
            }
        }
        return false;
    }

}
*/
