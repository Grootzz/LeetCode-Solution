package leetcode.solution.dp.q84;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * @author noodle
 * @date 2019/8/2 20:26
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = heights[i];
            for (int j = i; j >= 0; j--) {
                width = Math.min(width, heights[j]);
                maxArea = Math.max(maxArea, width * (i - j + 1));
            }
        }

        return maxArea;
    }


    @Test
    public void doTest() {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }
}