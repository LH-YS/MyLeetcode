package com.LY.MainTraining;
import java.util.*;
import java.io.*;
public class C215_DiskBackup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int res = computeDiskBackup(nums);
        System.out.println(res);
    }

    private static int computeDiskBackup(int[] nums) {
        int left = 1;
        int right = nums.length;
        Arrays.sort(nums);
        while (left<right){
            int mid = (left+right)/2;
            if (isOK(nums,mid)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    private static boolean isOK(int[] nums, int mid) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < mid; i++) {
            priorityQueue.add(500);
        }
        for (int i = nums.length-1; i >=0; i--) {
            if (priorityQueue.isEmpty()){
                return false;
            }
            int poll = priorityQueue.poll();
            if (poll>nums[i]){
                priorityQueue.add(poll-nums[i]);
            } else if (poll==nums[i]) {
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}
