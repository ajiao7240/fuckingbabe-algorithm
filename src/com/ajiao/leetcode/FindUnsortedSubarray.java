package com.ajiao.leetcode;

/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 */


public class FindUnsortedSubarray {
    public static void main(String[] args) {
        int[] nums = {3, 6, 4, 8, 10, 9 , 15};
        System.out.println(findUnsortedSubarray(nums));
    }
    public static int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int left = 0, right = -1;
        int max = nums[0], min = nums[length-1];
        for(int i = 0; i<length; i++){
            if(nums[i] < max)
                right = i;
            else
                max = nums[i];
            if(nums[length - i -1] > min)
                left = length - i -1;
            else
                min = nums[length - i -1];
        }
        return right-left+1;
    }
}
