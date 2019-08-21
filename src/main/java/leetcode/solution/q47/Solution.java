package leetcode.solution.q47;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 *
 * @author noodle
 * @date 2019/7/9 20:47
 */
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;

        List<Integer> tmp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrace(ans, tmp, used, nums);

        return ans;
    }

    private void backtrace(List<List<Integer>> ans, List<Integer> tmp, boolean[] used, int[] nums) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            tmp.add(nums[i]);
            backtrace(ans, tmp, used, nums);
            used[i] = false;
            tmp.remove(tmp.size() - 1);

        }
    }

    @Test
    public void doTest() {
        int[] nums = {1, 1, 2, 2};
        System.out.println(permuteUnique(nums));
    }
}
