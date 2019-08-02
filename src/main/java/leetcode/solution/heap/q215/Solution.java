package leetcode.solution.heap.q215;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author noodle
 * @date 2019/7/30 10:37
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // min heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size() > k)
                heap.poll();

        }

        return heap.poll();
    }

    @Test
    public void case01() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    @Test
    public void case02() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }
}