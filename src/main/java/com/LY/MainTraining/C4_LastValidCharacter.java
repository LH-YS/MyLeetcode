package com.LY.MainTraining;

import java.util.Scanner;

public class C4_LastValidCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        String L = scanner.nextLine();
        char[] SC = S.toCharArray();
        char[] LC = L.toCharArray();
        int left = 0;
        int right = 0;
        while (left<SC.length&&right<LC.length){
            if (SC[left]==LC[right]){
                left++;
            }
            right++;
        }
        if(left==SC.length){
            //说明此时匹配到了最后 有效字符为right-1
            System.out.println(right-1);
        }else {
            //说明没匹配完 输出-1
            System.out.println(-1);
        }
    }
}
