package com.LY.MainTraining;

import java.util.*;
/*
    本题一个关键点是不要用StringBuffer，会超时，应该用StringBuilder
 */
public class C5_TheSumOfContinuousNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        System.out.println(target+"="+target);
        List<String> res = new ArrayList<>();

        for (int i = 1; i < target; i++) {
            int j = i;
            int sum = 0;
            StringBuilder buffer = new StringBuilder();
            while (sum<target){
                sum+=j;
                buffer.append("+"+j);
                if (sum==target){
                    res.add(target+"="+buffer.substring(1,buffer.length()));
                }
                j++;
            }
        }
        Collections.sort(res, Comparator.comparingInt(String::length));
        for (String re : res) {
            System.out.println(re);
        }
        System.out.println("Result:"+(res.size()+1));
    }
}

