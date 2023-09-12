package com.LY.LeetCodeTraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15_TreeSum {

    //将两数之和拓展成三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //先对数组进行排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                List<List<Integer>> nexts = twosum(nums, i + 1, -nums[i]);
                for (List<Integer> cur : nexts) {
                    cur.add(0, nums[i]);
                    res.add(cur);
                }
            }
        }
        return res;
    }


    //找出数组上两数之和为target的组合
    public List<List<Integer>> twosum(int[] nums, int begin, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int L = begin;
        int R = nums.length - 1;
        while (L < R) {
            if (nums[L] + nums[R] < target) {
                L++;
            } else if (nums[L] + nums[R] > target) {
                R--;
            } else {
                if (L == begin || nums[L] != nums[L - 1]) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[L]);
                    cur.add(nums[R]);
                    res.add(cur);
                }
                L++;
            }
        }
        return res;
    }
}
