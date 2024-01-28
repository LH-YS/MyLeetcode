package com.LY.MainTraining;
import java.util.*;
public class C70_GrayscaleImageStorage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int tx = scanner.nextInt();
        int ty = scanner.nextInt();
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int[][] image = new int[nums[0]][nums[1]];
        int x = 0;
        int y = 0;
        for (int i = 2; i < nums.length; i++) {
            int val = nums[i++];
            int count = nums[i];
            while (count!=0){
                image[x][y++] = val;
                x = y==image[0].length?x+1:x;
                y = y==image[0].length?0:y;
                count--;
            }
        }
        System.out.println(image[tx][ty]);
    }
}
