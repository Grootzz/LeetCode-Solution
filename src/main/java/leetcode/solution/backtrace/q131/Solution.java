package leetcode.solution.backtrace.q131;
/*
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 131. 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 *
 * @author noodle
 * @date 2019/8/20 12:38
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        if (s == null || s.length() == 0)
            return ans;

        Stack<String> stack = new Stack<>();

        backtrace(ans, stack, s, 0);

        return ans;
    }

    private void backtrace(List<List<String>> ans, Stack<String> stack, String s, int cur) {

        if (cur == s.length()) {
            ans.add(new ArrayList<>(stack));
            return;
        }

        for (int i = cur + 1; i <= s.length(); i++) {
            String part = s.substring(cur, i);
            // 剪掉非回文的分支
            if (!isPal(part))
                continue;

            stack.push(part);
            backtrace(ans, stack, s, i);
            stack.pop();
        }
    }

    /**
     * 判断是否为回文
     */
    public boolean isPal(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    @Test
    public void doTest() {
        String s = "aab";
        System.out.println(partition(s));
    }

    @Test
    public void doTest01() {
        String s = "efe";
        System.out.println(partition(s));
    }
}