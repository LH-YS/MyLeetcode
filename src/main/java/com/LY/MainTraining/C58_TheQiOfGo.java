package com.LY.MainTraining;
import java.util.*;
public class C58_TheQiOfGo {
    private static class MyQi{
        int x;
        int y;

        public MyQi(int x,int y) {
            this.x = x;
            this.y = y;
        }
        public MyQi() {
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<MyQi> black = new ArrayList<>();
        ArrayList<MyQi> white = new ArrayList<>();
        String[] split = scanner.nextLine().split(" ");
        boolean isFirst = true;
        MyQi myQi = new MyQi();
        for (int i = 0; i < split.length; i++) {
            if (isFirst == true){
                myQi.x = Integer.parseInt(split[i]);
                isFirst = false;
            }else {
                myQi.y = Integer.parseInt(split[i]);
                black.add(myQi);
                myQi = new MyQi();
                isFirst = true;
            }
        }
        String[] split1 = scanner.nextLine().split(" ");
        for (int i = 0; i < split1.length; i++) {
            if (isFirst == true){
                myQi.x = Integer.parseInt(split1[i]);
                isFirst = false;
            }else {
                myQi.y = Integer.parseInt(split1[i]);
                white.add(myQi);
                myQi = new MyQi();
                isFirst = true;
            }
        }
        int[] res = computeTheQiOfGo(black,white);
        System.out.println(res[0]+" "+res[1]);
    }

    private static int[] computeTheQiOfGo(ArrayList<MyQi> black, ArrayList<MyQi> white) {
        int[][] nums = new int[19][19];
        //放棋子
        for (MyQi i:black){
            nums[i.x][i.y] = 1;
        }
        for(MyQi i:white){
            nums[i.x][i.y] = 2;
        }
        //计算黑棋子的气
        int sumB = 0;
        for (MyQi i:black){
            int x = i.x;
            int y =i.y;
            //计算每一个棋子四个方向的气
            if (x-1>=0&&nums[x-1][y]==0){
                sumB++;
                nums[x-1][y] = 3;
            }
            if (x+1<=18&&nums[x+1][y]==0){
                sumB++;
                nums[x+1][y] = 3;
            }
            if (y-1>=0&&nums[x][y-1]==0){
                sumB++;
                nums[x][y-1] = 3;
            }
            if (y+1<=18&&nums[x][y+1]==0){
                sumB++;
                nums[x][y+1] = 3;
            }
        }
        int sumW = 0;
        for (MyQi i:white){
            int x = i.x;
            int y =i.y;
            //计算每一个棋子四个方向的气
            if (x-1>=0&&(nums[x-1][y]==0||nums[x-1][y]==3)){
                sumW++;
                nums[x-1][y]=4;
            }
            if (x+1<=18&&(nums[x+1][y]==0||nums[x+1][y]==3)){
                sumW++;
                nums[x+1][y]=4;
            }
            if (y-1>=0&&(nums[x][y-1]==0||nums[x][y-1]==3)){
                sumW++;
                nums[x][y-1]=4;
            }
            if (y+1<=18&&(nums[x][y+1]==0||nums[x][y+1]==3)){
                sumW++;
                nums[x][y+1]=4;
            }
        }

        return new int[]{sumB,sumW};
    }
}
