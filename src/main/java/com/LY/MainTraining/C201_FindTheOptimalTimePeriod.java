package com.LY.MainTraining;

import java.util.*;

public class C201_FindTheOptimalTimePeriod {

    public static class MyPeriod{
        int left;
        int right;
        public MyPeriod(int left,int right){
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = Integer.parseInt(scanner.nextLine());
        String[] str = scanner.nextLine().split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        ArrayList<MyPeriod> res = computeFindTheOptimalTimePeriod(nums,target);
        if (res.isEmpty()){
            System.out.println("NULL");
            return ;
        }
        int count = 0;
        for (MyPeriod i:res){
            if (count==res.size()-1){
                System.out.print(i.left+"-"+i.right);
                break;
            }
            System.out.print(i.left+"-"+i.right+" ");
            count++;
        }
    }

    public static ArrayList<MyPeriod> computeFindTheOptimalTimePeriod(int[] nums, int target) {
        ArrayList<MyPeriod> list = new ArrayList<>();
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j >= i; j--) {
                sums[i]+=nums[j];
            }
        }
        int length = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                double tmp = 0;
                tmp = j == nums.length-1?(double)sums[i]/(j-i+1):(double)(sums[i]-sums[j+1])/(j-i+1);
                if (tmp<=target){
                    if (j-i+1>length){
                        list.clear();
                        list.add(new MyPeriod(i,j));
                        length = j-i+1;
                    }else if(j-i+1==length){
                        list.add(new MyPeriod(i,j));
                    }
                }
            }
        }
        return list;
    }
}
