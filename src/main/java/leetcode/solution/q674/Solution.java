package leetcode.solution.q674;

import org.junit.Test;

/**
 * 674. 最长连续递增序列
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 *
 * @author noodle
 * @date 2019/8/29 22:38
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int maxArrLen = 1;

        int j = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] < nums[i]) {
                maxArrLen = Math.max(maxArrLen, i - j + 1);
            } else {
                j = i;
            }
        }

        return maxArrLen;
    }

    @Test
    public void doTest() {
        int[] nums = {1, 3, 5, 4, 7};

        System.out.println(findLengthOfLCIS(nums));
    }

    @Test
    public void doTest01() {
        int[] nums = {2, 2, 2, 2, 2};

        System.out.println(findLengthOfLCIS(nums));
    }
}