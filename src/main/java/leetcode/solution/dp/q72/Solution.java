package leetcode.solution.dp.q72;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/edit-distance
 *
 * @author noodle
 * @date 2019/7/28 09:00
 */
public class Solution {
    public int minDistance(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();


        /**
         * dp[i][j]: 表示 word1[0:i] 到 word2[0:j] 的距离
         * 转移方程：
         * word1[i] == word2[j]时：
         *                          dp[i][j] = dp[i-1][j-1];
         * word1[i] != word2[j]时：
         *                          修改word1[i]到word2[j] --> dp[i][j] = dp[i-1][j-1]+1;
         *                          删除word1[i]到word2[j] --> dp[i][j] = dp[i-1][j]+1;
         *                          插入word1[i]到word2[j] --> dp[i][j] = dp[i][j-1]+1;
         */
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第0列删除操作
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        // 第0行插入
        for (int i = 1; i <= n2; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }

        return dp[n1][n2];
    }


    @Test
    public void case01() {
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }

    @Test
    public void case02() {
        String word1 = "intention", word2 = "execution";
        System.out.println(minDistance(word1, word2));
    }
}