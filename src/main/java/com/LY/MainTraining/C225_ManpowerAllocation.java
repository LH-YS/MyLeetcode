package com.LY.MainTraining;
import java.io.*;
import java.util.*;
public class C225_ManpowerAllocation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int res = computeManpowerAllocation(m,nums);
        System.out.println(res);
    }

    private static int computeManpowerAllocation(int m, int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        Arrays.sort(nums);
        int left = nums[nums.length-1];
        int right = sum/(m/2) + 1;
        while (left<right){
            int mid = (left+right)/2;
            //因为两个需求，双指针
            int x = 0;
            int y = nums.length-1;
            boolean flag = true;//是否能完成任务
            int need = 0;
            while (x<=y){
                if (nums[y]>mid){
                    flag = false;
                    break;
                }
                //只有一个
                if (x==y){
                    need++;
                    x++;
                }else if (nums[x]+nums[y]<=mid){//还有大于两个需求时
                    //如果人力能满足两个需求，则同时完成两个任务
                    x++;
                    y--;
                    need++;
                }else{
                    //人力只够满足最大的那个需求
                    y--;
                    need++;
                }
                if (need>m){
                    //如果目前花费的时间超过了m，则标记失败
                    flag = false;
                    break;
                }
            }
            if (flag==true){
                //说明可以
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
}
