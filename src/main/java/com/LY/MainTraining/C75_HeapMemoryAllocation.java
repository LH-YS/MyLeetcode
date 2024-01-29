package com.LY.MainTraining;
import java.util.*;
public class C75_HeapMemoryAllocation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = Integer.parseInt(scanner.nextLine());
        int[] bytes = new int[100];
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (line.isEmpty()){
                break;
            }
            String[] split = line.split(" ");
            int index = Integer.parseInt(split[0]);
            int len = Integer.parseInt(split[1]);
            for (int i = 0; i < len; i++) {
                bytes[index++] = 1;
            }
        }
        int mode = 0;
        int have = 0;
        int head = 0;
        for (int i = 0; i < 100; i++) {
            if (bytes[i]==0){
                if (mode==0){
                    mode = 1;//开启记录
                    head = i;
                    have +=1;
                }else {
                    have+=1;
                }
                if (have==target){
                    //说明分配成功
                    System.out.println(head);
                    return;
                }
            }else {
                if (mode==1){
                    //关闭记录 重置
                    mode = 0;
                    have = 0;
                }
            }
        }
        System.out.println(-1);
    }
}
