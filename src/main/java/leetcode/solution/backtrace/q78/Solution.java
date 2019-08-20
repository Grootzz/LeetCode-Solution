package leetcode.solution.backtrace.q78;
/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 *
 * @author noodle
 * @date 2019/8/20 09:33
 */
public class Solution {
    /**
     * 回溯
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;

        Stack<Integer> stack = new Stack<>();
        backtrace(ans, stack, nums, 0);

        return ans;
    }

    private void backtrace(List<List<Integer>> ans, Stack<Integer> stack, int[] nums, int start) {
        ans.add(new ArrayList<>(stack));

        for (int i = start; i < nums.length; i++) {
            stack.push(nums[i]);
            backtrace(ans, stack, nums, i + 1);
            stack.pop();
        }
    }


    /**
     * 方法二：位掩码
     */
    public List<List<Integer>> subsets_M2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;

        int n = (int) Math.pow(2, nums.length);

        for (int i = 0; i < n; i++) {
            List<Integer> set = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) != 0)
                    set.add(nums[j]);
            }

            ans.add(set);
        }

        return ans;
    }


    @Test
    public void doTest() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    @Test
    public void doTest_M2() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets_M2(nums));
    }
}