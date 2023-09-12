package com.LY.LeetCodeTraining;

public class Problem26_RemoveDuplicatesfromSortedArray {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums==null){
                return 0;
            }
            if (nums.length==1){
                return 1;
            }
            //双指针，p负责扫描，q负责刷新
            int p = 1;
            int q = 0;

            while (p<nums.length){
                if (nums[p]==nums[q]){
                    p++;
                }else{
                    nums[++q] = nums[p++];
                }
            }
            return q+1;
        }
    }
}
