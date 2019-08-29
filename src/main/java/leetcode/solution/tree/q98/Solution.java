package leetcode.solution.tree.q98;

import util.TreeNode;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author noodle
 * @date 2019/8/29 21:17
 */
public class Solution {

    /**
     * M1: 递归
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null)
            return true;

        int val = root.val;

        if (lower != null && lower >= val)
            return false;
        if (upper != null && upper <= val)
            return false;

        if (!helper(root.left, lower, val))
            return false;
        if (!helper(root.right, val, upper))
            return false;

        return true;
    }

    /**
     * M2: 迭代
     * TODO
     */
    public boolean isValidBST_M2(TreeNode root) {

        return false;
    }



}