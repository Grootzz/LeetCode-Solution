package leetcode.solution.dp.q188;

import org.junit.Test;

/**
 * 188. 买卖股票的最佳时机 IV
 *
 * @author noodle
 * @date 2019/8/7 21:57
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int MAX_K = k;

        int[][][] dp = new int[prices.length][MAX_K + 1][2];

        // 第i天未发生交易（卖出来才视为交易成功）处于0状态, 即前一天买入了或者前一天未买入；
        // 即：max(dp[i-1][0][0], dp[i-1][0][1]-prices[i]) = -prices[i]
//        for (int i = 0; i < prices.length; i++) {
//            dp[i][0][0] = -prices[i];
//        }

        for (int i = 0; i < prices.length; i++) {
            for (int n = 1; n <= MAX_K; n++) {
                if (i == 0) {
                    dp[0][n][1] = 0;
                    dp[0][n][0] = -prices[i];
                    continue;
                }
                dp[i][n][0] = Math.max(dp[i - 1][n][1] - prices[i - 1], dp[i - 1][n][0]);
                dp[i][n][1] = Math.max(dp[i - 1][n - 1][0] + prices[i - 1], dp[i - 1][n][1]);
            }
        }

        return dp[prices.length - 1][MAX_K][1];
    }

    @Test
    public void doTest() {
        int[] prices = {2, 4, 1};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }

    @Test
    public void doTest02() {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }

    @Test
    public void doTest03() {
        int[] prices = {2, 1, 4, 5, 2, 9, 7};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }
}