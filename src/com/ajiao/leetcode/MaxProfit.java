package com.ajiao.leetcode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 *
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int pre = 0;
        int beh = 0;
        int profit = 0;
        int temp = 0;
        for(int i=0,j=1;i<prices.length-1;i++,j=i+1){
            pre = prices[i];

            while(j<prices.length){
                beh = prices[j];
                if(beh>pre){
                    temp = beh - pre;
                    if(temp>profit){
                        profit=temp;
                    }
                }
                j++;
            }
        }
        return profit;
    }

    //todo 动态规划
    public static int maxProfit2(int[] prices) {
        if(prices.length == 0 ) return 0;
        int max = 0 ,min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min){
                max = Math.max(max,prices[i]-min);//f(i)=max(f(i-1),f(i))
            }else{
                min = prices[i];
            }
        }
        return max;
    }

}
