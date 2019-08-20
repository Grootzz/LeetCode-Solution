package leetcode.solution.backtrace.q90;
/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */

import org.junit.Test;

import java.util.*;

/**
 * 90. 子集 II
 * https://leetcode-cn.com/problems/subsets-ii/
 *
 * @author noodle
 * @date 2019/8/20 10:45
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;

        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        backtrace(ans, stack, nums, 0);

        return ans;
    }

    private void backtrace(List<List<Integer>> ans, Stack<Integer> stack, int[] nums, int cur) {
        ans.add(new ArrayList<>(stack));

        for (int i = cur; i < nums.length; i++) {
            // 剪枝
            if (i > cur && nums[i] == nums[i - 1])
                continue;

            stack.push(nums[i]);
            backtrace(ans, stack, nums, i + 1);
            stack.pop();
        }
    }

    @Test
    public void doTest() {
        int[] nums = new int[]{1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }
}