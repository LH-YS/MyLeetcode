package com.LY.MainTraining;
import java.util.*;
public class C47_SplicingURL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        if(split.length==0){
            System.out.println("/");
            return;
        }
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("/")){
                split[i] = "";
                continue;
            }
            if (split[i].charAt(0)=='/'){
                split[i] = split[i].substring(1,split[i].length());
            }
            if (split[i].charAt(split[i].length()-1)=='/'){
                split[i] = split[i].substring(0,split[i].length()-1);
            }
        }
        for (int i = 0; i < split.length; i++) {
            System.out.print("/"+split[i]);
        }
    }
}
