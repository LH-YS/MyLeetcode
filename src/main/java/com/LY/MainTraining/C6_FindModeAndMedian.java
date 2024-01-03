package com.LY.MainTraining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class C6_FindModeAndMedian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int res = ComputeModeAndMedian(nums);
        System.out.println(res);
    }

    private static int ComputeModeAndMedian(int[] nums) {
        HashMap<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (table.containsKey(nums[i])){
                table.put(nums[i],table.get(nums[i])+1);
            }else{
                table.put(nums[i],1);
            }
        }
        //选出众数,并记录众数出现的次数
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i: table.keySet()) {
            int val = table.get(i);
            if (val>max){
                list.clear();
                list.add(i);
                max = val;
            }else if(val==max){
                list.add(i);
            }
        }
        Collections.sort(list);
        int[] ints = new int[list.size() * max];
        int k = 0;
        for(int i:list){
            for (int j = 0; j < max; j++) {
                ints[k++] = i;
            }
        }
        if (ints.length%2==1){
            return ints[ints.length/2];
        }else{
            return (ints[ints.length/2 - 1]+ints[ints.length/2])/2;
        }
    }
}
