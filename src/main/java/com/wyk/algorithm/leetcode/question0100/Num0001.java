package com.wyk.algorithm.leetcode.question0100;

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

    }

    public static int[] twoNumSum(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            if (map.containsKey(target-arr[i])){
                return new int[]{map.get(target-arr[i]), arr[i]};
            }
            map.put(arr[i], i);
        }
        return null;
    }

}
