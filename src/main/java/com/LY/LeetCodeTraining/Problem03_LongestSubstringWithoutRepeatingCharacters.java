package com.LY.LeetCodeTraining;

public class Problem03_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        char[] str = s.toCharArray();
        int pre = -1;
        int[] map = new int[256];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        int maxlength = 0;
        int cur = 0;
        for (int i = 0; i != str.length ; i++) {
            pre = Math.max(pre,map[str[i]]);
            cur = i - pre;
            maxlength = Math.max(maxlength,cur);
            map[str[i]] = i;
        }
        return maxlength;
    }
}
