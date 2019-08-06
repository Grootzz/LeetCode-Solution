package leetcode.solution.dp.q132;

import org.junit.Test;

/**
 * 132. 分割回文串 II
 *
 * @author noodle
 * @date 2019/8/6 21:33
 */
public class Solution {
    public int minCut(String s) {

        int n = s.length();
        // dp[i]: 表示1~i个字符分割为回文的最小分割次数
        int[] dp = new int[n + 1];
        // 0次分割需要-1次
        dp[0] = -1;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = i;
            for (int j = 0; j < i; j++) {
                if (isPal(s, j, i)) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }

        return dp[n];
    }

    private boolean isPal(String s, int start, int end) {
        int left = start;
        int right = end - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }

        return true;
    }

    @Test
    public void doTest(){
        String s = "aab";
        System.out.println(minCut(s));
    }
}