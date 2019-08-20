package leetcode.solution.backtrace.q77;
/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 *
 * @author noodle
 * @date 2019/8/20 09:03
 */
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        backtrace(n, k, ans, stack, 0, 0);

        return ans;
    }

    private void backtrace(int n, int k, List<List<Integer>> ans, Stack<Integer> stack, int depth, int start) {
        if (k == depth) {
            ans.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i < n; i++) {
            stack.push(i + 1);
            backtrace(n, k, ans, stack, depth + 1, i + 1);
            stack.pop();
        }
    }

    @Test
    public void doTest() {
        int n = 4, k = 2;
        System.out.println(combine(n, k));
    }
}