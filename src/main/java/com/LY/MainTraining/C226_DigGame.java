package com.LY.MainTraining;
import java.io.*;
import java.util.*;
public class C226_DigGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int res = computeDigGame(target);
        System.out.println(res);
    }

    private static int computeDigGame(int target) {
        int oneNum = 0;//记录01模式右边有几个1
        //寻找01模式，定位0的位置因为可能首位为1
        int temp = target;
        int pos = 0;
        boolean flag = false;//是否进入匹配
        while (temp!=0){
            int now = temp&1;
            if (now==1){
                oneNum++;
                flag = true;
            }else if (flag==true){
                //如果当前为0且右边是1，则匹配成功
                flag = false;
                break;
            }
            pos++;
            temp = temp >> 1;
        }
        int origin = ~((1<<pos)-1) & target;
        int res = 1<<pos;
        for (int i = 0; i < oneNum-1; i++) {
            res = res|(1<<i);
        }
        res = res+origin;
        return res;
    }
}
