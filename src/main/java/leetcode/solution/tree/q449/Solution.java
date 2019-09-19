package leetcode.solution.tree.q449;

import util.TreeNode;

/**
 * 449. 序列化和反序列化二叉搜索树
 * https://leetcode-cn.com/problems/serialize-and-deserialize-bst/
 *
 * @author noodle
 * @date 2019/9/19 20:57
 */
public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);

        return sb.substring(0, sb.length() - 1);
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;

        sb.append(root.val).append("#");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        String[] pre = data.split("#");

        return builder(pre, 0, pre.length - 1);
    }

    private TreeNode builder(String[] pre, int left, int right) {
        if (left > right)
            return null;

        TreeNode root = new TreeNode(Integer.valueOf(pre[left]));

        int index = right + 1;
        for (int i = left + 1; i <= right; i++) {
            if (root.val < Integer.valueOf(pre[i])) {
                index = i;
                break;
            }
        }

        root.left = builder(pre, left + 1, index - 1);
        root.right = builder(pre, index, right);

        return root;
    }
}