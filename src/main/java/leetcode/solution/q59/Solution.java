package leetcode.solution.q59;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        int n = 5;
        int[][] matrix = new Solution().generateMatrix(n);

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int a = 0, b = 0, c = n - 1, d = n - 1;
        int num = 0;

        while (a <= c) {
            // left to right
            for (int i = b; i <= d; i++) {
                ans[a][i] = ++num;
            }
            // top to bottom
            for (int i = a + 1; i <= c; i++) {
                ans[i][d] = ++num;
            }

            // right to left
            for (int i = d - 1; i >= b; i--) {
                ans[c][i] = ++num;
            }

            // bottom to top
            for (int i = c - 1; i > a; i--) {
                ans[i][a] = ++num;
            }

            a++;
            b++;
            c--;
            d--;
        }

        return ans;
    }
}
