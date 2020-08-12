package com.example.springsecuritoauth2jwt.controller;

import com.alibaba.fastjson.JSON;
import com.example.springsecuritoauth2jwt.utils.GroupNode;
import com.example.springsecuritoauth2jwt.utils.Resource;
import com.example.springsecuritoauth2jwt.utils.TreeUtils;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.*;

/**
 * @Author: houyong
 * @Date: 2019/12/25 17:13
 * @describe
 */
@RestController
@RequestMapping("/controller")
@RefreshScope
public class TestController {

    @Value("${xuecheng.key}")
    private String key;

    @RequestMapping("/test")
    public List<Resource> test() {
        System.out.println(key);
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
    public List<GroupNode> getcookie(HttpServletRequest request) {
        List<GroupNode> groupNodeList = new ArrayList<>();

        GroupNode groupNode = new GroupNode();
        groupNode.setkey(1L);
        groupNode.setParentId(0L);
        groupNode.settitle("一级");


        GroupNode groupNode1 = new GroupNode();
        groupNode1.setkey(2L);
        groupNode1.setParentId(1L);
        groupNode1.settitle("一级");


        GroupNode groupNode2 = new GroupNode();
        groupNode2.setkey(3L);
        groupNode2.setParentId(2L);
        groupNode2.settitle("一级");

        groupNodeList.add(groupNode);
        groupNodeList.add(groupNode1);
        groupNodeList.add(groupNode2);

        List<GroupNode> tree = getTree(groupNodeList, 0L);
        return tree;
    }

    @PostMapping("/test23")
    public void test(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        boolean execlFile = isExeclFile(inputStream);
        System.out.println(execlFile);
    }

    @PostMapping("/testhell")
    public void testhell() {
        ThreadPoolExecutor threadPoolExecutor = threadPoolExecutor();
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 20; i++) {
            final int index = i;
            threadPoolExecutor.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(index);
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            });
        }

    }

    public ThreadPoolExecutor threadPoolExecutor() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("send-email-%d").build();
        return new ThreadPoolExecutor(10,
                20, 2, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(5), namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());
    }

    public static boolean isExeclFile(InputStream inputStream) {
        boolean res = false;
        try {

            FileMagic fileMagic = FileMagic.valueOf(new BufferedInputStream(inputStream));
            if (Objects.equals(fileMagic, FileMagic.OLE2) || Objects.equals(fileMagic, FileMagic.OOXML)) {
                res = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    private static List<GroupNode> getTree(List<GroupNode> nodeList, Long parentId) {
        List<GroupNode> threeNodeList = new ArrayList<>();
        for (GroupNode entity : nodeList) {
            Long getkey = entity.getkey();
            Long parentId1 = entity.getParentId();
            if (parentId.intValue() == parentId1.intValue()) {
                List<GroupNode> childList = getTree(nodeList, getkey);
                if (childList != null && childList.size() > 0) {
                    entity.setChildren(childList);
                }
                threeNodeList.add(entity);
            }
        }
        return threeNodeList;
    }


    public static void main(String[] args) {
        //需求：查找数组arr中第k个奇数如果不存在返回0
        /*PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        q.add(10);
        q.add(2);
        q.add(13);
        q.add(0);
        Iterator<Integer> iterator = q.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
        //扑克牌案例    4个人平均分配8个东西       0%4==0  1%4==1  2%4==2  3%4==3  4%4=0
        String[] nums = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] color = {"♦", "♣", "♠", "♥"};
        List<String> list = Lists.newArrayList();
        list.add("大王");
        list.add("小王");
        for (String c : color) {
            for (String n : nums) {
                list.add(c + n);
            }
        }
        Collections.shuffle(list);
        List<String> a = Lists.newArrayList();
        List<String> b = Lists.newArrayList();
        List<String> c = Lists.newArrayList();
        List<String> d = Lists.newArrayList();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            int mo = i % 4;
            test(mo,s,a,b,c,d);
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

    }


    private static void test(int mo, String s, List<String> a, List<String> b, List<String> c, List<String> d) {
        switch (mo) {
            case 0:
                a.add(s);
                break;
            case 1:
                b.add(s);
                break;
            case 2:
                c.add(s);
                break;
            default:
                d.add(s);
        }
    }

    /**
     * @param arr
     * @param k
     * @return
     */
    public int findKth(int[] arr, int k) {
        //程序的时间复杂度为O(n)。
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {   //奇数
                q.add(arr[i]);
            }
            if (q.size() > k) {   //如果队列容量超过k了  就弹出最小元素
                q.poll();
            }
        }
        //判断队列长度是否为空或者根本不存在第k大的奇数
        if (q.size() != k || q.size() == 0) {
            return 0;
        } else {
            return q.peek();
        }
    }


}
