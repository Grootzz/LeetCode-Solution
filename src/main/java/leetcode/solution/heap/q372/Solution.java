package leetcode.solution.heap.q372;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 *
 * @author noodle
 * @date 2019/7/31 16:09
 */
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {

                return (l2.get(0) + l2.get(1)) - (l1.get(0) + l1.get(1));
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                maxHeap.add(list);
                if (maxHeap.size() > k)
                    maxHeap.poll();
            }
        }

        while (!maxHeap.isEmpty()) {
            res.add(maxHeap.poll());
        }

        return res;
    }
}