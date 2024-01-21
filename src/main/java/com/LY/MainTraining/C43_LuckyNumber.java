package com.LY.MainTraining;
import java.util.*;
public class C43_LuckyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int real = scanner.nextInt();
        int lucky = scanner.nextInt();
        int target = scanner.nextInt();
        if(real<0||lucky<0||target<=1||lucky>=target){
            System.out.println(0);
        }else{
            int res = computeLuckyNumber(real,lucky,target);
            System.out.println(res);
        }
    }

    private static class Node{
        int num;
        Node next;
        public Node(int num){
            this.num = num;
        }
    }
    private static int computeLuckyNumber(int real, int lucky, int target) {
        Node head = new Node(-1);
        Node first = head;
        while (real!=0){
            int num = real%target;
            Node temp = new Node(num);
            head.next = temp;
            head = head.next;
            real = real/target;
        }
        int res = 0;
        while (first!=null){
            if (first.num==lucky){
                res++;
            }
            first = first.next;
        }
        return res;
    }
}
