package com.LY.LeetCodeTraining;

public class Problem21_MergeTwoSortedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1==null||list2==null){
                return list1==null?list2:list1;
            }
            ListNode left = list1;
            ListNode right = list2;
            ListNode res = new ListNode();
            ListNode head = res;
            while (left!=null&&right!=null){
                if (left.val<=right.val){
                    res.next = new ListNode(left.val);
                    res = res.next;
                    left = left.next;
                }else{
                    res.next = new ListNode(right.val);
                    res = res.next;
                    right = right.next;
                }
            }
            if (left==null){
                res.next = right;
            }else {
                res.next = left;
            }
            return head.next;
        }
    }
}
