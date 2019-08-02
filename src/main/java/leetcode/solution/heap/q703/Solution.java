package leetcode.solution.heap.q703;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author noodle
 * @date 2019/7/31 20:17
 */
public class Solution {
    class KthLargest {

        private PriorityQueue<Integer> minHeap;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.minHeap = new PriorityQueue<>();

            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        public int add(int val) {
            minHeap.add(val);
            if (minHeap.size() > k)
                minHeap.poll();

            return minHeap.peek();
        }
    }


    @Test
    public void case01() {
        int k = 3;
        int[] arr = {4, 5, 8, 2};

        KthLargest kthLargest = new KthLargest(k, arr);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));

    }
}