package com.LY.MainTraining;
import java.util.*;
public class C65_WhisperTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int res = computeWhisperTime(nums);
        System.out.println(res);
    }

    private static int computeWhisperTime(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        int max = Integer.MIN_VALUE;
        while (!list.isEmpty()){
            int temp = list.pollFirst();
            int left = 2*temp+1;
            int right = 2*temp+2;
            if (left<nums.length&&nums[left]!=-1){
                nums[left]+=nums[temp];
                list.add(left);
                max = Math.max(max,nums[left]);
            }
            if (right<nums.length&&nums[right]!=-1){
                nums[right]+=nums[temp];
                list.add(right);
                max = Math.max(max,nums[right]);
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }
}
