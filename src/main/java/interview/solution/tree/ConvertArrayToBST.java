package interview.solution.tree;

import org.junit.Test;
import util.TreeNode;

/**
 * 无序数组构建一棵二叉排序树
 *
 * @author noodle
 * @date 2019/8/29 22:56
 */
public class ConvertArrayToBST {

    public TreeNode convert(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        TreeNode root = new TreeNode(nums[0]);

        for (int num : nums) {
            insert(root, num);
        }

        return root;
    }

    private void insert(TreeNode root, int num) {
        if (num > root.val) {
            if (root.right == null)
                root.right = new TreeNode(num);
            else
                insert(root.right, num);
        } else {
            if (root.left == null)
                root.left = new TreeNode(num);
            else
                insert(root.left, num);
        }
    }


    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    @Test
    public void doTest() {
        int[] nums = {3, 4, 6, 1, 2, 5, 9};
        TreeNode root = convert(nums);
        inOrder(root);
    }
}