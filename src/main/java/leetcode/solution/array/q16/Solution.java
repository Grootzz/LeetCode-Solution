package leetcode.solution.array.q16;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 *
 * @author noodle
 * @date 2019/8/1 15:29
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;

        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(res - target))
                    res = sum;
                if (sum < target)
                    j++;
                else if (sum > target)
                    k--;
                else
                    return res;
            }
        }
        return res;
    }

    @Test
    public void case01() {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }
}