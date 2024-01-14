package com.LY.MainTraining;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C26_RemainingWeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        int res = computeRemainingWeight(weights);
        System.out.println(res);
    }

    private static int computeRemainingWeight(int[] weights) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < weights.length; i++) {
            priorityQueue.add(weights[i]);
        }
        int end_flag = 0;
        while (end_flag==0){
            int x = 0;
            int y = 0;
            int z = 0;
            if (!priorityQueue.isEmpty()){
                x = priorityQueue.poll();
            }else {
                end_flag = 1;
                continue;
            }
            if (!priorityQueue.isEmpty()){
                y = priorityQueue.poll();
            }else {
                return x;
            }
            if (!priorityQueue.isEmpty()){
                z = priorityQueue.poll();
            }else {
                return Math.max(x,y);
            }
            //此时xyz都有值
            if(x==y&&y==z){
                continue;
            }else if(x==y&&y!=z){
                priorityQueue.add(y-z);
            }else if(x!=y&&y==z){
                priorityQueue.add(x-y);
            }else {
                if(Math.abs((z-y) - (y-x))!=0){
                    priorityQueue.add(Math.abs((z-y) - (y-x)));
                }
            }
        }
        return 0;
    }
}
