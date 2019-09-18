package common.algo.sort;

import org.junit.Test;
import util.ListNode;

import java.util.Arrays;

import static util.ArrayUtils.*;

/**
 * quick sort
 * 不稳定，平均时间复杂度为O(Nlog(N))
 *
 * @author noodle
 * @date 2019/7/31 11:05
 */
public class QuickSort {

    /**
     * quick sort
     * 数组排序
     *
     * @param nums
     */
    public void quickSort(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {

        if (left >= right)
            return;

        int pivot = median3(nums, left, right);
        int i = left;
        int j = right - 1;

        while (true) {
            while (i < right - 1 && nums[++i] < pivot) {
            }
            while (j > left && nums[--j] > pivot) {
            }

            if (i < j)
                swap(nums, i, j);
            else
                break;
        }

        // swap pivot
        swap(nums, i, right - 1);

        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }


    /**
     * 链表快排
     *
     * @param head
     */
    public ListNode quickSort_LinkedList(ListNode head) {
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
                qswap(left, cur);
            }
            cur = cur.next;
        }

        qswap(head, left);

        qsort(head, left);
        qsort(left.next, tail);
    }

    private void qswap(ListNode left, ListNode cur) {
        int tmp = left.val;
        left.val = cur.val;
        cur.val = tmp;
    }

    /**
     * 三数取中作为 pivot，并将 pivot 放置于 nums[left-1]
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int median3(int[] nums, int left, int right) {
        int center = (left + right) / 2;

        if (nums[center] < nums[left])
            swap(nums, left, center);
        if (nums[left] > nums[right])
            swap(nums, left, right);
        if (nums[center] > nums[right])
            swap(nums, center, right);

        swap(nums, center, right - 1);

        return nums[right - 1];
    }

    @Test
    public void case01() {
        int[] nums = {2, 1, 4, 5, 0, 3, 9, 8, 7, 6};
        quickSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void case02() {
        int[] nums = {2, 2, 4, 5, 0, 0, 9, 9, 9, 6};
        quickSort(nums);

        System.out.println(Arrays.toString(nums));
    }


    @Test
    public void testLinkedQuickSort() {
        int[] nums = {2, 1, 4, 5, 0, 3, 9, 8, 7, 6};
        ListNode head = convertArrToList(nums);

        ListNode listNode = quickSort_LinkedList(head);

        printLinkedList(listNode);
    }
}