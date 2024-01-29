package com.LY.MainTraining;

import java.util.*;
public class C208_FindCitis {
    private static class MyUnionSet{
        int[] father;
        public MyUnionSet(int n){
            father = new int[n+1];
            for (int i = 0; i < father.length; i++) {
                father[i] = i;
            }
        }
        public int FindFather(int n){
            if (n != father[n]){
                n = FindFather(father[n]);
            }
            return n;
        }
        public void UnionTwoNum(int x,int y){
            x = FindFather(x);
            y = FindFather(y);
            if (x!=y){
                father[y] = x;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        int[][] nums = new int[len - 1][2];
        for (int i = 0; i < len - 1; i++) {
            String[] split = scanner.nextLine().split(" ");
            nums[i][0] = Integer.parseInt(split[0]);
            nums[i][1] = Integer.parseInt(split[1]);
        }
        ArrayList<Integer> res = computeFindCitis(nums);
        for (int i:res){
            System.out.print(i+" ");
        }
    }

    private static ArrayList<Integer> computeFindCitis(int[][] nums) {
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length+1; i++) {
            int max = Integer.MIN_VALUE;
            //对于每个城市都记录dpi
            ArrayList<int[]> ints = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (nums[j][0]==i||nums[j][1]==i){
                    continue;
                }
                int[] test = new int[2];
                test[0] = nums[j][0];
                test[1] = nums[j][1];
                ints.add(test);
            }
            MyUnionSet set = new MyUnionSet(nums.length + 1);
            for (int[] j:ints){
                set.UnionTwoNum(j[0],j[1]);
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j:set.father){
                int temp = set.FindFather(j);
                map.put(temp,map.getOrDefault(temp,0)+1);
            }
            for(int j:map.keySet()){
                if (map.get(j)>max&&j!=0){
                    max = map.get(j);
                }
            }
            if (max<min){
                min = max;
                result.clear();
                result.add(i);
            }else if (max==min){
                result.add(i);
            }
        }
        return result;
    }
}
