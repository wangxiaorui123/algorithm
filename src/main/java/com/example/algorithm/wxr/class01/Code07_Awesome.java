package com.example.algorithm.wxr.class01;

/**
 * @author:wangxiaorui
 * @create 2020年4月27日11:00:40
 * 查询当前数组中局部最小值
 */
public class Code07_Awesome {

    /**
     * 查询当前数组中的局部最小值（局部最小值：一个数没有他左边的数大的同时也没有他右边的数大）
     * 时间复杂度O(logN)
     * @param arr
     * @return
     */
    public static int getLessIndex(int[] arr){
        if (arr == null || arr.length == 0){
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]){
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]){
            return arr.length - 1;
        }
        int L = 1;
        int R = arr.length - 2;
        int mid = 0;
        while (L < R){
            mid = L + ((R - L) >> 1);
            if (arr[mid] > arr[mid + 1]){
                L = mid + 1;
            }else if (arr[mid] > arr[mid - 1]){
                R = mid - 1;
            }else {
                return mid;
            }
        }
        return L;
    }

    /**
     * 验证获取到的局部最小值下标是否符合局部最小值
     * @param arr
     * @param index
     * @return
     */
    public static boolean checkLessIndex(int[] arr, int index){
        if (arr.length == 1){
            return true;
        }else if (index == 0 && arr[index] <= arr[index + 1]){
            return true;
        }else if (index == arr.length - 1 && arr[index] <= arr[index - 1]){
            return true;
        }else if (arr[index] <= arr[index - 1] && arr[index] <= arr[index + 1]){
            return true;
        }
        return false;
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

    public static void printArray(int[] arr){
        if (arr == null){
            return;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+ " ");
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
            int index = getLessIndex(arr);
            if (index != -1){
                if (!checkLessIndex(arr, index)){
                    bool = false;
                    break;
                }
            }
        }
        System.out.println(bool ? "Success!" : "Fail!");
    }
}
