package com.LY.LeetCodeTraining;

public class Problem45_JumpGameII {



    //从开头开始遍历数组，分别找到能到达的最远距离，每一次更新最远距离跳数+1，直到到达最远距离
    class Solution {
        public int jump(int[] nums) {
            int end = 0;
            int index = 0;
            int res = 0;
            int maxpos = 0;
            while (index<nums.length){
                maxpos = Math.max(maxpos,index+nums[index]);
                if(index == end){
                    end = maxpos;
                    res++;
                }
                index++;
            }

            return res;
        }
    }




    //    class Solution {
//        public int jump(int[] nums) {
//            int index = nums.length-2;
//            int res = 0;
//            int next = nums.length-1;
//            while (index>0){
//                for (int i = next; i >=0 ; i--) {
//                    if (nums[next]-i<=nums[i]){
//                        index = i;
//                    }
//                }
//                next = index;
//                index--;
//                res++;
//            }
//
//            return res;
//        }
//    }










//    class Solution {
//        public int jump(int[] nums) {
//            int[] record = new int[nums.length];
//            for (int i = 0; i < record.length; i++) {
//                record[i] = -1;
//            }
//            if(nums[0] == 0||nums.length==1){
//                return 0;
//            }
//            //process函数代表从nums的index下标开始起跳的最小跳跃次数
//            return processJump(nums,0,record);
//        }
//
//        public int processJump(int[] nums, int index, int[] record) {
//            if (nums[index]==0){
//                return 0;
//            }
//            if (record[index]!=-1){
//                return record[index];
//            }
//            if (nums[index]>=nums.length-1-index){
//                record[index] = 1;
//                return 1;
//            }
//            int min = Integer.MAX_VALUE;
//            //如果一次跳不到，那么一个个试,先跳一次，再从index+i开始
//            for (int i = nums[index]; i > 0; i--) {
//                int temp = processJump(nums,index+i, record);
//                if (temp<min&&temp!=0){
//                    min = temp;
//                }
//            }
//            record[index] = min+1;
//            return min==Integer.MAX_VALUE?0:min+1;
//        }
//    }
}
