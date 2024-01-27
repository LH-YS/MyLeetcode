package com.LY.MainTraining;

import java.util.*;
public class C60_TheHeightOfTridentSearchTree {
    private static class MyTridentTree{
        int val;
        public MyTridentTree(int val){
            this.val = val;
        }
        MyTridentTree left;
        MyTridentTree mid;
        MyTridentTree right;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }
        int res = computeTheHeightOfTridentSearchTree(nums);
        System.out.println(res);
    }

    private static int computeTheHeightOfTridentSearchTree(int[] nums) {
        MyTridentTree tree = new MyTridentTree(nums[0]);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            boolean flag = true;
            MyTridentTree cur = tree;
            int hight = 1;
            while (flag){
                if (nums[i]<cur.val-500){
                    //到左边插入或者搜索
                    if (cur.left==null){
                        cur.left = new MyTridentTree(nums[i]);
                        max = Math.max(max,hight+1);
                        hight=1;
                        break;
                    }else {
                        cur = cur.left;
                        hight++;
                    }
                } else if (nums[i]>cur.val+500) {
                    if (cur.right==null){
                        cur.right = new MyTridentTree(nums[i]);
                        max = Math.max(max,hight+1);
                        hight=1;
                        break;
                    }else {
                        cur = cur.right;
                        hight++;
                    }
                }else {
                    if (cur.mid==null){
                        cur.mid = new MyTridentTree(nums[i]);
                        max = Math.max(max,hight+1);
                        hight=1;
                        break;
                    }else {
                        cur = cur.mid;
                        hight++;
                    }
                }
            }
        }
        return max;
    }
}
