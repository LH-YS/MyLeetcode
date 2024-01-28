package com.LY.MainTraining;
import java.util.*;
public class C69_GreedyMonkey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        int count = scanner.nextInt();
        int res = computeGreedyMonkey(nums,count);
        System.out.println(res);
    }

    private static int computeGreedyMonkey(int[] nums, int count) {
        if (count>=nums.length){
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum+=nums[i];
            }
            return sum;
        }
        if (count==0){
            return 0;
        }
        int res = process(nums,count,0,nums.length-1,0);
        return res;
    }

    private static int process(int[] nums, int count, int left, int right, int sum) {
        if (count==0){
            //表示不能再获取了，输出sum
            return sum;
        }
        int first = process(nums,count-1,left+1,right,sum+nums[left]);
        int last = process(nums,count-1,left,right-1,sum+nums[right]);
        return Math.max(first,last);
    }
}
