package com.LY.MainTraining;
import java.util.*;
public class C204_LongestLegalExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int res = computeLongestLegalExpression(str);
        System.out.println(res);
    }

    private static int computeLongestLegalExpression(String str) {
        //解析字符串，从左开始遍历，记录合法计算式，保留最长
        //list保存表达式
        ArrayList<String> list = new ArrayList<>();
        String express = "";
        String res = "";
        int maxLen = Integer.MIN_VALUE;
        int preDig = -1;
        boolean mode = true;//true时表示前一个为符号
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                //如果是数字，看一下前面有没有数字，如果有就加上
                if (preDig != -1) {
                    if (preDig != 0) {
                        preDig = preDig * 10 + Integer.parseInt(c + "");
                        express = express + c;
                    } else {
                        //如果前一个是0，那么下一个不能任何数字，所以结算
                        preDig = Integer.parseInt(c + "");
                        if (express.length() > maxLen) {
                            res = express;
                            maxLen = res.length();
                        }
                        express = "" + c;
                    }
                } else {
                    //如果为-1，无脑新创
                    mode = false;
                    preDig = Integer.parseInt(c + "");
                    express = express + c;
                }
            } else if (c == '+' || c == '-' || c == '*') {
                //如果前面已经是符号了，还遇到符号就错误，那就结算
                if (mode == true) {
                    if (!express.equals("")) {
                        express = express.substring(0, express.length() - 1);
                        if (express.length() > maxLen) {
                            res = express;
                            maxLen = res.length();
                        }
                        express = "";
                    }
                } else {
                    //前面已经有数字了，直接加上
                    express = express + c;
                    preDig = -1;
                    mode = true;
                }
            } else {
                //如果是字母或者其他东西，看看express是不是空
                //如果为空不管他，如果不为空，判断最后一个是不是符号，然后结算
                if (!express.equals("")) {
                    if (mode == true) {
                        express = express.substring(0, express.length() - 1);
                    }
                    if (express.length() > maxLen) {
                        res = express;
                        maxLen = res.length();
                    }
                    express = "";
                    mode = true;
                }
            }
        }
        //遍历结束最后再结算一次
        if (mode == true && !express.equals("")) {
            express = express.substring(0, express.length() - 1);
            if (express.length() > maxLen) {
                res = express;
                maxLen = res.length();
            }
            express = "";
        } else if (mode == false && !express.equals("")) {
            if (express.length() > maxLen) {
                res = express;
                maxLen = res.length();
            }
            express = "";
        }
        char[] chars = res.toCharArray();
        int pre = -1;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                if (pre != -1) {
                    pre = pre * 10 + Integer.parseInt(chars[i] + "");
                } else {
                    pre = Integer.parseInt(chars[i] + "");
                }
            } else {
                list.add(pre + "");
                list.add(chars[i] + "");
                pre = -1;
            }
        }
        if (pre!=-1){
            list.add(pre + "");
        }
        String[] strings = new String[list.size()];
        int index = 0;
        for (String i:list){
            strings[index++] = i;
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("*")) {
                int a = Integer.parseInt(strings[i - 1]);
                int b = Integer.parseInt(strings[i + 1]);
                strings[i - 1] = "";
                strings[i + 1] = "";
                strings[i] = (a * b) + "";
            }
        }
        int mod = 0;
        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].equals("")) {
                if (strings[i].equals("+")) {
                    mod = 1;
                } else if (strings[i].equals("-")) {
                    mod = -1;
                } else {
                    if (mod == 1 || mod == 0) {
                        sum += Integer.parseInt(strings[i]);
                    } else {
                        sum -= Integer.parseInt(strings[i]);
                    }
                }
            }
        }

        return sum;
    }
}
