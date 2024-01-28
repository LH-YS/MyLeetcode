package com.LY.MainTraining;
import java.util.*;
public class C66_PasswordDecryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String res = computePasswordDecryption(s);
        System.out.println(res);
    }

    private static String computePasswordDecryption(String s) {
        HashMap<String, String> map = new HashMap<>();
        for (char i = 'a'; i <='i'; i++) {
            map.put((char)((int)(i-'a')+'1')+"",i+"");
        }
        for (char i = 'j'; i <='z'; i++) {
            map.put(((int)((i-'j'))+10)+"*",i+"");
        }
        for (String i:map.keySet()){
            s = s.replace(i,map.get(i));
        }
        return s;
    }
}
