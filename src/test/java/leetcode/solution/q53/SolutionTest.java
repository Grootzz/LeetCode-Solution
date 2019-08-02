package leetcode.solution.q53;

public class SolutionTest {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(new SolutionTest().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int max = dp[0];
        for (int i = 1; i < n; i++) {
            if (max < dp[i])
                max = dp[i];
        }

        return max;
    }
}
