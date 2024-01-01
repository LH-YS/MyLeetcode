package com.LY.MainTraining;

import java.util.Scanner;

public class C1_TheNumberOfMountain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums_str = scanner.nextLine().split(", ");
        int[] nums = new int[nums_str.length];
        for (int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.valueOf(nums_str[i]);
        }
        //如果元素个数小于3则输入错误
        if(nums.length<3){
            System.out.println("invalid input");
            System.exit(0);
        }
        int MN = 0;//山脉的个数
        //数组第一个大于等于第二，则边界是山脉；同理最后一个也是
        //判断山头
        if(nums[0]>nums[1]){
            MN++;
        }
        //判断山尾
        if(nums[nums.length-1]>nums[nums.length-2]){
            MN++;
        }
        //判断山中
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
                MN++;
            }
        }
        System.out.println(MN);
        System.exit(0);
    }
}
