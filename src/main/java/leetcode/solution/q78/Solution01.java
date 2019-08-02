package leetcode.solution.q78;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/subsets/
 * 位掩码方式
 *
 * @author noodle
 * @date 2019/7/24 21:26
 */
public class Solution01 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;

        int n = 1 << nums.length;
        for (int i = 0; i < n; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1)
                    cur.add(nums[j]);
            }
            res.add(cur);
        }

        return res;
    }


    @Test
    public void case01() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> combine = subsets(nums);

        System.out.println(combine);
    }
}
