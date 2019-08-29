package leetcode.solution.linkedlist.q206;

import org.junit.Test;
import util.ListNode;

import static util.ArrayUtils.convertArrToList;
import static util.ArrayUtils.printLinkedList;

/**
 * @author noodle
 * @date 2019/8/29 16:04
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode rev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = rev;
            rev = cur;

            cur = tmp;
        }
        return rev;
    }

    @Test
    public void doTest() {
        ListNode head = convertArrToList(new int[]{1, 2, 3, 4});
        ListNode rev = reverseList(head);
        printLinkedList(rev);
    }
}