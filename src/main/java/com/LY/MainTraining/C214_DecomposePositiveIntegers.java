package com.LY.MainTraining;
import java.util.*;
import java.io.*;
public class C214_DecomposePositiveIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int[] res = computeDecomposePositiveIntegers(target);
        if (res==null){
            System.out.println("N");
            return;
        }
        System.out.print(target+"=");
        for (int i = 0; i < res[1]; i++) {
            if (i==res[1]-1){
                System.out.print(res[0]+i);
            }else {
                System.out.print(res[0]+i+"+");
            }
        }
    }

    private static int[] computeDecomposePositiveIntegers(int target) {
        for (int m = 2; m*(m+1)/2<=target; m++) {
            if ((target - m*(m-1)/2)%m==0){
                return new int[]{(target - m*(m-1)/2)/m,m};
            }
        }
        return null;
    }
}
