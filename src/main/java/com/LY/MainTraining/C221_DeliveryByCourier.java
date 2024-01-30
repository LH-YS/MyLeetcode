package com.LY.MainTraining;
import java.util.*;
import java.io.*;
public class C221_DeliveryByCourier {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int[][] dis = new int[m + 1][m + 1];
        for (int i = 0; i < dis.length; i++) {
            for (int j = 0; j < dis[0].length; j++) {
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int keyVal = 1;
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int key = Integer.parseInt(line[0]);
            if (!map.containsKey(key)){
                map.put(key,keyVal++);
            }
            dis[0][map.get(key)] = Integer.parseInt(line[1]);
            dis[map.get(key)][0] = Integer.parseInt(line[1]);
        }
        for (int i = 0; i < n; i++) {
            String[] split1 = br.readLine().split(" ");
            int oneK = Integer.parseInt(split1[0]);
            int twoK = Integer.parseInt(split1[1]);
            dis[map.get(oneK)][map.get(twoK)] = Integer.parseInt(split1[2]);
            dis[map.get(twoK)][map.get(oneK)] = Integer.parseInt(split1[2]);
        }
        int res = computeDeliveryByCourier(dis);
        System.out.println(res);
    }

    private static int computeDeliveryByCourier(int[][] dis) {
        int[][] nums = new int[1 << (dis.length - 1)][dis.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = Integer.MAX_VALUE;
            }
        }
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{0,0,0});
        nums[0][0] = 0;
        while (!list.isEmpty()){
            int[] temp = list.poll();
            int state = temp[0];
            int pos = temp[1];
            int haveSum = nums[state][pos];
            for (int nextpos = 0; nextpos < dis.length; nextpos++) {
                if (nextpos!=pos&&dis[pos][nextpos]!=Integer.MAX_VALUE){
                    int nextState = (nextpos==0)?state:state|(1<<(nextpos-1));
                    if (haveSum+dis[pos][nextpos]<nums[nextState][nextpos]){
                        nums[nextState][nextpos] = haveSum+dis[pos][nextpos];
                        list.add(new int[]{nextState,nextpos,0});
                    }
                }
            }
        }
        int res = nums[(1<<dis.length-1)-1][0];
        return res==Integer.MAX_VALUE?-1:res;
    }
}
