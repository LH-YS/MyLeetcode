package com.LY.LeetCodeTraining;

import static java.lang.Math.pow;

public class Problem07_ReverseInteger {
    class Solution {
        public int reverse(int x) {
            boolean sign = x>=0?true:false;
            int res = 0;
            if(x==-2147483648){
                return 0;
            }
            if (x<0){
                x = -x;
            }
            while (x!=0){
                if (res>214748364){
                    return 0;
                }else if (res == 214748364){
                    if (x%10>7){
                        return 0;
                    }
                }
                res = res*10;
                res += (x%10);
                x = x/10;
            }
            if (sign==false){
                res = -res;
            }
            return res;
        }
    }
}
