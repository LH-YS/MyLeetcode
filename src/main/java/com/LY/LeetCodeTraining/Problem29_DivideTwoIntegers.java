package com.LY.LeetCodeTraining;

//用位运算实现加减乘除

public class Problem29_DivideTwoIntegers {
    //加法
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    //减法
    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    //取负 取反+1
    public static int negNum(int n) {
        return add(~n, 1);
    }

    //乘法 一个往左移一个往右移
    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static int divide(int dividend, int divisor) {
        //如果除数是系统最小
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        //如果被除数是系统最小
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == negNum(1)) {
                //如果除数是负一，则直接得出系统最大
                return Integer.MAX_VALUE;
            }
            //为了防止溢出，先把被除数+1，得出一个结果res，再把res乘回 求差，差的部分再除，最后整合
            //相当于拆解了一下
            int res = div(add(dividend, 1), divisor);
            return add(res, div(minus(dividend, multi(res, divisor)), divisor));
        }
        //如果前两个情况都没中，则正常除法
        return div(dividend, divisor);

    }

    public static int div(int a, int b) {
        //两个数都取正
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        //其实就是 i>-1 i--
        for (int i = 31; i >negNum(1); i = minus(i,1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }


    public static boolean isNeg(int n) {
        return n < 0;
    }


}
