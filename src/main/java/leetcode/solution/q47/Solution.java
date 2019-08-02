package leetcode.solution.q47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author noodle
 * @date 2019/7/9 20:47
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2};
        System.out.println(new Solution().permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;

        List<Integer> tmp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrace(ans, tmp, used, nums);

        return ans;
    }

    private void backtrace(List<List<Integer>> ans, List<Integer> tmp, boolean[] used, int[] nums) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            tmp.add(nums[i]);
            backtrace(ans, tmp, used, nums);
            used[i] = false;
            tmp.remove(tmp.size() - 1);

        }
    }
}
