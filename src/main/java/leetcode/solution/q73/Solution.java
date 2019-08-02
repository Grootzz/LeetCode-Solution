package leetcode.solution.q73;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author noodle
 * @date 2019/7/22 20:58
 */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] matrix1 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        new Solution().setZeroes(matrix);
        new Solution().setZeroes(matrix1);

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("----------------------------");
        for (int i = 0; i < matrix1.length; i++) {
            System.out.println(Arrays.toString(matrix1[i]));
        }
    }

    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean isCol = false;

        for (int i = 0; i < m; i++) {

            if (matrix[i][0] == 0)
                isCol = true;

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // clear
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (isCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
