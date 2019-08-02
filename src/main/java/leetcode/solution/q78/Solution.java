package leetcode.solution.q78;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/subsets/
 * 回溯
 *
 * @author noodle
 * @date 2019/7/24 21:26
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;

        Stack<Integer> stack = new Stack<>();
        core(res, stack, 0, nums);

        return res;
    }

    private void core(List<List<Integer>> res, Stack<Integer> stack, int start, int[] nums) {

        res.add(new ArrayList<>(stack));

        for (int i = start; i < nums.length; i++) {
            stack.push(nums[i]);
            core(res, stack, i + 1, nums);
            stack.pop();
        }
    }


    @Test
    public void case01() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> combine = subsets(nums);

        System.out.println(combine);
    }
}
