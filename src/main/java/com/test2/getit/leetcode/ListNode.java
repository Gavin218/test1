package com.test2.getit.leetcode;

/**
 * @ClassName: ListNode
 * @Description: 数据结构——链表
 * @Author Chen Gavin
 * @Date 2021/12/4
 * @Version 1.0
 */


public class ListNode {

    int val;

    ListNode next;

    ListNode(){}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
