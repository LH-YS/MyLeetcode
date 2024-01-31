package com.LY.MainTraining;
import java.io.*;
public class C219_PairProgramming {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] nums = new int[len];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int res = computePairProgramming(nums);
        System.out.println(res);
    }

    private static int computePairProgramming(int[] nums) {
        int res = process(nums,0,new int[3],0);
        return res;
    }

    private static int process(int[] nums, int nIndex, int[] used,int uIndex) {
        if (uIndex==3){
            //判断三个是否满足要求
            boolean flag = false;
            if (used[0]<used[1]&&used[1]<used[2]){
                flag = true;
            }else if(used[0]>used[1]&&used[1]>used[2]){
                flag = true;
            }
            if (flag){
                return 1;
            }else {
                return 0;
            }
        }
        int res = 0;
        for (int i = nIndex; i <nums.length; i++) {
            used[uIndex] = nums[i];
            res+=process(nums,i+1,used,uIndex+1);
            used[uIndex] = 0;
        }
        return res;
    }
}
