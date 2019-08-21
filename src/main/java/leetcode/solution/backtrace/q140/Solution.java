package leetcode.solution.backtrace.q140;

import org.junit.Test;

import java.util.*;

/**
 * 140. 单词拆分 II
 * https://leetcode-cn.com/problems/word-break-ii/
 *
 * @author noodle
 * @date 2019/8/21 16:11
 */
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> ans = new ArrayList<>();

        if (s == null || s.length() == 0)
            return ans;

        Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
        }
        Stack<String> stack = new Stack<>();
        backtrace(ans, stack, dict, s, 0);
        return ans;
    }

    private void backtrace(List<String> ans, Stack<String> stack, Set<String> dict, String s, int cur) {

        if (cur == s.length()) {
            String res = stack.toString().substring(1, stack.toString().length() - 1).replace(", ", " ");
            ans.add(res);
            return;
        }

        for (int i = cur + 1; i <= s.length(); i++) {
            String part = s.substring(cur, i);
            // 剪枝
            if (!dict.contains(part))
                continue;

            stack.push(part);
            backtrace(ans, stack, dict, s, i);
            stack.pop();
        }
    }

    @Test
    public void doTest() {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

        System.out.println(wordBreak(s, wordDict));
    }

    @Test
    public void doTest01() {
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");

        System.out.println(wordBreak(s, wordDict));
    }

    @Test
    public void doTest02() {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

        System.out.println(wordBreak(s, wordDict));
    }

    @Test
    public void doTest03() {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");

        System.out.println(wordBreak(s, wordDict));
    }
}