package com.LY.LeetCodeTraining;

public class Problem10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        char pre = 'a';
        if (str.length<pattern.length){
            return false;
        }
        int i = 0,j = 0;
        while (i<str.length&&j<pattern.length){
            if(pattern[j]=='.'){
                i++;
                j++;
            }else if(pattern[j]=='*'){
                break;
            }else{
                if(str[i]!=pattern[j]){
                    if (j!=pattern.length-1){
                        if (pattern[j+1]=='*'){
                            j = j+2;
                            continue;
                        }else{
                            return false;
                        }
                    }else {
                        return false;
                    }
                }
                i++;
                j++;
            }
        }
        if (j>= pattern.length&&i!=str.length){
            return false;
        }

        return true;
    }
}
