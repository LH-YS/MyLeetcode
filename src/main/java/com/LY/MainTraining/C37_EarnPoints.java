package com.LY.MainTraining;

import java.util.*;
public class C37_EarnPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int limit = Integer.parseInt(scanner.nextLine());
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String[] s = scanner.nextLine().split(" ");
            int time = Integer.parseInt(s[0]);
            int point = Integer.parseInt(s[1]);
            if (map.containsKey(time)){
                map.get(time).add(point);
            }else {
                map.put(time,new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                    }
                }));
                map.get(time).add(point);
            }
        }
        int res = computeEarnPoints(map,limit);
        System.out.println(res);
    }


    private static int computeEarnPoints(HashMap<Integer, PriorityQueue<Integer>> map, int limit) {
        int current = Integer.MIN_VALUE;
        for (int i:map.keySet()){
            current = Math.max(current,i);
        }
        int res = 0;
        while (current>0&&limit>0){
            if (map.containsKey(current)){
                if (!map.get(current).isEmpty()){
                    //如果存在，就挑选出最大的执行
                    res+=map.get(current).poll();
                    limit--;//执行时间-1
                }
            }
            current--;
        }
        return res;
    }
}
