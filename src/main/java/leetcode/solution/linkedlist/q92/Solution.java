package leetcode.solution.linkedlist.q92;

import util.ListNode;

/**
 * 92. 反转链表 II（反转从位置 m 到 n 的链表）
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * @author noodle
 * @date 2019/8/30 13:29
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || head.next == null)
            return head;

        ListNode cur = head;
        ListNode rev = null;

        while (m > 1) {
            m--;
            n--;
            rev = cur;
            cur = cur.next;
        }

        ListNode prev = rev, tail = cur;

        while (n > 0) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            n--;
        }

        if (rev == null) {
            head = prev;
        } else {
            rev.next = prev;
        }

        tail.next = cur;

        return head;
    }
}