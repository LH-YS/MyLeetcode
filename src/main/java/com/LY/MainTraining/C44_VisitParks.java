package com.LY.MainTraining;

import java.util.*;
public class C44_VisitParks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        int res = computeVisitParks(nums);
        System.out.println(res);
    }

    private static int computeVisitParks(int[][] nums) {
        int res = process(nums,0,0);
        return res;
    }

    private static int process(int[][] nums, int m, int n) {
        if (m==nums.length||n==nums[0].length||nums[m][n]==1){
            return 0;
        }
        if (m== nums.length-1&&n==nums[0].length-1){
            return 1;
        }
        int right = process(nums,m+1,n);
        int down = process(nums,m,n+1);
        return right+down;
    }
}
