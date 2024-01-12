package com.LY.MainTraining;

import java.util.*;
public class C21_TheWealthiestFamily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String[] str = scanner.nextLine().split(" ");
        int[] wealth = new int[str.length];
        for (int i = 0; i < wealth.length; i++) {
            wealth[i] = Integer.parseInt(str[i]);
        }
        int[] Family = new int[wealth.length];
        for (int i = 0; i < Family.length; i++) {
            Family[i] = wealth[i];
        }
        while (scanner.hasNext()){
            String[] tmpstr = scanner.nextLine().split(" ");
            Family[Integer.parseInt(tmpstr[0])-1] += wealth[Integer.parseInt(tmpstr[1])-1];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < Family.length; i++) {
            if (Family[i]>max){
                max = Family[i];
            }
        }
        System.out.println(max);
    }
}
