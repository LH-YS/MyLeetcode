package com.LY.MainTraining;

import java.util.*;
public class C24_LookingForTheSimilarChildren {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int base = scanner.nextInt();
        int length = scanner.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            nums.add(scanner.nextInt());
        }
        ArrayList<Integer> res = computeLookingForTheSimilarChild(nums,base);
        Iterator<Integer> iterator = res.iterator();
        for (int i = 0; i < length-1; i++) {
            System.out.print(iterator.next()+" ");
        }
        System.out.print(iterator.next());
    }

    private static ArrayList<Integer> computeLookingForTheSimilarChild(ArrayList<Integer> nums, int base) {
        Collections.sort(nums,new ComparatorOfLookingForSimilar(base));
        return nums;
    }
    private static class ComparatorOfLookingForSimilar implements Comparator<Integer>{

        int base;
        public ComparatorOfLookingForSimilar(int base) {
            this.base = base;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            if (Math.abs(o1.intValue() - base) - Math.abs(o2.intValue() - base)==0){
                return o1 - o2;
            }
            return Math.abs(o1 - base) - Math.abs(o2 - base);
        }
    }
}
