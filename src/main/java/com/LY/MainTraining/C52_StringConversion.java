package com.LY.MainTraining;
import java.util.*;
public class C52_StringConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = Integer.parseInt(scanner.nextLine());
        String[] split = scanner.nextLine().split("-");
        String res = computeStringConversion(target,split);
        System.out.println(split[0]+"-"+res);
    }

    private static String computeStringConversion(int target, String[] split) {
        ArrayList<String> list = new ArrayList<>();
        int number = 0;//已经有了n个
        int upNum = 0;
        int lowNum = 0;
        char[] chars = new char[target];
        for (int i = 1; i < split.length; i++) {
            for (int j = 0; j < split[i].length(); j++) {
                if (number<target){
                    char c = split[i].charAt(j);
                    chars[number] = c;
                    number++;
                    if (Character.isUpperCase(c)){
                        upNum++;
                    }else if (Character.isLowerCase(c)){
                        lowNum++;
                    }
                }else {
                    //如果数量够了就闭合
                    if (upNum>lowNum){
                        for (int k = 0; k < target; k++) {
                            if (Character.isLowerCase(chars[k])){
                                chars[k] = Character.toUpperCase(chars[k]);
                            }
                        }
                    } else if (upNum<lowNum) {
                        for (int k = 0; k < target; k++) {
                            if (Character.isUpperCase(chars[k])){
                                chars[k] = Character.toLowerCase(chars[k]);
                            }
                        }
                    }
                    StringBuilder builder = new StringBuilder();
                    for (int k = 0; k < chars.length; k++) {
                        builder.append(chars[k]);
                    }
                    list.add(builder.toString());
                    chars = new char[target];
                    number = 0;
                    upNum = 0;
                    lowNum = 0;
                    j--;
                }
            }
        }
        if (number!=0){
            //如果数量够了就闭合
            if (upNum>lowNum){
                for (int k = 0; k < target; k++) {
                    if (Character.isLowerCase(chars[k])){
                        chars[k] = Character.toUpperCase(chars[k]);
                    }
                }
            } else if (upNum<lowNum) {
                for (int k = 0; k < target; k++) {
                    if (Character.isUpperCase(chars[k])){
                        chars[k] = Character.toLowerCase(chars[k]);
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
            for (int k = 0; k < number; k++) {
                builder.append(chars[k]);
            }
            list.add(builder.toString());
        }
        StringBuilder res = new StringBuilder();
        for (String i:list){
            res.append(i+"-");
        }
        String str = res.toString();
        return str.substring(0,str.length()-1);
    }
}
