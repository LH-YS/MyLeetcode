package com.LY.LeetCodeTraining;

public class Problem38_CountAndSay {
    public String countAndSay(int n) {
        if (n<=0){
            return null;
        }
        String str = "1";
        for (int i = 1; i < n; i++) {
            char[] chars = str.toCharArray();
            char tmpnum = chars[0];
            StringBuffer stringBuffer = new StringBuffer();
            int count = 0;
            for (int j = 0; j < chars.length; j++) {
                //如果现在看的数相同，计数加一
                if (chars[j]==tmpnum){
                    count++;
                }else {
                    //不同的话结算
                    stringBuffer.append(count).append(tmpnum);
                    tmpnum=chars[j];
                    count=1;
                }
            }
            //遍历结束后还需要结算一次
            stringBuffer.append(count).append(tmpnum);
            str = stringBuffer.toString();
        }
        return str;
    }
}
