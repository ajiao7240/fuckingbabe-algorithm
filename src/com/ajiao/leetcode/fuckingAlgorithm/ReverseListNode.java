package com.ajiao.leetcode.fuckingAlgorithm;

/**
 * @author panrunqiao
 * @version 1.0.0
 * @ClassName ReverseListNode.java
 * @Description 反转链表
 * @createTime 2021年10月24日 10:10:00
 */
public class ReverseListNode {
    //后驱节点
    ListNode successor = null;

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    ListNode reverse(ListNode head){
        //base case
        if(head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        //new head,always the last one
        return last;
    }

    /**
     * 反转前N个节点
     * @param head
     * @param n
     * @return
     */
    ListNode reverseN(ListNode head,int n){
        if(n==1){
            //record successor && base case
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * 反转m~n个节点
     * @param head
     * @param m
     * @param n
     * @return
     */
    ListNode reverseBetween(ListNode head,int m, int n){
        if(m==1){
            return reverseN(head,n);
        }
        //前进
        head.next = reverseBetween(head.next,m-1,n-1);
        return head;
    }
}
