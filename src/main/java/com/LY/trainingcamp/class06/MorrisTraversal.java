package com.LY.trainingcamp.class06;

import com.LY.Main;
import com.LY.trainingcamp.class04.TreeEqual;

public class MorrisTraversal {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int v){
            value = v;
        }
    }
    public static void morris(Node head){
        if(head==null){
            return;
        }
        Node cur = head;
        Node mostright = null;
        while (cur!=null){
            mostright = cur.left;
            //cur有左树
            if(mostright!=null){//如果有左树
                //找到cur真实的最右节点
                while (mostright.right!=null&&mostright.right!=cur){
                    mostright = mostright.right;
                }
                //从while中出来，mostright一定是cur左树上的最右节点
                if (mostright.right == null){
                    mostright.right = cur;
                    cur = cur.left;
                    continue;
                }
                if(mostright.right == cur){
                    mostright.right = null;
                }
            }
            //cur没有左树
            cur = cur.right;
        }
    }

    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostright = null;
        while (cur != null) {
            mostright = cur.left;
            //cur有左树
            if (mostright != null) {//如果有左树
                //找到cur真实的最右节点
                while (mostright.right != null && mostright.right != cur) {
                    mostright = mostright.right;
                }
                //从while中出来，mostright一定是cur左树上的最右节点
                if (mostright.right == null) {
                    mostright.right = cur;
                    cur = cur.left;
                    continue;
                }
                if (mostright.right == cur) {
                    mostright.right = null;
                }
            }
            //cur没有左树
            //往右跳之前打印，就是终须遍历
            System.out.println(cur.value + " ");
            cur = cur.right;
        }
    }

    //先序遍历，没有左树时第一次第二次不分家的，遇到就打印
    //能到达自己两次的节点，第一次就打印
    public static void morrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostright = null;
        while (cur != null) {
            mostright = cur.left;
            //cur有左树
            if (mostright != null) {//如果有左树
                //找到cur真实的最右节点
                while (mostright.right != null && mostright.right != cur) {
                    mostright = mostright.right;
                }
                //从while中出来，mostright一定是cur左树上的最右节点
                if (mostright.right == null) {
                    mostright.right = cur;
                    System.out.println(cur.value+" ");
                    cur = cur.left;
                    continue;
                }
                if (mostright.right == cur) {
                    mostright.right = null;
                }
            }else{
                System.out.println(cur.value+" ");
            }
            //cur没有左树
            cur = cur.right;
        }
    }

    public static void morrisPos(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostright = null;
        while (cur != null) {
            mostright = cur.left;
            //cur有左树
            if (mostright != null) {//如果有左树
                //找到cur真实的最右节点
                while (mostright.right != null && mostright.right != cur) {
                    mostright = mostright.right;
                }
                //从while中出来，mostright一定是cur左树上的最右节点
                if (mostright.right == null) {
                    mostright.right = cur;
                    cur = cur.left;
                    continue;
                }
                if (mostright.right == cur) {
                    mostright.right = null;
                    printEdge(cur.left);
                }
            }
            //cur没有左树
            cur = cur.right;
        }
        printEdge(head);
    }

    public static void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur!=null){
            System.out.println(cur.value+" ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public static Node reverseEdge(Node head) {
        Node pre = null;
        Node next = null;
        while (head!=null){
            next = head.right;
            head.right = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        Node cur = head;
        Node mostright = null;

        Integer pre = null;
        while (cur != null) {
            mostright = cur.left;
            //cur有左树
            if (mostright != null) {//如果有左树
                //找到cur真实的最右节点
                while (mostright.right != null && mostright.right != cur) {
                    mostright = mostright.right;
                }
                //从while中出来，mostright一定是cur左树上的最右节点
                if (mostright.right == null) {
                    mostright.right = cur;
                    cur = cur.left;
                    continue;
                }
                if (mostright.right == cur) {
                    mostright.right = null;
                }
            }
            //cur没有左树
            //打印时机换成比对时机就行
            //因为BST的中序遍历必然是递增的
            if(pre!=null&&pre>=cur.value){
                return false;
            }
            pre = cur.value;
            cur = cur.right;
        }
        return true;
    }
    public static int minHeight1(Node head){
        if(head==null){
            return 0;
        }
        return p(head);
    }

    //暴力递归求
    public static int p(Node x) {
        if(x.left==null&&x.right==null){
            return 1;
        }
        //左右子树起码有一个为空
        int LH = Integer.MAX_VALUE;
        int RH = Integer.MAX_VALUE;
        if(x.left!=null){
            LH = p(x.left);
        }
        if (x.right!=null){
            RH = p(x.right);
        }
        return 1+Math.min(LH,RH);
    }
    public static int minHeight2(Node head){
        if(head==null){
            return 0;
        }
        Node cur = head;
        Node mostright = null;
        int curLevel = 0;
        int minHeight = Integer.MAX_VALUE;
        while (cur!=null){
            mostright = cur.left;
            //cur有左树
            if(mostright!=null){//如果有左树
                int rightBoardSize = 1;
                //找到cur真实的最右节点
                while (mostright.right!=null&&mostright.right!=cur){
                    rightBoardSize++;
                    mostright = mostright.right;
                }
                //从while中出来，mostright一定是cur左树上的最右节点
                if (mostright.right == null){//第一次到达
                    curLevel++;
                    mostright.right = cur;
                    cur = cur.left;
                    continue;
                }
                if(mostright.right == cur){//第二次到达
                    if (mostright.left==null){//
                        minHeight = Math.min(minHeight,curLevel);
                    }
                    //如果是从底下上来的，那么需要调回当前层数
                    curLevel -=rightBoardSize;
                    mostright.right = null;
                }
            }else {//只有一次到达
                curLevel++;
            }
            //cur没有左树
            cur = cur.right;
        }
        int finalRight = 1;
        cur = head;
        while (cur.right!=null){
            finalRight++;
            cur = cur.right;
        }
        if (cur.left==null&&cur.right==null){
            minHeight = Math.min(minHeight,finalRight);
        }
        return minHeight;
    }


}
