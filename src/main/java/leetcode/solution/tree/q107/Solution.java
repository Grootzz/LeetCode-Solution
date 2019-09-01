package leetcode.solution.tree.q107;

import util.TreeNode;

import java.util.*;

/**
 * 107. 二叉树的层次遍历 II
 *
 * @author noodle
 * @date 2019/9/1 21:37
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {

            List<Integer> level = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.peek();
                level.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);

                queue.poll();
            }
            ans.add(level);
        }
        Collections.reverse(ans);
        return ans;
    }
}