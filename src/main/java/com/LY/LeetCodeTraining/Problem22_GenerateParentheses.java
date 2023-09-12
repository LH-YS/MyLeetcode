package com.LY.LeetCodeTraining;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Problem22_GenerateParentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {
            if (n <= 0) {
                return null;
            }
            HashSet<String> set = new HashSet<>();//用来收集答案
            char[] chars = new char[2 * n];//用来存放过程
            int hasput = 0;//已经存放的左括号数量
            int index = 0;//当前填写到index
            collectRes(set, chars, n, hasput, index);
            Iterator<String> iterator = set.iterator();
            List<String> res = new ArrayList<>();
            while (iterator.hasNext() == true) {
                res.add(iterator.next());
            }
            return res;

        }

        private void collectRes(HashSet<String> set, char[] chars, int n, int hasput, int index) {
            if (index == chars.length) {
                //此时已经得到一种答案
                set.add(String.valueOf(chars));
            }
            if (hasput == 0) {
                //第一种情况，还没有放过左括号,此时下一个只能放左括号
                chars[index] = '(';
                collectRes(set, chars, n - 1, hasput + 1, index + 1);
                chars[index] = 0;
            } else {
                //第二种情况，放过左括号
                //如果还可以放左括号就放左括号收集信息，放右括号收集信息
                if (n > 0) {
                    chars[index] = '(';
                    collectRes(set, chars, n - 1, hasput + 1, index + 1);
                    chars[index] = ')';
                    collectRes(set, chars, n, hasput - 1, index + 1);
                    chars[index] = 0;
                } else {
                    //如果n=0说明左括号已经放完了，此时只能放右括号
                    chars[index] = ')';
                    collectRes(set, chars, n, hasput - 1, index + 1);
                    chars[index] = 0;
                }
            }
        }
    }
}
