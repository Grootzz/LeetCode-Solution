package leetcode.solution.dp.q123;

import org.junit.Test;

/**
 * 123. 买卖股票的最佳时机 III
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iiI/
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/
 *
 * @author noodle
 * @date 2019/8/5 16:06
 */
public class Solution {
    public int maxProfit(int[] prices) {

        int MAX_K = 2;// 最大交易次数

        // dp[i][k][j]: 第i天最多进行k次交易且持有状态为j时的最大利润
        // j={0,1}, 0：不持有，1: 持有
        int[][][] dp = new int[prices.length + 1][MAX_K + 1][2];

        for (int i = 0; i <= prices.length; i++) {
            for (int k = 1; k <= MAX_K; k++) {
                if (i == 0) {
                    // 第0天特殊处理
                    dp[i][k][0] = 0;// 未持有，利润为0
                    dp[i][k][1] = Integer.MIN_VALUE;// 持有，第0天不可能持有，所以设置利润为负无穷
                } else {
                    // 不持有; max(前一天未不持有，前一天持有)
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1]);
                    // 持有; max(前一天持有，前一天为持有)
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i - 1]);
                }
            }
        }

        return dp[prices.length][MAX_K][0];
    }

    @Test
    public void doTest() {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }

    @Test
    public void doTest01() {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }


    @Test
    public void doTest02() {
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));
    }

}