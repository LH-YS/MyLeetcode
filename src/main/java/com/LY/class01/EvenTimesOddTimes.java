package com.LY.class01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class EvenTimesOddTimes {
    //只有一种数出现奇数次
    public static void printOddTimeNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    //一个数字有两种数出现了奇数次，剩下都是偶数次，找到并打印这两种书
    public static void printOddTimenum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        int rightOne = eor ^ (-eor);//提取最右侧的1
        int onlyOne = 0;//eor'
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + "  " + (onlyOne ^ eor));
    }

    //一个数组有一种树出现了k次，其他数都出现了M次，M>1 K<M 找到出现了k次的数
    //要求额外空间复杂度o(1) 时间复杂度o(N)
    public static int onlyKTimes(int[] arr, int k, int m) {
        int[] t = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                t[i] += (num >> i)&1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % m != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 1, 1, 2, 2, 2, 6, 6, 3, 3, 3};
//        int k = 2,m = 3;
//        onlyKTimes(arr, k, m);
        int maxKinds = 200;
        int range = 200;
        int testTime = 100000;
        int max = 9;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int a = (int) (Math.random() * max) + 1;
            int b = (int) (Math.random() * max) + 1;
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            //k<m
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(maxKinds, range, k, m);
            int ans1 = test(arr, k, m);
            int ans2 = onlyKTimes(arr, k, m);
            if (ans1 != ans2) {
                System.out.println("出错了");
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println(ans1);
                System.out.println(ans2);
            }
        }
        System.out.println("测试结束");

    }

    //对数器
    public static int test(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) == k) {
                return num;
            }
        }
        return -1;
    }

    public static int[] randomArray(int maxKinds, int range, int k, int m) {
        int ktimeNum = randomNumber(range);
        int numKinds = (int) (Math.random() * maxKinds) + 2;
        int[] arr = new int[k + (numKinds - 1) * m];
        int index = 0;
        for (; index < k; index++) {
            arr[index] = ktimeNum;
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(ktimeNum);
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
            //arr经过上述过程就填好了

        }
        return arr;
    }

    //[-range,+range]
    public static int randomNumber(int range) {
        return ((int) (Math.random() * range) + 1) - ((int) (Math.random() * range) + 1);
    }
}
