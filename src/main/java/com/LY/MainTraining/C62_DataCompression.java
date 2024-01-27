package com.LY.MainTraining;
import java.util.*;
public class C62_DataCompression {
    private static class MyPoint{
        int x;
        int y;
        public MyPoint(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        MyPoint[] myPoints = new MyPoint[split.length / 2];
        for (int i = 0; i < split.length; i++) {
            int x = Integer.parseInt(split[i]);
            i++;
            int y = Integer.parseInt(split[i]);
            myPoints[i/2] = new MyPoint(x,y);
        }
        ArrayList<MyPoint> res = computeDataCompression(myPoints);
        for (MyPoint i:res){
            System.out.print(i.x+" "+i.y+" ");
        }
    }

    private static ArrayList<MyPoint> computeDataCompression(MyPoint[] myPoints) {
        if (myPoints.length==1){
            return new ArrayList<MyPoint>(Arrays.asList(myPoints[0]));
        }
        ArrayList<MyPoint> res = new ArrayList<>();
        res.add(myPoints[0]);

        for (int i = 1; i < myPoints.length-1; i++) {
            MyPoint last = myPoints[i-1];
            MyPoint next = myPoints[i+1];
            MyPoint now = myPoints[i];
            int a = now.x - last.x;
            int b = now.y - last.y;
            if (next.x-now.x!=a||next.y-now.y!=b){
                res.add(myPoints[i]);
            }
        }
        res.add(myPoints[myPoints.length-1]);
        return res;
    }
}
