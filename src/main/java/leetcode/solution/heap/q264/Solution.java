package leetcode.solution.heap.q264;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/ugly-number-ii/
 * dp
 *
 * @author noodle
 * @date 2019/7/30 20:54
 */
public class Solution {

    public int nthUglyNumber(int n) {

        // dp[i] = min(dp[i2]*2, dp[i3]*3, dp[i5]*5)
        int[] dp = new int[n];

        int x = 0, y = 0, z = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[x] * 2, Math.min(dp[y] * 3, dp[z] * 5));
            if (min == dp[x] * 2) x++;
            if (min == dp[y] * 3) y++;
            if (min == dp[z] * 5) z++;
            dp[i] = min;
        }
        return dp[n - 1];
    }

    @Test
    public void case01() {
        System.out.println(nthUglyNumber(10));
    }
}