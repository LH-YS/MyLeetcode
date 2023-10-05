package com.LY.LeetCodeTraining;

public class Problem34_FindFirstAndLastPositionOfElement {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return new int[]{-1,-1};
        }
        //先二分查找到目标值，然后左右扩
        int L = 0;
        int R = nums.length - 1;
        int M = 0;
        int index = -1;
        while (L < R) {
            M = (L + R) / 2;
            if (nums[M] == target) {
                index = M;
                break;
            }
            if (nums[L] <= target && target < nums[M]) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        if (index == -1) {
            return new int[]{-1,-1};
        } else {
            //左右两边扩
            int left = index;
            int right = index;
            while (left >= 0 && nums[left] == target) {
                left--;
            }
            while (right < nums.length && nums[right] == target) {
                right++;
            }
            if (left == -1 || left != index) {
                left++;
            }
            if (right == nums.length || right != index) {
                right--;
            }
            return new int[]{left, right};
        }
    }
}
