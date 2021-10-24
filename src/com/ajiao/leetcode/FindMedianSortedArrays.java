package com.ajiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        double medianSortedArrays = findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
        System.out.println(medianSortedArrays);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        if(m==0&&n==1){
            return nums2[0];
        }
        if(m==1&&n==0){
            return nums1[0];
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list1.add(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            list2.add(nums2[i]);
        }
        list1.addAll(list2);
        Collections.sort(list1);
        if (list1.size()%2==0){
            return (double) (list1.get(list1.size()/2)+list1.get((list1.size()/2)-1))/2;
        }else {
            return list1.get(list1.size()/2);
        }
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        if(m==0&&n==1){
            return nums2[0];
        }
        if(m==1&&n==0){
            return nums1[0];
        }
        int i=0,j=0;
        int temp = m>n?m:n;
        return 0;
    }
}
