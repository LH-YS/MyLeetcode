package com.LY.MainTraining;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    敏感字段加密
    给定一个由多个命令字组成的命令字符串：
    1、字符串长度小于等于127字节，只包含大小写字母，数字，下划线和偶数个双引号；
    2、命令字之间以一个或多个下划线_进行分割；
    3、可以通过两个双引号””来标识包含下划线_的命令字或空命令字（仅包含两个双引号的命令字），双引号不会在命令字内部出现；
    请对指定索引的敏感字段进行加密，替换为******（6个*），并删除命令字前后多余的下划线_。 如果无法找到指定索引的命令字，输出字符串ERROR。

    1
    password__a12345678_timeout_100

    password_******_timeout_100

    2
    aaa_password_"a12_45678"_timeout__100_""_

    aaa_password_******_timeout_100_""
 */
public class P0_Sensitivefield {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        String tempStr = "";//保存临时结果
        List<String> list = new ArrayList<>();
        //开始解析
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '"' && tempStr.contains(chars[i] + "")) {
                //第一种情况，已经包含了一个引号，这时候结算
                tempStr += chars[i];
                list.add(tempStr);
                tempStr = "";
            }else if (!tempStr.contains('"'+"")&&chars[i]=='_'){
                //没有双引号有下划线，不为空结算，防止连续下划线
                if (!tempStr.isEmpty()){
                    list.add(tempStr);
                    tempStr = "";
                }
            } else if (i == chars.length - 1) {
                //结尾不可能是下划线，如果是，那前面有引号，照样结算
                tempStr += chars[i];
                list.add(tempStr);
                tempStr = "";
            } else {
                //正常情况以及遇到第一个前引号（也算正常情况
                tempStr+=chars[i];
            }
        }
        //解析后判断
        if(index<0||index>list.size()-1){
            //如果不合法
            System.out.println("ERROR");
        }else {
            list.set(index,"******");
            StringBuffer stringBuffer = new StringBuffer();
            for(String temp:list){
                stringBuffer.append("_").append(temp);
            }
            stringBuffer.deleteCharAt(0);
            System.out.println(stringBuffer.toString());
        }
    }
}
