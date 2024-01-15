package com.LY.MainTraining;

import java.util.*;
public class C34_GPUScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int length = scanner.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        int res = computeGOUScheduling(nums,n);
        System.out.println(res);
    }

    private static int computeGOUScheduling(int[] nums, int n) {
        int current = 0;
        int time = 0;
        for (int i = 0; i < nums.length; i++) {
            time++;
            current+=nums[i];
            current-=n;
            current = current<0?0:current;
        }
        time+=(current/n);
        if (current%n!=0){
            time+=1;
        }
        return time;
    }

}
