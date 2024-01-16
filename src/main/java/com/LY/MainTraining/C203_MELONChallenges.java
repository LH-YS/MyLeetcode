package com.LY.MainTraining;

import java.util.Scanner;

public class C203_MELONChallenges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }
        int res = computeMELONChallenges(nums,0,0);
        System.out.println(res);
    }

    //返回值为最少次数达到平衡
    private static int computeMELONChallenges(int[] nums,int startindex,int sum) {
        if (startindex>=nums.length){
            return -1;
        }
        int count = 0;
        int Aadd = process(nums,startindex+1,count+nums[0],sum+1);
        int Badd = process(nums,startindex+1,count-nums[0],sum);
        if(Aadd==-1&&Badd==-1){
            return -1;
        }else {
            Aadd = Aadd==-1?Integer.MAX_VALUE:Aadd;
            Badd = Badd==-1?Integer.MAX_VALUE:Badd;
            return Math.min(Aadd,Badd);
        }
    }

    private static int process(int[] nums, int index, int count,int sum) {
        //如果平衡了返回sum
        if (count==0&&index==nums.length){
            return sum;
        }
        if (index>=nums.length){
            return -1;
        }
        //如果不平衡，继续放石头
        int Aadd = process(nums,index+1,count+nums[index],sum+1);
        int Badd = process(nums,index+1,count-nums[index],sum);
        if(Aadd==-1&&Badd==-1){
            return -1;
        }else {
            Aadd = Aadd==-1?Integer.MAX_VALUE:Aadd;
            Badd = Badd==-1?Integer.MAX_VALUE:Badd;
            return Math.min(Aadd,Badd);
        }
    }
}
