package com.LY.LeetCodeTraining;

import java.util.Arrays;
import java.util.Comparator;

public class Problem179_LargestNumber {
    class Solution {
        public String largestNumber(int[] nums) {
            String[] str = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                str[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(str,new MyComparator());
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < str.length; i++) {
                stringBuffer.append(str[i]);
            }
            String res = stringBuffer.toString();
            int index = -1;//用来表示res中第一个不是0的坐标
            char[] chars = res.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i]!='0'){
                    index = i;
                    break;
                }
            }
            return index==-1?"0":res.substring(index);
        }
        public class MyComparator implements Comparator<String> {

            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        }
    }
}
