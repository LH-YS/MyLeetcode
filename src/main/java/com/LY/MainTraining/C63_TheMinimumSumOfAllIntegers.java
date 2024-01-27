package com.LY.MainTraining;
import java.util.*;
public class C63_TheMinimumSumOfAllIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int res = computeTheMinimumSumOfAllIntegers(line);
        System.out.println(res);
    }

    private static int computeTheMinimumSumOfAllIntegers(String line) {
        char[] chars = line.toCharArray();
        //为了达到最小和，如果是正整数直接加，如果是负数就达到最小后再加
        int pre = 0;
        int res = 0;
        boolean mode = false;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])){
                if (mode==false){
                    //正整数模式
                    res += Integer.parseInt(chars[i]+"");
                }else {
                    //负数模式
                    pre = pre*10+Integer.parseInt(chars[i]+"");
                }
            } else if (chars[i]=='-') {
                if (mode==true){
                    //结算,继续沿用负数模式
                    res += -1 * pre;
                    pre = 0;
                }else {
                    //开启负数模式
                    mode=true;
                }
            } else {
                //如果不是数字，判断之前是否为负数模式，如果是就结算
                if (mode==true){
                    res += -1 * pre;
                    pre = 0;
                    mode = false;
                }
            }
        }
        //最后再结算一次
        if (mode==true){
            res += -1 * pre;
        }
        return res;
    }
}
