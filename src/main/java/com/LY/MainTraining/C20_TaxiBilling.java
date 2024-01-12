package com.LY.MainTraining;

import java.util.*;
public class C20_TaxiBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int res = ComputeTaxiBilling(target);
        System.out.println(res);
    }

    private static int ComputeTaxiBilling(int target) {
        int tmp = target;
        int res = 0;
        int n = 0;
        while (tmp!=0){
            int t = tmp%10>4?tmp%10-1:tmp%10;
            res += t * Math.pow(9,n++);
            tmp = tmp/10;
        }
        return res;
    }
}
