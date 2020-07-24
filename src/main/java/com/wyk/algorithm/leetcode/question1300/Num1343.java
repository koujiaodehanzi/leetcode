package com.wyk.algorithm.leetcode.question1300;

/**
 * @author wuyankun
 * @title: Num01343
 * @projectName leetcode
 * @description:
 *  https://leetcode-cn.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 *  大小为 K 且平均值大于等于阈值的{子数组}数目
 * @date 2020/7/24 11:20
 */
public class Num1343 {

    /**
     * 重点：子数组和子序列的区别
     * @param arr
     * @param k
     * @param threshold
     * @return
     */
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0 ,result=0;
        int sumTarget = k*threshold;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int adder = sum - sumTarget;
        if (adder >= 0) {
            result++;
        }
        int pos = k;
        for (int i = 0; i < arr.length-k; i++) {
            adder = adder+arr[pos]-arr[i];
            if (adder>=0){
                result++;
            }
            pos++;
        }
        return result;
    }


}
