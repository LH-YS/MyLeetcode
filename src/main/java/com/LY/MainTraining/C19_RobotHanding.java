package com.LY.MainTraining;

import java.util.*;
public class C19_RobotHanding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        int res = ComputeRobotHanding(nums);
        System.out.println(res);
    }

    private static int ComputeRobotHanding(int[] nums) {
        if(nums.length>8){
            return -1;
        }
        int left = 1;
        int right = ComputMaxOfRobotHandingNums(nums);
        while (left<right){
            int time = 0;
            int mid = (left+right)/2;
            for (int i = 0; i < nums.length; i++) {
                time = time+(nums[i]/mid);
                if (nums[i]%mid!=0){
                    time++;
                }
            }
            if(time>8){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    private static int ComputMaxOfRobotHandingNums(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return max;
    }
}
