package com.example.algorithm.wxr.class01;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;

/**
 * @author:wangxiaorui
 * 冒泡排序
 * @create 2020年4月20日17:43:28
 */
public class Code01_BubbleSort {

    /**
     * 冒泡排序
     * 时间复杂度O(N^2)
     * @param arr
     */
    public static void BubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        //第一次循环，循环整个数组
        for(int i = arr.length - 1; i > 0; i--){
            //循环0~arr.length
            for(int j = 0; j < i; j++){
                //每次比较后，若前一个比后一个大，就交换位置
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 系统自带排序算法
     * 对数器
     * 测试使用
     * @param arr
     */
    public static void comparator(int[] arr){ Arrays.sort(arr); }

    /**
     * 生成随机数组
     * 测试使用
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 复制一个数组
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr){
        if(arr == null){
            return null;
        }
        int[] copyArr = new int[arr.length];
        //第一种复制数组的方法
        /*for (int i = 0; i < arr.length; i++){
            copyArr[i] = arr[i];
        }*/
        //第二种复制数组的方法
        /*copyArr = (int[]) arr.clone();*/
        //第三种复制数组的方法
        System.arraycopy(arr, 0, copyArr, 0, arr.length);
        return copyArr;
    }

    /**
     * 比较两个数组是否长度和每个数值都相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static Boolean isEquals(int[] arr1, int[] arr2){
        if(arr1 == null && arr2 == null){
            return true;
        }
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
            return false;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int testCount = 500000;
        int maxSize = 100;
        int maxValue = 500;
        Boolean bool = true;
        for (int i = 0; i < testCount; i++){
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] copyArr = copyArray(arr);
            if(!isEquals(arr, copyArr)){
                bool = false;
                break;
            }
        }
        System.out.println(bool == true ? "Success!" : "Fail!");
    }
}
