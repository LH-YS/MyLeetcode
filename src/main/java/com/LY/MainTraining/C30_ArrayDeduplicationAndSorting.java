package com.LY.MainTraining;

import java.util.*;
public class C30_ArrayDeduplicationAndSorting {
    public static void main(String[] args) {
        String[] split = new Scanner(System.in).nextLine().split(",");
        int[] ints = new int[split.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        ArrayList<Integer> res = computeArrayDeduplicationAndSorting(ints);
        int count = 0;
        for (int i:res){
            if(count<res.size()-1){
                System.out.print(i+",");
                count++;
            }else {
                System.out.print(i);
            }
        }
    }

    private static ArrayList<Integer> computeArrayDeduplicationAndSorting(int[] ints) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            if(map.containsKey(ints[i])){
                map.put(ints[i],map.get(ints[i])+1);
            }else {
                map.put(ints[i],1);
            }
        }
        for(int i:map.keySet()){
            list.add(i);
        }
        Collections.sort(list,new MyComparatorOfDeduplication(map,ints));
        return list;
    }
    private static class MyComparatorOfDeduplication implements Comparator<Integer>{

        HashMap<Integer,Integer> map;
        int[] ints;

        public MyComparatorOfDeduplication(HashMap<Integer, Integer> map,int[] ints) {
            this.map = map;
            this.ints = ints;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            int res = map.get(o2)-map.get(o1);
            if (res==0){
                for (int i = 0; i < ints.length; i++) {
                    if (ints[i]==o1.intValue()){
                        return -1;
                    }else if(ints[i]==o2.intValue()){
                        return 1;
                    }
                }
            }
            return res;
        }
    }
}
