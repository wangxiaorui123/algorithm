package com.example.algorithm.wxr.class01;

import java.util.Arrays;

/**
 * @author:wangxiaorui
 * @create 2020年4月23日14:44:51
 * 插入排序
 */
public class Code03_InsertionSort {

    /**
     * 插入排序
     * 时间复杂度 O(n^2)
     * @param arr
     */
    public static void insertionSort(int[] arr){
        if(arr == null && arr.length < 2){
            return;
        }

        //第一次循环，循环需要有序的0~i位置
        for (int i = 1;i < arr.length; i++){

            //第二次循环。完成当前0~i位置上有序
            //声明一个i-1的j位置，每次比较j位置和j+1位置上的数值，若前者大则交换位置
            for (int j = i-1; j >=0 && arr[j] > arr[j+1]; j--){
                swap(arr, j, j+1);
            }
        }
    }

    /**
     * 交换位置
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int arr[],  int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 系统自带的排序
     * 测试使用
     * @param arr
     */
    public static void comparator(int[] arr){ Arrays.sort(arr); };

    /**
     * 获取随机数组
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generatrRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 复制数组
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr){
        if (arr == null){
            return null;
        }
        int[] copyArr = new int[arr.length];
        System.arraycopy(arr, 0, copyArr, 0, arr.length);
        return copyArr;
    }

    /**
     * 比较两个数组是否相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2){
        if(arr1 == null && arr2 == null){
            return true;
        }
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
            return false;
        }
        if (arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i <arr1.length; i++){
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int testCount = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean bool = true;
        for (int i = 0; i < testCount; i++){
            int[] arr = generatrRandomArray(maxSize, maxValue);
            int[] copyArr = copyArray(arr);
            insertionSort(arr);
            comparator(copyArr);
            if (!isEqual(arr, copyArr)){
                bool = false;
                break;
            }
        }
        System.out.println(bool ? "Success!" : "Fail!");
    }
}
