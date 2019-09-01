package leetcode.solution.tree.q103;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. 二叉树的锯齿形层次遍历
 *
 * @author noodle
 * @date 2019/9/1 22:05
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if ((level & 1) != 0)
                    list.add(node.val);
                else
                    list.add(0, node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
            ans.add(list);
        }
        return ans;
    }
}