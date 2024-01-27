package com.LY.MainTraining;
import java.util.*;
public class C206_NumberOfRightAngledTriangles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = scanner.nextLine();
        }
        int[] res = computeNumberOfRightAngledTriangles(str);
        for (int i = 0; i < len; i++) {
            System.out.println(res[i]);
        }
    }

    private static int[] computeNumberOfRightAngledTriangles(String[] str) {
        int[] res = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            String[] split = str[i].split(" ");
            int[] nums = new int[split.length];
            for (int j = 0; j < split.length; j++) {
                nums[j] = Integer.parseInt(split[j]);
            }
            Arrays.sort(nums);
            Boolean[] used = new Boolean[nums.length];
            for (int j = 0; j < used.length; j++) {
                used[j] = false;
            }
            res[i] = process(nums,used,0,0);
        }
        return res;
    }

    private static int process(int[] nums, Boolean[] used, int index, int count) {
        //目前答案有count种
        int res = count;
        for (int i = index; i < nums.length; i++) {
            if (used[i]==true){
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (used[j]==true){
                    continue;
                }
                for (int k = j+1; k < nums.length; k++) {
                    if (used[k]==true){
                        continue;
                    }
                    //选好了三个数，进行判断
                    if (nums[i]*nums[i]+nums[j]*nums[j]==nums[k]*nums[k]){
                        //如果能组成直角三角形，标记使用，并从i+1开始继续选
                        used[i] = true;
                        used[j] = true;
                        used[k] = true;
                        res = Math.max(res,process(nums,used,index+1,count+1));
                        used[i] = false;
                        used[j] = false;
                        used[k] = false;
                    }
                }
            }
        }
        //最后返回所有从index开始选的最大可能数
        return res;
    }
}
