package com.LY.MainTraining;

import java.util.*;
public class C11_LongestStringInTheRing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] array = str.toCharArray();
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]=='o'){
                res++;
            }
        }
        if(res%2==1){
            System.out.println(str.length()-1);
        }else {
            System.out.println(str.length());
        }
    }
}
