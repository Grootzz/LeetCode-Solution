package leetcode.solution.tree.q102;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 */

/**
 * 102. 二叉树的层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author noodle
 * @date 2019/8/30 09:48
 */
public class Solution {
    /**
     * 递归方式
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        helper(ans, root, 0);

        return ans;
    }

    private void helper(List<List<Integer>> ans, TreeNode root, int curLevel) {
        if (ans.size() == curLevel)
            ans.add(new ArrayList<>());

        // get current level
        ans.get(curLevel).add(root.val);

        if (root.left != null)
            helper(ans, root.left, curLevel + 1);
        if (root.right != null)
            helper(ans, root.right, curLevel + 1);
    }

    /**
     * 迭代
     */
    public List<List<Integer>> levelOrder_M2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        int curLevel = 0;

        queue.add(root);
        while (!queue.isEmpty()) {
            ans.add(new ArrayList<>());

            int width = queue.size();
            for (int i = 0; i < width; i++) {
                TreeNode node = queue.poll();

                ans.get(curLevel).add(node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            curLevel++;
        }

        return ans;
    }

}