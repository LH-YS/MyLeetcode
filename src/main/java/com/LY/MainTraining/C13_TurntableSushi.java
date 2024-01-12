package com.LY.MainTraining;

import com.LY.Main;
import java.util.*;
public class C13_TurntableSushi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        int[] prices = new int[strs.length];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.parseInt(strs[i]);
        }
        int[] res = ComputeAfterPrices(prices);
        for (int i = 0; i < res.length-1; i++) {
            System.out.print(res[i]+" ");
        }
        System.out.print(res[res.length-1]);
    }

    private static int[] ComputeAfterPrices(int[] prices) {
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int index = i+1==prices.length?0:i+1;
            res[i] = prices[i];
            while (index!=i){
                if (prices[index]<prices[i]){
                    res[i] = res[i] + prices[index];
                    break;
                }
                index++;
                if(index==prices.length){
                    index = 0;
                }
            }
        }
        return res;
    }
}
