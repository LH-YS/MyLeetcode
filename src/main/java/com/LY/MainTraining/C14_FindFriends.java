package com.LY.MainTraining;

import java.util.*;
public class C14_FindFriends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String[] str = scanner.nextLine().split(" ");
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        int[] res = ComputeFindFriends(nums);
        for (int i = 0; i < res.length-1; i++) {
            System.out.print(res[i]+" ");
        }
        System.out.print(res[res.length-1]);
    }

    private static int[] ComputeFindFriends(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i]<nums[j]){
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
}
