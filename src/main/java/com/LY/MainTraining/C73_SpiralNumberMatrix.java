package com.LY.MainTraining;
import java.util.*;
public class C73_SpiralNumberMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int m = scanner.nextInt();
        int n = count/m;
        if (count%m!=0){
            n += 1;
        }
        int[][] nums = new int[m][n];
        int mode = 1;
        int x = 0;
        int y = 0;
        int number = 1;
        while (number!=count+1){
            if (nums[x][y]==0){
                nums[x][y] = number++;
            }
            if (mode==1){
                if (y+1==n||nums[x][y+1]!=0){
                    mode = 2;
                }else {
                    y = y+1;
                }
            }else if (mode==2){
                if (x+1==m||nums[x+1][y]!=0){
                    mode = 3;
                }else {
                    x = x+1;
                }
            }else if (mode==3){
                if (y-1==-1||nums[x][y-1]!=0){
                    mode = 4;
                }else {
                    y = y-1;
                }
            }else if (mode==4){
                if (x-1==-1||nums[x-1][y]!=0){
                    mode = 1;
                }else {
                    x = x-1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j!=n-1){
                    if(nums[i][j]==0){
                        builder.append("* ");
                    }else {
                        builder.append(nums[i][j]+" ");
                    }
                }else {
                    if(nums[i][j]==0){
                        builder.append("*");
                    }else {
                        builder.append(nums[i][j]);
                    }
                }
            }
            System.out.println(builder.toString());
        }
    }
}
