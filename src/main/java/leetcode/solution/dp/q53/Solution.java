package leetcode.solution.dp.q53;

import org.junit.Test;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author noodle
 * @date 2019/7/27 21:47
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        // dp[i] 表示到以第 i 个元素结尾的子串的最大值
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < dp[i])
                max = dp[i];
        }
        return max;
    }

    @Test
    public void case01() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    @Test
    public void case02() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}