package leetcode.solution.q54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author noodle
 * @date 2019/7/10 21:03
 */
public class Solution {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return ans;
        int R = matrix.length;
        int C = matrix[0].length;
        boolean[][] visited = new boolean[R][C];

        int r = 0, c = 0;
        for (int i = 0; i < R * C; i++) {
            visited[r][c] = true;
            ans.add(matrix[r][c]);

        }


        return ans;
    }

}
