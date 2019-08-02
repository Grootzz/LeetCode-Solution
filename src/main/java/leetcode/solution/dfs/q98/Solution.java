package leetcode.solution.dfs.q98;


import util.TreeNode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author noodle
 * @date 2019/7/31 20:45
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        int inorder = Integer.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (inorder >= root.val)
                return false;

            inorder = root.val;
            root = root.right;
        }

        return true;
    }

}