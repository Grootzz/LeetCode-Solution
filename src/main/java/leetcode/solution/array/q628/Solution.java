package leetcode.solution.array.q628;

import org.junit.Test;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 *
 * @author noodle
 * @date 2019/8/15 21:35
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);
    }


    @Test
    public void doTest() {
        int[] nums = {1, 2, 3};
        System.out.println(maximumProduct(nums));
    }
}