package com.LY.MainTraining;
import java.util.*;
public class C46_SortedASCIIWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        int target = scanner.nextInt();
        int res = computeSortedASCIIWords(chars,target);
        System.out.println(res);

    }

    private static int computeSortedASCIIWords(char[] chars, int target) {
        char[] temp = copyTempchars(chars);
        Arrays.sort(temp);
        if(target>chars.length){
            for (int i = 0; i < chars.length; i++) {
                if(chars[i]==temp[temp.length-1]){
                    return i;
                }
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==temp[target-1]){
                return i;
            }
        }
        return -1;
    }

    private static char[] copyTempchars(char[] chars) {
        char[] temp = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            temp[i] = chars[i];
        }
        return temp;
    }
}
