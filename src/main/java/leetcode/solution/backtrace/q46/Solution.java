package leetcode.solution.backtrace.q46;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
/*
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 *
 * @author noodle
 * @date 2019/7/9 20:32
 */
class Solution {

    /**
     * 使用交换的方式回溯
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int num : nums)
            tmp.add(num);

        int n = nums.length;
        backtrace(n, tmp, ans, 0);

        return ans;
    }

    private void backtrace(int n, List<Integer> tmp, List<List<Integer>> ans, int start) {
        if (start == n)
            ans.add(new ArrayList<>(tmp));

        for (int i = start; i < n; i++) {
            Collections.swap(tmp, i, start);
            backtrace(n, tmp, ans, start + 1);
            Collections.swap(tmp, start, i);
        }
    }


    /**
     * 使用标记的方式回溯
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;

        int n = nums.length;
        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[n];
        backtrace2(nums, ans, path, used, 0);

        return ans;
    }

    /**
     * @param nums
     * @param ans
     * @param path
     * @param used  标记使用过的数字
     * @param level 将要进入的层数
     */
    private void backtrace2(int[] nums, List<List<Integer>> ans, Stack<Integer> path, boolean[] used, int level) {
        if (level == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backtrace2(nums, ans, path, used, level + 1);
                used[i] = false;
                path.pop();
            }
        }
    }

    @Test
    public void doTest_M1() {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    @Test
    public void doTest_M2() {
        int[] nums = {1, 2, 3};
        System.out.println(permute2(nums));
    }
}
