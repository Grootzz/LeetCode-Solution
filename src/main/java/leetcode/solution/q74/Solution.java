package leetcode.solution.q74;

/**
 * @author noodle
 * @date 2019/7/22 20:58
 */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        int[][] matrix1 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        Solution solution = new Solution();

        System.out.println(solution.searchMatrix(matrix, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == target)
                    return true;
                else if (matrix[i][j] < target) {
                    break;
                }
            }
        }
        return false;
    }
}
