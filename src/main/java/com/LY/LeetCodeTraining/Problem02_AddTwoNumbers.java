package com.LY.LeetCodeTraining;

public class Problem02_AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode head = res;
        int c = 0;
        ListNode AddNumber1 = l1;
        ListNode AddNumber2 = l2;
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        while (AddNumber1 != null || AddNumber2 != null) {
            int sum1 = AddNumber1 == null ? 0 : AddNumber1.val;
            int sum2 = AddNumber2 == null ? 0 : AddNumber2.val;
            int sum = sum1 + sum2 + c;
            c = sum / 10;
            int value = sum % 10;
            res.next = new ListNode(value);
            AddNumber1 = AddNumber1 == null ? AddNumber1 : AddNumber1.next;
            AddNumber2 = AddNumber2 == null ? AddNumber1 : AddNumber2.next;
            res = res.next;
        }
        if (c != 0) {
            res.next = new ListNode(c);
        }
        return head.next;
    }
}
