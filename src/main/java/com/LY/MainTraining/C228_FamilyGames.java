package com.LY.MainTraining;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class C228_FamilyGames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[][] nums = new int[len][len];
        int[] start = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < len; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < len; j++) {
                nums[i][j] = Integer.parseInt(split[j]);
                if (nums[i][j]==-3){
                    start[0] = i;
                    start[1] = j;
                }else if (nums[i][j]==-2){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        int res = computeFamilyGames(nums,start,end);
        System.out.println(res);
    }

    private static int computeFamilyGames(int[][] nums, int[] start, int[] end) {
        ArrayList<int[]> dis = new ArrayList<>();
        dis.add(new int[]{1,0});
        dis.add(new int[]{-1,0});
        dis.add(new int[]{0,1});
        dis.add(new int[]{0,-1});
        LinkedList<int[]> list = new LinkedList<>();
        int[][][] record = new int[nums.length][nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                record[i][j][0] = Integer.MAX_VALUE;
                record[i][j][1] = Integer.MIN_VALUE;
            }
        }
        list.add(new int[]{start[0],start[1],0,0});
        while (!list.isEmpty()){
            int[] cur = list.poll();
            int x = cur[0];
            int y = cur[1];
            int spend = cur[2];
            int val = cur[3];
            for (int[] distance:dis){
                int nextx = x+distance[0];
                int nexty = y+distance[1];
                if (0<=nextx&&nextx<nums.length&&0<=nexty&&nexty<nums[0].length&&nums[nextx][nexty]!=-1){
                    int nextval = nums[nextx][nexty]>0?val+nums[nextx][nexty]:val;
                    int nextspend = spend+1;
                    if (nextspend<record[nextx][nexty][0]||(nextspend==record[nextx][nexty][0])&&nextval>record[nextx][nexty][1]){
                        record[nextx][nexty][0] = nextspend;
                        record[nextx][nexty][1] = nextval;
                        list.add(new int[]{nextx,nexty,nextspend,nextval});
                    }
                }
            }
        }

        return record[end[0]][end[1]][1]==Integer.MIN_VALUE?-1:record[end[0]][end[1]][1];
    }
}
