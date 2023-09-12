package com.LY.class01;

public class SwapNum {
    public static void main(String[] args) {
        int a = 17;
        int b = 931;
        System.out.println(a);
        System.out.println(b);
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a);
        System.out.println(b);

        //  提取最右侧的1
        int c = 7;
        int d = -c;
        System.out.println(c&d);
    }
}
