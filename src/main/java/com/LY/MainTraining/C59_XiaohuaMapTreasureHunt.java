package com.LY.MainTraining;
import java.util.*;
public class C59_XiaohuaMapTreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int res = computeXiaohuaMapTreasureHunt(m,n,k);
        System.out.println(res);
    }

    private static int computeXiaohuaMapTreasureHunt(int m, int n, int k) {
        //当前从00位置开始走，返回00位置能获得的所有金子数量
        int[][] nums = new int[m][n];
        int res = process(nums,m,n,k,0,0);
        return res;
    }

    private static int process(int[][] nums,int m, int n, int k, int x, int y) {
        if (x==m||y==n||x<0||y<0||sumDig(x)+sumDig(y)>k||nums[x][y]==1){
            return 0;
        }
        nums[x][y] = 1;
        //返回四个方向能获得的金子数
        int up = process(nums,m,n,k,x,y-1);
        int down = process(nums,m,n,k,x,y+1);
        int left = process(nums,m,n,k,x-1,y);
        int right = process(nums,m,n,k,x+1,y);
        return 1+up+down+left+right;
    }

    private static int sumDig(int x) {
        int res = 0;
        int temp = x;
        while (temp!=0){
            res+=temp%10;
            temp = temp/10;
        }
        return res;
    }
}
