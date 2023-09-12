package com.LY.LeetCodeTraining;

public class Problem70_ClimbingStairs {
    class Solution {
        public int climbStairs(int n) {
            int[] res = new int[n+1];
            for (int i = 0; i < n+1; i++) {
                res[i] = -1;
            }
            int result = climingMethods(n,res);
            return result;
        }
        //还剩下n个台阶才能爬到楼顶,返回剩余的方法数
        public int climingMethods(int n,int[] res){
            if (res[n]!=-1){
                return res[n];
            }
            //如果还有一个台阶，只有一种方法
            if(n==1){
                return 1;
            }
            //如果还有两个台阶，有两种，一种是一次登顶，一种是一个一个登
            if(n==2){
                return 2;
            }
            //如果选择这一步爬一个台阶
            int method1 = n-1>0?climingMethods(n-1,res):0;
            //如果选择这一步爬两个台阶
            int method2 = n-2>0?climingMethods(n-2,res):0;
            res[n] = method1+method2;
            return method1+method2;
        }
    }
}
