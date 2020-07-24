package com.wyk.algorithm.leetcode.question0000;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuyankun
 * @title: Num0001
 * @projectName leetcode
 * @description: TODO
 * @date 2019/6/615:25
 */
public class Num0001 {

    public static void main(String[] args) {
        int[] sum = twoSum(new int[]{3, 3}, 6);
        for (int i:sum) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target){
        if (nums == null || nums.length < 2){
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int sub = target-nums[i];
            if (map.containsKey(sub)){
                return new int[]{map.get(sub), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


}
