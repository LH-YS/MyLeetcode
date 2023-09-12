package com.LY.LeetCodeTraining;

public class Problem05_LongestPalindrome {
    class Solution {
        public String longestPalindrome(String s) {
            char[] charArr = getmanacherString(s);
            int[] pArr = new int[charArr.length];
            int R = -1;//最有边界
            int C = -1;//最右边界对应的中心
            int maxOfpArr = Integer.MIN_VALUE;
            int maxMid = Integer.MIN_VALUE;
            for (int i = 0; i < charArr.length; i++) {
                //减少重复计算
                pArr[i] = R > i ? Math.min(R - i, pArr[2 * C - i]) : 1;
                //在以上基础上开始拓展
                while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                    if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
                        pArr[i]++;
                    } else {
                        break;
                    }
                }
                //更新
                if (i + pArr[i] > R) {
                    R = i + pArr[i];
                    C = i;
                }
                if (pArr[i] > maxOfpArr) {
                    maxOfpArr = pArr[i];
                    maxMid = i;
                }
            }
            StringBuffer res = new StringBuffer();
            for (int i = maxMid - maxOfpArr + 1; i < maxMid + maxOfpArr; i++) {
                if (i % 2 == 1) {
                    res.append(charArr[i]);
                }
            }
            return res.toString();
        }

        private char[] getmanacherString(String s) {
            char[] chars = new char[2 * s.length() + 1];
            chars[0] = '#';
            char[] str = s.toCharArray();
            int index = 1;
            for (int i = 0; i < str.length; i++) {
                chars[index++] = str[i];
                chars[index++] = '#';
            }
            return chars;
        }
    }
}
