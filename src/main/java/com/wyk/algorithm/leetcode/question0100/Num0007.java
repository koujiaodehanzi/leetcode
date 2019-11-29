package com.wyk.algorithm.leetcode.question0100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuyankun
 * @title: Num0007
 * @projectName leetcode
 * @description: TODO
 * @date 2019/11/2510:34
 */
public class Num0007 {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    /**
     * 本地运行成功，提交运行失败。不知道原因在哪
     * @param x
     * @return
     */
    public static int reverse(int x) {
        if (x == Integer.MIN_VALUE){
            return 0;
        }

        int target = 0;
        int i = 0;

        while (true){
            int mod = x % 10;
            x = x / 10;

            target = target * 10 + mod;

            i++;
            if (x == 0){
                break;
            }
        }
        return target;
    }

}
