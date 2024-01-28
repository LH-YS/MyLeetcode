package com.LY.MainTraining;
import java.util.*;
public class C72_MinimumNumberOfAreas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] split = scanner.nextLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            int num = Integer.parseInt(split[i]);
            if (map.containsKey(num+1)){
                map.put(num+1,map.get(num+1)+1);
            }else {
                map.put(num+1,1);
            }
        }
        HashMap<Integer, Integer> table = new HashMap<>();
        for(int i:map.keySet()){
            int temp = map.get(i)/i;
            if (map.get(i)%i!=0){
                temp += 1;
            }
            table.put(i,temp);
        }
        int res = 0;
        for(int i:table.keySet()){
            res += i*table.get(i);
        }
        System.out.println(res);
    }
}
