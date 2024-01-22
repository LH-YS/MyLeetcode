package com.LY.MainTraining;

import java.util.*;
public class C45_FindEnglishWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        String target = scanner.nextLine();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String[] s = split[i].split(" ");
            for (int j = 0; j < s.length; j++) {
                list.add(s[j]);
            }
        }
        ArrayList<String> list1 = new ArrayList<>();
        for (String i:list){
            String[] split1 = i.split("'");
            for (int j = 0; j < split1.length; j++) {
                list1.add(split1[j]);
            }
        }
        ArrayList<String> res = computeFindEnglishWords(list1,target);
        Collections.sort(res);
        HashSet<String> set = new HashSet<>();
        if (res.isEmpty()){
            System.out.println(target);
        }else {
            for(String i:res){
                    if(!set.contains(i)){
                        System.out.print(i + " ");
                        set.add(i);
                    }
                }
            }
    }

    private static ArrayList<String> computeFindEnglishWords(ArrayList<String> list, String target) {
        ArrayList<String> res = new ArrayList<>();
        for (String i:list) {
            if(i.length()>=target.length()){
                String temp = i.substring(0, target.length());
                if (temp.equals(target)){
                    if(Character.isLetter(i.charAt(i.length()-1))){
                        res.add(i);
                    }else {
                        res.add(i.substring(0,i.length()-1));
                    }
                }
            }
        }
        return res;
    }
}
