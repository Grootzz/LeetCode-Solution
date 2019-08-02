package leetcode.solution.dfs.q104;

import util.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author noodle
 * @date 2019/7/31 22:25
 */
public class Solution {
    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}