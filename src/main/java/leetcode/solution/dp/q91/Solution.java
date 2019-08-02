package leetcode.solution.dp.q91;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/decode-ways/
 *
 * @author noodle
 * @date 2019/7/28 11:11
 */
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        // dp[i] 表示只字符串 s[0:i] 的解码个数
        int[] dp = new int[s.length() + 1];

        // 初始化边界条件
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= s.length(); i++) {
            dp[i] = s.charAt(i - 1) != '0' ? dp[i - 1] : 0;
            boolean legal = s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7');
            dp[i] += legal ? dp[i - 2] : 0;
        }

        return dp[s.length()];
    }

    @Test
    public void case01() {
        String s = "226";
        System.out.println(numDecodings(s));
    }

    @Test
    public void case02() {
        String s = "27";
        System.out.println(numDecodings(s));
    }
}