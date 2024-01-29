package com.LY.MainTraining;
import java.util.*;
public class C207_AJoyfulWeekend {
    private static class MyPoint{
        int x;
        int y;

        public MyPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] nums = new int[m][n];
        ArrayList<MyPoint> people = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = scanner.nextInt();
                if (nums[i][j]==2){
                    people.add(new MyPoint(i,j));
                }
            }
        }
        int res = computeAJoyfulWeekend(people,nums);
        System.out.println(res);
    }

    private static int computeAJoyfulWeekend(ArrayList<MyPoint> people, int[][] nums) {
        ArrayList<MyPoint> oneSearch = new ArrayList<>();
        ArrayList<MyPoint> twoSearch = new ArrayList<>();
        int index = 0;
        for(MyPoint i:people){
            int[][] used = new int[nums.length][nums[0].length];
            if (index++==0){
                process(i.x,i.y,oneSearch,nums,used);
            }else {
                process(i.x,i.y,twoSearch,nums,used);
            }
        }
        int res = 0;
        for (MyPoint i:oneSearch){
            for (MyPoint j:twoSearch){
                if (i.x==j.x&&i.y==j.y){
                    res++;
                }
            }
        }
        return res;
    }

    private static void process(int x,int y, ArrayList<MyPoint> search, int[][] nums,int[][] used) {
        //base case
        if (x<0||x>=nums.length||y<0||y>=nums[0].length||nums[x][y]==1||used[x][y]==1){
            return;
        }
        used[x][y] = 1;
        if (nums[x][y]==3){
            search.add(new MyPoint(x,y));
        }
        //四个方向拓展
        process(x+1,y,search,nums,used);
        process(x-1,y,search,nums,used);
        process(x,y+1,search,nums,used);
        process(x,y-1,search,nums,used);
    }
}
