package leetcode.solution.linkedlist.q234;

import org.junit.Test;
import util.ListNode;

import static util.ArrayUtils.convertArrToList;

/**
 * 请判断一个链表是否为回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author noodle
 * @date 2019/8/29 14:47
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        // 找中间节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 对奇数个节点的链表做处理：slow指向mid，所以需要rev指向下一个
        if (fast != null)
            slow = slow.next;

        // 翻转后半部分链表
        ListNode cur = slow;
        ListNode rev = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = rev;
            rev = cur;
            cur = tmp;
        }

        // 判断回文
        while (rev != null) {
            if (rev.val != head.val)
                return false;
            rev = rev.next;
            head = head.next;
        }

        return true;
    }

    @Test
    public void doTest() {
        ListNode head = convertArrToList(new int[]{1, 2, 3, 3, 2, 1});

        boolean ans = isPalindrome(head);
        System.out.println(ans);
    }

    @Test
    public void doTest01() {
        ListNode head = convertArrToList(new int[]{1, 0, 1});
        boolean ans = isPalindrome(head);
        System.out.println(ans);
    }

    @Test
    public void doTest02() {
        ListNode head = convertArrToList(new int[]{1, 2, 3, 2, 1});

        boolean ans = isPalindrome(head);
        System.out.println(ans);
    }

}