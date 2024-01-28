package com.LY.MainTraining;
import java.util.*;
public class C71_APPRegistration {
    private static class MyAPP{
        String name;
        int rank;
        int start;
        int end;

        public MyAPP(String name, int rank, int start, int end) {
            this.name = name;
            this.rank = rank;
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        MyAPP[] apps = new MyAPP[len];
        for (int i = 0; i < len; i++) {
            String[] temp = scanner.nextLine().split(" ");
            apps[i] = new MyAPP(temp[0],Integer.parseInt(temp[1]),TransTime(temp[2]),TransTime(temp[3]));
        }
        String target = scanner.nextLine();
        String res = computeAPPRegistration(apps,target);
        System.out.println(res);
    }

    private static int TransTime(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0])*60+Integer.parseInt(split[1]);
    }

    private static String computeAPPRegistration(MyAPP[] apps, String target) {
        ArrayList<MyAPP> list = new ArrayList<>();
        for (int i = 0; i < apps.length; i++) {
            if (list.isEmpty()&&apps[i].start<apps[i].end){
                list.add(apps[i]);
            }else {
                boolean flag = false;
                MyAPP example = null;
                for(MyAPP temp:list){
                    if (temp.start<=apps[i].start&&apps[i].start<=temp.end){
                        flag = true;//存在冲突
                        example = temp;
                        break;
                    }
                    if (apps[i].start<=temp.start&&temp.start<=apps[i].end){
                        flag = true;//存在冲突
                        example = temp;
                        break;
                    }
                }
                if (flag&&apps[i].rank>example.rank&&apps[i].start<apps[i].end){
                    list.remove(example);
                    list.add(apps[i]);
                }
            }
        }
        String[] split = target.split(":");
        int tar = Integer.parseInt(split[0])*60+Integer.parseInt(split[1]);
        for (MyAPP i:list){
            if (i.start<=tar&&tar<=i.end){
                return i.name;
            }
        }
        return "NA";
    }
}
