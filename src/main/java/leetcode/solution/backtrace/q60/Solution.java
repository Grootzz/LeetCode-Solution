package leetcode.solution.backtrace.q60;
/*
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:

输入: n = 3, k = 3
输出: "213"
示例 2:

输入: n = 4, k = 9
输出: "2314"
 */

import org.junit.Test;

import java.util.Stack;

/**
 * 60. 第k个排列
 * https://leetcode-cn.com/problems/permutation-sequence/
 *
 * @author noodle
 * @date 2019/8/19 16:36
 */
public class Solution {

    public String getPermutation(int n, int k) {
        boolean[] visit = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        backtrace(n, k, stack, ans, visit, 0);

        return ans.toString();
    }

    private void backtrace(int n, int k, Stack<Integer> stack, StringBuilder ans, boolean[] visit, int depth) {
        if (depth == n) {
            String res = stack.toString().substring(1, stack.toString().length() - 1).replace(", ", "");
            ans.append(res);
            return;
        }

        int fib = factorial(n - 1 - depth);

        for (int i = 0; i < n; i++) {

            // 已经用过的数不参与剪枝
            if (visit[i])
                continue;

            // 剪枝
            if (fib < k) {
                k -= fib;
                continue;
            }

            if (!visit[i]) {
                visit[i] = true;
                stack.push(i + 1);
                backtrace(n, k, stack, ans, visit, depth + 1);
            }
        }
    }

    private int factorial(int n) {
        int f = 1;
        while (n > 0) {
            f = f * n;
            n--;
        }
        return f;
    }

    @Test
    public void doTest() {
        int n = 3, k = 3;
        System.out.println(getPermutation(n, k));
    }

    @Test
    public void doTest01() {
        int n = 4, k = 9;
        System.out.println(getPermutation(n, k));
    }
}