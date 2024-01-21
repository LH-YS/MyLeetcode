package com.LY.MainTraining;

import java.util.*;
public class C41_CPUExchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] length = scanner.nextLine().split(" ");
        int AL = Integer.parseInt(length[0]);
        int BL = Integer.parseInt(length[1]);
        int[] Anums = new int[AL];
        int[] Bnums = new int[BL];
        for (int i = 0; i < AL; i++) {
            Anums[i] = scanner.nextInt();
        }
        for (int i = 0; i < BL; i++) {
            Bnums[i] = scanner.nextInt();
        }
        int[] res = computeCPUExchange(Anums,Bnums);
        System.out.println(res[0]+" "+res[1]);
    }

    private static int[] computeCPUExchange(int[] anums, int[] bnums) {
        int asum = 0;
        int bsum = 0;
        for (int i = 0; i < anums.length; i++) {
            asum += anums[i];
        }
        for (int i = 0; i < bnums.length; i++) {
            bsum += bnums[i];
        }
        int[] res = new int[2];
        int min = Integer.MAX_VALUE;
        int cut_min = Integer.MAX_VALUE;
        for (int i = 0; i < anums.length; i++) {
            for (int j = 0; j < bnums.length; j++) {
                int newAsum = asum - anums[i] + bnums[j];
                int newBsum = bsum - bnums[j] + anums[i];
                int cut = Math.abs(newAsum-newBsum);
                if (cut<cut_min){
                    cut_min=cut;
                    min = anums[i];
                    res[0] = anums[i];
                    res[1] = bnums[j];
                }else if(cut==cut_min&&anums[i]<min){
                    min=anums[i];
                    res[0] = anums[i];
                    res[1] = bnums[j];
                }
            }
        }
        return res;
    }
}


