package com.example.algorithm.wxr.class01;

import java.util.Arrays;

/**
 * @author:wangxiaorui
 * @create 2020年4月24日21:19:42
 */
public class Code04_BSExist {

    /**
     * 判断一个数组中是否有一个数值
     * 时间复杂度O(logN)
     * 前提：数组必须有序
     * @param arr
     * @param num
     * @return
     */
    public static boolean exist(int[] arr, int num){
        if (arr == null || arr.length == 0){
            return false;
        }
        //定义二分法需要比较的数组首尾下标
        int L = 0;
        int R = arr.length - 1;
        //定义中点位置
        int mid = 0;
        while (L < R){
            //生成当前查询范围的中间点
            mid = L + ((R - L) >> 1);//等同于(L + R) / 2,但是由于预防越界溢出
            if (arr[mid] == num){//如果中点值等于num
                return true;
            }else if (arr[mid] > num){//如果中点值大于num,数组是有序数组，则num所处位置一定为L ~ 当前中点前一位
                R = mid - 1;
            }else{//如果中点值小于num,数组是有序数组，则num所处位置一定为当前中点后一位 ~ R
                L = mid + 1;
            }
        }
        //二分到最后都没有找到，则判断当前范围的最小值是否等于num
        return arr[L] == num;
    }

    /**
     * 循环数组的方式查找当前数组是否包含num值
     * @param arr
     * @param num
     * @return
     */
    public static boolean existTest(int[] arr, int num){
        if(arr == null || arr.length == 0){
            return false;
        }
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == num){
                return true;
            }
        }
        return false;
    }

    /**
     * 生成随机数组
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] createRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0;i < arr.length; i++){
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 复制一个相同的数组
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr){
        if(arr == null){
            return null;
        }
        int[] copyArr = new int[arr.length];
        System.arraycopy(arr, 0, copyArr, 0, arr.length);
        return copyArr;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void printArray(int[] arr){
        if (arr == null){
            return;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testCount = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean bool = true;
        for (int i = 0; i < testCount; i++){
            int[] arr = createRandomArray(maxSize, maxValue);
            int[] copyArr = copyArray(arr);
            Arrays.sort(arr);
            Arrays.sort(copyArr);
            int random = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
            if (exist(arr, random) != existTest(copyArr, random)){
                System.out.println("随机数："+random);
                System.out.print("数组arr：");
                printArray(arr);
                System.out.print("数组copyArr：");
                printArray(copyArr);
                System.out.println("exist结果："+exist(arr, random));
                System.out.println("existTest结果："+existTest(copyArr, random));
                bool = false;
                break;
            }
        }
        System.out.println(bool ? "Success!" : "Fail!");
    }
}
