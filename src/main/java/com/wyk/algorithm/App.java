package com.wyk.algorithm;

import com.wyk.algorithm.leetcode.question0100.Num0028;
import com.wyk.algorithm.utils.PrintUtil;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Num0028 num0028 = new Num0028();
        int[] next = num0028.get_next("ABCDABDBCD");
        PrintUtil.printIntArr(next);
    }
}
