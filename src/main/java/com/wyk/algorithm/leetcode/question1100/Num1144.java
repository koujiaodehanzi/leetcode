package com.wyk.algorithm.leetcode.question1100;

/**
 * @author wuyankun
 * @title: Num1144
 * @projectName leetcode
 * @description:
 * https://leetcode-cn.com/problems/decrease-elements-to-make-array-zigzag/
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 *  每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 *  或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 *  返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 * @date 2020/7/24 15:46
 */
public class Num1144 {

    /**

     */


    /**
     *
     * @param nums
     * @return
     */
    public int movesToMakeZigzag(int[] nums) {
        int ans1 = 0, ans2 = 0;
        for (int i=0; i<nums.length; i++){
            if (i % 2 == 0){
                // 如果是偶数位置
                int d1 = (i==0 || nums[i]<nums[i-1] ) ? 0 : ( nums[i]-nums[i-1]+1);
                int d2 = (i==nums.length-1 || nums[i]<nums[i+1] ) ? 0 : ( nums[i]-nums[i+1]+1);
                ans1 += Math.max(d1, d2);
            }else {
                // 如果是奇数位置
                int d1 = (nums[i]<nums[i-1] ) ? 0 : ( nums[i]-nums[i-1]+1);
                int d2 = (i==nums.length-1 || nums[i]<nums[i+1] ) ? 0 : ( nums[i]-nums[i+1]+1);
                ans2 += Math.max(d1, d2);
            }
        }
        return Math.min(ans1, ans2);
    }

}
