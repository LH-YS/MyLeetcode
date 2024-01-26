package com.LY.MainTraining;
import java.util.*;
public class C57_AirportFlightScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        String[] res = computeAirportFlightScheduling(split);
        for (int i = 0; i < res.length; i++) {
            if (i!=res.length-1){
                System.out.print(res[i]+",");
            }else {
                System.out.print(res[i]);
            }
        }
    }

    private static String[] computeAirportFlightScheduling(String[] split) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(0)!=o2.charAt(0)){
                    return o1.charAt(0) - o2.charAt(0);
                }else if (o1.charAt(1)!=o2.charAt(1)){
                    return o1.charAt(1) - o2.charAt(1);
                }else {
                    int a = Integer.parseInt(o1.substring(2,6));
                    int b = Integer.parseInt(o2.substring(2,6));
                    return a-b;
                }
            }
        });
        String[] res = new String[split.length];
        int k = 0;
        for(String i:list){
            res[k++] = i;
        }
        return res;
    }
}
