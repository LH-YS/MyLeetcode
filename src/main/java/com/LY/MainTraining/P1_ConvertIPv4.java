package com.LY.MainTraining;

import java.util.Scanner;

/*
    #号相隔的ip4地址转换为32位整数
 */
public class P1_ConvertIPv4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] address = scanner.nextLine().split("#");

        if(address.length!=4){
            System.out.println("invalid IP");
            System.exit(0);
        }
        //判断是否非法
        int firstAddress = Integer.parseInt(address[0]);
        if (firstAddress < 1 || firstAddress > 128) {
            System.out.println("invalid IP");
            System.exit(0);
        }

        //不非法继续判断后面三个小节
        for (int i = 1; i < 4; i++) {
            int temp = Integer.parseInt(address[i]);
            if (temp < 0 || temp > 255) {
                System.out.println("invalid IP");
                System.exit(0);
            }
        }

        //转换成数字
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            String hexString = Integer.toHexString(Integer.parseInt(address[i]));
            //如果十六进制字符串长度为1则需要补0
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            stringBuffer.append(hexString);
        }
        System.out.println(Long.parseLong(stringBuffer.toString(),16));
    }
}
