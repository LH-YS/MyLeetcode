package com.LY.MainTraining;
import java.util.*;
public class C202_MaximumNumberOfServers {
    static int n;
    static int m;
    static int[][] nums;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s1 = scanner.nextLine();
            String[] split = s1.split(" ");
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(split[j]);
            }
        }
        int res = computeMaximumNumberOfServers(nums,n,m);
        System.out.println(res);
    }

    private static int computeMaximumNumberOfServers(int[][] nums, int n, int m) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res,process(nums,i,j));
            }
        }
        return res;
    }

    private static int process(int[][] nums, int i, int j) {
        //从ij出发感染，返回感染的格子个数
        if (nums[i][j]==0){
            return 0;
        }
        int sum = 1;
        nums[i][j] = 0;
        //向四个方向感染
        int left = process(nums,i==0?0:i-1,j);
        int right = process(nums,i==nums.length-1?nums.length-1:i+1,j);
        int up = process(nums,i,j==0?0:j-1);
        int down = process(nums,i,j==nums[0].length-1?nums[0].length-1:j+1);
        sum += left+right+up+down;
        return sum;
    }
}
