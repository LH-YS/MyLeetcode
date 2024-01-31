package com.LY.MainTraining;
import java.util.*;
import java.io.*;
public class C223_EmployeeDispatch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        long[] nums = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        long res = computeEmployeeDispatch(nums);
        System.out.println(res);
    }

    private static long computeEmployeeDispatch(long[] nums) {
        long x = nums[0];
        long y = nums[1];
        long left = nums[2]+nums[3];
        long right = 1000000000L;
        while (left<right){
            long mid = left + (left-right)/2;
            //算出不能1-mid中不能去A国家和B国家以及都不能去的人
            long ANot = mid/x;
            long BNot = mid/y;
            long ABNot = mid/(x*y);
            //不能去B的全部去A，不能去A的全部去B
            long Aneed = Math.max(0,nums[2]-(BNot - ABNot));
            long Bneed = Math.max(0,nums[3]-(ANot-ABNot));
            long beside = mid - (ANot+BNot-ABNot);
            if (beside>=Aneed+Bneed){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
}
