package com.LY.MainTraining;

import java.util.*;

public class C50_MaxNumberOfGroups {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        int res = computeMaxNumberOfGroups(target,nums);
        System.out.println(res);
    }

    private static int computeMaxNumberOfGroups(int target, int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            if (nums[right]>=target){
                res++;
                right--;
            }else {
                //找到满足条件的队友
                while (left<right&&nums[left]+nums[right]<target){
                    left++;
                }
                if (left<right&&nums[left]+nums[right]>=target){
                    left++;
                    right--;
                    res++;
                }
            }
        }
        if (left==right&&nums[left]>=target){
            res++;
        }
        return res;
    }
}
