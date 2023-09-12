package com.LY.LeetCodeTraining;

public class Problem10_PalindromeNumber {
    class Solution {
        public boolean isPalindrome(int x) {
            if (x<0){
                return false;
            }
            if (x==0){
                return true;
            }

            int y = x;
            int res = 0;
            while (y!=0){
                res *= 10;
                res += (y%10);
                y = y/10;
            }
            return res==x?true:false;
        }
    }
}
