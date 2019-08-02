package leetcode.solution.dfs.q100;

import util.TreeNode;

/**
 * https://leetcode-cn.com/problems/same-tree/
 *
 * @author noodle
 * @date 2019/7/31 21:59
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && p == q)
            return true;

        if ((p == null && q != null) || (p != null && q == null) || p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}