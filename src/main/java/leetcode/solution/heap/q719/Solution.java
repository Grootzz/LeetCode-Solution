package leetcode.solution.heap.q719;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/find-k-th-smallest-pair-distance/
 *
 * @author noodle
 * @date 2019/7/31 20:29
 */
public class Solution {
    public int smallestDistancePair(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                maxHeap.add(Math.abs(nums[i] - nums[j]));
                if (maxHeap.size() > k)
                    maxHeap.poll();
            }
        }

        return maxHeap.poll();
    }


    @Test
    public void case01() {
        int[] nums = {1, 3, 1};
        int k = 1;
        System.out.println(smallestDistancePair(nums, k));
    }

    @Test
    public void case02() {
        int[] nums = {1, 6, 1};
        int k = 3;
        System.out.println(smallestDistancePair(nums, k));
    }
}