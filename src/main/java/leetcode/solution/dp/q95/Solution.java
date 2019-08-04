package leetcode.solution.dp.q95;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author noodle
 * @date 2019/7/28 12:59
 */

class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<TreeNode>();

        List<TreeNode> allTrees = generateTrees(1, n);
        return allTrees;
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generateTrees(start, i - 1);
            List<TreeNode> rightTree = generateTrees(i + 1, end);

            // 组合左右子树
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }

        return allTrees;
    }

}




