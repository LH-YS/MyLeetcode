package com.LY.LeetCodeTraining;

public class Problem1143_LongestCommonSubsequence {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            char[] char1 = text1.toCharArray();
            char[] char2 = text2.toCharArray();
            int[][] record = new int[char1.length+1][char2.length+1];
            for (int i = 0; i < char1.length+1; i++) {
                for (int j = 0; j < char2.length+1; j++) {
                    record[i][j] = -1;
                }
            }
            int res = processing(record,char1,char2,0,0);
            return res;
        }
        //返回值是 从left和right开始的字符串有几个最长公共子序列
        private int processing(int[][] record, char[] char1, char[] char2, int left, int right) {
            if (left==char1.length||right==char2.length){
                record[left][right] = 0;
                return 0;
            }
            if (record[left][right]!=-1){
                return record[left][right];
            }

            if (char1[left]==char2[right]){
                //相等，则sum+1，同时往前进一格
                int res = processing(record,char1,char2,left+1,right+1);
                record[left][right] = res+1;
                return res+1;
            }else {
                //不相等则返回两种情况最大的那个
                int resLeft = processing(record,char1,char2,left+1,right);
                int resRight = processing(record,char1,char2,left,right+1);
                record[left][right] = Math.max(resLeft,resRight);
                return Math.max(resLeft,resRight);
            }
        }
    }
}
