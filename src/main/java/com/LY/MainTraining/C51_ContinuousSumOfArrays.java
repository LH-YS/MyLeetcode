package com.LY.MainTraining;

import java.util.Scanner;

public class C51_ContinuousSumOfArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int target = scanner.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }
        int res = computeContinuousSumOfArrays(nums,target);
        System.out.println(res);
    }

    private static int computeContinuousSumOfArrays(int[] nums, int target) {
        int res = 0;
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum[i]+=nums[j];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (j!=nums.length-1){
                    if (sum[i]-sum[j+1]>=target){
                        res++;
                    }
                }else {
                    if (sum[i]>=target){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
