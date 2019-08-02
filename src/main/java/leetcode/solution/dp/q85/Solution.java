package leetcode.solution.dp.q85;

import org.junit.Test;

/**
 * @author noodle
 * @date 2019/7/28 10:08
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        // dp[i][j]表示到(i, j)点处的 i 行最大宽度
        int[][] dp = new int[matrix.length][matrix[0].length];

        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = (j == 0) ? 1 : (dp[i][j - 1] + 1);

                    int width = dp[i][j];

                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);
                        maxArea = Math.max(maxArea, width * (i - k + 1));
                    }
                }
            }
        }
        return maxArea;
    }

    @Test
    public void case01() {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        int maxArea = maximalRectangle(matrix);
        System.out.println(maxArea);
    }
}