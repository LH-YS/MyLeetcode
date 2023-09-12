package com.LY.LeetCodeTraining;

import java.util.LinkedList;

public class Problem20_ValidParentheses {
    public boolean isValid(String s) {
        char[] str = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<Character>();
        int i = 0;
        while (i!=str.length){
            if (str[i]=='('||str[i]=='{'||str[i]=='['){
                stack.push(str[i++]);
            }else {
                if (stack.peek()==null){
                    return false;
                }
                if(str[i]==')'){
                    if (stack.pop()!='('){
                        return false;
                    }
                } else if (str[i]=='}') {
                    if (stack.pop()!='{'){
                        return false;
                    }
                } else if (str[i]==']') {
                    if (stack.pop()!='['){
                        return false;
                    }
                }
                i++;
            }
        }
        if (stack.peek()!=null){
            return false;
        }
        return true;
    }
}
