package com.wyk.algorithm.leetcode.question0100;

/**
 * @Author: wyk
 * @Description:
 * @Date: Create in 2020/3/30 0:15
 * @Modified By:
 */
public class Num0190 {

    /**
     * 颠倒给定的 32 位无符号整数的二进制位。
     *
     * 示例 1：
     *
     * 输入: 00000010100101000001111010011100
     * 输出: 00111001011110000010100101000000
     * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     *       因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
     */

    public int reverseBits(int n) {
        int ans = 0;
        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            ans += (n & 1) << bitsSize;
        }
        return ans;
    }

}