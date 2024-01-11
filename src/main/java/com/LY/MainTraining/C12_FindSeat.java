package com.LY.MainTraining;

import java.util.*;
public class C12_FindSeat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int res = ComputeFindSeat(str);
        System.out.println(res);
    }

    private static int ComputeFindSeat(String str) {
        int res = 0;
        char[] array = str.toCharArray();
        int length = array.length;
        if (length==1&&array[0]=='0'){
            res++;
        } else if (length==2&&array[0]=='0'&&array[1]=='0') {
            res++;
        }else {
            if (array[0]=='0'&&array[1]=='0'){
                res++;
                array[0]='1';
            }
            if (array[length-1]=='0'&&array[length-2]=='0'){
                res++;
                array[length-1]='1';
            }
            for (int i = 1; i < length-1; i++) {
                if (array[i]=='0'&&array[i-1]=='0'&&array[i+1]=='0'){
                    res++;
                    array[i] = '1';
                }
            }
        }
        return res;
    }
}
