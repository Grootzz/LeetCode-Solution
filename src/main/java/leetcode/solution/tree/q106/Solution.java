package leetcode.solution.tree.q106;

import org.junit.Test;
import util.TreeNode;
/*
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 */

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * @author noodle
 * @date 2019/9/1 18:31
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return rebuild(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode rebuild(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd)
            return null;

        TreeNode root = new TreeNode(postorder[pEnd]);

        int mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                mid = i;
                break;
            }
        }

        root.left = rebuild(inorder,
                iStart,
                mid - 1,
                postorder,
                pStart,
                pStart + mid - iStart - 1);

        root.right = rebuild(inorder,
                mid + 1,
                iEnd,
                postorder,
                pEnd - (iEnd - mid),
                pEnd - 1);

        return root;
    }

    @Test
    public void doTest() {
        int[] in = {9, 3, 15, 20, 7};
        int[] post = {9, 15, 7, 20, 3};

        buildTree(in,post);
    }
}