package com.ajiao.leetcode;

import java.util.*;

public class LRU {
    private HashMap<Integer,Node> map;
    private DoubleList cache;
    private int cap;

    public LRU(int cap){
            this.cap = cap;
            map = new HashMap<>();
            cache = new DoubleList();

    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key,int val){
        if(map.containsKey(key)){
            deleteKey(key);
            addRecently(key,val);
            return;
        }
        if(cap==cache.size()){
            removeLeastRecently();
        }
        addRecently(key,val);
    }

    //将某个key提升为最近使用的
    private void makeRecently(int key){
        Node x = map.get(key);
        //链表中删除节点
        cache.remove(x);
        //重新插入到队尾
        cache.addLast(x);
    }

    //添加最近使用的元素
    private void addRecently(int key,int value){
        Node x = new Node(key,value);
        cache.addLast(x);
        map.put(key,x);
    }

    //删除某一个key
    private void deleteKey(int key){
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    //删除最久未使用的元素
    private void removeLeastRecently(){
        Node deleteNode = cache.removeFirst();
        int deleteKey = deleteNode.key;
        map.remove(deleteKey);
    }
}

class DoubleList{
    //头尾虚节点
    private Node head,tail;
    //链表元素数
    private int size;

    public DoubleList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next=tail;
        tail.prev=head;
        size = 0;
    }

    //链表尾部添加X
    public void addLast(Node x){
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next=x;
        tail.prev = x;
        size++;
    }
    //删除x节点
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    //删除第一个节点
    public Node removeFirst(){
        if(head.next==tail){
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    //返回链表长度
    public int size(){
        return size;
    }
}

class Node{
    public int key,val;
    public Node next,prev;
    public Node(int k,int v){
        this.key = k;
        this.val = v;
    }
}


