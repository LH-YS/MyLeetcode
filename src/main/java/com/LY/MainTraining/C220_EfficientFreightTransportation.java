package com.LY.MainTraining;
import java.util.*;
import java.io.*;
public class C220_EfficientFreightTransportation {
    static int Aspend;
    static int Bspend;
    static int total;
    static int Aval;
    static int Bval;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int res = computeEfficientFreightTransportation(nums);
        System.out.println(res);
    }

    private static int computeEfficientFreightTransportation(int[] nums) {
        Aspend = nums[0];
        Bspend = nums[1];
        total = nums[2];
        Aval = nums[3];
        Bval = nums[4];
        int res = process(new int[]{1,1},Aspend+Bspend);
        return res;
    }

    private static int process(int[] nums,int sum) {
        int end = (total-sum)/Aspend;
        int res = Integer.MIN_VALUE;
        for (int i = 0;i<=end;i++){
            //循环，放A，其他放B
            if(((total-sum) - Aspend*i)%Bspend==0){
                int temp = (1+i)*Aval+(1+ ((total-sum) - Aspend*i)/Bspend)*Bval;
                res = Math.max(res,temp);
            }
        }
        return res==Integer.MIN_VALUE?0:res;
    }
}
