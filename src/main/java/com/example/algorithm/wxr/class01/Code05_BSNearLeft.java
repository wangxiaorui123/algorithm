package com.example.algorithm.wxr.class01;

import java.util.Arrays;

/**
 * @author:wangxiaorui
 * @create 2020年4月25日21:23:38
 * 寻找当前数组中>=num数的最左位置
 */
public class Code05_BSNearLeft {

    /**
     * 寻找当前数组中大于等于num的最左位置
     * 时间复杂度O(logN)
     * 前提：数组必须是有序的
     * @param arr
     * @param num
     * @return
     */
    public static int nearLeft(int[] arr, int num){
        //定位当前数组中大于等于num数值的最左位置
        int index = -1;
        if (arr == null){
            return index;
        }
        int L = 0;//定位的数组左下标
        int R = arr.length - 1;//定位的数组右下标
        while (L <= R){
            int mid = L + ((R - L) >> 1);//中间点下标
            if (arr[mid] >= num){
                R = mid - 1;
                index = mid;
            }else{
                L = mid + 1;
            }
        }
        return index;
    }

    /**
     * 循环的方式查询当前数组大于等于num数值的最左位置
     * @param arr
     * @param num
     * @return
     */
    public static int nearLeftTest(int[] arr, int num){
        if (arr == null){
            return -1;
        }
        for (int i = 0; i < arr.length; i++){
            if (arr[i] >= num){
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
            if (nearLeft(arr, random) != nearLeftTest(arr, random)){
                bool = false;
                break;
            }
        }
        System.out.println(bool ? "Success!" : "Fail!");
    }
}
