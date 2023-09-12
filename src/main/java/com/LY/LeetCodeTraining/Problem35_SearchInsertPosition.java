package com.LY.LeetCodeTraining;

public class Problem35_SearchInsertPosition {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums==null){
                return -1;
            }
            return searchFunction(nums,target,0,nums.length-1);
        }

        public int searchFunction(int[] nums, int target, int l, int r) {
            if (l==r){
                if (nums[l]==target){
                    return l;
                }else if(target>nums[l]){
                    return l+1;
                }else {
                    return l;
                }
            }

            int mid = l+(r-l)/2;
            if (target>nums[mid]){
                return searchFunction(nums,target,mid+1,r);
            } else if (target<nums[mid]) {
                return searchFunction(nums,target,l,mid-1);
            }else {
                return mid;
            }

        }
    }
}
