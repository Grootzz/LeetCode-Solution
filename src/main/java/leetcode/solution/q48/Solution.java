package leetcode.solution.q48;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author noodle
 * @date 2019/7/9 20:47
 */
public class Solution {

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution().rotate(nums);
        System.out.println(Arrays.toString(nums[0]));
        System.out.println(Arrays.toString(nums[1]));
        System.out.println(Arrays.toString(nums[2]));
    }

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
                if (i != j){
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
    }

}
