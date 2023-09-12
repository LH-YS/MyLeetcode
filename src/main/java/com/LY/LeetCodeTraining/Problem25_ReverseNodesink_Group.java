package com.LY.LeetCodeTraining;

public class Problem25_ReverseNodesink_Group {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            //先让右指针移动到k位置，不满足返回原链表
            ListNode R = head;
            for (int i = 0; i < k-1; i++) {
                if (R==null){
                    return head;
                }
                R = R.next;
            }
            //此时R第一次到达的节点是未来的头结点
            ListNode res = R;
            ListNode L = head;
            ListNode pre = null;//代表L的前一个
            int move = k;
            while (R!=null){
                if (move == k){//如果移动次数达到要求，执行反转
                    move = 0;
                    reverseListNode(pre,L,R);//翻转L到R之间的链表
                    //调换L和R的位置
                    ListNode temp = L;
                    L = R;
                    R = temp;
                }
                R = R.next;
                pre = L;
                L = L.next;
                move++;
            }
            return res;

        }

        public void reverseListNode(ListNode LPre, ListNode l, ListNode r) {
            ListNode L = l;
            ListNode R = r;
            ListNode RNext = R.next;
            //翻转链表
            ListNode pre = null;
            while (L!=R){
                ListNode temp = L.next;
                L.next = pre;
                pre = L;
                L = temp;
            }
            L.next = pre;

            //翻转链表后拼接
            if(LPre!=null){
                LPre.next = r;
            }
            l.next = RNext;
        }
    }
}
