package leetcode.solution.heap.q451;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 *
 * @author noodle
 * @date 2019/7/31 16:46
 */
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqTable = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            freqTable.put(s.charAt(i), freqTable.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuffer sb = new StringBuffer(s.length());

        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        heap.addAll(freqTable.entrySet());

        while (!heap.isEmpty()) {
            Map.Entry<Character, Integer> entry = heap.poll();
            Character key = entry.getKey();
            Integer value = entry.getValue();
            while (value > 0) {
                value--;
                sb.append(key);
            }
        }

        return sb.toString();
    }

    @Test
    public void case01() {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}