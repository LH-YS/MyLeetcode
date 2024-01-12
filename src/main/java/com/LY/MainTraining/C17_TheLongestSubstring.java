package com.LY.MainTraining;

import java.util.ArrayList;
import java.util.Scanner;

public class C17_TheLongestSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] array = scanner.nextLine().toCharArray();
        int res = ComputeLengthOfSubstring(array);
        System.out.println(res);
    }

    private static int ComputeLengthOfSubstring(char[] array) {
        int res = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if(Character.isLetter(array[i])){
                list.add(i);
            }
        }
        if(list.size()==array.length||list.isEmpty()){
            return -1;
        }
        int[] indexs = new int[list.size()];
        int k = 0;
        for (int i:list) {
            indexs[k] = i;
            k++;
        }
        if(indexs.length==1){
            return array.length;
        }else {
            res = Math.max(res,indexs[1]-1);
            res = Math.max(res,array.length-indexs[indexs.length-2]-1);
            for (int i = 1; i < indexs.length-1; i++) {
                res = Math.max(res,(indexs[i+1]-indexs[i-1]-1));
            }
        }
        return res;
    }
}
