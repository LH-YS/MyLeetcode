package com.LY.MainTraining;

import java.util.Scanner;

public class C15_MonkeysEatPeaches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        int H = Integer.parseInt(scanner.nextLine());
        int res = ComputeLeastK(H, nums);
        System.out.println(res);
    }

    private static int ComputeLeastK(int h, int[] nums) {
        int max = FindMax(nums);
        int left = 1;
        int right = max;

        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp = tmp + (nums[i] / max);
            if (nums[i] % max != 0) {
                tmp++;
            }
        }
        if (tmp>h){
            return 0;
        }

        while (left < right) {
            int mid = (left + right) / 2;
            int used = 0;
            for (int i = 0; i < nums.length; i++) {
                used = used + (nums[i] / mid);
                if (nums[i] % mid != 0) {
                    used++;
                }
            }

            if (used > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int FindMax(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>res){
                res = nums[i];
            }
        }
        return res;
    }
}
