package leetcode.solution.np;


/*
背包问题(Knapsack problem)是一种组合优化的NP完全问题。
        问题可以描述为：
        给定一组物品，每种物品都有自己的重量w和价格v，在限定的总重量内，我们如何选择，才能使得物品的总价格最高。
 */

import org.junit.Test;

/**
 * 0-1背包问题
 * https://zhuanlan.zhihu.com/p/30959069
 *
 * @author noodle
 * @date 2019/8/5 21:20
 */
public class KnapsackProblem {

    /**
     * @param values    物品价值
     * @param weights   物品重量
     * @param maxWeight 背包最大容量
     * @return 最大价值
     */
    public int knapsack(int[] values, int[] weights, int maxWeight) {
        if (maxWeight == 0)
            return 0;
        // 物品数目
        int n = values.length;

        // dp[i][w]: 表示前 i 件物品中挑选总重量不超过 w 的商品的的最大价值
        int[][] dp = new int[n + 1][maxWeight + 1];

        // 1. dp[0][w]: 前0件商品中挑选总总量不超过w的商品的最大价值，因为是0件商品，故dp[0][w]=0
        for (int w = 0; w <= maxWeight; w++) {
            dp[0][w] = 0;
        }

        // 2. dp[i][0]: 在前i件物品中挑选总重量不超过0的商品的最大价值，因为重量不超过0，即0减商品，故dp[i][w]=0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // 3. dp[i][w]: 有两种选择，第i件物品选了和没选
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= maxWeight; w++) {
                // 第i件物品直接大于 1~(i-1) 中挑选的物品总和
                if (weights[i - 1] > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                }
            }
        }

        return dp[n][maxWeight];
    }



    @Test
    public void doTest() {
        int[] values = {1, 6, 18, 22, 28};
        int[] weights = {1, 2, 5, 6, 7};
        int maxWeight = 11;

        int maxValue = knapsack(values, weights, maxWeight);
        System.out.println(maxValue);

    }
}