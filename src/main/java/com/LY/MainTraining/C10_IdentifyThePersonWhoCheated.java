package com.LY.MainTraining;

import java.util.*;
public class C10_IdentifyThePersonWhoCheated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] nums = new int[length];
        scanner.nextLine();
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(scanner.nextLine().split(" ")[1]);
        }
        HashMap<Integer, List<Integer>> res = ComputeThePerson(nums);
        ArrayList<Integer> list = new ArrayList<>(res.keySet());
        Collections.sort(list, new MyComparator11(nums));
        for (int i: list) {
            for (int j:res.get(i)) {
                System.out.println((i+1)+" "+(j+1));
            }
        }
    }

    private static class MyComparator11 implements Comparator<Integer>{
        int[] nums;
        public MyComparator11(int[] nums) {
            this.nums = nums;
        }
        @Override
        public int compare(Integer o1, Integer o2) {
            return nums[o1]-nums[o2];
        }
    }
    private static HashMap<Integer, List<Integer>> ComputeThePerson(int[] nums) {
        int[][] ints = new int[nums.length][nums.length];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (Math.abs(nums[i]-nums[j])<min){
                    map.clear();
                    min = Math.abs(nums[i]-nums[j]);
                    map.put(i,new ArrayList<Integer>(Arrays.asList(j)));
                }else if(Math.abs(nums[i]-nums[j])==min){
                    if (map.containsKey(i)) {
                        map.get(i).add(j);
                    }else {
                        map.put(i,new ArrayList<Integer>(Arrays.asList(j)));
                    }
                }
            }
        }
        return map;
    }
}
