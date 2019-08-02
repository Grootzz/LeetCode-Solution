package leetcode.solution.heap.q295;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/find-median-from-data-stream/
 * 295. 数据流的中位数
 *
 * @author noodle
 * @date 2019/7/30 21:39
 */
public class Solution {

    // Solution
    class MedianFinder {

        // min heap
        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;
        private int n;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
            maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
            n = 0;
        }

        public void addNum(int num) {
            n++;
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            if ((n & 1) != 0)
                maxHeap.add(minHeap.poll());
        }

        public double findMedian() {

            if ((n & 1) == 0) {
                return (double) (maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                return (double)maxHeap.peek();
            }
        }
    }


    @Test
    public void case01() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(4);
        medianFinder.addNum(7);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());

    }

    @Test
    public void case02() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}