package com.wyk.algorithm.leetcode.question0100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wuyankun
 * @title: Num0002
 * @projectName leetcode
 * @description: TODO
 * @date 2019/6/615:25
 */
public class Num0002 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);

        while (listNode.next != null){
            System.out.print(listNode.next.val + " -> ");
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        Queue<Integer> queue = new LinkedList();
        boolean jinwei = false;
        int num;

        while (l1 != null && l2 != null){
            num = l1.val + l2.val + (jinwei?1:0);

            if (num > 9){
                jinwei = true;
                num = num - 10;
            }else {
                jinwei = false;
            }

            queue.add(num);

            l1 = l1.next;
            l2 = l2.next;

            /**
             * 三种情况：
             *  1.l1的长度小于l2,l1补0
             *  2.l2的长度小于l1,l2补0
             *  3.l1和l2的长度相等,并且前面有进位,挡遍历到最高位时,最高位提升一位补1
             */
            if (l1 == null && l2 != null){
                l1 = new ListNode(0);
            }else if (l2 == null && l1 != null){
                l2 = new ListNode(0);
            }else if (l1 == null && l2 == null && jinwei){
                queue.add(1);
            }
        }

        // 构造一个包含虚拟头结点的链表
        ListNode dummyHead = new ListNode(-1);

        // 依次从队列中取出数值,插入链表
        ListNode p = dummyHead;
        while (!queue.isEmpty()) {
            p.next = new ListNode(queue.remove());
            p = p.next;
        }

        return dummyHead;
    }

    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
  }

}
