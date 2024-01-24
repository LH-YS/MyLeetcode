package com.LY.LeetCodeTraining;

public class Problem560_SubarraySumEqualsK {
    class Solution {
//        public int subarraySum(int[] nums, int k) {
//            int[] sum = new int[nums.length];
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = i; j < nums.length; j++) {
//                    sum[i] += nums[j];
//                }
//            }
//            int res = 0;
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = i; j < nums.length; j++) {
//                    if (j == nums.length - 1) {
//                        if (sum[i]==k){
//                            res++;
//                        }
//                    }else {
//                        if (sum[i]-sum[j+1]==k){
//                            res++;
//                        }
//                    }
//                }
//            }
//            return res;
//        }
        public int subarraySum(int[] nums, int k) {
            int res = 0;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    sum+=nums[j];
                    if (sum==k){
                        res++;
                    }
                }
                sum = 0;
            }
            return res;
        }
    }
}
