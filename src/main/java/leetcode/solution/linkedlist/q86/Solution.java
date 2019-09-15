package leetcode.solution.linkedlist.q86;

import util.ListNode;

/**
 * 86. 分隔链表
 *
 * @author noodles
 * @date 2019/9/1 22:38
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode smaller = new ListNode(-1);
        ListNode smallerTmp = smaller;
        ListNode larger = new ListNode(-1);
        ListNode largerTmp = larger;

        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                larger.next = head;
                larger = larger.next;
            }
            head = head.next;
        }

        larger.next = null;
        smaller.next = largerTmp.next;

        return smallerTmp.next;
    }
}