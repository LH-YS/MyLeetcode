package com.LY.MainTraining;

import java.util.*;
public class C40_TheNumberOfWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String[] str = new String[length];
        for (int i = 0; i < length; i++) {
            str[i] = scanner.nextLine();
        }
        String source = scanner.nextLine();
        int res = computeTheNumberOfWords(str,source);
        System.out.println(res);
    }

    private static int computeTheNumberOfWords(String[] str, String source) {
        char[] chars = source.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])){
                map.put(chars[i],1);
            }else {
                map.put(chars[i],map.get(chars[i])+1);
            }
        }
        int res = 0;
        for (int i = 0; i < str.length; i++) {
            char[] array = str[i].toCharArray();
            HashMap<Character, Integer> copymap = Copymap(map);
            boolean flag = true;
            for (int j = 0; j < array.length; j++) {
                if (copymap.containsKey(array[j])&&copymap.get(array[j])>0){
                    copymap.put(array[j],copymap.get(array[j])-1);
                } else if (copymap.containsKey('?')&&copymap.get('?')>0) {
                    copymap.put('?',copymap.get('?')-1);
                } else {
                    flag = false;
                    break;
                }
            }
            res = flag==true?res+1:res;
        }
        return res;
    }

    private static HashMap<Character, Integer> Copymap(HashMap<Character, Integer> map) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (Character i:map.keySet()){
            map1.put(i,map.get(i));
        }
        return map1;
    }
}
