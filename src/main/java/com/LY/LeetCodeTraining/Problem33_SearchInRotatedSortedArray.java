package com.LY.LeetCodeTraining;

/*
    与普通二分区别在于 不是单调的，需要重新写单调的部分
 */
public class Problem33_SearchInRotatedSortedArray {
    public static int search(int[] arr, int num) {
        int L = 0;
        int R = arr.length - 1;
        int M = 0;
        while (L <= R) {
            M = (L + R) / 2;
            if (arr[M] == num) {
                return M;
            }
            //首先需要去除重复部分，有一种情况是这一大段都是相同值
            if (arr[L] == arr[M] && arr[M] == arr[R]) {
                //去除左部分的重复值
                while (L != M && arr[L] == arr[M]) {
                    L++;
                }
                //如果到了M，说明左边都是重复值，如果没到M，则进入正常判断
                if (L == M) {
                    L = M + 1;
                    continue;
                }
            }
            //当三个值不全部相等的时候，分为左不相等中，右不相等中
            if (arr[L] != arr[M]) {
                //左不相等中
                if (arr[L] < arr[M]) {
                    //假定单调，如果目标在这个范围就在这个范围寻找，不在就去另一边
                    if (arr[L] <= num && num < arr[M]) {
                        R = M - 1;
                    } else {
                        L = M + 1;
                    }
                } else {
                    //如果不单调，说明旋转点肯定在左半段，去另一边判断
                    if (arr[M] < num && num <= arr[R]) {
                        L = M + 1;
                    } else {
                        R = M - 1;
                    }
                }
            } else {
                //左相等中，右不相等中
                if (arr[M] < arr[R]) {
                    if (arr[M] < num && num <= arr[R]) {
                        L = M + 1;
                    } else {
                        R = M - 1;
                    }
                } else {
                    if (arr[L] <= num && num < arr[M]) {
                        R = M - 1;
                    } else {
                        L = M + 1;
                    }
                }
            }
        }
        return -1;
    }

}
