package leetcode.solution.np.q518;

import org.junit.Test;

/**
 * 518. 零钱兑换 II
 * https://leetcode-cn.com/problems/coin-change-2/
 *
 * @author noodle
 * @date 2019/8/5 22:42
 */
public class Solution {
    public int change(int amount, int[] coins) {

        // dp[i][a]: 前i种面值构成总金额为a的情况总数
        int[][] dp = new int[coins.length + 1][amount + 1];

        dp[0][0] = 1;

        for (int i = 1; i < coins.length + 1; i++) {
            dp[i][0] = 1;
            for (int a = 1; a < amount + 1; a++) {
                    dp[i][a] = dp[i - 1][a] + (coins[i - 1] > a ? 0 : dp[i][a - coins[i - 1]]);
            }
        }

        return dp[coins.length][amount];
    }

    @Test
    public void doTest() {
        int amount = 5;
        int[] coins = {1, 2, 5};

        System.out.println(change(amount, coins));
    }
}