package leetcode.solution.dp.q120;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 *
 * @author noodle
 * @date 2019/8/4 16:43
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];

        int k = 0;
        for (Integer integer : triangle.get(triangle.size() - 1)) {
            dp[k++] = integer;
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> lines = triangle.get(i);
            for (int j = 0; j < lines.size(); j++) {
                dp[j] = Math.min(dp[j] + lines.get(j), dp[j + 1] + lines.get(j));
            }

        }
        return dp[0];
    }


    @Test
    public void doTest() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(triangle);

        System.out.println(minimumTotal(triangle));
    }
}