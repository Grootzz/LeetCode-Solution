package leetcode.solution.dp.q90;

import org.junit.Test;

import java.util.*;

/**
 * 90. 子集 II
 * https://leetcode-cn.com/problems/subsets-ii/
 *
 * @author noodle
 * @date 2019/8/2 22:34
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(res, subset, nums, 0);

        return res;
    }

    private void backtrace(List<List<Integer>> res, List<Integer> subset, int[] nums, int curPos) {
        res.add(new ArrayList<>(subset));

        for (int i = curPos; i < nums.length; i++) {
            if (i > curPos && nums[i] == nums[i - 1])
                continue;
            subset.add(nums[i]);
            backtrace(res, subset, nums, i + 1);
            subset.remove(subset.size()-1);
        }
    }

    @Test
    public void doTest() {
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = subsetsWithDup(nums);
        System.out.println(subsets);
    }

    @Test
    public void doTest01() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsetsWithDup(nums);
        System.out.println(subsets);
    }
}