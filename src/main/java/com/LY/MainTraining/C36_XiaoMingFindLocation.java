package com.LY.MainTraining;

import java.util.*;
public class C36_XiaoMingFindLocation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int target = scanner.nextInt();
        int res = computeXiaoMingFindLocation(nums,target);
        System.out.println(res+1);
    }

    private static int computeXiaoMingFindLocation(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int mid = (left+right)/2;
            if (target>nums[mid]){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        if (left==nums.length-1){
            if (nums[left]<target){
                left++;
            }
        }
        return left;
    }
}
