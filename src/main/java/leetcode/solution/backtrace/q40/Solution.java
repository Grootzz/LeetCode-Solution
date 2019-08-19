package leetcode.solution.backtrace.q40;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
 */

/**
 * 40. 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * @author noodle
 * @date 2019/8/19 10:49
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return ans;

        Stack<Integer> stack = new Stack<>();
        Arrays.sort(candidates);
        backtrace(ans, stack, candidates, 0, target);

        return ans;
    }

    private void backtrace(List<List<Integer>> ans, Stack<Integer> stack, int[] candidates, int start, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(stack));
            return;
        }

        // 剪枝
        if (target < 0)
            return;

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;

            stack.push(candidates[i]);
            backtrace(ans, stack, candidates, i + 1, target - candidates[i]);
            stack.pop();
        }
    }

    @Test
    public void doTest() {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(nums, target));
    }

    @Test
    public void doTest01() {
        int[] nums = {10, 1, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(nums, target));
    }
}