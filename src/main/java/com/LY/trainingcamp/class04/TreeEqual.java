package com.LY.trainingcamp.class04;

import java.util.ArrayList;


public class TreeEqual {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int v){
            value = v;
        }
    }
    //暴力方法
    //big做头节点的数，其中是否有某棵子树的结构，适合small为头的树是完全一样的
    public static boolean containsTree1(Node big,Node small){
        if(small==null){
            return true;
        }
        if (big==null){
            return false;
        }
        if (isSameValueStructure(big,small)){
            return true;
        }
        return containsTree1(big.left,small)||containsTree1(big.right,small);
    }


    //head1微投的数是否在结构对应上，完全和head2一样
    public static boolean isSameValueStructure(Node head1, Node head2) {
        if (head1==null&&head2!=null){
            return false;
        }
        if (head1==null&&head2==null){
            return true;
        }
        if (head1!=null&&head2==null){
            return false;
        }
        if (head1.value!=head2.value){
            return false;
        }
        //head1.v ==head2.v
        return isSameValueStructure(head1.left,head2.left)
                &&isSameValueStructure(head1.right,head2.right);
    }
    public static boolean containsTree2(Node big,Node small){
        if (small==null){
            return false;
        }
        if (big == null){
            return false;
        }
        ArrayList<String> b = preSerial(big);
        ArrayList<String> s = preSerial(small);
        String[] str = new String[b.size()];
        for (int i = 0; i < str.length; i++) {
            str[i] = b.get(i);
        }
        String[] match = new String[s.size()];
        for (int i = 0; i < match.length; i++) {
            match[i] = s.get(i);
        }
        return getIndexOf1(str,match) != -1;

    }

    public static int getIndexOf1(String[] str1, String[] str2) {
        if (str1==null||str2==null||str1.length<1||str1.length< str2.length){
            return -1;
        }
        int x = 0;
        int y = 0;
        int[] next = getNextArray1(str2);
        while (x<str1.length&&y< str2.length){
            if(isEqual(str1[x],str2[y])){
                x++;
                y++;
            } else if (next[y] == -1) {
                x++;
            }else {
                y = next[y];
            }
        }
        return y==str2.length?x-y:-1;

    }

    public static boolean isEqual(String s1, String s2) {
        if (s1==null&&s2==null){
            return true;
        }else {
            if (s1==null||s2==null){
                return false;
            }else {
                return s1.equals(s2);
            }
        }
    }

    public static int[] getNextArray1(String[] str2) {
        if (str2.length==1){
            return new int[]{-1};
        }
        int[] next = new int[str2.length];
        int i = 2;
        int cn = 0;
        next[0] = -1;
        next[1] = 0;
        while (i<str2.length){
            if (isEqual(str2[i-1],str2[cn])){
                next[i++] = ++cn;
            }else if(cn>0){
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }
        return  next;
    }

    public static ArrayList<String> preSerial(Node head) {
        ArrayList<String> ans = new ArrayList<>();
        pres(head,ans);
        return ans;
    }

    public static void pres(Node head, ArrayList<String> ans) {
        //先序序列化
        if (head == null){
            ans.add(null);
        }else {
            ans.add(String.valueOf(head.value));
            pres(head.left,ans);
            pres(head.right,ans);
        }

    }


}
