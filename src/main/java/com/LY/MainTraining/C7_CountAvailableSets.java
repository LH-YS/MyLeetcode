package com.LY.MainTraining;

import java.util.*;
public class C7_CountAvailableSets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split("@");
        String[] str_all = strs[0].split(",");
        HashMap<String, Integer> table_all = new HashMap<>();
        for (int i = 0; i < str_all.length; i++) {
            String[] split = str_all[i].split(":");
            table_all.put(split[0],Integer.parseInt(split[1]));
        }
        if (strs.length==1){
            System.out.println(strs[0]);
            System.exit(0);
        }
        String[] str_used = strs[1].split(",");
        for (int i = 0; i < str_used.length; i++) {
            String[] split = str_used[i].split(":");
            if(table_all.containsKey(split[0])){
                table_all.put(split[0],table_all.get(split[0])-Integer.parseInt(split[1]));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String i:table_all.keySet()) {
            if(table_all.get(i)>0){
                stringBuilder.append(i+":"+table_all.get(i)+",");
            }
        }
        System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));
    }
}
