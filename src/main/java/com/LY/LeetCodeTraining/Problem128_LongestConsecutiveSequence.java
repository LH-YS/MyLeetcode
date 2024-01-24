package com.LY.LeetCodeTraining;

import java.util.Arrays;
import java.util.HashSet;

public class Problem128_LongestConsecutiveSequence {
    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums==null||nums.length==0){
                return 0;
            }else if (nums.length==1){
                return 1;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            int[] temp = new int[set.size()];
            int k = 0;
            for (int i:set){
                temp[k++] = i;
            }
            Arrays.sort(temp);
            int index = 1;
            int res = Integer.MIN_VALUE;
            int sum = 1;
            while (index<temp.length){
                if(temp[index]==temp[index-1]+1){
                    sum++;
                }else {
                    res = Math.max(res,sum);
                    sum = 1;
                }
                index++;
            }
            res = Math.max(res,sum);
            return res;
        }
    }
}
