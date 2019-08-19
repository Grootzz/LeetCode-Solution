package leetcode.solution.array.q41;
/*
给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1
说明:

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */

import org.junit.Test;

import static util.ArrayUtils.swap;

/**
 * 41. 缺失的第一个正数
 * https://leetcode-cn.com/problems/first-missing-positive/
 *
 * @author noodle
 * @date 2019/8/19 15:34
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && (nums[i] != nums[nums[i] - 1]))
                swap(nums, i, nums[i] - 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return nums.length + 1;
    }

    @Test
    public void doTest() {
        int[] nums = {1, 2, 0};
        System.out.println(firstMissingPositive(nums));
    }

    @Test
    public void doTest01() {
        int[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums));
    }

    @Test
    public void doTest02() {
        int[] nums = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(nums));
    }

}