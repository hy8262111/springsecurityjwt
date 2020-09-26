package com.example.springsecuritoauth2jwt.sort;

/*
 * @author: houyong
 * @description:
 * @create: 2020-08-25 14:56
 **/

import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {1, -1, 0, 9, 5, 4, 2, 3, -5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] sort(int[] arr) {
        //外循环控制趟数
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //升序
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
}
