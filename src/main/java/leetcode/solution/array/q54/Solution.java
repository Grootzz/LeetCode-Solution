package leetcode.solution.array.q54;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/*
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
 */

/**
 * 54. 螺旋矩阵
 * https://leetcode-cn.com/problems/spiral-matrix/
 *
 * @author noodle
 * @date 2019/7/10 21:03
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return ans;

        // 左上
        int r1 = 0, c1 = 0;
        // 右下
        int r2 = matrix.length - 1, c2 = matrix[0].length - 1;

        while (c1 <= c2 && r1 <= r2) {

            for (int i = c1; i <= c2; i++)
                ans.add(matrix[r1][i]);

            for (int i = r1 + 1; i <= r2; i++)
                ans.add(matrix[i][c2]);

            if (r1 < r2 && c1 < c2) {
                for (int i = c2 - 1; i > c1; i--)
                    ans.add(matrix[r2][i]);

                for (int i = r2; i > r1; i--)
                    ans.add(matrix[i][c1]);
            }

            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }

    @Test
    public void doTest() {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(nums));
    }

}
