package com.LY.LeetCodeTraining;

public class Problem37_SolveSudoku {
    //底层使用三个数组去验证重复
    //主函数
    public static void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] bucket = new boolean[9][10];
        initSudoku(board,row,col,bucket);
        process(board,0,0,row,col,bucket);
    }

    //数独初始化
    public static void initSudoku(char[][] board, boolean[][] row, boolean[][] col, boolean[][] bucket) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int bid = 3 * (i / 3) + (j / 3);
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bid][num] = true;
                }
            }
        }
    }

    //递归函数，从某位置开始填数，如果重复就返回false，能填就继续填直到全部填完为止
    public static boolean process(char[][] board, int i, int j, boolean[][] row, boolean[][] col, boolean[][] bucket) {
        //basecase 写到最后的时候停止
        if (i == 9) {
            return true;
        }
        int nexti = j != 8 ? i : i + 1;
        int nextj = j != 8 ? j + 1 : 0;
        //如果要填的位置有数字，就填下一个
        if (board[i][j] != '.') {
            return process(board, nexti, nextj, row, col, bucket);
        } else {
            int bid = 3 * (i / 3) + (j / 3);
            for (int num = 1; num <= 9; num++) {
                //从1到9尝试，如果三个数组都显示没有放入数字，则放入数字尝试
                if ((!row[i][num]) && (!col[j][num]) &&(!bucket[bid][num])){
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bid][num] = true;
                    board[i][j] = (char)(num+'0');//原先数独需要填入数字
                    //填入数字后继续往后填，如果往后填也ok，则这次填数也ok，反之恢复现场返回false
                    if(process(board,nexti,nextj,row,col,bucket)){
                        return true;
                    }
                    row[i][num] = false;
                    col[j][num] = false;
                    bucket[bid][num] = false;
                    board[i][j] = '.';
                }
            }
            //如果1-9都尝试过不能填入，则返回false
            return false;
        }
    }
}
