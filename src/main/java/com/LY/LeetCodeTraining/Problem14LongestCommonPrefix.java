package com.LY.LeetCodeTraining;

import java.util.LinkedList;

public class Problem14LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs==null){
                return null;
            }
            if (strs.length==1){
                return strs[0];
            }
            int minLen = Integer.MAX_VALUE;
            //找到数组中最短字符串的长度
            for (int i = 0; i < strs.length; i++) {
                if(strs[i].length()<minLen){
                    minLen = strs[i].length();
                }
            }
            boolean ifequal = true;
            LinkedList<Character> res = new LinkedList<Character>();
            //以队列为存储，每次取出第一个字符串一个字符和其他字符串比较
            //如果比较全部相同则加入队列，如果不同则停止
            for (int i = 0; i < minLen; i++) {
                //获取第一个字符
                char key = strs[0].charAt(i);
                //逐个比较
                for (int j = 1; j < strs.length; j++) {
                    ifequal = strs[j].charAt(i) == key?true:false;
                    if(ifequal==false){
                        break;
                    }
                }
                if(ifequal==false){
                    break;
                }
                //如果都没问题就加入队列
                res.addLast(key);
            }

            //输出队列结果
            if (res.peekFirst()==null){
                return "";
            }else{
                StringBuffer result = new StringBuffer("");
                while (res.peekFirst()!=null){
                    result.append(res.removeFirst());
                }
                return result.toString();
            }
        }
    }
}
