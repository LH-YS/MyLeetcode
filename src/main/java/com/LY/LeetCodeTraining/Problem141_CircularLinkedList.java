package com.LY.LeetCodeTraining;

import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Problem141_CircularLinkedList {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        boolean flag = false;
        HashSet<ListNode> set = new HashSet<>();
        while(temp!=null){
            if (set.contains(temp)){
                flag = true;
                break;
            }else {
                set.add(temp);
            }
            temp = temp.next;
        }
        return flag;
    }
}
