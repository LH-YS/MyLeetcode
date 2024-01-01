package com.LY.MainTraining;

import java.util.*;
public class C2_TheNumberOfStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int num = Integer.parseInt(s1[1]);
        int res = ComputeTheNum(s1[0],num);
        System.out.println(res);
        System.exit(0);
    }

    private static int ComputeTheNum(String s, int num) {
        //首先去重s，得到list个数
        //然后直接计算 n*（n-1）*。。。 乘num次
        int distinct_num = ComputeDistinctNum(s);
        int res = distinct_num;
        for (int i = 0; i < num-1; i++) {
            res = res * (distinct_num - 1);
        }
        return res;
    }

    private static int ComputeDistinctNum(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (!list.contains(chars[i])){
                list.add(chars[i]);
            }
        }
        return list.size();
    }
}
