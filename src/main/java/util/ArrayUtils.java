package util;

/**
 * @author noodle
 * @date 2019/7/30 09:29
 */
public class ArrayUtils {

    /**
     * 交换数组中的两个元素
     *
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static ListNode convertArrToList(int[] arr) {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;

        for (int i = 0; i < arr.length; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }

        return tmp.next;
    }


    public static void printLinkedList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println();
    }
}