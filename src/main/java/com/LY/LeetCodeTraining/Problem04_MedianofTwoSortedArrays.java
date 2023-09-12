package com.LY.LeetCodeTraining;

public class Problem04_MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[m+n];
        int l = 0,r = 0,k = 0;
        while(l<nums1.length||r<nums2.length){
            int number1 = l>=nums1.length?Integer.MAX_VALUE:nums1[l];
            int number2 = r>=nums2.length?Integer.MAX_VALUE:nums2[r];
            if(number1<=number2){
                res[k++] = number1;
                l++;
            }else{
                res[k++] = number2;
                r++;
            }
        }
        double result = 0;
        if((m+n)%2==1){
            result = res[(m+n)/2];
        }else{
            result = (res[(m+n)/2] + res[(m+n)/2 - 1]);
            result = result/2;
        }
        return result;
    }
    //第二种方法 通过调用递归来解决，思路是进行比较，通过对比大小来组成新的数组
    public double findMedianSortedArrays2(int[] nums1, int[] nums2){
        return 0;
    }
    public static int[] NewNums(int[] nums1, int[] nums2){
        return null;
    }
}
