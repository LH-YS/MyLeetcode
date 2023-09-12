package com.LY.trainingcamp.class04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class KMP {
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str = s.toCharArray();
        char[] match = m.toCharArray();
        int x = 0;//str中当前比对到的位置
        int y = 0;//match中当前比对到的位置
        int[] next = getNextArray(match);
        while (x < str.length && y < match.length) {
            if (str[x] == match[y]) {
                x++;
                y++;
            } else if (next[y] == -1) {//y已经来到0位置了  等效 y==0
                x++;//如果0位置都没有配出来，那只能往下了
            } else {
                y = next[y];//y跳跃
            }
        }
        //1 x越界了，y没有越界，返回-1 说明没匹配上
        //2 x没越界，y越界了 找到合适的开头
        //3 x越界了，y越界了 说明str中等量长的后缀匹配了match aacaakaab 和 aab 共同越界
        return y == match.length ? x - y : -1;
    }

    private static int[] getNextArray(char[] match) {
        if (match.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;//从2出发求每一步next的值
        int cn = 0;//cn代表：cn位置的字符是当前和i-1位置比较的字符
        while (i < next.length) {
            if (match[i - 1] == match[cn]) {//跳出来的时候
                next[i++] = ++cn;//cn在用过后下一次还会用到，所以不妨先加一直接用
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
    //arr[L..R]范围上如果排序的话（但不是真的排序），找位于index的数,潜台词index一定能找到
    public static int process2(int[] arr, int L,int R ,int index){
        if (L==R){
            return arr[L];
        }
        //不止一个数
        //等概率选一个数来划分
        int privot = arr[L+(int)(Math.random()*(R-L+1))];

        //荷兰国旗划分，但返回值不同
        //L。。。。R
        //0。。。。1000  划分值等于区的区域范围记录在range里
        // 比如划分后17-89都是70，那么range[0]=17,range[1]=89
        int[] range = partition(arr,L,R,privot);

        if(index>=range[0]&&index<=range[1]){
            return arr[index];
        } else if (index<range[0]) {
            return process2(arr,L,range[0]-1,index);//小于区搜索
        }else {
            return process2(arr,range[1]+1,R,index);
        }

    }

    public static int[] partition(int[] arr, int l, int r, int privot) {
        int less = l-1;
        int more = r+1;
        int cur = l;
        while (cur<more){
            if (arr[cur]<privot){
                swap(arr,++less,cur++);
            } else if (arr[cur] > privot) {
                swap(arr,--more,cur);
            }else {
                cur++;
            }

        }
        return new int[]{less+1,more-1};
    }

    public static void swap(int[]arr,int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    //利用bfprt算法，时间复杂度o(N)
    public static int minKth3(int[] arr,int k){
        int[] array = copyArray(arr);
        return bfprt(array,0,array.length-1,k-1);
    }

    public static int[] copyArray(int[] arr) {
        int[] ints = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ints[i] = arr[i];
        }
        return ints;
    }


    //arr[LR]如果排序的话，位于index未知的数是什么 返回
    public static int bfprt(int[]arr, int L, int R,int index){
        if(L==R){
            return arr[L];
        }
        int pivot = medianOfMedians(arr,L,R);
        int[] range = partition(arr,L,R,pivot);
        if (index>=range[0]&&index<=range[1]){
            return arr[index];
        } else if (index<range[0]) {
            return bfprt(arr,L,range[0]-1,index);
        }else {
            return bfprt(arr,range[1]+1,R,index);
        }

    }

    //arr[LR]请以五个数一组，每个小组内部排序，每个小组中位数拿出来组成marr，再求marr中位数返回
    public static int medianOfMedians(int[] arr, int l, int r) {
        int size = r-l+1;
        //要不要补最后一组
        int offset = size%5==0?0:1;
        int[] mArr = new int[size/5+offset];
        for (int team = 0; team<mArr.length;team++){
           int teamFirst = l+team*5;
            //如果最后一组不足，那么r更小
           mArr[team] = getMedian(arr,teamFirst,Math.min(r,teamFirst+4));

        }
        //带回重新求
        //mArr中，找到中位数
        //就相当于数组中取长度一半的数，bfprt最快，最难懂的就是又调用了一次主递归
        return bfprt(mArr,0,mArr.length-1,mArr.length/2);

    }

    public static int getMedian(int[] arr, int l, int r) {
        int[] ints = copyArray(arr);
        Arrays.sort(ints);
        return ints[(l+r)/2];
    }

    public static void main(String[] args) {
        int[] ints = {3, 1, 2, 4, 7, 5, 6};
        System.out.println(minKth3(ints,3));
    }
    //应用：求一个数组前10小的数，或者前100小的数
    //可用bfprt求出第100小的数，然后遍历输出
}
