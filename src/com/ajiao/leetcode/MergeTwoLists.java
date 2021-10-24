package com.ajiao.leetcode;

/**
 *
 * 合并两个有序链表
 */


public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode2 l1 = new ListNode2(1);
        ListNode2 l2 = new ListNode2(2);
        ListNode2 l3 = new ListNode2(5);
        l1.next=l2;
        l2.next=l3;
        ListNode2 l4 = new ListNode2(0);
        ListNode2 l5 = new ListNode2(3);
        ListNode2 l6 = new ListNode2(4);
        l4.next=l5;
        l5.next=l6;

        ListNode2 listNode2 = mergeTwoLists(l1, l4);
    }
    public static ListNode2 mergeTwoLists(ListNode2 l1, ListNode2 l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}


class ListNode2{
    int val;
    ListNode2 next;
    ListNode2(int x) { val = x; }
}