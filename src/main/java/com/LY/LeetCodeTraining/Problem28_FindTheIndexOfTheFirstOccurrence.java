package com.LY.LeetCodeTraining;

public class Problem28_FindTheIndexOfTheFirstOccurrence {
    public static int getIndexOf(String s,String m){
        if (s==null||m==null||s.length()<m.length()){
            return -1;
        }
        if (m.length()==0){
            return 0;
        }
        //kmp
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int x = 0,y = 0;
        int[] next = getNextArr(str2);

        while (x< str1.length&&y<str2.length){
            if (str1[x]==str2[y]){
                x++;
                y++;
            } else if (next[y] == -1) {
                x++;
            }else {
                y = next[y];
            }
        }
        return y==str2.length?x-y:-1;
    }

    public static int[] getNextArr(char[] str) {
        if (str.length==1){
            return new int[]{-1};
        }
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;//cn位置与i-1位置比较
        while (i<next.length){
            if (str[i-1]==str[cn]){
                next[i++] = ++cn;
            }else if (cn>0){
                cn = next[cn];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }
    public int strStr(String haystack, String needle) {
        return getIndexOf(haystack, needle);
    }
}
