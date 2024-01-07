package com.LY.MainTraining;

import java.util.*;
public class C9_MinimumSumOfIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s1 = scanner.nextLine().split(" ");
        String[] s2 = scanner.nextLine().split(" ");
        int target = scanner.nextInt();
        int[] n1 = new int[s1.length];
        int[] n2 = new int[s2.length];
        for (int i = 0; i < n1.length; i++) {
            n1[i] = Integer.parseInt(s1[i]);
        }
        for (int i = 0; i < n1.length; i++) {
            n2[i] = Integer.parseInt(s2[i]);
        }
        int res = ComputeSumOfIntegers(n1,n2,target);
        System.out.println(res);
    }

    private static int ComputeSumOfIntegers(int[] n1, int[] n2, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n1.length; i++) {
            for (int j = 0; j < n2.length; j++) {
                res.add(n1[i]+n2[j]);
            }
        }
        Collections.sort(res);
        int sum = 0;
        for (int i:res) {
            sum+=i;
            target--;
            if (target==0){
                break;
            }
        }
        return sum;
    }
}
