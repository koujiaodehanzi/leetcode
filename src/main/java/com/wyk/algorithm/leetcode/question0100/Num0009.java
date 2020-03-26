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

    public boolean IsPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
    }

}
