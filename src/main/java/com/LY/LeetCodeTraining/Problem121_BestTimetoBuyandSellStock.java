package com.LY.LeetCodeTraining;

public class Problem121_BestTimetoBuyandSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices==null||prices.length==1){
                return 0;
            }
            //维护一个最小值，当遇到比最小值小的更新，大的记录差值
            int min = Integer.MAX_VALUE;
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i]<min){
                    min = prices[i];
                }else{
                    if (prices[i] - min > res){
                        res = prices[i] - min;
                    }
                }
            }
            if (res==Integer.MIN_VALUE){
                return 0;
            }else {
                return res;
            }
        }
    }
}
