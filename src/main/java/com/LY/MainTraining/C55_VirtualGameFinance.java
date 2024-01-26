package com.LY.MainTraining;
import java.util.*;
public class C55_VirtualGameFinance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int money = scanner.nextInt();
        int allRisk = scanner.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] risk = new int[length];
        for (int i = 0; i < length; i++) {
            risk[i] = scanner.nextInt();
        }
        int[] value = new int[length];
        for (int i = 0; i < length; i++) {
            value[i] = scanner.nextInt();
        }
        int[] res = computeVirtualGameFinance(money,allRisk,nums,risk,value);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }

    private static int[] computeVirtualGameFinance(int money, int allRisk, int[] nums, int[] risk, int[] value) {
        int[] res = new int[risk.length];
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < risk.length; i++) {
            for (int j = i; j < risk.length; j++) {
                if (i==j){
                    if (risk[i]>allRisk){
                        continue;
                    }
                    //单个产品投资
                    double temp = value[i]<=money?value[i]:money;
                    if (temp*(1+nums[i]*0.01)>max){
                        max = temp*(1+nums[i]*0.01);
                        res = new int[risk.length];
                        res[i] = (int) temp;
                    }
                }else {
                    if (risk[i]+risk[j]>allRisk){
                        continue;
                    }
                    //投资两个产品，优先买满投资率高的那个
                    int big = nums[i]>=nums[j]?i:j;
                    int small = big==i?j:i;
                    double temp_big = value[big]<=money?value[big]:money;
                    double temp_small = money-temp_big>0?(value[small]<=(money-temp_big)?value[small]:(money-temp_big)):0;
                    double earn = temp_big*(1+nums[big]*0.01) + temp_small*(1+nums[small]*0.01);
                    if (earn>max){
                        max = earn;
                        res = new int[risk.length];
                        res[big] = (int) temp_big;
                        res[small] = (int) temp_small;
                    }
                }
            }
        }
        return res;
    }
}
