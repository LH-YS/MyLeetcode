package com.LY.LeetCodeTraining;

public class Problem42_TrappingRainWater {
    class Solution {
        public int trap(int[] height) {
            if (height==null||height.length<2){
                return 0;
            }
            int lenOfnums = height.length;
            int leftMax = height[0];
            int rightMax = height[lenOfnums - 1];
            int L = 1;
            int R = lenOfnums - 2;
            int water = 0;
            while (L <= R) {
                if (leftMax <= rightMax) {
                    water += Math.max(0, leftMax - height[L]);
                    leftMax = Math.max(leftMax, height[L++]);
                } else {
                    water += Math.max(0, rightMax - height[R]);
                    rightMax = Math.max(rightMax, height[R--]);
                }
            }
            return water;
        }
    }
}
