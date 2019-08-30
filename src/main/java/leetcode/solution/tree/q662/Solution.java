package leetcode.solution.tree.q662;

import util.TreeNode;

import java.util.*;

/**
 * 662. 二叉树最大宽度
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 *
 * @author noodle
 * @date 2019/8/30 09:39
 */
public class Solution {

    /**
     * 迭代
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int width = 0;

        Queue<Entry> queue = new LinkedList<>();

        queue.add(new Entry(root, 1));
        while (!queue.isEmpty()) {

            int start = queue.peek().getId();
            int end = start;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.peek().getNode();
                end = queue.poll().getId();

                if (node.left != null)
                    queue.offer(new Entry(node.left, end * 2));
                if (node.right != null)
                    queue.offer(new Entry(node.right, end * 2 + 1));
            }

            width = Math.max(width, end - start + 1);
        }

        return width;
    }

    private class Entry {
        private TreeNode node;
        private int id;

        public Entry(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }

        public TreeNode getNode() {
            return node;
        }

        public int getId() {
            return id;
        }
    }
}