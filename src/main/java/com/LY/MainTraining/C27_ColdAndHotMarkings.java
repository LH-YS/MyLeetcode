package com.LY.MainTraining;

import java.util.*;
public class C27_ColdAndHotMarkings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        ArrayList<Integer> res = computeColdAndHotMarkings(nums,target);
        System.out.println(res.size());
        if(res.size()!=0){
            for(int i:res){
                System.out.println(i);
            }
        }
    }

    private static ArrayList<Integer> computeColdAndHotMarkings(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i:map.keySet()) {
            if (map.get(i)>=target){
                list.add(i);
            }
        }
        Collections.sort(list,new MyComparatorOfMap(map));
        return list;
    }
    private static class MyComparatorOfMap implements Comparator<Integer>{

        HashMap<Integer,Integer> table;

        public MyComparatorOfMap(HashMap<Integer, Integer> table) {
            this.table = table;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            return table.get(o2) - table.get(o1);
        }
    }
}
