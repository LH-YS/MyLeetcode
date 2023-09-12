package com.LY.LeetCodeTraining;

public class Problem200_NumberofIslands {
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid==null){
                return 0;
            }
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j]=='1'){
                        infect(grid,i,j);
                        res++;
                    }
                }
            }
            return res;
        }

        public void infect(char[][] grid, int i, int j) {
            if (grid[i][j]=='1'){
                grid[i][j]='0';
            }else{
                return;
            }
            if (i>0){//表示可以向左感染
                infect(grid,i-1,j);
            }
            if (i< grid.length-1){//表示可以向右感染
                infect(grid,i+1,j);
            }
            if (j>0){
                infect(grid,i,j-1);
            }
            if (j<grid[i].length-1){
                infect(grid,i,j+1);
            }
        }
    }
}
