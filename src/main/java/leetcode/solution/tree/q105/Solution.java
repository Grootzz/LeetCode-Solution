package leetcode.solution.tree.q105;
/*
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 */

import util.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author noodle
 * @date 2019/9/1 16:52
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = rebuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode rebuildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int mid = findRootLoc(inorder, root.val);

        root.left = rebuildTree(preorder,
                preStart + 1,
                preStart + mid - inStart,
                inorder,
                inStart,
                mid - 1);

        root.right = rebuildTree(preorder,
                preEnd - (inEnd - mid - 1),
                preEnd,
                inorder,
                mid + 1,
                inEnd);

        return root;
    }

    private int findRootLoc(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i])
                return i;
        }
        return 0;
    }
}