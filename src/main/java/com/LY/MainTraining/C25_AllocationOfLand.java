package com.LY.MainTraining;

import java.util.Scanner;

public class C25_AllocationOfLand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] lands = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lands[i][j] = scanner.nextInt();
            }
        }
        int res = computeAllocationOfLands(lands,m,n);
        System.out.println(res);

    }

    private static int computeAllocationOfLands(int[][] lands, int m, int n) {
        int[][] minpos = new int[501][3];
        int[][] maxpos = new int[501][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (lands[i][j]!=0){
                    //有旗子
                    int tmp = lands[i][j];
                    if (minpos[tmp][0]==0){
                        //说明第一次见这种旗子，初始化
                        minpos[tmp][0] = 1;
                        maxpos[tmp][0] = 1;
                        minpos[tmp][1] = i;
                        maxpos[tmp][1] = i;
                        minpos[tmp][2] = j;
                        maxpos[tmp][2] = j;
                    }else {
                        //如果已经有过这种旗子了就比较
                        minpos[tmp][1] = Math.min(minpos[tmp][1],i);
                        minpos[tmp][2] = Math.min(minpos[tmp][2],j);
                        maxpos[tmp][1] = Math.max(maxpos[tmp][1],i);
                        maxpos[tmp][2] = Math.max(maxpos[tmp][2],j);
                    }
                }
            }
        }
        int res = 0;
        //最后计算最大值
        for (int i = 1; i < 500; i++) {
            if (minpos[i][0]!=0){
                int tmp = (maxpos[i][1]-minpos[i][1]+1)*(maxpos[i][2]-minpos[i][2]+1);
                res = Math.max(res,tmp);
            }
        }
        return res;
    }
}
