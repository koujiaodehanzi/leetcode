package com.wyk.algorithm.utils;

/**
 * @author wuyankun
 * @title: PrintUtil
 * @projectName leetcode
 * @description: TODO
 * @date 2019/6/616:44
 */
public class PrintUtil {

    public static void printIntArr(int[] arr){
        StringBuilder result = new StringBuilder("[");
        for (int i : arr){
            result.append(i).append(",");
        }
        result.deleteCharAt(result.length()-1).append("]");
        System.out.println(result);
    }

}
