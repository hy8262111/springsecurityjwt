package com.example.springsecuritoauth2jwt.sort;

/*
 * @author: houyong
 * @description:
 * @create: 2020-08-25 18:37
 **/

import java.util.Arrays;

public class 选择排序 {
    public static void main(String[] args) {
        int[] arr = {1, -1, 0, 9, 5, 4, 2, 3, -5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
