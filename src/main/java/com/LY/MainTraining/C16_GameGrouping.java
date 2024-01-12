package com.LY.MainTraining;

import java.util.Scanner;

public class C16_GameGrouping {
    static int sum_all = 0;
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        ComputeGameGrouping(nums);
        System.out.println(res);
    }

    private static void ComputeGameGrouping(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            sum_all+=nums[i];
        }
        GameGrouping(nums,0,0,0);
    }

    private static void GameGrouping(int[] nums, int index, int count, int sum) {
        if (sum>sum_all/2||index==10){
            return ;
        }
        //如果第一个队伍选了五个人，就计算此时的res
        if (count==5){
            int new_res = (sum_all-sum) - sum;
            res = Math.min(res,new_res);
            return;
        }
        //选第一个队员进队伍
        GameGrouping(nums,index+1,count+1,sum+nums[index]);
        //不选第一个队员进队伍
        GameGrouping(nums,index+1,count,sum);
    }
}