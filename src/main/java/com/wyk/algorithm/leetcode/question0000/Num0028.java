package com.wyk.algorithm.leetcode.question0000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuyankun
 * @title: Num0028
 * @projectName leetcode
 * @description: TODO
 * @date 2020/3/25 15:44
 */
public class Num0028 {

    /**
     * 实现 strStr() 函数。
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * 示例 1:
     *
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     *
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     */

    public int strStr(String haystack, String needle){
        if(needle.length()==0)return 0;
        int i=0,m=haystack.length();//文本指针i用来指示文本串
        int j=0,n=needle.length();//模式指针j用来指示模式串
        int[] nextVal = get_nextVal(needle);
        while(i<m&&j<n){
            if(j==-1||needle.charAt(j)==haystack.charAt(i)){
                i++;
                j++;
            } else {
                j=nextVal[j];
            }
        }
        return j==n?i-j:-1;
    }

    public int[] get_next(String pat){
        int n=pat.length();
        int[] next = getDefaultIntArr(pat);//这里数组大小为n+1，要算上pat[n-1]
        int k=-1,j=0;
        while(j<n){
            if(k==-1||pat.charAt(k)==pat.charAt(j)) next[++j]=++k;//k，j指针都右移一位
            else k=next[k];//后缀指针k回退到next[k]（下标）的位置
        }
        return next;
    }



    //优化：get_nextVal
    public int[] get_nextVal(String pat){
        int n=pat.length();
        int[] next = getDefaultIntArr(pat);//这里next数组大小为n，已经算上pat[n-1]了
        int k=-1,j=0; //j:记录当前下标; k记录当前位的next
        while(j<n-1){
            if(k==-1||pat.charAt(k)==pat.charAt(j)){
                k++;j++;
                if(pat.charAt(j)!=pat.charAt(k)) next[j]=k;
                else next[j]=next[k];
            }
            else k=next[k];// 回溯当前位的next
        }
        return next;
    }

    private int[] getDefaultIntArr(String pat){
        int [] arr = new int[pat.length()+1];
        for (int i=0; i<pat.length(); i++){
            arr[i] = -1;
        }
        return arr;
    }

}
