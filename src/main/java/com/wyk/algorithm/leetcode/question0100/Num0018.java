package com.wyk.algorithm.leetcode.question0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wuyankun
 * @title: Num0001
 * @projectName leetcode
 * @description: TODO
 * @date 2019/6/615:25
 */
public class Num0018 {

    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * 注意：
     * 答案中不可以包含重复的四元组。
     * 示例：
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     * 满足要求的四元组集合为：
     * [
     *   [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2]
     * ]
     */

    public static List<Integer> nums = null;

    public static List<List<Integer>> results = new ArrayList<>();

    public static void main(String[] args){
        int[] arr = new int[]{1, 0, -1, 0, -2, 2};
        Arrays.sort(arr);
        sum(0, arr);
//        nSum(arr, 0, 4, new ArrayList<Integer>());
        for (List<Integer> list : results){
            System.out.println(list);
        }
    }

    public static void sum(int target, int[] arr){
        int len = arr.length;
        for (int i=0; i<len-3; i++){

            if (i>0 && arr[i]==arr[i-1]){
                continue;
            }

            for (int j=i+1; j<len-2; j++){

                if (j>0 && arr[j]==arr[j-1]){
                    continue;
                }

                int m = j+1;
                int n = arr.length-1;
                while(m < n){
                    int sum = arr[i] + arr[j] + arr[m] + arr[n];
                    if (sum == target){
                        results.add(Arrays.asList(new Integer[]{arr[i],arr[j],arr[m],arr[n]}));
                        while (m<n && arr[m]==arr[m+1]){
                            m++;
                        }
                        while (m<n && arr[n]==arr[n-1]){
                            n--;
                        }
                        m++;
                        n--;
                    }else if (sum > target){
                        n--;
                    }else{
                        m++;
                    }
                }

            }
        }
    }

    public static void nSum(int[] arr, int target, int n, List<Integer> result){
        if (arr.length < n || n<2 || n*arr[0]> target || n*arr[arr.length-1]<target){
            return;
        }
        if (n==2){
            int start = 0;
            int end = arr.length-1;
            while (start<end){
                int sum = arr[start] + arr[end];
                if (sum > target){
                    end--;
                }else if (sum < target){
                    start++;
                }else {
                    result.add(arr[start]);
                    result.add(arr[end]);
                    while (start < end && arr[start] == arr[start+1]){
                        start++;
                    }
                    while (start < end && arr[end] == arr[end-1]){
                        end--;
                    }
                }
            }
        }else{
            for (int i=0; i<arr.length-n+1; i++){
                if ((i>0 && arr[i]==arr[i+1]) || (arr[i]+n*arr[arr.length-1] < target)){
                    continue;
                }
                if (n*arr[i] > target){
                    break;
                }
                if (n*arr[i]==target && i+n-1<arr.length && arr[i+n-1]==arr[i]){

                    nSum(arr, target-arr[i], n-1, result);
                }
            }
        }
    }

}
