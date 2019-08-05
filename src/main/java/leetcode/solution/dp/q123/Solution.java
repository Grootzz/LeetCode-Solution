package leetcode.solution.dp.q123;

import org.junit.Test;
/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [3,3,5,0,0,3,1,4]
输出: 6
解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
示例 2:

输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
示例 3:

输入: [7,6,4,3,1]
输出: 0
解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 */

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