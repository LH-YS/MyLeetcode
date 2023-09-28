package com.LY.LeetCodeTraining;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem23_MergeKSortedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        //通过小根堆来组织节点，重新组成新的链表
        if(lists==null){
            return null;
        }
        if (lists.length==1){
            return lists[0];
        }
        //第一步，先把所有节点加入小根堆
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null){
                priorityQueue.add(lists[i]);
            }
        }
        if (priorityQueue.isEmpty()){
            return null;
        }
        //第二步，提取出头结点
        ListNode head = priorityQueue.poll();
        ListNode pre = head;
        if (pre.next!=null){
            priorityQueue.add(pre.next);
        }
        //接下来重复这个过程，取节点加入链表，如果这个节点还有后续，再次加入小根堆
        while (!priorityQueue.isEmpty()){
            ListNode cur = priorityQueue.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next!=null){
                priorityQueue.add(cur.next);
            }
        }
        return head;
    }

    public class ListNodeComparator implements Comparator<ListNode>{

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }
}
