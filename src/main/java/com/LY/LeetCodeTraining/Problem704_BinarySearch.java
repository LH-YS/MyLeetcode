package com.LY.LeetCodeTraining;

import java.util.Arrays;

public class Problem704_BinarySearch {
    public int search(int[] nums, int target) {
        Arrays.sort(nums);
        int res = SearchNum(nums,target,0,nums.length-1);
        return res;
    }

    public int SearchNum(int[] nums, int target,int L,int R) {
        if(L==R){
            if (nums[L]==target){
                return L;
            }else {
                return -1;
            }
        }

        int left = SearchNum(nums,target,L,(L+R)/2);
        int right = SearchNum(nums,target,(L+R)/2+1,R);

        if (left!=-1||right!=-1){
            return left==-1?right:left;
        }
        return -1;
    }
}
