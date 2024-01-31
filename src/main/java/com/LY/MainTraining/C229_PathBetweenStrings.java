package com.LY.MainTraining;
import java.io.*;
import java.util.*;
public class C229_PathBetweenStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int res = computePathBetweenStrings(str);
        System.out.println(res);
    }

    private static int computePathBetweenStrings(String[] str) {
        char[] Achars = str[0].toCharArray();
        char[] Bchars = str[1].toCharArray();
        int[][] record = new int[Achars.length+1][Bchars.length+1];
        record[0][0] = 0;
        for (int i = 0; i < Achars.length; i++) {
            record[i+1][0] = i+1;
        }
        for (int i = 0; i < Bchars.length; i++) {
            record[0][i+1] = i+1;
        }
        for (int i = 1; i < Achars.length+1; i++) {
            for (int j = 1; j < Bchars.length+1; j++) {
                if (Achars[i-1]==Bchars[j-1]){
                    record[i][j] = record[i-1][j-1]+1;
                }else {
                    record[i][j] = Math.min(record[i-1][j],record[i][j-1])+1;
                }
            }
        }
        return record[Achars.length][Bchars.length];
    }
}
