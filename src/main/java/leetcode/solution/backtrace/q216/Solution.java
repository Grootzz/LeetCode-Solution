package leetcode.solution.backtrace.q216;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
 */

/**
 * 216. 组合总和 III
 * https://leetcode-cn.com/problems/combination-sum-iii/
 *
 * @author noodle
 * @date 2019/8/21 21:28
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        backtrace(ans, stack, k, n, 1);

        return ans;
    }

    private void backtrace(List<List<Integer>> ans, Stack<Integer> stack, int k, int n, int cur) {
        if (n == 0 && stack.size() == k) {
            ans.add(new ArrayList<>(stack));
            return;
        }

        if ((stack.size() > k || n < 0) || (stack.size() < k && n == 0))
            return;

        for (int i = cur; i < 10; i++) {
            stack.push(i);
            backtrace(ans, stack, k, n - i, i + 1);
            stack.pop();
        }
    }

    @Test
    public void doTest() {
        int k = 3, n = 7;
        System.out.println(combinationSum3(k, n));
    }

    @Test
    public void doTest01() {
        int k = 3, n = 9;
        System.out.println(combinationSum3(k, n));
    }
}