package com.LY.MainTraining;
import java.util.*;
public class C38_MaximumPurchaseQuantity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        if (length==0){
            System.out.println(0);
            return;
        }
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }
        int value = scanner.nextInt();
        int res = computeMaximumPurchaseQuantity(nums,value);
        System.out.println(res);
    }

    private static int computeMaximumPurchaseQuantity(int[] nums, int value) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MIN_VALUE;
        while (left<=right&&right<nums.length){
            sum+=nums[right];
            if (sum<=value){
                res = Math.max(res,right-left+1);
                right++;
            }else {
                if(left==right){
                    left++;
                    right++;
                    sum=0;
                    continue;
                }
                while (left<=right&&sum>value){
                    sum-=nums[left];
                    left++;
                }
                res = Math.max(res,right-left+1);
            }
        }
        if (res==Integer.MIN_VALUE){
            return 0;
        }
        return res;
    }
}
