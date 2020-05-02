package com.example.algorithm.wxr.class01;

/**
 * @author:wangxiaorui
 * @create 2020年4月27日15:34:07
 * 异或运算和同或运算
 */
public class Code08_EvenTimesOddTimes {

    /**
     * 一个数组中有一个数字出现了奇数次，其他数字都出现了偶数次，计算出这个奇数次的数字
     * 原理：异或运算，0 ^ N = N , N ^ N = 0。所以把这个数组里的所有数字都进行异或运算，偶数次的数字最后都会成0，0 ^ N = N，所有异或运算后的数字就是出现奇数次的那个数字。
     * @param arr
     * @return
     */
    public static int getNum1(int[] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++){
            eor ^= arr[i];
        }
        return eor;
    }

    /**
     * 获取某个数字的二进制位最右侧的1
     * @param num
     * @return
     */
    public static int getNum2(int num){
        //例如一个二进制数字1100101010，~（取反）后的二进制是0011010101，然后+1就变成了0011010110，最后进行&运算
        //1100101010
        //0011010110
        //上面两个数进行&运算后的数字就成了0000000010，这样就提取出了最右侧的1
        return num & ((~num) + 1);
    }

    /**
     * 一个数组中有两个不相同的数字出现了奇数次，其他数字都出现了偶数次，计算出出现奇数次的这两个数字
     * @param arr
     */
    public static void getNum3(int[] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++){
            eor ^= arr[i];
        }
        //假设出现的奇数次的两个数字是a和b，则eor = a ^ b.且a != b,eor != 0
        //eor != 0,则代表eor的二进制数值中至少有一个1
        //计算出最右侧的1
        int rightOne = getNum2(eor);
        int onlyOne = 0;
        //利用rightOne跟数组中的每个数字进行&运算
        //两个出现了奇数次的数字不相等，并且这个rightOne是a ^ b后的结果，至少a和b在这个rightOne为1的数字上不同。
        //则&运算会把整个数组分成两部分，一部分是rightOne最右侧为1的地方是1的，一部分是0的。并且a和b必然一部分一个。
        //就把问题分解成上面第一个问题，计算一堆数字中出现奇数次的数值
        for (int i = 0; i < arr.length; i++){
            //&（与）运算就是二进制位上有0即为0，没有0则是两个1，则为1.
            //|（或）运算就是二进制位上有1即为1，没有1则是两个0，则为0
            //~（非）运算就是二进制位上颠倒，0改成1,1改成0
            //^（异或）运算就是二进制位上相加，相加后=2的记为0，相当于0 + 0 = 0 || 0 + 1 = 1 || 1 + 0 = 1 || 1 + 1 = 0
            if ((arr[i] & rightOne) != 0){//数组上的数&上rightOne，因为rightOne除了一位上是1其他都是0，最后计算后不等于0的就是那一位上是1
                onlyOne ^= arr[i];//把这部分的数字都进行^运算，最后的值就是两个奇数次中的一个
            }
        }
        System.out.println(onlyOne +" "+ (onlyOne ^ eor));
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,4};
        getNum3(arr);
        int[] arr1 = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,4};
        System.out.println(getNum1(arr1));
    }
}
