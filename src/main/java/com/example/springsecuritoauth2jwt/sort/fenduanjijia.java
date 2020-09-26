package com.example.springsecuritoauth2jwt.sort;

/*
 * @author: houyong
 * @description:
 * @create: 2020-08-27 14:18
 **/

import java.util.ArrayList;
import java.util.List;

public class fenduanjijia {
    public static void main(String[] args) {
        //3-10  11-20  21-30
        List<JIjia> jIjiaList = new ArrayList<>();
        jIjiaList.add(new JIjia(1, 10, 1));
        jIjiaList.add(new JIjia(11, 20, 2));
        jIjiaList.add(new JIjia(21, 30, 3));
    }

    //10-3  7
    private static int test(List<JIjia> jIjiaList, int mil) {
        if (null == jIjiaList || jIjiaList.size() < 0 || mil <= 0) {
            return 0;
        }
        if (mil > 0 && mil < 3) {
            return 8;
        }
        mil = mil - 3;

        //得到该里程数在几阶段,如果大于3公里，至少是有一阶段的，所以count设置为1开始增长
        int count = 1;
        for (JIjia jIjia : jIjiaList) {
            if (mil > jIjia.getEndMil()) {
                count++;
            }
        }

        //可能这个里程数大于30 ，count的下标会超过size的最大长度  就设置为里程数的最大计数
        int size = jIjiaList.size();
        if (count > size) {
            count = size;
        }

        int fee = 0;

        if (count == 1) {
            Integer price = jIjiaList.get(0).getPrice();
            return mil * price.intValue();
        } else {
            for (int i = 1; i < count; i++) {
                //此时分开求   1.//当前费用不在对应的阶数，计算之前的费用   //2.当前水费在对应的阶数
                if (i != count - 1) {
                } else {

                }
            }
        }
        return fee;
    }
}

