package leetcode.solution.heap.q692;

import org.junit.Test;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 *
 * @author noodle
 * @date 2019/7/31 19:47
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], 1 + map.getOrDefault(words[i], 0));
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((word1, word2) -> {
            if (map.get(word1) == map.get(word2))
                return word2.compareTo(word1);

            return map.get(word1) - map.get(word2);
        });

        for (String word : map.keySet()) {
            minHeap.add(word);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        List<String> topK = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            topK.add(minHeap.poll());
        }

        Collections.reverse(topK);
        return topK;
    }

    @Test
    public void case01() {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;

        System.out.println(topKFrequent(words, k));
    }

    @Test
    public void case02() {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;

        System.out.println(topKFrequent(words, k));
    }
}