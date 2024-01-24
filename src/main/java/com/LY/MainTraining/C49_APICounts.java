package com.LY.MainTraining;

import java.util.*;

public class C49_APICounts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String[][] strs = new String[length][10];
        for (int i = 0; i < strs.length; i++) {
            String[] line = scanner.nextLine().trim().split("/");
            for (int j = 0; j < 10; j++) {
                if(j+1<line.length){
                    strs[i][j] = line[j+1];
                }else {
                    strs[i][j] = null;
                }
            }
        }
        int target = scanner.nextInt();
        String target_str = scanner.next();
        int res = computeAPICounts(strs,target,target_str);
        System.out.println(res);
    }

    private static int computeAPICounts(String[][] strs, int target, String targetStr) {
        int res = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i][target-1]!=null&&strs[i][target-1].equals(targetStr)){
                res++;
            }
        }
        return res;
    }
}
