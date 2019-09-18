package leetcode.solution.tree.q257;
/*
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/submissions/
 *
 * @author noodle
 * @date 2019/9/18 18:34
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();
        String path = "";

        dfs(ans, path, root);

        return ans;
    }

    private void dfs(List<String> ans, String path, TreeNode root) {
        if (root != null) {
            path += root.val;
            if (root.left == null && root.right == null) {
                ans.add(path);
            } else {
                path += "->";
                dfs(ans, path, root.left);
                dfs(ans, path, root.right);
            }
        }
    }
}