package leetcode.solution.dp.q115;

import org.junit.Test;

/**
 * 115. 不同的子序列
 * https://leetcode-cn.com/problems/distinct-subsequences/
 *
 * @author noodle
 * @date 2019/8/4 15:51
 */
public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        for (int i = 0; i < s.length() + 1; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else
                    dp[i][j] = dp[i][j - 1];
            }
        }

        return dp[t.length()][s.length()];
    }

    @Test
    public void doTest() {
        String S = "rabbbit", T = "rabbit";
        System.out.println(numDistinct(S, T));
    }

    @Test
    public void doTest01() {
        String S = "babgbag", T = "bag";
        System.out.println(numDistinct(S, T));
    }
}