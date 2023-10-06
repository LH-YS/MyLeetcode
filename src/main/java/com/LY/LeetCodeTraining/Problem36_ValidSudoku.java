package com.LY.LeetCodeTraining;

/*
    验证数独是否合法，即横竖九宫格三个方面验证
 */
public class Problem36_ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        //底层设置三个数组，只要出现重复值就返回false
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] bucket = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //一个数属于第几个九宫格
                int bid = 3 * (i / 3) + (j / 3);
                if (board[i][j] != '.') {
                    //如果有数字，看是否重复，重复返回false，不重复赋值
                    int num = board[i][j] - '0';
                    if (row[i][num] || col[j][num] || bucket[bid][num]) {
                        return false;
                    }
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bid][num] = true;
                }
            }
        }
        return true;
    }
}
