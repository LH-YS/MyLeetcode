package com.LY.MainTraining;
import java.util.*;
public class C68_NucleicAcidTesting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        String[] split = scanner.nextLine().split(",");
        int[] have = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            have[i] = Integer.parseInt(split[i]);
        }
        int[][] nums = new int[len][len];
        for (int i = 0; i < len; i++) {
            String[] str = scanner.nextLine().split(",");
            for (int j = 0; j < len; j++) {
                nums[i][j] = Integer.parseInt(str[j]);
            }
        }
        int res = computeNucleicAcidTesting(nums,have);
        System.out.println(res);
    }

    private static int computeNucleicAcidTesting(int[][] nums, int[] have) {
        HashSet<Integer> setHave = new HashSet<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < have.length; i++) {
            setHave.add(have[i]);
            list.add(have[i]);
        }
        HashSet<Integer> setNext = new HashSet<>();
        boolean end = false;
        while (!list.isEmpty()){
            int target = list.pollFirst();
            for (int i = 0; i < nums.length; i++) {
                if (nums[target][i]==1&&target!=i){
                    if (!setNext.contains(i)){
                        list.add(i);
                    }
                    setNext.add(i);
                }
            }
        }
        HashSet<Integer> res = new HashSet<>();
        for (int i:setNext){
            if (!setHave.contains(i)){
                res.add(i);
            }
        }
        return res.size();
    }
}
