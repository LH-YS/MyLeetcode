package com.LY.MainTraining;

import java.util.*;
public class C29_LowestOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        ArrayList<Integer> res = computeLowestOrder(nums);
        int count = 0;
        for(int i:res){
            if(count<split.length-1){
                System.out.print(i+",");
                count++;
            }else if(count==split.length-1){
                System.out.print(i);
            }
        }
    }

    private static ArrayList<Integer> computeLowestOrder(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list,new MyComparatorOfLowestOrder(nums));
        return list;
    }
    private static class MyComparatorOfLowestOrder implements Comparator<Integer>{

        int[] nums;

        public MyComparatorOfLowestOrder(int[] nums) {
            this.nums = nums;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1.intValue()<0){
                o1 = -o1;
            }
            if (o2.intValue()<0){
                o2 = -o2;
            }
            return (o1%10) - (o2%10);
        }
    }
}
