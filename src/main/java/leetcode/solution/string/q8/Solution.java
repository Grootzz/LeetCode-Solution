package leetcode.solution.string.q8;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * @author noodle
 * @date 2019/8/12 20:24
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        int p = 0;// 指向无重复子串的第一个字符
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                p = Math.max(p, map.get(s.charAt(i)));
            } else {
                max = Math.max(max, i - p + 1);
                map.put(s.charAt(i), i);
            }
        }

        return max;
    }

    @Test
    public void doTest() {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    @Test
    public void doTest01() {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}