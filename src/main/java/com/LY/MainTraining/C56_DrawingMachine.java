package com.LY.MainTraining;
import java.util.*;
public class C56_DrawingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int length = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);
        int[][] nums = new int[length][2];
        for (int i = 0; i < length; i++) {
            String[] split = scanner.nextLine().split(" ");
            nums[i][0] = Integer.parseInt(split[0]);
            nums[i][1] = Integer.parseInt(split[1]);
        }
        int res = computeDrawingMachine(nums,end);
        System.out.println(res);
    }

    private static int computeDrawingMachine(int[][] nums, int end) {
        int res = 0;
        int cur = 0;
        int high = 0;
        for (int i = 0; i < nums.length; i++) {
            res += (nums[i][0] - cur)*Math.abs(high);
            high += nums[i][1];
            cur = nums[i][0];
        }
        //最后再闭合一次
        res += (end - cur)*Math.abs(high);
        return res;
    }
}
