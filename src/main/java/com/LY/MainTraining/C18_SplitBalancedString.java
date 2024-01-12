package com.LY.MainTraining;

import java.util.*;

public class C18_SplitBalancedString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        int res = ComputeSplitBalancedString(chars);
        System.out.println(res);
    }

    private static int ComputeSplitBalancedString(char[] chars) {
        int res = 0;
        int balance = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='X'){
                balance+=1;
            }else {
                balance-=1;
            }
            if (balance==0){
                res++;
            }
        }
        return res;
    }
}
