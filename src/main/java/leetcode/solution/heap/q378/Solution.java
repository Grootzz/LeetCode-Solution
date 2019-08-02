package leetcode.solution.heap.q378;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * @author noodle
 * @date 2019/7/31 16:30
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxHeap.add(matrix[i][j]);
                if (maxHeap.size() > k)
                    maxHeap.poll();
            }
        }

        return maxHeap.poll();
    }
}