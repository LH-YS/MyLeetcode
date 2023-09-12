package com.LY.DayTraining.class0603;


import java.lang.reflect.Array;
import java.util.Arrays;

// 来自华为OD，学员问题
// 一个图像有n个像素点，存储在一个长度为n的数组arr里，
// 每个像素点的取值范围[0,s]的整数
// 请你给图像每个像素点值加上一个整数k（可以是负数）
// 像素值会自动截取到[0,s]范围，
// 当像素值<0，会更改为0，当新像素值>s，会更改为s
// 这样就可以得到新的arr，想让所有像素点的平均值最接近中位值s/2, 向下取整
// 请输出这个整数k, 如有多个整数k都满足, 输出小的那个
// 1 <= n <= 10^6
// 1 <= s <= 10^18
public class ImageArrayAverageGotoHalf {

    //arr:每一个像素点的值，一定在0-s范围
    //s 如果像素值<0 自动变成0 如果像素值>s 自动变成s
    //请返回 加上哪个数k,会让整个数组的平均值，最接近s/2
    public static int zuo(int[] arr, int s) {
        //k    -s ~s
        int l = -s;
        int r = s;
        int half = s / 2;
        int abs = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        while (l <= r) {//lr之间找答案
            int k = (l + r) / 2;
            int avg = avg(arr, s, k);
            //差值变小了更新，差值一样但是数字更小也更新
            if (Math.abs((avg - half)) < abs || (Math.abs((avg - half)) == abs) && k < ans) {
                abs = Math.abs((avg - half));
                ans = k;
            }
            if (avg >= half) {//去左侧找
                r = k - 1;
            } else {//去右侧二分
                l = k + 1;
            }
        }

        return ans;
    }
    //arr中所有数组+k，以s为边界判断,返回加上k之后的平均值
    public static int avg(int[] arr, int s, int k) {
        int sum = 0;
        for (int num:arr) {
            int v = num +k;
            if (v<=0){
                sum+=0;
            } else if (v>=s) {
                sum+=s;
            }else {
                sum+=v;
            }
        }
        return sum / arr.length;
    }

    public static int best(int[] arr, int s){
        Arrays.sort(arr);
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = arr[i] + sum[i-1];
        }
        int l = -s;
        int r = s;
        int half = s / 2;
        int abs = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        while (l <= r) {//lr之间找答案
            int k = (l + r) / 2;
            int avg = avg2(arr,sum, s, k);
            //差值变小了更新，差值一样但是数字更小也更新
            if (Math.abs((avg - half)) < abs || (Math.abs((avg - half)) == abs) && k < ans) {
                abs = Math.abs((avg - half));
                ans = k;
            }
            if (avg >= half) {//去左侧找
                r = k - 1;
            } else {//去右侧二分
                l = k + 1;
            }
        }
        return ans;
    }
    //利用前缀和信息pre数组，快速算出一段范围的累加和
    //二分范围就可以了
    public static int avg2(int[] arr, int[] sum, int s, int k) {
        int n = arr.length;
        return -1;

    }

}
