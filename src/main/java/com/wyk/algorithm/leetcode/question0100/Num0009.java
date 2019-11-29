package com.wyk.algorithm.leetcode.question0100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuyankun
 * @title: Num0009
 * @projectName leetcode
 * @description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @date 2019/11/2511:24
 */
public class Num0009 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        if (x == 0){
            return  true;
        }

        List<Integer> list = new ArrayList<>();
        int mod;
        while (true){
            mod = x % 10;
            x = x / 10;

            list.add(mod);

            if (x == 0){
                break;
            }
        }

        int left=0, right=list.size()-1;
        while (left < right){
            if (!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
