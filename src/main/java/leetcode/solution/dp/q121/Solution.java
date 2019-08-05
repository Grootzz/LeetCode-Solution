package leetcode.solution.dp.q121;

import org.junit.Test;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author noodle
 * @date 2019/8/5 15:48
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1)
            return 0;

        int[] dp = new int[prices.length - 1];
        dp[0] = prices[1] - prices[0];

        int res = Integer.MIN_VALUE;
        res = Math.max(res, dp[0]);
        for (int i = 1; i < prices.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1] + prices[i + 1] - prices[i], prices[i + 1] - prices[i]);
            res = Math.max(res, dp[i]);
        }
        return res > 0 ? res : 0;
    }

    @Test
    public void doTest() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}