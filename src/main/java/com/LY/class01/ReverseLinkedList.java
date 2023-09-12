package com.LY.class01;

public class ReverseLinkedList {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            value = data;
        }
    }

    //反转链表
    public static Node reserveList(Node head){
        Node pre = null;
        Node next = null;
        while (head!=null)
        {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    //删除给定值
    public static Node deleteValueInList(Node head,int num){
        //head来到第一个不需要删除的地方
        while (head!=null){
            if (head.value!=num){
                break;
            }
            head = head.next;
        }
        //跳出后第一种情况head为空，说明整个链表都是num
        Node pre = head;
        Node cur = head;
        while (cur!=null){
            if(cur.value == num){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
