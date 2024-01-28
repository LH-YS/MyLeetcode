package com.LY.MainTraining;
import java.util.*;
public class C64_TheSumOfSurvivingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int jump = scanner.nextInt();
        int left = scanner.nextInt();
        int res = computeTheSumOfSurvivingNumbers(nums,jump,left);
        System.out.println(res);
    }

    private static int computeTheSumOfSurvivingNumbers(int[] nums, int jump, int left) {
        int index = 0;
        int res = 0;
        if (nums.length<=left){
            for (int i = 0; i < nums.length; i++) {
                res+=nums[i];
            }
            return res;
        }
        int now = nums.length;
        while (now>left){
            index = findNext(nums,index,jump);
            nums[index] = -1;
            now--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=-1){
                res+=nums[i];
            }
        }
        return res;
    }

    private static int findNext(int[] nums, int index, int jump) {
        index++;
        index = index%nums.length;
        while (jump!=0){
            if (nums[index] != -1){
                jump--;
            }
            index++;
            index = index%nums.length;
        }
        //检索完所有数字后跟到最近有数字的地方
        while (nums[index]==-1){
            index++;
            index = index%nums.length;
        }
        return index;
    }
}
