package leetcode.solution.np.q416;

import org.junit.Test;

/**
 * 416. 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * 0-1背包问题
 *
 * @author noodle
 * @date 2019/8/5 22:22
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2)
            return false;

        int sum = 0;
        for (int num : nums)
            sum += num;

        // 如果和为奇数，不可能有两组数据可分
        if ((sum & 1) != 0)
            return false;

        sum /= 2;

        // dp[i][s]: 表示前i个元素中挑选元素之和为s的可能性
        boolean[][] dp = new boolean[nums.length+1][sum + 1];

        dp[0][0] = true;

        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int s = 1; s <= sum; s++) {
            dp[0][s] = false;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int s = 1; s <= sum; s++) {

                if (nums[i - 1] > s) {
                    // 前i个元素之和大于s, 则第i个元素不可选
                    dp[i][s] = dp[i - 1][s];
                } else {
                    // 两种情况：不选择第i个元素 或 选择第i个元素
                    dp[i][s] = dp[i - 1][s] || dp[i - 1][s - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][sum];
    }


    @Test
    public void doTest() {
        int[] nums = {1, 5, 11, 5};

        boolean canPartition = canPartition(nums);
        System.out.println(canPartition);
    }

    @Test
    public void doTest01() {
        int[] nums = {1, 2, 3, 4, 5};

        boolean canPartition = canPartition(nums);
        System.out.println(canPartition);
    }
}