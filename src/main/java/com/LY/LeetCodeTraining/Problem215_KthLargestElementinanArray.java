package com.LY.LeetCodeTraining;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem215_KthLargestElementinanArray {

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if(nums==null||k>nums.length){
                return -1;
            }
            if (nums.length==1){
                return nums[0];
            }
            return process(nums,0,nums.length-1,nums.length-k);
        }

        public int process(int[] nums, int l, int r, int k) {
            if (l == r){
                return nums[l];
            }
            //从随机选取
            int pivot = nums[l+(int)Math.random()*(r-l+1)];
            //进行partition，并返回中间数坐标
            int[] range = partition(nums,l,r,pivot);
            //如果中间数的坐标等于k的坐标,则说明这部分已经排好了
            if (range[0]<=k&&range[1]>=k){
                return nums[k];
            } else if (k<range[0]) {
                return process(nums,l,range[0]-1,k);
            }else{
                return process(nums,range[1]+1,r,k);
            }
        }

        public int[] partition(int[] nums, int l, int r, int pivot) {
            int less = l-1;
            int more = r+1;
            int cur = l;
            while (cur<more){
                if(nums[cur]<pivot){
                    swap(nums,++less,cur++);
                }else if(nums[cur]==pivot){
                    cur++;
                }else {
                    swap(nums,cur,--more);
                }
            }
            return new int[]{less+1,more-1};
        }
        public void swap(int[] nums,int a,int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }








//调用系统的快速排序问题在于，我们只求前K大的数字，其实在快排过程中已经找到了

    //    class Solution {
//        public int findKthLargest(int[] nums, int k) {
//            Arrays.sort(nums);
//            return nums[k-1];
//        }
//    }







//    class Solution {
//        public int findKthLargest(int[] nums, int k) {
//            if (nums == null || k > nums.length) {
//                return -1;
//            }
//            if (nums.length == 1) {
//                return nums[0];
//            }
//            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new MyComparator());
//            for (int i = 0; i < nums.length; i++) {
//                priorityQueue.add(nums[i]);
//            }
//            for (int i = 0; i < k - 1; i++) {
//                priorityQueue.poll();
//            }
//            return priorityQueue.poll();
//        }
//
//        public class MyComparator implements Comparator<Integer> {
//
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        }
//    }
}
