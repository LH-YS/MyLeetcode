package com.LY.MainTraining;
import java.io.*;
import java.util.*;
public class C216_MeetingRoom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.equals("[]")||str.equals("")){
            System.out.println(str);
            return;
        }
        str = str.replaceAll("\\[","");
        str = str.replaceAll("\\]","");
        if (str.equals("")){
            System.out.println("");
            return;
        }
        String[] split = str.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        ArrayList<int[]> res = computeMeetingRoom(nums);
        System.out.print("[");
        int index = 0;
        for (int[] i:res){
            if (index++!=res.size()-1){
                System.out.print("["+i[0]+","+i[1]+"],");
            }else {
                System.out.print("["+i[0]+","+i[1]+"]");
            }
        }
        System.out.print("]");
    }

    private static ArrayList<int[]> computeMeetingRoom(int[] nums) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int[] temp = new int[2];
            temp[0] = nums[i++];
            temp[1] = nums[i];
            list.add(temp);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> res = new ArrayList<>();
        int[] cur = new int[]{nums[0],nums[1]};
        res.add(cur);
        for (int[] i:list){
            if (i[0]<=cur[1]){
                cur[1] = Math.max(cur[1],i[1]);
            }else {
                cur = i;
                res.add(i);
            }
        }
        return res;
    }
}
