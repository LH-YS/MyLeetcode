package com.LY.trainingcamp.class04;

public class Manacher {
    public static int maxPlen(String s){
        if(s==null || s.length()==0){
            return 0;
        }
        //"123" "#1#2#3#"
        char[] str = manacherString(s);
        //回文半径的大小
        int[] pArr = new int[str.length];
        int C = -1;
        //讲述中，R代表最右的扩成功的位置 coding最右的扩成功的位置的再下一个位置
        int R = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length ; i++) {
            //i位置从左往后依次扩张
            //i位置扩出来的答案，i位置扩的区域，至少是多大
            //R第一个违规的位置 i>=R就代表了i在边界外
            //2*C-i是i的对称点
            pArr[i] = R > i ? Math.min(pArr[2*C-i],R-i):1;

            while (i+pArr[i]< str.length&&i-pArr[i]>-1){
                if(str[i+pArr[i]] == str[i-pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }


            //如果i扩张比R大那就刷新R和中心
            if (i+pArr[i]>R){
                R = i+pArr[i];
                C = i;
            }
            max = Math.max(max,pArr[i]);
        }
        return max -1;


    }

    public static char[] manacherString(String s) {
        char[] chars = new char[s.length() * 2 + 1];
        char[] toCharArray = s.toCharArray();
        int i = 0;
        for (char c : toCharArray) {
            chars[i++] = '#';
            chars[i++] = c;
        }
        chars[i] = '#';
        return chars;
    }

    public static void main(String[] args) {
        String str = "abcd12321wdwq";
        System.out.println(maxPlen(str));
    }
}
