package leetcode.solution.q60;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

        int n = 4, k = 9;

        String permutation = new Solution().getPermutation(n, k);
        System.out.println(permutation);

    }

    public String getPermutation(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[n];
        backtrace(ans, path, nums, used, 0);
        List<Integer> list = ans.get(k - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append("" + list.get(i));
        }
        return sb.toString();
    }

    /**
     * @param ans
     * @param path
     * @param nums
     * @param used
     * @param level 将要进入的层数
     */
    private void backtrace(List<List<Integer>> ans, Stack<Integer> path, int[] nums, boolean[] used, int level) {
        if (level == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backtrace(ans, path, nums, used, level + 1);
                used[i] = false;
                path.pop();
            }
        }
    }
}
