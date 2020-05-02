package com.example.algorithm.wxr.class01;

import java.util.Arrays;

/**
 * @author:wangxiaorui
 * @create 2020年4月25日21:53:15
 * 寻找当前数组中小于等于num的最右位置
 */
public class Code06_BSNearRight {

    /**
     * 寻找数组中小于等于num的最右位置
     * 前提：数组必须有序
     * 时间复杂度O(logN)
     * @param arr
     * @param num
     * @return
     */
    public static int nearRight(int[] arr, int num){
        int index = -1;
        if (arr == null){
            return index;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R){
            int mid = L + ((R - L) >> 1);
            if (arr[mid] <= num){
                index = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        return index;
    }

    /**
     * 循环方式寻找当前数组中小于等于num的最右位置
     * @param arr
     * @param num
     * @return
     */
    public static int nearRightTest(int[] arr, int num){
        if (arr == null){
            return -1;
        }
        for (int i = arr.length - 1; i >=0; i--){
            if (arr[i] <= num){
                return i;
            }
        }
        return -1;
    }

    /**
     * 创建随机数组
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] createRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int testCount = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean bool = true;
        for (int i = 0; i < testCount; i++){
            int[] arr = createRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int random = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
            if (nearRight(arr, random) != nearRightTest(arr, random)){
                bool = false;
                break;
            }
        }
        System.out.println(bool ? "Success!" : "Fail!");
    }
}
