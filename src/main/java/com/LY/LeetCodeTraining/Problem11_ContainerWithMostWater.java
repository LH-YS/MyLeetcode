package com.LY.LeetCodeTraining;

public class Problem11_ContainerWithMostWater {
    class Solution {
        public int maxArea(int[] height) {
            if (height == null || height.length < 2) {
                return 0;
            }
            int len = height.length;
            int leftMax = height[0];
            int rightMax = height[len - 1];
            int L = 0;
            int R = len-1;
            int water = Math.min(leftMax,rightMax)*(len-1);
            while (L<R){
                if (leftMax<=rightMax){
                    while (L<R&&height[L]<=leftMax){
                        L++;
                    }
                    water = Math.max(water,(R-L)*Math.min(height[L],rightMax));
                    leftMax = height[L];
                }else {
                    while (L<R&&height[R]<=rightMax){
                        R--;
                    }
                    water = Math.max(water,(R-L)*Math.min(leftMax,height[R]));
                    rightMax = height[R];
                }
            }
            return water;
        }
    }
}
