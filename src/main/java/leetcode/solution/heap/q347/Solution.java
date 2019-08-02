package leetcode.solution.heap.q347;

import org.junit.Test;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * <p>
 * Time Complexity：O(N) + N*log(k) + k*log(k)
 * Space Complexity：O(N) + O(K)
 *
 * @author noodle
 * @date 2019/7/30 20:30
 */
public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> counter = new HashMap<>();

        // build freq table
        // [O(n)]
        for (int num : nums) {
            counter.put(num, 1 + counter.getOrDefault(num, 0));
        }

        // create min-heap: freq(num1) < freq(num2) --> "num1 < num2"
        PriorityQueue<Integer> heap = new PriorityQueue<>((num1, num2) -> counter.get(num1) - counter.get(num2));

        // build top-K
        // [N*log(k)]
        for (Integer key : counter.keySet()) {
            heap.add(key);
            if (heap.size() > k)
                heap.poll(); //
        }

        List<Integer> topK = new LinkedList<>();
        // [k*log(k)]
        while (!heap.isEmpty())
            topK.add(heap.poll());

        Collections.reverse(topK);

        return topK;
    }

    @Test
    public void case01() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        List<Integer> topKFreq = topKFrequent(nums, k);

        System.out.println(topKFreq);
    }

    @Test
    public void case02() {
        int[] nums = {1};
        int k = 1;

        List<Integer> topKFreq = topKFrequent(nums, k);

        System.out.println(topKFreq);
    }

}