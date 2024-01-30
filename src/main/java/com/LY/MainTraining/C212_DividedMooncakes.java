package com.LY.MainTraining;
import java.io.*;
import java.util.*;
public class C212_DividedMooncakes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int people = Integer.parseInt(split[0]);
        int goods = Integer.parseInt(split[1]);
        int res = computeDividedMooncakes(people,goods);
        System.out.println(res);
    }

    private static int computeDividedMooncakes(int people, int goods) {
        int[] nums = new int[people];
        if (people==1){
            return 1;
        }else if (goods<people){
            return 0;
        }
        int res = process(nums,goods,0);
        return res;
    }

    private static int process(int[] nums, int goods, int index) {
        if (index==nums.length-1){
            if (goods<=nums[index-1]&&nums[index-1]-goods<=3){
                return 1;
            }
            return 0;
        }
        int res = 0;
        int start = index==0?1:(nums[index-1]-3<1?1:nums[index-1]-3);
        int end = index==0?(goods - (nums.length - index -1)):Math.min((goods - (nums.length - index -1)),nums[index-1]);
        for (int i = start; i <= end; i++) {
            nums[index] = i;
            if (index==0||nums[index-1]-nums[index]<=3){
                res+=process(nums,goods-i,index+1);
            }
        }
        return res;
    }
}
