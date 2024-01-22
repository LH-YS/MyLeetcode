package com.LY.MainTraining;

import java.util.*;
public class C48_LeastNumberOfCars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int res = computeLeastNumberOfCars(nums);
        System.out.println(res);
    }

    private static int computeLeastNumberOfCars(int[] nums) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1){
                count++;
            }else {
                if (count!=0){
                    res += count/3 + count%3==0?0:1;
                    count = 0;
                }
            }
        }
        if (count!=0){
            res += (count/3) + (count%3==0?0:1);
            count = 0;
        }
        return res;
    }
}
