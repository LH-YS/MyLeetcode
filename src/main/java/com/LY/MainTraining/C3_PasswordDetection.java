package com.LY.MainTraining;

import java.util.Scanner;

public class C3_PasswordDetection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuffer res = new StringBuffer();
        boolean isBig = false;
        boolean isSmall = false;
        boolean isNum = false;
        boolean isSpec = false;
        char[] chars = s.toCharArray();
        //得到真实密码
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='<'){
                if(res.length()>0){
                    //res减去最后一个元素
                    res.deleteCharAt(res.length()-1);
                }
            }else{
                res.append(chars[i]);
            }
        }
        //遍历真实密码，判断每个条件是否符合
        for (int i = 0; i < res.length(); i++) {
            char c = res.charAt(i);
            if(Character.isDigit(c)){
                isNum = true;
            } else if (Character.isLowerCase(c)){
                isSmall = true;
            } else if(Character.isUpperCase(c)){
                isBig = true;
            }else{
                isSpec = true;
            }
        }
        //最后判断
        boolean flag = false;
        if(res.length()>=8&&isSmall==true&&isBig==true&&isNum==true&&isSpec==true){
            flag=true;
        }
        System.out.println(res.toString()+","+flag);
    }
}
