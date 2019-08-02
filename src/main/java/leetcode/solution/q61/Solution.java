package leetcode.solution.q61;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        System.out.println(4 - 4 % 4 - 1);
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null)
            return head;

        int cnt = 1;

        ListNode p = head;
        while (p.next != null) {
            cnt++;
            p = p.next;
        }

        p.next = head;

        int n = cnt - k % cnt - 1;
        while (n-- > 0) {
            head = head.next;
        }

        ListNode res = head.next;

        head.next = null;

        return res;
    }


}
