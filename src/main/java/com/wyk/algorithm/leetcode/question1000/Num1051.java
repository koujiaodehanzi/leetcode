package com.wyk.algorithm.leetcode.question1000;

/**
 * @author wuyankun
 * @title: Num1051
 * @projectName leetcode
 * @description:
 *  https://leetcode-cn.com/problems/height-checker/
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * 请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
 * 注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。

 * @date 2020/7/24 16:18
 */
public class Num1051 {

    /**
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) count++;
            }
        }
        return count;
    }

}
