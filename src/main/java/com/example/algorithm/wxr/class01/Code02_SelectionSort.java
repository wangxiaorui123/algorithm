package com.example.algorithm.wxr.class01;

import java.util.Arrays;

/**
 * @author:wangxiaorui
 * @create 2020年4月20日16:18:27
 * 选择排序
 */
public class Code02_SelectionSort {

    /**
     * 选择排序
     * 时间复杂度O(N^2)
     * @param arr
     */
    public static void SelectionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //第一次循环，循环整个数组
        for(int i = 0; i < arr.length; i++){
            //定义当前循环范围内(i~arr.length-1)最小值的下标
            int minIndex = i;
            //第二次循环，循环比较当前最小数值（下标为minIndex）与比i下标大的数值的比较，数值小值把下标付给minIndex
            for(int j = i+1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            //循环结束后minIndex下标的数值则为当前范围内的最小数值，把minIndex下标的数值与当前范围内最左边（i下标）的值交换
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmep = arr[i];
        arr[i] = arr[j];
        arr[j] = tmep;
    }

    /**
     *系统提供的排序方法
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
        //生成最大Size内的随机大小数组
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for(int i = 0; i < arr.length; i++){
            //生成一个maxValue+1的随机数 - maxValue的随机数
            //即得到一个[-?, +?]的一个有负数的数组
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 复制一个数组
     * 测试使用
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr){
        if(arr == null){
            return null;
        }
        //复制一个长度相等的数组
        int[] copyArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    /**
     * 判断两个数组是否长度，每个数值都相等
     * 测试使用
     * @param arr1
     * @param arr2
     * @return
     */
    public static Boolean isEquals(int[] arr1, int[] arr2){
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
            return false;
        }
        if(arr1 == null && arr2 == null){
            return true;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return  false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int testCount = 500000;
        int maxSize = 100;
        int maxValue = 500;
        Boolean bool = true;
        System.out.println("开始时间"+System.currentTimeMillis());
        for(int i = 0; i < testCount; i++){
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] copyArr = copyArray(arr);
            SelectionSort(arr);
            comparator(copyArr);
            if(!isEquals(arr, copyArr)){
                bool = false;
                break;
            }
        }
        System.out.println(bool == true ? "Success!" : "Fail!");
        System.out.println("结束时间"+System.currentTimeMillis());
    }

}
