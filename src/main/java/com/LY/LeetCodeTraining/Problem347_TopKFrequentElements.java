package com.LY.LeetCodeTraining;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Problem347_TopKFrequentElements {
    class Solution {

        class NumberCount{
            int num;
            int count;
            NumberCount(int val,int count1){
                num = val;
                count = count1;
            }
        }


        public int[] topKFrequent(int[] nums, int k) {
            if (nums==null||k<=0){
                return null;
            }
            if (nums.length==1){
                return nums;
            }

            HashMap<Integer, NumberCount> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if(!map.containsKey(nums[i])){
                    map.put(nums[i],new NumberCount(nums[i],1));
                }else {
                    map.get(nums[i]).count++;
                }
            }

            PriorityQueue<NumberCount> priorityQueue = new PriorityQueue<>(new MyComparator());
            for (NumberCount value : map.values()) {
                priorityQueue.add(value);
            }
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = priorityQueue.poll().num;
            }
            return res;
        }
        public class MyComparator implements Comparator<NumberCount>{

            @Override
            public int compare(NumberCount o1, NumberCount o2) {
                return o2.count - o1.count;
            }
        }
    }
}
