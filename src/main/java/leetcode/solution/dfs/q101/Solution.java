package leetcode.solution.dfs.q101;

import util.TreeNode;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author noodle
 * @date 2019/7/31 22:07
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return mirror(root, root);
    }

    private boolean mirror(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null)
            return true;
        if (r1 == null || r2 == null)
            return false;


        return (r1.val == r2.val)
                && mirror(r1.right, r2.left)
                && mirror(r1.left, r2.right);
    }
}