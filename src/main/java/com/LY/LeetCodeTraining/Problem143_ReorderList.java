package com.LY.LeetCodeTraining;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem143_ReorderList {
     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    class Solution {
        public void reorderList(ListNode head) {
            ListNode temp = head;
            int index = 0;
            ArrayList<ListNode> list = new ArrayList<>();
            while (temp!=null){
                list.add(temp);
                index++;
                temp = temp.next;
            }
            int L = 0;
            int R = index-1;
            while (R-L>1){
                list.get(L++).next = list.get(R);
                list.get(R-1).next = null;
                list.get(R--).next = list.get(L);
            }
        }
    }
}
