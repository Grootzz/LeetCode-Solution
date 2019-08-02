package leetcode.solution.q77;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/combinations/
 *
 * @author noodle
 * @date 2019/7/24 21:26
 */
public class Solution {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0 || n < k)
            return res;

        Stack<Integer> stack = new Stack<>();

        core(res, stack, k, 1, n);

        return res;
    }

    private void core(List<List<Integer>> res, Stack<Integer> stack, int k, int start, int n) {
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i <= n; i++) {
            stack.push(i);
            core(res, stack, k, i + 1, n);
            stack.pop();
        }
    }

    @Test
    public void case01(){
        List<List<Integer>> combine = combine(4, 2);

        System.out.println(combine);
    }
}
