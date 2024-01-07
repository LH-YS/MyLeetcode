package com.LY.MainTraining;
/*
    The longest specified defect degree vowel substring
 */
import java.util.*;
public class C8_TheLongestSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        ArrayList<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int res = ComputeTheLengthOfSubstring(str,target,list);
        System.out.println(res);
    }

    private static int ComputeTheLengthOfSubstring(String str, int target, ArrayList<Character> list) {
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= str.length(); j++) {
                if(i>=j){continue;}
                String tmp = str.substring(i, j);
                char t = tmp.charAt(tmp.length()-1);
                if(list.contains(tmp.charAt(0))&&list.contains(t)){
                    int count=0;
                    for (int k = 0; k < tmp.length(); k++) {
                        if (!list.contains(tmp.charAt(k))){
                            count++;
                        }
                        if(count>target){
                            break;
                        }
                    }
                    if (count==target){
                        max = Math.max(max,tmp.length());
                    }
                }
            }
        }
        return max;
    }
}
