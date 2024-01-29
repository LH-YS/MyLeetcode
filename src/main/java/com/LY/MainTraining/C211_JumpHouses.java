package com.LY.MainTraining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;
import java.util.*;

public class C211_JumpHouses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scanner = new Scanner(System.in);
        //String[] split = scanner.nextLine().split(" ");
        String[] split = br.readLine().split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int[][] nums = new int[m][n];
        ArrayList<int[]> houses = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (!line[j].equals(".")){
                    nums[i][j] = Integer.parseInt(line[j]);
                    houses.add(new int[]{i,j});
                }
            }
        }
        int res = computeJumpHouses(nums,houses);
        System.out.println(res);
    }

    private static int computeJumpHouses(int[][] nums, ArrayList<int[]> houses) {
        int min = Integer.MAX_VALUE;
        int[][] dis = new int[][]{{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                boolean found = true;
                int jumpNum = 0;
                for (int[] house:houses){
                    LinkedList<int[]> queue = new LinkedList<>();
                    int count = nums[house[0]][house[1]];
                    queue.add(new int[]{house[0],house[1],0});
                    HashSet<String> used = new HashSet<>();
                    used.add(house[0]+"-"+house[1]);
                    boolean flag = false;
                    while (!queue.isEmpty()){
                        int[] temp = queue.pollFirst();
                        int x = temp[0];
                        int y = temp[1];
                        if (x==i&&y==j){
                            flag=true;
                            jumpNum+=temp[2];
                            break;
                        }
                        for (int[] dir:dis){
                            int nx = x+dir[0];
                            int ny = y+dir[1];
                            if (nx>=0&&nx<nums.length&&ny>=0&&ny<nums[0].length&&temp[2]<count&&!used.contains(nx+"-"+ny)){
                                queue.add(new int[]{nx,ny,temp[2]+1});
                                used.add(nx+"-"+ny);
                            }
                        }
                    }
                    if (flag==false){
                        found = false;
                        break;
                    }
                }
                if (found==true){
                    min = Math.min(min,jumpNum);
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}


