package leetcode.solution.dp.q32;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * @author noodle
 * @date 2019/7/27 21:47
 */
public class Solution {

    public int longestValidParentheses(String s) {

        if (s == null || s.length() == 0)
            return 0;

        // dp[i] 表示到以第 i 个字符结尾的最大子字符串的长度
        int dp[] = new int[s.length()];

        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if ((i - dp[i - 1] > 0) && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    @Test
    public void case01() {
        String s = "(()";
        System.out.println(longestValidParentheses(s));
    }

    @Test
    public void case02() {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }
}