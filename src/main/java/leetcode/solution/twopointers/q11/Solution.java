package leetcode.solution.twopointers.q11;

import org.junit.Test;

/**
 * 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author noodle
 * @date 2019/8/29 18:23
 */
public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return -1;

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, (j - i) * Math.min(height[j], height[i]));
            }
        }

        return maxArea;
    }

    private int maxArea_M2(int[] height) {

        if (height == null || height.length == 0)
            return -1;

        int maxArea = 0;

        int left = 0, right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }

    @Test
    public void doTest() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    @Test
    public void doTest_M2() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea_M2(height));
    }
}