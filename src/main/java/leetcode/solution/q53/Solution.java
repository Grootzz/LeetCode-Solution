package leetcode.solution.q53;

/**
 * https://leetcode.com/problems/maximum-subarray/submissions/
 * <p>
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 */
public class Solution {
    /**
     * 采用动态规划的方法，用额外的空间存储局部最优解
     * dp[i]: 表示以 nums[i] 结尾的连续子数组的最大和
     * <p>
     * 状态转移方程为: dp[i] = max{dp[i-1]+dp[i], dp[i]}
     * <p>
     * 注: DP 问题需要用额外的空间将子问题的最优解存储起来，然后在利用存储的局部最优解求全局最优
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        // DP求解
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
        }
        // 从 dp 中找出最大值
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 省去了单独求最优解的过程，在状态转移的时候就将最优解求出来
     *
     * @param nums
     * @return
     */
    public int maxSubArray01(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        // DP求解
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = dp[0];// 结果
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]); // 状态转移
            res = Math.max(dp[i], res); // 从 dp 中找出最大值
        }


        return res;
    }
}
