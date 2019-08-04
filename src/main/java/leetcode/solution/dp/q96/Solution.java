package leetcode.solution.dp.q96;

import org.junit.Test;

/**
 * 96. 不同的二叉搜索树
 * <p>
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * <p>
 * 设dp[n]为n个节点的具有的BST个数，f[i]为以i节点为root的BST个数，则有：
 * dp[n] = f(0)+f(1)+f(2)+...+f(n)
 * 而：
 * f(i) = dp[i-1]*dp[n-i]
 * 故：
 * dp[n] = sum(dp[i-1]*dp[n-i])
 *
 * @author noodle
 * @date 2019/8/4 14:14
 */
public class Solution {
    public int numTrees(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int k = 2; k <= n; k++) {
            for (int i = 1; i <= k; i++) {
                dp[k] += dp[i - 1] * dp[k - i];
            }
        }

        return dp[n];
    }


    @Test
    public void doTest() {
        System.out.println(numTrees(3));
    }

}