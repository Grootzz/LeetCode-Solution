package leetcode.solution.linkedlist.q148;

import org.junit.Test;
import util.ListNode;

import static util.ArrayUtils.convertArrToList;
import static util.ArrayUtils.printLinkedList;
/*
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5
 */

/**
 * 148. 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 *
 * @author noodle
 * @date 2019/9/18 20:07
 */
public class Solution {

    /**
     * 快速排序方式
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        qsort(head, null);
        return head;
    }

    private void qsort(ListNode head, ListNode tail) {
        if (head == tail)
            return;

        int pivot = head.val;

        ListNode left = head, cur = head.next;

        while (cur != tail) {
            if (cur.val < pivot) {
                left = left.next;
                qswap(cur, left);
            }
        }

        qswap(head, left);

        qsort(head, left);
        qsort(left.next, tail);
    }

    private void qswap(ListNode cur, ListNode left) {
        int tmp = cur.val;

        cur.val = left.val;
        left.val = tmp;
    }


    /**
     * 归并排序方式
     *
     * @param head
     * @return
     */
    public ListNode sortList_M2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sortList_M2(head);
        ListNode right = sortList_M2(mid);

        ListNode node = new ListNode(-1);
        ListNode ans = node;

        while (left != null && right != null) {
            if (left.val < right.val) {
                node.next = left;
                left = left.next;
            } else {
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }

        node.next = (left == null) ? right : left;

        return ans.next;
    }

    @Test
    public void testLinkedQuickSort() {
        int[] nums = {2, 1, 4, 5, 0, 3, 9, 8, 7, 6};
        ListNode head = convertArrToList(nums);

        ListNode listNode = sortList_M2(head);

        printLinkedList(listNode);
    }
}