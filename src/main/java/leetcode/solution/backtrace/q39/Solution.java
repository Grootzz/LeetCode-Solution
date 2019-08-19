package leetcode.solution.backtrace.q39;

import org.junit.Test;

import java.util.*;
/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * @author noodle
 * @date 2019/8/19 10:02
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return ans;

        Arrays.sort(candidates);

        Stack<Integer> stack = new Stack<>();
        backtrace(ans, stack, candidates, 0, target);

        return ans;
    }

    private void backtrace(List<List<Integer>> ans, Stack<Integer> stack, int[] candidates, int start, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 剪枝
            if (target - candidates[i] >= 0) {
                stack.push(candidates[i]);
                backtrace(ans, stack, candidates, i, target - candidates[i]);
            } else {
                break;
            }
            stack.pop();
        }

    }

    @Test
    public void doTest() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    @Test
    public void doTest01() {
        int[] candidates = {2, 3, 8};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }
}