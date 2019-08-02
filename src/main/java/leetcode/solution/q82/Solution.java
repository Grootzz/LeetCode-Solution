package leetcode.solution.q82;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @author noodle
 * @date 2019/7/28 13:48
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode h = head, cur = head, pre = head.next;

        while (pre != null) {
            if (cur.val == pre.val) {
                cur.next = pre.next;
            } else {
                cur = cur.next.next;
            }
            pre = pre.next;
        }
        return h;
    }


    public void case01() {
        // 1->2->3->3->4->4->5
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p33 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p44 = new ListNode(4);
        ListNode p5 = new ListNode(5);

        ListNode head = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p33;
        p33.next = p4;
        p4.next = p44;
        p44.next = p5;


    }
}