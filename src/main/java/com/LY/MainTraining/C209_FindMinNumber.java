package com.LY.MainTraining;
import java.util.*;
public class C209_FindMinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        String str = ""+num1;
        int target = scanner.nextInt();
        if (target>=str.length()){
            System.out.println(0);
            return;
        }
        String res = computeFindMinNumber(str,target);
        System.out.println(res);
    }

    private static String computeFindMinNumber(String str, int target) {
        LinkedList<Integer> list = new LinkedList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int num = Integer.parseInt(chars[i]+"");
            if (list.isEmpty()){
                list.addLast(num);
            }else {
                while (!list.isEmpty()){
                    if (list.peekLast()>num&&target>0){
                        list.pollLast();
                        target--;
                    }else {
                        break;
                    }
                }
                list.addLast(num);
            }
        }
        while (target>0){
            list.pollLast();
            target--;
        }
        String res = "";
        for (int i:list){
            res = res + i;
        }
        boolean head = true;
        int sum = 0;
        for (char i:res.toCharArray()){
            if (i=='0'&&head){
                continue;
            }
            head = false;
            sum = sum*10+Integer.parseInt(i+"");
        }
        return sum==0?"0":sum+"";
    }
}
