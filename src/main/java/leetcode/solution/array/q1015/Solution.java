package leetcode.solution.array.q1015;

import org.junit.Test;

/**
 * <a href="https://leetcode-cn.com/problems/height-checker/">1051. 高度检查器</a>
 *
 * @author noodle
 * @date 2020/8/14 21:00
 */
public class Solution {
    public int heightChecker(int[] heights) {

        int[] counts = new int[101];
        for (int height : heights) {
            counts[height]++;
        }

        int ans = 0;

        for (int i = 1, j = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                if (heights[j++] != i)
                    ans++;
            }
        }
        return ans;
    }

    @Test
    public void case_01() {
        int[] heights = {1, 1, 4, 2, 1, 3};
        System.out.println(heightChecker(heights));
    }
}
