package leetcode.solution.tree.q101;

import util.TreeNode;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author noodle
 * @date 2019/8/30 13:19
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return mirror(root.left, root.right);
    }

    private boolean mirror(TreeNode left, TreeNode right) {

        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        return (left.val == right.val) && mirror(left.left, right.right) && mirror(left.right, right.left);
    }
}