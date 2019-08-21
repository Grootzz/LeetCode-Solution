package leetcode.solution.array.q48;

import org.junit.Test;

import java.util.Arrays;
/*
给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。
 */

/**
 * 48. 旋转图像
 * https://leetcode-cn.com/problems/rotate-image/
 *
 * @author noodle
 * @date 2019/7/9 20:47
 */
public class Solution {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
    }

    @Test
    public void doTest() {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(nums);

        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
    }
}
