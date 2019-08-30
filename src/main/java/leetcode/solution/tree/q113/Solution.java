package leetcode.solution.tree.q113;
/*
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @author noodle
 * @date 2019/8/30 22:15
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Stack<Integer> stack = new Stack<>();

        backtrack(ans, stack, root, sum);

        return ans;
    }

    private void backtrack(List<List<Integer>> ans, Stack<Integer> stack, TreeNode root, int sum) {
        if (root == null)
            return;

        stack.push(root.val);

        if (root.left == null && root.right == null && root.val - sum == 0)
            ans.add(new ArrayList<>(stack));

        backtrack(ans, stack, root.left, sum - root.val);
        backtrack(ans, stack, root.right, sum - root.val);

        stack.pop();
    }
}