package com.LY.MainTraining;
import java.io.*;
import java.util.*;
public class C212_ProjectScheduling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int[] nums = new int[split.length];
        int sum = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
            sum+=nums[i];
            if (nums[i]>maxNum){
                maxNum = nums[i];
            }
        }
        int people = Integer.parseInt(br.readLine());
        int res = computeProjectScheduling(nums,people,sum,maxNum);
        System.out.println(res);
    }

    private static int computeProjectScheduling(int[] nums, int people, int sum, int maxNum) {
        if (people<1){
            return 0;
        }
        int left = maxNum;
        int right = sum;
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        while (l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        while (left<right){
            int mid = (left+right)/2;
            int[] days = new int[people];
            if (!process(nums,days,0,mid)){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
    //  选择nums的任务分配给某人，并在过程中记录最大日期
    private static boolean process(int[] nums, int[] days, int index,int mid) {
        if (index>=nums.length){
            return true;
        }
        boolean flag = false;
        //分配
        for (int i = 0; i < days.length; i++) {
            days[i] += nums[index];
            if (days[i]>mid){
                days[i] -= nums[index];
                continue;
            }
            if (process(nums,days,index+1,mid)){
                //说明这种分法存在，直接跳出循环
                flag = true;
                break;
            }
            days[i] -= nums[index];
            if (days[i]==0||days[i]==mid){
                break;
            }
        }
        return flag;
    }
}
