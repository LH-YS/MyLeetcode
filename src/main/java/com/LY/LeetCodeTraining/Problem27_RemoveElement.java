package com.LY.LeetCodeTraining;

public class Problem27_RemoveElement {
    class Solution {
        public int removeElement(int[] nums, int val) {
            //遍历数组，如果遇到匹配的数字，就把记录的长度-1，原地与数组最后一位进行交换
            //如果已经到达记录的长度就停止遍历，返回记录的长度
            int newLen = nums.length;
            int i = 0;
            while (i <= nums.length){
                if(i == newLen){
                    break;
                }
                if (nums[i] == val){
                    swapNums(nums,i,newLen-1);
                    newLen -= 1;
                    continue;
                }
                i++;
            }
            return newLen;
        }
        public void swapNums(int[] nums,int a, int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}
